package com.framgia.marvel01.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.framgia.marvel01.R;
import com.framgia.marvel01.data.Marvel;
import com.framgia.marvel01.data.MarvelSqlite;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity implements OnItemClickListener {
    private List<Marvel> mMarvelList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private FavoriteAdapter mAdapter;
    private MarvelSqlite mSqlite = new MarvelSqlite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        initView();
    }

    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_favorite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mMarvelList = mSqlite.getAllFavorite();
        mAdapter = new FavoriteAdapter(mMarvelList, R.layout.item_marvel, getApplicationContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(Marvel marvel) {
        startActivity(
            DetailFavorite.getDetailIntentFavorite(getApplicationContext(), marvel));
    }
}
