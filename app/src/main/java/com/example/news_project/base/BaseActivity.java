package com.example.news_project.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initComponents();
        registerListener();
    }

    protected abstract void registerListener();

    protected abstract void initComponents();

    protected abstract int getLayoutId();
}
