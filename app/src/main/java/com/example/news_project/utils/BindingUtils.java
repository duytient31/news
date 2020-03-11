package com.example.news_project.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.news_project.R;

public class BindingUtils {

    @BindingAdapter("setImagePoster")
    public static void setImagePoster(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .into(view);
    }
    @BindingAdapter("setAdapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
