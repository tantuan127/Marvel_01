package com.framgia.marvel01.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.framgia.marvel01.R;
import com.framgia.marvel01.data.Marvel;
import com.framgia.marvel01.data.MarvelResponse;
import com.framgia.marvel01.service.MarvelService;
import com.framgia.marvel01.service.ServiceGenerator;
import com.framgia.marvel01.service.APIUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView
    .OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ProgressDialog mDialog;
    private RecyclerView mRecycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getCharacterByApi();
        mRecycleview = (RecyclerView) findViewById(R.id.recyclee_view);
        mRecycleview.setLayoutManager(new LinearLayoutManager(this));
        mRecycleview.setItemAnimator(new DefaultItemAnimator());
        mRecycleview
            .addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
            this, mDrawerLayout, toolbar, R.string.title_main_drawer_open,
            R.string.title_main_drawer_close);
        mDrawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_actionbar, menu);
        menu.findItem(R.id.menu_search);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_bring_on_the_bad_guys:
                //TODO Intent Activity Bring on the bad guys
                break;
            case R.id.nav_women_of_marvel:
                //TODO Intent Activity women of marvel
                break;
            case R.id.nav_titanic_teams:
                //TODO Intent Activity titanic teams
                break;
            case R.id.nav_favorites:
                //TODO Intent Activity favorites
                break;
            case R.id.nav_listsave:
                //TODO Intent Activity listsave
            default:
                break;
        }
        return true;
    }

    private void initDialog() {
        mDialog = new ProgressDialog(this);
        mDialog.setCancelable(false);
        mDialog.setMessage(getString(R.string.title_loading));
    }

    private void showDialog() {
        if (mDialog == null) initDialog();
        if (!mDialog.isShowing()) mDialog.show();
    }

    private void dissmissDialog() {
        if (mDialog != null && mDialog.isShowing()) mDialog.dismiss();
    }

    private void getCharacterByApi() {
        showDialog();
        long timeStamp = System.currentTimeMillis();
        ServiceGenerator
            .createService(MarvelService.class)
            .getCharacters(timeStamp, APIUtil.API_KEY, APIUtil.getKey(timeStamp))
            .enqueue(new Callback<MarvelResponse>() {
                @Override
                public void onResponse(Call<MarvelResponse> call,
                                       Response<MarvelResponse> response) {
                    dissmissDialog();
                    if (!response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, R.string.title_error, Toast
                            .LENGTH_SHORT).show();
                        return;
                    } else {
                        List<Marvel> marvelList = response.body().getData().getMarvels();
                        mRecycleview.setAdapter(new MarvelCustomAdapter(
                            (ArrayList<Marvel>) marvelList, R.layout
                            .custom_adapter_recyclerview, getApplicationContext()));
                    }
                }

                @Override
                public void onFailure(Call<MarvelResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, R.string.error_no_network_connection,
                        Toast.LENGTH_SHORT)
                        .show();
                    dissmissDialog();
                }
            });
    }
}