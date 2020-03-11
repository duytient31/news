package com.example.news_project.ui.test;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;

import com.example.news_project.data.model.News;
import com.example.news_project.utils.ItemClickListener;

public class ItemNewsViewModel extends BaseObservable {
    private ObservableField<News> mNewsObservableField = new ObservableField<>();
    private ItemClickListener mNewsListener;

    public ItemNewsViewModel(ItemClickListener newsListener) {
        mNewsListener = newsListener;
    }

    void setItemListNewsBiding(News news) {
        mNewsObservableField.set(news);
    }

    public News getNews() {
        return mNewsObservableField.get();
    }

    public void onItemClicked(View view) {
        if (mNewsListener == null || mNewsObservableField.get() == null) {
            return;
        }
        mNewsListener.onItemClicked(mNewsObservableField.get().getId());
    }
}
