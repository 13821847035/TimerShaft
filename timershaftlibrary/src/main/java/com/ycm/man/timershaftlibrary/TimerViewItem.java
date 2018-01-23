package com.ycm.man.timershaftlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by man on 2018/1/23.
 */

public class TimerViewItem extends FrameLayout {


    private Context mContext;
    private int leftLineColor = R.color.colorTextChecked;//左边横线颜色
    private int rightLineColor = R.color.colorTextChecked;//右边横线颜色
    private int verticalLineColor = R.color.colorTextChecked;//竖线颜色

    private TextView leftAcross;//左边横线
    private TextView rightAcross;//左边横线
    private TextView viewRow;//竖线

    RelativeLayout top, son;//顶部还是下方单独

    private TextView tvCenterCircle; //中间的圆
    private LinearLayout llLeftItem; //左边的圆外层
    private LinearLayout llRightItem; //左边的圆外层


    public TimerViewItem(@NonNull Context context) {
        this(context, null);
    }

    public TimerViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.TimerViewItem);
        for (int i = 0; i < arr.length(); i++) {
            int index = arr.getIndex(i);
            if (index == R.styleable.TimerViewItem_LeftLineColor) {
                leftLineColor = arr.getResourceId(index, leftLineColor);
//                leftLineColor = arr.getColor(index, leftLineColor);
            }
            if (index == R.styleable.TimerViewItem_RightLineColor) {
                rightLineColor = arr.getResourceId(index, rightLineColor);
            }
            if (index == R.styleable.TimerViewItem_VerticalLineColor) {
                verticalLineColor = arr.getResourceId(index, verticalLineColor);
            }
        }
    }


    /***
     * 实例化View的各个组件
     * @param view
     */
    private void initView(View view) {
        leftAcross = (TextView) view.findViewById(R.id.left_across);
        rightAcross = (TextView) view.findViewById(R.id.right_across);
        viewRow = (TextView) view.findViewById(R.id.view_row);

        top = (RelativeLayout) view.findViewById(R.id.top);
        son = (RelativeLayout) view.findViewById(R.id.son);

        llRightItem = (LinearLayout) view.findViewById(R.id.ll_right_line);
        llLeftItem = (LinearLayout) view.findViewById(R.id.ll_left_item);

        tvCenterCircle = (TextView) view.findViewById(R.id.tv_center_circle);


    }


    public void setData(RecyclerViewBin recyclerViewBin) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.timer_item, null);
        initView(view);
        if ("top".equals(recyclerViewBin.getType())) {
            top.setVisibility(VISIBLE);
            son.setVisibility(GONE);
        } else {
            top.setVisibility(GONE);
            son.setVisibility(VISIBLE);
            if ("left".equals(recyclerViewBin.getType())) {
                hintAcross(true);
                setAcross();
            }
            if ("right".equals(recyclerViewBin.getType())) {
                hintAcross(false);
                setAcross();
            }
        }

        addView(view);

    }

    //设置线条颜色
    private void setAcross() {
        leftAcross.setBackgroundResource(leftLineColor);
        rightAcross.setBackgroundResource(rightLineColor);
        viewRow.setBackgroundResource(verticalLineColor);
    }

    private void hintAcross(boolean status) {
        //为真隐藏右边，为假隐藏左边
        if (status){
            llLeftItem.setVisibility(VISIBLE);
            llRightItem.setVisibility(GONE);
            leftAcross.setVisibility(VISIBLE);
            rightAcross.setVisibility(INVISIBLE);
        }else {
            llLeftItem.setVisibility(GONE);
            llRightItem.setVisibility(VISIBLE);
            leftAcross.setVisibility(INVISIBLE);
            rightAcross.setVisibility(VISIBLE);
        }
    }

}
