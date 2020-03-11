package com.example.news_project.ui.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news_project.R;
import com.example.news_project.data.model.Category;
import com.example.news_project.data.model.News;
import com.example.news_project.databinding.FragmentDynamicBinding;
import com.example.news_project.ui.Viewpager.FragmentDynamicContract;
import com.example.news_project.ui.Viewpager.FragmentDynamicPresenter;
import com.example.news_project.ui.Viewpager.KeyViewPager;

import java.util.List;

public class FragmentNewsDynamic extends Fragment implements FragmentDynamicContract.View {
    private FragmentDynamicContract.Presenter mPresenter;
    private Category mCategory;
    private FragmentDynamicBinding mBinding;
    private NewsViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private NewsApdapter mNewsApdapter;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dynamic, container, false);
       /* View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        ButterKnife.bind(this, view);*/
        return mBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            mCategory = (Category) getArguments().getSerializable(KeyViewPager.CATEGORY);
        } else {
            return;
        }
        mPresenter = new FragmentDynamicPresenter(this, mCategory);
        mPresenter.loadCategory();
        mViewModel = new NewsViewModel(getActivity(), mCategory.getId());

        mBinding.setViewModel(mViewModel);
        mRecyclerView = view.findViewById(R.id.recycler);

    }

    @Override
    public void onCategorySuccess(Category category) {

    }

    @Override
    public void onCategortFailure(String message) {
    }
}
