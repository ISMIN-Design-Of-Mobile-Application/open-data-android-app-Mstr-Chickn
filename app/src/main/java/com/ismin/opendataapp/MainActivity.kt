package com.ismin.opendataapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttInfo = findViewById<Button>(R.id.info_button)
        buttInfo.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment = InfoFragment()
            fragmentTransaction.replace(R.id.main_fragments_view, fragment)
            fragmentTransaction.commit()
        }
    }
}
