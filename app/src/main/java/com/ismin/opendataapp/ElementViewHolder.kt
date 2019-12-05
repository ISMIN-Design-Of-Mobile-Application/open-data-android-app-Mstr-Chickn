package com.ismin.opendataapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ElementViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
    var txvName: TextView
    var imvImage: ImageView

    init {
        this.txvName = rootView.findViewById(R.id.title)
        this.imvImage = rootView.findViewById(R.id.image)
    }
}
