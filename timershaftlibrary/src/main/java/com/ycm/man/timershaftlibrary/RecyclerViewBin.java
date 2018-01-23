package com.ycm.man.timershaftlibrary;

/**
 * Created by man on 2018/1/22.
 */

public class RecyclerViewBin {

    public String type;//top 顶部 ，left 左边，right 右边

    private int resoureId;


    public int getResoureId() {
        return resoureId;
    }

    public void setResoureId(int resoureId) {
        this.resoureId = resoureId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RecyclerViewBin(String type,int resoureId) {
        this.type=type;
        this.resoureId=resoureId;
    }
}
