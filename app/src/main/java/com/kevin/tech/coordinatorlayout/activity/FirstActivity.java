package com.kevin.tech.coordinatorlayout.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kevin.tech.coordinatorlayout.R;
import com.kevin.tech.coordinatorlayout.adapter.MyViewPagerAdapter;
import com.kevin.tech.coordinatorlayout.adapter.TabFragmentPagerAdapeter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Kevin on 2016/11/21.
 * Blog:http://blog.csdn.net/student9128
 * Description:
 */

public class FirstActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mData = new ArrayList<>();
    private ViewPager mViewPagerTop, mViewPagerBottom;
    private TabLayout mTabLayout;
    private TabFragmentPagerAdapeter mAdapterBottom;

    private LinearLayout mIndicator;
    private ImageView[] mImageView;
    private int[] mImageArr = new int[]{R.drawable.slideimage1, R.drawable.slideimage2, R.drawable.slideimage3};
    private MyViewPagerAdapter mAdapter;
    private Timer mTimer;
    private static final int UPDATE_VIEWPAGER = 100;
    private boolean isLoop = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mViewPagerTop = (ViewPager) findViewById(R.id.view_pager);
        mViewPagerBottom = (ViewPager) findViewById(R.id.view_pager_1);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTimer = new Timer();
        mIndicator = (LinearLayout) findViewById(R.id.indicator);
        mAdapter = new MyViewPagerAdapter(this, mImageArr);
        mViewPagerTop.setAdapter(mAdapter);

        mAdapterBottom = new TabFragmentPagerAdapeter(getSupportFragmentManager());
        mViewPagerBottom.setAdapter(mAdapterBottom);
        mTabLayout.setupWithViewPager(mViewPagerBottom);
        iniData();


        mViewPagerTop.setCurrentItem(5000 * (mImageArr.length));
        mViewPagerTop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isLoop = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        isLoop = true;
                        break;
                }
                return false;
            }
        });
        initIndicator();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = UPDATE_VIEWPAGER;
                if (isLoop) {//如果isLoop = true 才进行轮播
                    handler.sendMessage(message);
                }
            }
        }, 3000, 5000);//这里定义了轮播图切换的间隔时间
        mViewPagerTop.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setIndicator(position);
                Log.i("kevin", position + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void iniData() {
        for (int i = 0; i < 100; i++) {
            mData.add("Hello, Item " + i);
        }
    }


    private void initIndicator() {
        mImageView = new ImageView[mImageArr.length];
        for (int i = 0; i < mImageArr.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.indicator_image, null);
            view.findViewById(R.id.indicator_iamge).setBackgroundResource(R.drawable.shape_origin_point_pink);
            mImageView[i] = new ImageView(this);
            if (i == 0) {
                mImageView[i].setBackgroundResource(R.drawable.shape_origin_point_pink);
            } else {
                mImageView[i].setBackgroundResource(R.drawable.shape_origin_point_white);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(20, 0, 0, 0);
                mImageView[i].setLayoutParams(layoutParams);
            }
            mIndicator.addView(mImageView[i]);
        }
    }

    private void setIndicator(int position) {
        position %= mImageArr.length;
        for (int i = 0; i < mImageArr.length; i++) {
            mImageView[i].setBackgroundResource(R.drawable.shape_origin_point_pink);
            if (position != i) {
                mImageView[i].setBackgroundResource(R.drawable.shape_origin_point_white);
            }

        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_VIEWPAGER:
                    mViewPagerTop.setCurrentItem(mViewPagerTop.getCurrentItem() + 1, true);
                    break;
            }
        }
    };
}
