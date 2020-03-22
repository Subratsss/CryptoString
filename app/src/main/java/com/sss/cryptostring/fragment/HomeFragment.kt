package com.sss.cryptostring.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sss.cryptostring.R
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.encrypt_button!!.setOnClickListener(this)
        view.decrypt_button!!.setOnClickListener(this)

         return view
    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.encrypt_button ->{

                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.view_container,EncryptFragment())
                    .addToBackStack(null)
                    .commit()
            }

            R.id.decrypt_button ->{

                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.view_container,DecryptFragment())
                    .addToBackStack(null)
                    .commit()

            }
        }
    }

}
