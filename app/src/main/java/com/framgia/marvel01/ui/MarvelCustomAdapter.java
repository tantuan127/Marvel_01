package com.framgia.marvel01.ui;

import android.content.Context;
import android.content.Intent;
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
 * Created by levutantuan on 3/11/17.
 */
public class MarvelCustomAdapter extends RecyclerView.Adapter<MarvelCustomAdapter
    .MarvelViewHolder> {
    private List<Marvel> mMarvel;
    private int mRowLayout;
    private Context mContext;

    public class MarvelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LinearLayout mMarvellayout;
        private TextView mTextviewId, mTextviewName, mTextviewDescription;
        private ImageView mImageView;
        private ItemClickListener mItemClickListener;

        public MarvelViewHolder(View v) {
            super(v);
            mMarvellayout = (LinearLayout) v.findViewById(R.id.item_something);
            mTextviewId = (TextView) v.findViewById(R.id.text_id);
            mTextviewName = (TextView) v.findViewById(R.id.text_name);
            mTextviewDescription = (TextView) v.findViewById(R.id.text_description);
            mImageView = (ImageView) v.findViewById(R.id.image_icon_custom);
            v.setOnClickListener(this);
        }

        public void onClick(View v) {
            this.mItemClickListener.onItemClick(this.getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.mItemClickListener = itemClickListener;
        }

        public void bindData(Marvel marvel) {
            if (marvel == null) return;
            mTextviewId.setText(mContext.getString(R.string.title_ids) + marvel.getId());
            mTextviewName.setText(mContext.getString(R.string.title_names) + marvel.getName());
            mTextviewDescription
                .setText(mContext.getString(R.string.title_descriptons) + marvel.getDescription());
            Picasso.with(mContext).load(String.valueOf(marvel.getThumbnail().toString()))
                .into(mImageView);
        }
    }

    public MarvelCustomAdapter(List<Marvel> marvel, int rowLayout, Context context) {
        mMarvel = marvel;
        mRowLayout = rowLayout;
        mContext = context;
    }

    public MarvelViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mRowLayout, parent, false);
        return new MarvelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MarvelViewHolder holder, int position) {
        final Marvel marvels = mMarvel.get(position);
        holder.bindData(marvels);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
            }
        });
    }
        @Override
    public int getItemCount() {
        return mMarvel == null ? 0 : mMarvel.size();
    }
}