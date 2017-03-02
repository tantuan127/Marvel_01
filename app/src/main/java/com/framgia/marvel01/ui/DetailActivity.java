package com.framgia.marvel01.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.framgia.marvel01.R;

public class DetailActivity extends AppCompatActivity {
    private TextView mTextViewId, mTextViewName, mTextViewDescription;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mTextViewId = (TextView) findViewById(R.id.text_id_detail);
        mTextViewName = (TextView) findViewById(R.id.text_name_detail);
        mTextViewDescription = (TextView) findViewById(R.id.text_description_detail);
        mImageView = (ImageView) findViewById(R.id.image_detail);
        Intent i = this.getIntent();
        String id = String.valueOf(i.getExtras().getString("mId"));
        String name = i.getExtras().getString("mName");
        String description = i.getExtras().getString("mDescription");
        String img = i.getExtras().getString("mThumbnail");
        mTextViewId.setText(id);
        mTextViewName.setText(name);
        mTextViewDescription.setText(description);
        mImageView.setImageURI(Uri.parse(img));
    }
}
