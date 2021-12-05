package com.system.assignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.system.assignment.R
import com.system.assignment.data.local.entity.User

class MainAdapter(private val context: Context, private val mutableList: ArrayList<User>) :
    RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private lateinit var listener: RecyclerViewCallback

    fun setOnClickListener(listener: RecyclerViewCallback) { this.listener = listener }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Boolean) {
            val view = itemView.findViewById<TextView>(R.id.status)
            view.visibility = View.VISIBLE
            if (position) view.text = "Accepted" else view.text = "Rejected"
        }
    }

    override fun getItemCount(): Int = mutableList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentObject = mutableList[position]
        if (!currentObject.newUser){
            holder.bind(currentObject.status)
        }

        holder.itemView.findViewById<TextView>(R.id.name).text = currentObject.name
        holder.itemView.findViewById<TextView>(R.id.desc).text = currentObject.id.substring(0, 8)
        holder.itemView.findViewById<TextView>(R.id.email).text = currentObject.email
        holder.itemView.findViewById<TextView>(R.id.country).text = currentObject.id.substring(0, 16)
        Glide.with(context).load(currentObject.avatar).into(holder.itemView.findViewById(R.id.image))

        holder.itemView.findViewById<ImageView>(R.id.accept).setOnClickListener {
            listener.position(currentObject, true)
            holder.bind(true)
        }
        holder.itemView.findViewById<ImageView>(R.id.reject).setOnClickListener {
            listener.position(currentObject, false)
            holder.bind(false)
        }
    }

}