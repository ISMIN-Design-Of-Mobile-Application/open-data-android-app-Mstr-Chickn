package com.ismin.opendataapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CarteFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CarteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarteFragment : Fragment(),OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {
    // TODO: Rename and change types of parameters
    private lateinit var mMap: GoogleMap
    private lateinit var mClusterManager: ClusterManager<PointCarte>
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_carte, container, false)

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)
        // Inflate the layout for this fragment
        return rootView
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        setUpClusterer()
        mMap.setOnInfoWindowClickListener(this)

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        //val sydney1 = LatLng(-34.5, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney1).title("Marker in Sydney1"))
        //val sydney2 = LatLng(-34.0, 151.5)
        //mMap.addMarker(MarkerOptions().position(sydney2).title("Marker in Sydney2"))
        //val sydney3 = LatLng(-34.5, 151.5)
        //mMap.addMarker(MarkerOptions().position(sydney3).title("Marker in Sydney3"))
        //val sydney4 = LatLng(-33.5, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney4).title("Marker in Sydney4"))
    }

    private fun setUpClusterer() {
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(51.503186, -0.126446), 10f))
        val sydney = LatLng(-34.0, 151.0)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        mClusterManager = ClusterManager(activity, mMap)
        mMap.setOnCameraIdleListener(mClusterManager)
        mMap.setOnMarkerClickListener(mClusterManager)
        addItems()
    }

    private fun addItems() {
        val sydney = PointCarte(-34.0, 151.0, "Sydney", "Description de Sydney")
        mClusterManager.addItem(sydney)

        val sydney1 = PointCarte(-34.5, 151.0, "Sydney1", "Description de Sydney1")
        mClusterManager.addItem(sydney1)

        val sydney2 = PointCarte(-34.0, 151.3, "Sydney2", "Description de Sydney2")
        mClusterManager.addItem(sydney2)

        val sydney3 = PointCarte(-34.2, 151.0, "Sydney3", "Description de Sydney3")
        mClusterManager.addItem(sydney3)

        val sydney4 = PointCarte(-34.4, 151.5, "Sydney4", "Description de Sydney4")
        mClusterManager.addItem(sydney4)

    }

    override fun onInfoWindowClick(marker: Marker) {
        Toast.makeText(
            activity, "Info window clicked",
            Toast.LENGTH_SHORT
        ).show()
    }
}
