package com.ismin.opendataapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListeFragment.OnFragmentInteractionListener {

    var bundle = Bundle()
    var listElement:ArrayList<Element> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttInfo = findViewById<Button>(R.id.info_button)
        buttInfo.setOnClickListener {
            var fragmentTransaction = supportFragmentManager.beginTransaction()
            var fragment = InfoFragment()
            fragmentTransaction.replace(R.id.main_fragments_view, fragment)
            fragmentTransaction.commit()
        }

        //à supprimer après
        val element1: Element = Element("lol", "juste un mot", null)
        listElement.add(element1)


        val listButton =  findViewById<Button>(R.id.liste_button)
        listButton.setOnClickListener {
            var fragment = ListeFragment()
            bundle.putSerializable("element", listElement)
           // fragment.arguments = bundle
            var fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.main_fragments_view, fragment)
            fragmentTransaction.commit()
        }
    }
}
