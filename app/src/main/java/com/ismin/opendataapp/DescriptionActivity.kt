package com.ismin.opendataapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class DescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        //définition des variables
        val intent = this.intent
        val bundle = intent.extras
        val backButton: ImageButton

        //on récupère les données
        val data = bundle!!.getSerializable("Element") as Element
        val (name, biography, image) = data

        //on affiche les données
        this.findViewById<TextView>(R.id.titleDescription).text = name
        this.findViewById<TextView>(R.id.biography).text = biography
        this.findViewById<ImageView>(R.id.photoDescription).setImageResource(image)

        //Listener qui termine l'activity et retourne au MainActivity
        backButton = this.findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}
