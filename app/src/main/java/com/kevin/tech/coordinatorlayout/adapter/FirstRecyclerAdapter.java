package com.kevin.tech.coordinatorlayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.tech.coordinatorlayout.R;

import java.util.List;

/**
 * Created by Kevin on 2016/11/21.
 * Blog:http://blog.csdn.net/student9128
 * Description:
 */

public class FirstRecyclerAdapter extends RecyclerView.Adapter<FirstRecyclerAdapter.MyViewHolder> {
    private List<String> mData;
    private Context mContext;

    public FirstRecyclerAdapter(List<String> data, Context context) {
        mData = data;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_activity_first,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
