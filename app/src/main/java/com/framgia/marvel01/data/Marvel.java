package com.framgia.marvel01.data;

import android.database.Cursor;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by levutantuan on 3/10/17.
 */
public class Marvel implements Serializable {
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("modified")
    private String mModified;
    @SerializedName("thumbnail")
    private Thumbnail mThumbnail;
    private String mTitle;

    public Marvel() {
    }

    public Marvel(Cursor cursor) {
        mId = cursor.getString(cursor.getColumnIndex(MarvelSqlite.COMLUMN_ID));
        mName = cursor.getString(cursor.getColumnIndex(MarvelSqlite.COMLUMN_NAME));
        mModified = cursor.getString(cursor.getColumnIndex(MarvelSqlite.COMLUMN_MODIFIED));
        mDescription = cursor.getString(cursor.getColumnIndex(MarvelSqlite.COMLUMN_DESCRIPTION));
        mTitle = cursor.getString(cursor.getColumnIndex(MarvelSqlite.COMLUMN_TITLE));
    }

    public Marvel(String id, String name, String description, String modified,
                  Thumbnail thumbnail, String title) {
        mId = id;
        mName = name;
        mDescription = description;
        mModified = modified;
        mThumbnail = thumbnail;
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public String toString() {
        return mTitle + "";
    }

    @SerializedName("urls")
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getModified() {
        return mModified;
    }

    public void setModified(String modified) {
        mModified = modified;
    }

    public Thumbnail getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        mThumbnail = thumbnail;
    }

    public class Thumbnail implements Serializable {
        @SerializedName("path")
        private String mPath;
        @SerializedName("extension")
        private String mExtension;

        public String getPath() {
            return mPath;
        }

        public void setPath(String path) {
            mPath = path;
        }

        public String getExtension() {
            return mExtension;
        }

        public void setExtension(String extension) {
            mExtension = extension;
        }

        @Override
        public String toString() {
            return mPath + "." + mExtension;
        }
    }
}