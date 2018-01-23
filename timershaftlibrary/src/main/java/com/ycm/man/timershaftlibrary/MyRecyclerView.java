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

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.ViewHolder> {

    private Context mContext;
    private List<RecyclerViewBin> data;
    private LayoutInflater inf;


    public MyRecyclerView(Context mContext, List<RecyclerViewBin> data) {
        this.mContext = mContext;
        inf = LayoutInflater.from(mContext);
        this.data = data;
    }


    public MyRecyclerView(Context mContext) {
        this.mContext = mContext;
        inf = LayoutInflater.from(mContext);
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 1) {
            view = inf.inflate(R.layout.top_view, parent, false);
            TopViewHolder holer = new TopViewHolder(view);
            return holer;
        }
        if (viewType == 2) {
            view = inf.inflate(R.layout.left_view, parent, false);
            LeftViewHolder holer = new LeftViewHolder(view);
            return holer;
        }
        if (viewType == 3) {
            view = inf.inflate(R.layout.right_view, parent, false);
            RightViewHolder holer = new RightViewHolder(view);
            return holer;
        }
        return null;

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Resources resource = mContext.getResources();
//        ColorStateList csGreen = (ColorStateList) resource.getColorStateList(R.color.colorGreen);
//        ColorStateList csYellow = (ColorStateList) resource.getColorStateList(R.color.colorTextChecked);
//        ColorStateList csGay = (ColorStateList) resource.getColorStateList(R.color.colorGrayGray);
        ColorStateList csGay = resource.getColorStateList(data.get(position).getResoureId());
        int i = getItemViewType(position);
        if (i == 1) {
            TopViewHolder holder1 = (TopViewHolder) holder;
            holder1.tvAllContent.setTextColor(csGay);
            holder1.tvAllContent.setText("头部啊");
        } else {
            DirectionHolder direction = (DirectionHolder) holder;
            GradientDrawable background = (GradientDrawable) direction.tvCenterCircle.getBackground();
            background.setStroke(1, mContext.getResources().getColor(R.color.colorGreen));
            direction.tvCenterCircle.setBackground(background);//中间圆
            direction.viewRow.setBackgroundResource(R.color.colorGreen);
            direction.viewAcross.setBackgroundResource(R.color.colorGreen);

            if (i == 2) {
                LeftViewHolder left = (LeftViewHolder) holder;
                left.tvAllContent.setText("左边啊");
            }
            if (i == 3) {
                RightViewHolder right = (RightViewHolder) holder;
                right.tvAllContent.setText("右边啊");
            }
        }


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
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class TopViewHolder extends ViewHolder {
        public TextView tvAllContent;

        public TopViewHolder(View itemView) {
            super(itemView);
            tvAllContent = (TextView) itemView.findViewById(R.id.tv_all_content);
        }
    }


    public class DirectionHolder extends ViewHolder {
        public TextView viewAcross, viewRow;//横线，竖线
        public TextView tvCenterCircle, tvAllContent, tvAllContentStatus;//中心的圆，和最右边的圆tvCenterCircle,
        public TextView tvDescribition, tvTime;//时间和描述
        public LinearLayout llLineItem;

        public DirectionHolder(View itemView) {
            super(itemView);
        }
    }

    public class LeftViewHolder extends DirectionHolder {

        public LeftViewHolder(View view) {
            super(view);
            llLineItem = (LinearLayout) view.findViewById(R.id.ll_line_item);
            viewRow = (TextView) view.findViewById(R.id.view_row);
            viewAcross = (TextView) view.findViewById(R.id.view_across);
            tvCenterCircle = (TextView) view.findViewById(R.id.tv_center_circle);
            tvAllContent = (TextView) view.findViewById(R.id.tv_all_content);
            tvAllContentStatus = (TextView) view.findViewById(R.id.tv_all_content_status);
            tvDescribition = (TextView) view.findViewById(R.id.tv_describition);
            tvTime = (TextView) view.findViewById(R.id.tv_time);

        }
    }

    public class RightViewHolder extends DirectionHolder {

        public RightViewHolder(View view) {
            super(view);
            llLineItem = (LinearLayout) view.findViewById(R.id.ll_line_item);
            viewRow = (TextView) view.findViewById(R.id.view_row);
            viewAcross = (TextView) view.findViewById(R.id.view_across);
            tvCenterCircle = (TextView) view.findViewById(R.id.tv_center_circle);
            tvAllContent = (TextView) view.findViewById(R.id.tv_all_content);
            tvAllContentStatus = (TextView) view.findViewById(R.id.tv_all_content_status);
            tvDescribition = (TextView) view.findViewById(R.id.tv_describition);
            tvTime = (TextView) view.findViewById(R.id.tv_time);
        }
    }
}
