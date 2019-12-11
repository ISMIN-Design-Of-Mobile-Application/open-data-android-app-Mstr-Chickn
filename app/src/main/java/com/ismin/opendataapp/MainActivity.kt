package com.ismin.opendataapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.httpGet
import org.json.JSONObject


class MainActivity : AppCompatActivity(), CarteFragment.OnFragmentInteractionListener, ListeFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) { //pour plus tard avec la map
         }
    var listElement: ArrayList<Element> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listElement = arrayListOf()

        getBDD()
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

    //on utilise Fuel pour récuperer les données
    fun getBDD() {
        val myurl: String = "https://www.data.gouv.fr/s/resources/monuments-et-tombes-de-personnalites-du-cimetiere-du-pere-lachaise/20141103-215847/perelachaise_data.json"
        Fuel.get(myurl).responseString { request, response, result ->
            //do something with response
            result.fold({ d ->
                //do something with data
                val response = result.get()
                Toast.makeText(this, "It works, values: $result", Toast.LENGTH_SHORT).show()
                val jsonObject = JSONObject(response)
                val dataArray = jsonObject.getJSONArray("monuments")
                for (i in 0 until dataArray.length()) {
                    val dataobj = dataArray.getJSONObject(i)
                    val element: Element = Element(dataobj.getString("nom"), dataobj.getJSONObject("node_osm").getString("longitude"), R.drawable.maxime_le_moine, dataobj.getJSONObject("node_osm").getString("latitude").toFloat(), dataobj.getJSONObject("node_osm").getString("longitude").toFloat())
                    listElement.add(element)

                }

            }, { err ->
                //do something with error
            })
        }
    }

}
