package com.example.news_project.data.service;

import com.example.news_project.data.model.News;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestApi {
    @GET("get_arc_by_catid")
    Single<News> getNews(@Query("catid") int idCategory, @Query("page") int page);

    @GET("get_arc_by_catid?catid=2&page=4")
    Call<List<News>> getNewsAll();
}
