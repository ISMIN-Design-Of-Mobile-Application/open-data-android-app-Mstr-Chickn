package com.ismin.opendataapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), CarteFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) { //pour plus tard avec la map
         }

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

        val buttCarte = findViewById<Button>(R.id.carte_button)
        buttCarte.setOnClickListener {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment = CarteFragment()
            fragmentTransaction.replace(R.id.main_fragments_view, fragment)
            fragmentTransaction.commit()
                //val intent = Intent(this, MapsActivity::class.java)
                //startActivity(intent)
        }
    }
}
