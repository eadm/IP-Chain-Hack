package ru.nobird.android.ipchain.view.patent.ui.adapter

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class InputDataAdapter(@LayoutRes private val resId: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var counter = 0
        set(value) {
            field = value
            notifyItemInserted(value - 1)
        }

    override fun getItemCount(): Int =
        counter

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(p0.context).inflate(resId, p0, false))

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) = Unit

    private class ViewHolder(root: View) : RecyclerView.ViewHolder(root)
}