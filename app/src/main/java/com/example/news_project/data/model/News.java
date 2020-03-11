package com.example.news_project.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "favorite_table")
public class News extends BaseObservable implements Parcelable {
    @PrimaryKey()
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int mId;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String mTitle;

    @ColumnInfo(name ="source")
    @SerializedName("source")
    private String mSource;

    @ColumnInfo(name = "thumb")
    @SerializedName("thumb")
    private String mThumb;

    @ColumnInfo(name = "sourceLink")
    @SerializedName("sourceLink")
    private String mLink;

    @ColumnInfo(name = "contentText")
    @SerializedName("contentText")
    private String mContentText;

    @ColumnInfo(name ="nextpage")
    @SerializedName("nextpage")
    private String mNextPage;

    public News(int id, String title, String source, String thumb, String link, String contentText, String nextPage) {
        mId = id;
        mTitle = title;
        mSource = source;
        mThumb = thumb;
        mLink = link;
        mContentText = contentText;
        mNextPage = nextPage;
    }

    protected News(Parcel in) {
        mId = in.readInt();
        mTitle = in.readString();
        mSource = in.readString();
        mThumb = in.readString();
        mLink = in.readString();
        mContentText = in.readString();
        mNextPage = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public String getThumb() {
        return mThumb;
    }

    public void setThumb(String thumb) {
        mThumb = thumb;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public String getContentText() {
        return mContentText;
    }

    public void setContentText(String contentText) {
        mContentText = contentText;
    }

    public String getNextPage() {
        return mNextPage;
    }

    public void setNextPage(String nextPage) {
        mNextPage = nextPage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mTitle);
        dest.writeString(mSource);
        dest.writeString(mThumb);
        dest.writeString(mLink);
        dest.writeString(mContentText);
        dest.writeString(mNextPage);
    }
}
