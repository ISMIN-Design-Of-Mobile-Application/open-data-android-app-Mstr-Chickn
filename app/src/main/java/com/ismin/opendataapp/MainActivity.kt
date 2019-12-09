package com.ismin.opendataapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), CarteFragment.OnFragmentInteractionListener, ListeFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) { //pour plus tard avec la map
         }
    var listElement: ArrayList<Element> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listElement = arrayListOf()
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

        //à supprimer après
        val element1: Element = Element("lol", "juste un mot", R.drawable.maxime_le_moine)
        listElement.add(element1)
        listElement.add(Element("lol2", "hehe", R.drawable.maxime_le_moine))

        //listener qui charge le fragment liste
        val listButton =  findViewById<Button>(R.id.liste_button)
        listButton.setOnClickListener {
            var fragment = ListeFragment()

            //data à transmettre
            val bundle = Bundle()
            bundle.putSerializable("element", listElement)
            fragment.arguments = bundle

            var fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_fragments_view, fragment)
            fragmentTransaction.commit()
        }
    }

    override fun openDescription(position: Int) {
        val intent = Intent(this, DescriptionActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("Element", listElement[position])
        intent.putExtras(bundle)
        this.startActivity(intent)
    }
}
