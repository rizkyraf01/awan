package com.example.ngawan.ui.notifications

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ngawan.R
import kotlinx.parcelize.Parcelize

class NotificationsAdapter(private var data: ArrayList<Data>):
    RecyclerView.Adapter<NotificationsAdapter.HeadHolder>() {

        @Parcelize
    data class Data(
        var headline : String = "",
        var caption : String = "",
        var detail : String = "",
        var photo :Int = 0,
        var index : String = ""
    ):Parcelable

    inner class HeadHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var photo : ImageView = itemView.findViewById(R.id.iv_help)
        var headline : TextView = itemView.findViewById(R.id.HeadHelp)
        var caption : TextView = itemView.findViewById(R.id.CaptionHeadHelp)
        var detail : TextView = itemView.findViewById(R.id.DetailsHeadHelp)
    }

    override fun onBindViewHolder(holder: HeadHolder, position: Int) {
        val data = data[position]
        Glide.with(holder.photo.context)
            .load(data.photo)
            .apply(RequestOptions().override(300,300))
            .into(holder.photo)
        holder.headline.text = data.headline
        holder.caption.text = data.caption
        holder.detail.text = data.detail
    }

    override fun getItemCount(): Int = data.size
    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): HeadHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_help, parent, false)
        return HeadHolder(view)
    }


    fun setData(items: ArrayList<Data>){
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
}