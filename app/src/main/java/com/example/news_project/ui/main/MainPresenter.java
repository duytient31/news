package com.example.news_project.ui.main;

import com.example.news_project.data.model.Category;
import com.example.news_project.data.reponsitory.LocalReponsitory;
import com.example.news_project.data.source.local.FetchCategoryLocal;
import com.example.news_project.ui.main.MainContract;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;

    private LocalReponsitory mReponsitory;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mReponsitory = LocalReponsitory.getInstance(new FetchCategoryLocal());
    }


    @Override
    public void loadCategory() {
        List<Category> categories = mReponsitory.getCategory();
        mView.onCategoryDataSource(categories);
    }

}
