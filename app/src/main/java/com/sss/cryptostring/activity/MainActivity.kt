package com.sss.cryptostring.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sss.cryptostring.R
import com.sss.cryptostring.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Toolbar Set up
        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.app_name)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
       // supportActionBar!!.setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.view_container, HomeFragment())
            .commit()
    }
}
