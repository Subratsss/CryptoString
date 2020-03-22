package com.sss.cryptostring.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sss.cryptostring.R
import kotlinx.android.synthetic.main.fragment_encrypt.*
import kotlinx.android.synthetic.main.fragment_encrypt.view.*


/**
 * A simple [Fragment] subclass.
 */
class EncryptFragment : Fragment(), TextWatcher {
    private var output: String = ""
    private lateinit var outputArrayList: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)

        view.input_TIE!!.addTextChangedListener(this)

        view.submit_button!!.setOnClickListener {
            clearResult()
            doEncryption()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        outputArrayList = ArrayList()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.encryption)
    }

    private fun doEncryption() {

        val input = input_TIE.text.toString()
        var previousChar: Char? = null
        var prevCharCount: Int = 1

        for (currentChar in input) {
            var count: Int = 1

            if (previousChar == currentChar) {
                outputArrayList.removeAt(outputArrayList.lastIndex)
                prevCharCount++
                outputArrayList.add("$currentChar$prevCharCount")
            } else {
                prevCharCount = 1
                outputArrayList.add("$currentChar$count")
            }

            previousChar = currentChar

        }
        if (outputArrayList.size > 0) {
            for (j in outputArrayList) {
                var result = j
                output += result
            }
            result_tv.text = output

        }


    }

    private fun clearResult() {
        result_tv.text = ""
        output = ""
        outputArrayList.clear()
    }

    override fun afterTextChanged(editable: Editable?) {
        if (editable!!.isNotEmpty()) {
            submit_button.isEnabled = true
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if (result_tv.text.isNotEmpty()) {
            clearResult()
        }
    }
}
