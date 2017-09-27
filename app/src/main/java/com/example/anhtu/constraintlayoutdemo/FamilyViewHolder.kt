package com.example.anhtu.constraintlayoutdemo

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by anhtu on 8/31/2017.
 */
open class FamilyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class Parent(itemView: View, onClickHeader: (position: Int) -> Unit) : FamilyViewHolder(itemView) {
        var tvName: TextView

        init {
            tvName = itemView.findViewById(R.id.tv_name)
            itemView.setOnClickListener {
                onClickHeader(adapterPosition)
            }
        }

        fun bindData(parent: com.example.anhtu.constraintlayoutdemo.Parent) {
            tvName.text = parent.name
        }
    }

    class Children(itemView: View) : FamilyViewHolder(itemView) {
        var tvName: TextView

        init {
            tvName = itemView.findViewById(R.id.tv_name)
        }

        fun bindData(children: com.example.anhtu.constraintlayoutdemo.Children) {
            tvName.text = children.name
        }
    }
}