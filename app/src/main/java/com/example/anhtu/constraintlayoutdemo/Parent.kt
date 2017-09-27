package com.example.anhtu.constraintlayoutdemo

/**
 * Created by anhtu on 8/31/2017.
 */
data class Parent(val id: Int,
                  val name: String,
                  val listChildren: ArrayList<Children>,
                  var isExpand: Boolean) {
}