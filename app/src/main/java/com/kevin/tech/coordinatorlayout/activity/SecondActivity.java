package com.kevin.tech.coordinatorlayout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kevin.tech.coordinatorlayout.R;
import com.kevin.tech.coordinatorlayout.adapter.FirstRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 2016/11/21.
 * Blog:http://blog.csdn.net/student9128
 * Description:
 */

public class SecondActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FirstRecyclerAdapter mAdapter;
    private List<String> mData = new ArrayList<>();
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle("Kevin");
        mCollapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(SecondActivity.this, R.color.white));
        mCollapsingToolbarLayout.setStatusBarScrimColor(ContextCompat.getColor(SecondActivity.this, R.color.colorAccent));
        iniData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FirstRecyclerAdapter(mData, SecondActivity.this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void iniData() {
        for (int i = 0;i<100;i++){
            mData.add("Hello, Item " + i);
        }
    }
}
