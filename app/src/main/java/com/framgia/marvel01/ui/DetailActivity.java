package com.framgia.marvel01.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.framgia.marvel01.R;
import com.framgia.marvel01.data.Marvel;
import com.framgia.marvel01.data.MarvelSqlite;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private static final String EXTRA_MARVEL = "EXTRA_MARVEL";
    private TextView mTextId, mTextName, mTextDescription, mTextViewModified;
    private ImageView mImageView;
    private ImageButton mImageButtonLike;
    private String mUrlImage;
    private MarvelSqlite mDb = new MarvelSqlite(this);
    private Marvel mMarvel = new Marvel();

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
        mMarvel = (Marvel) getIntent().getSerializableExtra(EXTRA_MARVEL);
        mTextId = (TextView) findViewById(R.id.text_id_detail);
        mTextName = (TextView) findViewById(R.id.text_name_detail);
        mTextViewModified = (TextView) findViewById(R.id.text_modified_detail);
        mTextDescription = (TextView) findViewById(R.id.text_description_detail);
        mImageView = (ImageView) findViewById(R.id.image_detail);
        mImageButtonLike = (ImageButton) findViewById(R.id.button_like);
        mTextId.setText(mMarvel.getId());
        mTextName.setText(mMarvel.getName());
        mTextViewModified.setText(mMarvel.getModified());
        mTextDescription.setText(mMarvel.getDescription());
        Picasso.with(getApplicationContext()).load(mMarvel.getThumbnail().toString())
            .into(mImageView);
        mImageButtonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMarvel.setTitle(mMarvel.getThumbnail().toString());
                mDb.insertFavorites(mMarvel);
                Toast.makeText(getApplicationContext(), R.string.msg_add_to_favorite,
                    Toast.LENGTH_SHORT)
                    .show();
            }
        });
    }
}