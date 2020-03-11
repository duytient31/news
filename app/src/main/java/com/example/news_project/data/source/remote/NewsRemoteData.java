package com.example.news_project.data.source.remote;

import com.example.news_project.data.model.News;
import com.example.news_project.data.service.RequestApi;
import com.example.news_project.data.service.ServiceClient;
import com.example.news_project.data.source.NewsDataSource;

import java.util.List;

import io.reactivex.Single;

public class NewsRemoteData implements NewsDataSource.Remote {
    private static NewsRemoteData sRemoteData;
    private RequestApi mApi;

    public NewsRemoteData(RequestApi api) {
        mApi = api;
    }

    public static NewsRemoteData getInstance() {
        if (sRemoteData == null) {
            sRemoteData = new NewsRemoteData(ServiceClient.createServiceClient());
        }
        return sRemoteData;
    }

    @Override
    public Single<News> getNew(int idMovie, int page) {
        return mApi.getNews(idMovie, page);
    }
}
