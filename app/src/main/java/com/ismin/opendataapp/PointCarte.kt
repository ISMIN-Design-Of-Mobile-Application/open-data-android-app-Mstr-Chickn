package com.ismin.opendataapp

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

class PointCarte  : ClusterItem {

    private var mPosition : LatLng = LatLng(0.0,0.0)
    private var mTitle : String = ""
    private var mSnippet : String = ""

    constructor(lat: Double, lng: Double) {
        mPosition = LatLng(lat, lng)
    }

    constructor(lat: Double, lng: Double, title: String, snippet: String) {
        mPosition = LatLng(lat, lng)
        mTitle = title
        mSnippet = snippet
    }

    override fun getPosition(): LatLng? {
        return mPosition
    }

    override fun getTitle(): String? {
        return mTitle
    }

    override fun getSnippet(): String? {
        return mSnippet
    }
}
