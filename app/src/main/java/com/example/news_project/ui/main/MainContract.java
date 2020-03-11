package com.example.news_project.ui.main;

import com.example.news_project.data.model.Category;

import java.util.List;

public class MainContract {
    interface View {
        void onCategoryDataSource(List<Category>  categories);
    }
    interface Presenter{
        void loadCategory();
    }
}
