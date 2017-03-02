package com.framgia.marvel01.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by levutantuan on 3/10/17.
 */
public class Marvel {
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

    public Object getModified() {
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

    public class Thumbnail {
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