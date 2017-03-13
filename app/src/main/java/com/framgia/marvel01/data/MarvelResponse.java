package com.framgia.marvel01.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by levutantuan on 3/10/17.
 */
public class MarvelResponse {
    @SerializedName("code")
    private int mCode;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("copyright")
    private String mCopyright;
    @SerializedName("attributionText")
    private String mAttributionText;
    @SerializedName("attributionHTML")
    private String mAttributionHTML;
    @SerializedName("etag")
    private String mEtag;
    @SerializedName("data")
    private Data mData;

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        mCode = code;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getCopyright() {
        return mCopyright;
    }

    public void setCopyright(String copyright) {
        mCopyright = copyright;
    }

    public String getAttributionText() {
        return mAttributionText;
    }

    public void setAttributionText(String attributionText) {
        mAttributionText = attributionText;
    }

    public String getAttributionHTML() {
        return mAttributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        mAttributionHTML = attributionHTML;
    }

    public String getEtag() {
        return mEtag;
    }

    public void setEtag(String etag) {
        mEtag = etag;
    }

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public class Data {
        @SerializedName("offset")
        private int mOffset;
        @SerializedName("limit")
        private int mLimit;
        @SerializedName("total")
        private int mTotal;
        @SerializedName("count")
        private int mCount;
        @SerializedName("results")
        private List<Marvel> mMarvels = null;

        public int getOffset() {
            return mOffset;
        }

        public void setOffset(int offset) {
            mOffset = offset;
        }

        public int getLimit() {
            return mLimit;
        }

        public void setLimit(Integer limit) {
            mLimit = limit;
        }

        public int getTotal() {
            return mTotal;
        }

        public void setTotal(Integer total) {
            mTotal = total;
        }

        public int getCount() {
            return mCount;
        }

        public void setCount(int count) {
            mCount = count;
        }

        public List<Marvel> getMarvels() {
            return mMarvels;
        }

        public void setMarvels(List<Marvel> marvels) {
            mMarvels = marvels;
        }
    }
}
