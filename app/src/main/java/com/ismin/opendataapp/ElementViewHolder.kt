package com.ismin.opendataapp

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ElementViewHolder(rootView: View, private val onItemClick: (Int) -> Unit) : RecyclerView.ViewHolder(rootView){

    var txvName: TextView
    var imvImage: ImageView


    init {
        this.txvName = rootView.findViewById(R.id.title)
        this.imvImage = rootView.findViewById(R.id.image)

        //listener qui détecte l'appuie sur cet item
        rootView.setOnClickListener{
            onItemClick(adapterPosition)

        }
    }
}
