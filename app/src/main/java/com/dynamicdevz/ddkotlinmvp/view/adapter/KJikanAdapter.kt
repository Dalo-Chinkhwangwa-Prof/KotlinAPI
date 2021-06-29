package com.dynamicdevz.ddkotlinmvp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynamicdevz.ddkotlinmvp.databinding.JikanItemLayoutBinding
import com.dynamicdevz.ddkotlinmvp.model.Result

class KJikanAdapter(private val delegate: JikanDelegate): RecyclerView.Adapter<KJikanAdapter.KJikanViewHolder>() {

    interface JikanDelegate {
        fun selectImage(url: String)
    }

    inner class KJikanViewHolder(val binding: JikanItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    var jikans: List<Result> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KJikanViewHolder {
        val binding = JikanItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return KJikanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KJikanViewHolder, position: Int) {
        with(jikans[position]){
            holder.binding.apply{

                Glide.with(holder.itemView)
                    .applyDefaultRequestOptions(RequestOptions.circleCropTransform())
                    .load(image_url)
                    .into(posterImageview)

                posterImageview.setOnClickListener {
                    delegate.selectImage(image_url)
                }

                titleTextview.text = title
            }
        }
    }

    override fun getItemCount() = jikans.size
}




















