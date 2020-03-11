package com.example.news_project.data.reponsitory;

import com.example.news_project.data.model.News;
import com.example.news_project.data.source.NewsDataSource;
import com.example.news_project.data.source.remote.NewsRemoteData;

import io.reactivex.Single;

public class RemoteReponsitory implements NewsDataSource.Remote {
    private static RemoteReponsitory sRemoteReponsitory;
    private NewsRemoteData mNewsRemoteData;

    public RemoteReponsitory(NewsRemoteData newsRemoteData) {
        mNewsRemoteData = newsRemoteData;
    }

    public static RemoteReponsitory getInstance(NewsRemoteData newsRemoteData) {
        if (sRemoteReponsitory == null) {
            sRemoteReponsitory = new RemoteReponsitory(newsRemoteData);
        }
        return sRemoteReponsitory;
    }

    @Override
    public Single<News> getNew(int idMovie, int page) {
        return mNewsRemoteData.getNew(idMovie, page);
    }

}
