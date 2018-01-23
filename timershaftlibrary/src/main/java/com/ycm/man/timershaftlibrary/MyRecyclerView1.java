package com.ycm.man.timershaftlibrary;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by man on 2018/1/22.
 */

public class MyRecyclerView1 extends RecyclerView.Adapter<MyRecyclerView1.ViewHolder> {

    private Context mContext;
    private List<RecyclerViewBin> data;
    private LayoutInflater inf;


    public MyRecyclerView1(Context mContext, List<RecyclerViewBin> data) {
        this.mContext = mContext;
        inf = LayoutInflater.from(mContext);
        this.data = data;
    }


    public MyRecyclerView1(Context mContext) {
        this.mContext = mContext;
        inf = LayoutInflater.from(mContext);
    }


    @Override
    public MyRecyclerView1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inf.inflate(R.layout.my_recycler_view, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.my_timer_item.setData(data.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        if ("top".equals(data.get(position).getType())) {
            return 1;
        }
        if ("left".equals(data.get(position).getType())) {
            return 2;
        }
        if ("right".equals(data.get(position).getType())) {
            return 3;
        }
        return 2;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<RecyclerViewBin> data) {
        this.data = data;
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TimerViewItem my_timer_item;

        public ViewHolder(View itemView) {
            super(itemView);
            my_timer_item = (TimerViewItem) itemView.findViewById(R.id.my_timer_item);
        }
    }

}
