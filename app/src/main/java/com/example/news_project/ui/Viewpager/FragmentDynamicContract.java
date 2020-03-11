package com.example.news_project.ui.Viewpager;

import com.example.news_project.data.model.Category;

import java.util.List;

public interface FragmentDynamicContract {
    interface View {
        void onCategorySuccess(Category  category);

        void onCategortFailure(String message);
    }
    interface Presenter{
        void loadCategory();
    }
}
