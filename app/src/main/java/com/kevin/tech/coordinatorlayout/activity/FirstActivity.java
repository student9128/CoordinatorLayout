package com.kevin.tech.coordinatorlayout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class FirstActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FirstRecyclerAdapter mAdapter;
    private List<String> mData = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        iniData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FirstRecyclerAdapter(mData, FirstActivity.this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void iniData() {
        for (int i = 0;i<100;i++){
            mData.add("Hello, Item " + i);
        }
    }
}
