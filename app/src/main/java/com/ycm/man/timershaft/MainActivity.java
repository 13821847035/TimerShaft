package com.ycm.man.timershaft;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.ycm.man.timershaftlibrary.MyRecyclerView;
import com.ycm.man.timershaftlibrary.RecyclerViewBin;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_timer_shaft;
    private Context mContext;
    private List<RecyclerViewBin> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;
        data=new ArrayList<>();
        data.add(new RecyclerViewBin("top",R.color.colorAccent));
        data.add(new RecyclerViewBin("left",R.color.colorPrimaryDark));
        data.add(new RecyclerViewBin("right",R.color.colorAccent));
        data.add(new RecyclerViewBin("left",R.color.colorPrimaryDark));
        data.add(new RecyclerViewBin("right",R.color.colorAccent));
        rv_timer_shaft = (RecyclerView) findViewById(R.id.rv_timer_shaft);
//        MyRecyclerView myRecyclerView = new MyRecyclerView(mContext,data);
        MyRecyclerView myRecyclerView = new MyRecyclerView(mContext);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        // 设置布局管理器
        rv_timer_shaft.setLayoutManager(layoutManager);
        rv_timer_shaft.setAdapter(myRecyclerView);
        myRecyclerView.setData(data);
    }
}
