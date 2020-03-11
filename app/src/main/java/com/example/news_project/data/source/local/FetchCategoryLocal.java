package com.example.news_project.data.source.local;

import android.content.Context;

import com.example.news_project.data.model.Category;
import com.example.news_project.data.source.NewsDataSource;

import java.util.ArrayList;
import java.util.List;

public class FetchCategoryLocal implements NewsDataSource.Local {
    private Context mContext;

    @Override
    public List<Category> getCategory() {
        List<Category> categories = new ArrayList<>();
        Category c1 = new Category(0, "Tin Nổi Bật");
        Category c2 = new Category(1, "Pháp Luật");
        Category c3 = new Category(2, "Thế Giới");
        Category c4 = new Category(3, "Thể Thao");
        Category c5 = new Category(4, "Xã Hội");
        Category c6 = new Category(5, "Văn Hoá");
        Category c7 = new Category(6, "Kinh Tế");
        Category c8 = new Category(7, "Công Nghệ");
        Category c9 = new Category(8, "Giải Trí");
        Category c10 = new Category(9, "Giáo Dục");
        Category c11 = new Category(10, "Sức Khoẻ");
        Category c12 = new Category(11, "Nhà Đất");
        Category c13 = new Category(12, "Xe Cộ");
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);
        categories.add(c5);
        categories.add(c6);
        categories.add(c7);
        categories.add(c8);
        categories.add(c9);
        categories.add(c10);
        categories.add(c11);
        categories.add(c12);
        categories.add(c13);
        return categories;
    }
}
