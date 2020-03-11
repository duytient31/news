package com.example.news_project.data.service;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceClient {
        public static final String BASE_URL = "http://45.76.191.33:8090/api/";

    public static RequestApi createServiceClient() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create(new Gson())).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(RequestApi.class);
    }
}
