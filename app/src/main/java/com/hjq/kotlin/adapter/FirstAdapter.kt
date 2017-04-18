package com.hjq.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hjq.kotlin.R
import com.hjq.kotlin.bean.GankBean
import kotlinx.android.synthetic.main.item_first.view.*

/**
 * Created by hjq on 17-4-18.
 */
class FirstAdapter(val items : List<GankBean.ResultsBean>)
    : RecyclerView.Adapter<FirstAdapter.FirstViewHolder>(){

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FirstViewHolder?, position: Int) {
        holder?.bindView(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FirstViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_first,parent,false)
        return FirstViewHolder(view)
    }

    class FirstViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item : GankBean.ResultsBean){
            with(item){
                Glide.with(itemView.context).load(item.url).centerCrop().into(itemView.first_iv)
                itemView.first_title.text = item.who
                itemView.firist_desc.text = item.publishedAt
            }
        }
    }
}