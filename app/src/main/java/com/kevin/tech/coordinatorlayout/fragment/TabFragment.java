package com.kevin.tech.coordinatorlayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.tech.coordinatorlayout.R;
import com.kevin.tech.coordinatorlayout.adapter.FirstRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Kevin on 2016/11/18.
 * Blog:http://blog.csdn.net/student9128
 * Description: TabFragment
 */

public class TabFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;
    private RecyclerView mRecyclerView;
    private List<String> mData = new ArrayList<>();
    private FirstRecyclerAdapter mMAdapter;

    public static TabFragment newInstance(int page) {
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_PAGE, page);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARGS_PAGE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.item_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_item);
        iniData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMAdapter = new FirstRecyclerAdapter(mData, getActivity());
        mRecyclerView.setAdapter(mMAdapter);
        return view;
    }

    private void iniData() {
        for (int i = 0; i < 100; i++) {
            mData.add("Hello, Item " + i);
        }
    }
}
