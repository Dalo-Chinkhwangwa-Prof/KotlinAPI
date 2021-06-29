package com.dynamicdevz.ddkotlinmvp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dynamicdevz.ddkotlinmvp.databinding.JikanItemLayoutBinding;
import com.dynamicdevz.ddkotlinmvp.model.Result;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class JJikanAdapter extends RecyclerView.Adapter<JJikanAdapter.JJikanViewHolder> {

    private List<Result> jikans = new ArrayList<>();

    public void setJikans(List<Result> jikans) {
        this.jikans = jikans;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public JJikanViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        JikanItemLayoutBinding binding =
                JikanItemLayoutBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                );
        return new JJikanViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull JJikanViewHolder holder, int position) {
        Result jikan = jikans.get(position);

        Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions.circleCropTransform())
                .load(jikan.getImage_url())
                .into(holder.binding.posterImageview);
        holder.binding.titleTextview.setText(jikan.getTitle());
    }

    @Override
    public int getItemCount() {
        return jikans.size();
    }
// inner class KJikanViewHolder(val binding: JikanItemLayoutBinding): RecyclerView.ViewHolder(binding.root)
    class JJikanViewHolder extends RecyclerView.ViewHolder {
        JikanItemLayoutBinding binding;
        public JJikanViewHolder(JikanItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}










