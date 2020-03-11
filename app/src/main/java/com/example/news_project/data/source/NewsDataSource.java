package com.example.news_project.data.source;

import com.example.news_project.data.model.Category;
import com.example.news_project.data.model.News;

import java.util.List;

import io.reactivex.Single;

public interface NewsDataSource {
    interface Local {
        List<Category> getCategory();
    }

    interface Remote {
        Single<News> getNew(int idMovie,int page);
    }
}
