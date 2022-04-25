package com.example.wallpaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaper.model.Wallpaper
import com.example.wallpaper.model.WallpaperPost

class WallAdapter( val items: ArrayList<WallpaperPost>): RecyclerView.Adapter<viewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemwall,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val currentItem  = items[position]
        holder.titleview.text = currentItem.data.title
        Glide.with(holder.itemView.context).load(currentItem.data.urlOverriddenByDest).into(holder.wallpaperurl)
    }

    override fun getItemCount(): Int {
        return items.size
    }


}
class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val titleview : TextView = itemView.findViewById(R.id.wallpapertitle)
    val wallpaperurl : ImageView = itemView.findViewById(R.id.wallpaerimage)

}