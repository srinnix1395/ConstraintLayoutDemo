package com.example.anhtu.constraintlayoutdemo

import android.content.Context
import android.support.v4.util.ArrayMap
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by anhtu on 8/31/2017.
 */
class Adapter(context: Context,
              val list: ArrayList<Any>,
              val onClickHeader: (position: Int) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val mapPosition = ArrayMap<String, Int>()

    init {
        list.forEachIndexed { index, item ->
            if (item is Parent) {
                mapPosition.put(item.id.toString(), index)
            }
        }
    }

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        when (viewType) {
            1 -> {
                val view = layoutInflater.inflate(R.layout.item_parent, parent, false)
                return FamilyViewHolder.Parent(view, onClickHeader)
            }
            2 -> {
                val view = layoutInflater.inflate(R.layout.item_child, parent, false)
                return FamilyViewHolder.Children(view)
            }
            else -> return null
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is FamilyViewHolder.Parent) {
            holder.bindData(list[position] as Parent)
        } else if (holder is FamilyViewHolder.Children) {
            holder.bindData(list[position] as Children)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        if (list[position] is Parent) {
            return 1
        } else {
            return 2
        }
    }
}