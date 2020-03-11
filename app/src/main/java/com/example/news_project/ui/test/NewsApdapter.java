package com.example.news_project.ui.test;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news_project.R;
import com.example.news_project.data.model.News;
import com.example.news_project.databinding.ItemNewsBinding;
import com.example.news_project.utils.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class NewsApdapter extends RecyclerView.Adapter<NewsApdapter.ViewHolder> {
    private List<News> mNews;
    private ItemClickListener mListener;

    public NewsApdapter() {
        mNews = new ArrayList<>();
    }

    public void setNews(List<News> news) {
        mNews = news;
        notifyDataSetChanged();
    }

    public void updateAdapter(List<News> news) {
        if (mNews != null) {
            mNews.clear();
        }
        mNews.addAll(news);
        notifyDataSetChanged();
    }

    public void setListener(ItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNewsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_news, parent, false);
        return new ViewHolder(binding, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mNews.get(position));
    }

    @Override
    public int getItemCount() {
        return mNews != null ? 0 : mNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemNewsBinding mItemNewsBinding;
        private ItemNewsViewModel mItemNewsViewModel;

        public ViewHolder(ItemNewsBinding itemNewsBinding, ItemClickListener listener) {
            super(itemNewsBinding.getRoot());
            mItemNewsBinding = itemNewsBinding;
            mItemNewsViewModel = new ItemNewsViewModel(listener);
            mItemNewsBinding.setViewModel(mItemNewsViewModel);
        }

        public void bindData(News news) {
            mItemNewsViewModel.setItemListNewsBiding(news);
            mItemNewsBinding.executePendingBindings();
        }
    }
}
