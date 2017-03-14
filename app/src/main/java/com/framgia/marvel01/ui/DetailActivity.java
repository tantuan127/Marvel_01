package com.framgia.marvel01.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.framgia.marvel01.R;
import com.framgia.marvel01.data.Marvel;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private static final String EXTRA_MARVEL = "EXTRA_MARVEL";
    private TextView mTextId, mTextName, mTextDescription, mTextViewModified;
    private ImageView mImageView;

    public static Intent getDetailIntent(Context context, Marvel marvel) {
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra(EXTRA_MARVEL, marvel);
        return i;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
    }

    public void initView() {
        Marvel marvel = (Marvel) getIntent().getSerializableExtra(EXTRA_MARVEL);
        mTextId = (TextView) findViewById(R.id.text_id_detail);
        mTextName = (TextView) findViewById(R.id.text_name_detail);
        mTextViewModified = (TextView) findViewById(R.id.text_modified_detail);
        mTextDescription = (TextView) findViewById(R.id.text_description_detail);
        mImageView = (ImageView) findViewById(R.id.image_detail);
        mTextId.setText(marvel.getId());
        mTextName.setText(marvel.getName());
        mTextViewModified.setText(marvel.getModified());
        mTextDescription.setText(marvel.getModified());
        Picasso.with(this).load(marvel.getThumbnail().toString()).into(mImageView);
    }
}