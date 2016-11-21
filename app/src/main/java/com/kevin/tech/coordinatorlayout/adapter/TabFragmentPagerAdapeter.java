package com.kevin.tech.coordinatorlayout.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kevin.tech.coordinatorlayout.fragment.TabFragment;


/**
 * Created by Kevin on 2016/11/18.
 * Blog:http://blog.csdn.net/student9128
 * Description: The adapter for fragment of TabLayout
 */

public class TabFragmentPagerAdapeter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] mTitles = new String[]{"Tab1","Tab2","Tab3","Tab4","Tab5","Tab6","Tab7","Tab8"};

    public TabFragmentPagerAdapeter(FragmentManager fm) {
        super(fm);
    }

    public TabFragmentPagerAdapeter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
