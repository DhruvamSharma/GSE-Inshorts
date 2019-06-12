package com.dhruvam.gseinshorts.VerticalNews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dhruvam.gseinshorts.R;

import java.util.ArrayList;

public class ScreenVerticalSlideAdapter extends RecyclerView.Adapter<ScreenVerticalSlideAdapter.NewsViewHolder> {

    private CardClickListener mCardClickListener;
    private ArrayList<NewsModel> mNewsList;

    ScreenVerticalSlideAdapter(CardClickListener cardClickListener) {
        mCardClickListener = cardClickListener;
        mNewsList = new ArrayList<>();
        setUpData();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_top_bottom, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.mHeadLine.setText(mNewsList.get(position).getNewsTitle());
        holder.mNewsSource.setText(mNewsList.get(position).getNewsSource());
        holder.mNewsBody.setText(mNewsList.get(position).getNewsBody());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }


    class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView mHeadLine, mNewsBody, mNewsSource;
        NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            mHeadLine = itemView.findViewById(R.id.news_title);
            mNewsSource = itemView.findViewById(R.id.news_source);
            mNewsBody = itemView.findViewById(R.id.news_body);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCardClickListener.onCardClick(getAdapterPosition());
                }
            });
        }
    }

    /**
     * Creating mock Data
     */
    private void setUpData() {
        mNewsList.add(new NewsModel("Amitabh Bachan pays off loans of 2,100 farmers in Bihar", "New's Body", "HT News", "lin"));
        mNewsList.add(new NewsModel("Amitabh Bachan pays off loans of 2,100 farmers in Bihar", "New's Body", "HT News", "lin"));
        mNewsList.add(new NewsModel("Amitabh Bachan pays off loans of 2,100 farmers in Bihar", "New's Body", "HT News", "lin"));
        mNewsList.add(new NewsModel("Amitabh Bachan pays off loans of 2,100 farmers in Bihar", "New's Body", "HT News", "lin"));
        mNewsList.add(new NewsModel("Amitabh Bachan pays off loans of 2,100 farmers in Bihar", "New's Body", "HT News", "lin"));
    }
}

interface CardClickListener {
    void onCardClick(int i);
}
