package com.example.news_project.ui.Viewpager;

import android.os.Bundle;
import android.util.SparseArray;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.news_project.data.model.Category;
import com.example.news_project.ui.test.FragmentNewsDynamic;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Category> mCategories;
    private SparseArray<FragmentNewsDynamic> mFragmentDynamicSparseArray = new SparseArray<>();

    public ViewPagerAdapter(FragmentManager fm, List<Category> categories) {
        super(fm);
        mCategories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        return newInstace(mCategories.get(position));
    }

    private Fragment newInstace(Category category) {
        FragmentNewsDynamic fragmentNewsDynamic = new FragmentNewsDynamic();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KeyViewPager.CATEGORY, category);
        fragmentNewsDynamic.setArguments(bundle);
        return fragmentNewsDynamic;
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mCategories.get(position).getName();
    }
}
