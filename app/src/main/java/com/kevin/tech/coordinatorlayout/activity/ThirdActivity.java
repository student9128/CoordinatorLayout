package com.kevin.tech.coordinatorlayout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.kevin.tech.coordinatorlayout.R;
import com.kevin.tech.coordinatorlayout.adapter.FirstRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/11/22.
 * Blog:http://blog.csdn.net/student9128
 * Description:
 */

public class ThirdActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    private CoordinatorLayout mCoordinatorLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private FirstRecyclerAdapter mAdapter;
    private List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coorinator_layout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FirstRecyclerAdapter(mData, this);
        mRecyclerView.setAdapter(mAdapter);
        mCollapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(this, R.color.green));
        mCollapsingToolbarLayout.setTitle("Kevin");
        mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.Red_500));
//        mCollapsingToolbarLayout.setStatusBarScrimColor(ContextCompat.getColor(this,R.color.green));
        mToolbar.setOnMenuItemClickListener(this);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            mData.add("CoordinatorLayout Item " + i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.message:
                Snackbar.make(mCoordinatorLayout, "Message", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Snackbar.make(mCoordinatorLayout, "Share", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Snackbar.make(mCoordinatorLayout, "Settings", Snackbar.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }
}
