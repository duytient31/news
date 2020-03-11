package com.example.news_project.ui.test;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.ObservableField;

import com.example.news_project.data.model.News;
import com.example.news_project.data.reponsitory.RemoteReponsitory;
import com.example.news_project.data.service.RequestApi;
import com.example.news_project.ui.main.MainActivity;
import com.example.news_project.utils.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel implements ItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    //public final ObservableField<News> mNews = new ObservableField<>();

    public ObservableField<NewsApdapter> mNewsApdapterObservableField;
    private NewsApdapter mNewsApdapter;
    private CompositeDisposable mCompositeDisposable;
    private RemoteReponsitory mReponsitory;
    private Context mContext;
    private List<News> mNews;

    public NewsViewModel(Context context, int id) {
        mContext = context;
        mNewsApdapterObservableField = new ObservableField<>();
        mNewsApdapter = new NewsApdapter();
      /*  mCompositeDisposable = new CompositeDisposable();
        mReponsitory = RemoteReponsitory.getInstance(NewsRemoteData.getInstance());*/
        mNewsApdapter.setListener(this);
        getListNewsById(id);

    }

    private void getListNewsById(int id) {
        mNews = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://45.76.191.33:8090/api/").addConverterFactory(GsonConverterFactory.create()).build();
        RequestApi requestInterface = retrofit.create(RequestApi.class);
        Call<List<News>> call = requestInterface.getNewsAll();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                mNewsApdapterObservableField.set(mNewsApdapter);
                mNews = response.body();
                mNewsApdapter.updateAdapter(mNews);
                mNewsApdapter.setNews(mNews);
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClicked(int id) {
        Log.d(TAG, "onItemClicked: " + id);
    }
}

