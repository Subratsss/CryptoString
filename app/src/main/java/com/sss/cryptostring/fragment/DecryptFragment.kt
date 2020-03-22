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
import kotlinx.android.synthetic.main.fragment_decrypt.*
import kotlinx.android.synthetic.main.fragment_encrypt.view.*

/**
 * A simple [Fragment] subclass.
 */
class DecryptFragment : Fragment(), TextWatcher {
    private var output: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_decrypt, container, false)

        view.input_TIE!!.addTextChangedListener(this)

        view.submit_button?.setOnClickListener {
            clearResult()
            doDecryption()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.decryption)
    }

    private fun doDecryption() {
        val input = input_TIE.text.toString()
        var currentAlphabet: Char? = null
        var currentAlphabetCount: Int? = 0
        var numericCount: String? = null


        for (currentChar in input) {
            //IsAlphabetic or Special Character
            if (currentChar.isLetter() || !currentChar.isDigit() || currentChar.isWhitespace()) {

                numericCount = ""
                currentAlphabet = currentChar


            } //For Numeric value check
            else if (currentChar.isDigit()) {
                numericCount += currentChar
                currentAlphabetCount = numericCount!!.toInt()


                    if (currentAlphabetCount >= 1) {
                        var currentString = currentAlphabet.toString()
                        output += currentString.repeat(currentAlphabetCount)
                    }
            }

        }
        result_tv.text = output
    }

    private fun clearResult() {
        result_tv.text = ""
        output = ""
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
