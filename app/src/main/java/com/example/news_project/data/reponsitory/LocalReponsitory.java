package com.example.news_project.data.reponsitory;

import com.example.news_project.data.model.Category;
import com.example.news_project.data.source.NewsDataSource;

import java.util.List;

public class LocalReponsitory {
    private static LocalReponsitory sLocalReponsitory;
    private NewsDataSource.Local mLocalDataSource;

    public LocalReponsitory(NewsDataSource.Local localDataSource) {
        mLocalDataSource = localDataSource;
    }

    public static LocalReponsitory getInstance(NewsDataSource.Local localDataSource) {
        if (sLocalReponsitory == null) {
            sLocalReponsitory = new LocalReponsitory(localDataSource);
        }
        return sLocalReponsitory;
    }

    public List<Category> getCategory(){
        return mLocalDataSource.getCategory();
    }
}
