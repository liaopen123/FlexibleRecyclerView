package com.lph.wearable.flexiblevp2.adapter

import android.content.Context
import android.util.Log
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.util.set
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lph.wearable.flexiblevp2.R

class RVAdapter(val images: List<String>, val mainActivity: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val heightsMap = floatArrayOf(1618/ 1080f*1176,721/ 1080f*1176,721/ 1080f*1176,)
 private var  listener: HeightMapChangeListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_page, parent, false) as ImageView
        return VH(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.e("TAG","onBindViewHolder:$position")
        val layoutParams = holder.itemView.layoutParams
//        if (position == 0) {
//            layoutParams.height = 300
//        } else if (position == 1) {
//            layoutParams.height = 500
//        } else if (position == 2) {
//
//            layoutParams.height = 400
//        } else if (position == 3) {
//            layoutParams.height = 600
//        }else if(position == 4){
//            layoutParams.height = 300
//        }else if (position%5 == 0) {
//            layoutParams.height = 300
//        } else if (position%5 == 1) {
//            layoutParams.height = 500
//        } else if (position%5 == 2) {
//
//            layoutParams.height = 400
//        } else if (position%5 ==3) {
//            layoutParams.height = 600
//        }else if (position%5 ==4) {
//            layoutParams.height = 600
//        }
        layoutParams.height = heightsMap[position].toInt()
        holder.itemView.layoutParams = layoutParams
        val imageView = holder.itemView as ImageView
        listener?.setMapChangeListener(heightsMap)

        Glide.with(mainActivity).load(images[position]).into(imageView)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class VH(var view: ImageView) : RecyclerView.ViewHolder(view) {

    }
      interface HeightMapChangeListener{
          fun setMapChangeListener(heightsMap :FloatArray)
    }

    fun setHeightChangeListener(heightMapChangeListener: HeightMapChangeListener){
        this.listener = heightMapChangeListener

    }


}