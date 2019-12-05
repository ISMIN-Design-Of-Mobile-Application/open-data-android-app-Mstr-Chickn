package com.ismin.opendataapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ElementAdapter(private val icons: ArrayList<Element>) :
    RecyclerView.Adapter<ElementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.element_liste, parent,
            false)

        return ElementViewHolder(row)
    }

    override fun onBindViewHolder(viewholder: ElementViewHolder, position: Int) {
        val (name, image) = this.icons[position]

        viewholder.txvName.text = name
        //viewholder.imvImage.setImageResource(R.drawable.maxime_le_moine)
    }

    override fun getItemCount(): Int {
        return this.icons.size
    }
}