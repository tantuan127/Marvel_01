package com.framgia.marvel01.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framgia.marvel01.R;
import com.framgia.marvel01.data.Marvel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by levutantuan on 3/17/17.
 */
public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter
    .MarvelViewHolder> {
    private List<Marvel> mMarvel;
    private int mRowLayout;
    private Context mContext;
    private OnItemClickListener mItemClickListener;

    public FavoriteAdapter(List<Marvel> marvel, int
        rowLayout, Context context) {
        mMarvel = marvel;
        mRowLayout = rowLayout;
        mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public FavoriteAdapter.MarvelViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mRowLayout, parent, false);
        return new FavoriteAdapter.MarvelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoriteAdapter.MarvelViewHolder holder, int position) {
        Marvel marvels = mMarvel.get(position);
        holder.bindData(marvels);
    }

    @Override
    public int getItemCount() {
        return mMarvel == null ? 0 : mMarvel.size();
    }

    public class MarvelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LinearLayout mMarvellayout;
        private TextView mTextviewId, mTextviewName, mTextViewModified, mTextViewTitle;
        private ImageView mImageView;

        public MarvelViewHolder(View v) {
            super(v);
            mMarvellayout = (LinearLayout) v.findViewById(R.id.item_something);
            mTextviewId = (TextView) v.findViewById(R.id.text_id);
            mTextviewName = (TextView) v.findViewById(R.id.text_name);
            mTextViewModified = (TextView) v.findViewById(R.id.text_modified);
            mImageView = (ImageView) v.findViewById(R.id.image_icon_custom);
            v.setOnClickListener(this);
        }

        public void bindData(Marvel marvel) {
            if (marvel == null) return;
            mTextviewId.setText(mContext.getString(R.string.title_ids) + marvel.getId());
            mTextviewName.setText(mContext.getString(R.string.title_names) + marvel.getName());
            mTextViewModified.setText(marvel.getModified());
            Picasso.with(mContext).load(marvel.getTitle()).into(mImageView);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(mMarvel.get(getPosition()));
            }
        }
    }
}

