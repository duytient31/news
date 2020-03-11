package com.example.news_project.ui.Viewpager;

import android.content.Context;

import com.example.news_project.R;
import com.example.news_project.data.model.Category;

public class FragmentDynamicPresenter implements FragmentDynamicContract.Presenter {
    private FragmentDynamicContract.View mView;
    private Category mCategory;

    public FragmentDynamicPresenter(FragmentDynamicContract.View view, Category category) {
        mView = view;
        mCategory = category;
    }

    @Override
    public void loadCategory() {
        if (mCategory != null) {
            mView.onCategorySuccess(mCategory);
        } else {
            Context context = (Context) mView;
            if (context == null) {
                return;
            }
            mView.onCategortFailure(context.getString(R.string.category_empty));
        }
    }
}
