package com.dhruvam.gseinshorts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScreenVerticalSlideAdapter extends RecyclerView.Adapter<ScreenVerticalSlideAdapter.NewsViewHolder> {
    /**
     * The number of pages to show in this apk.
     */
    private static final int NUM_PAGES = 3;

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_top_bottom, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }


    class NewsViewHolder extends RecyclerView.ViewHolder {
        NewsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
