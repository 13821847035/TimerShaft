package com.ycm.man.timershaftlibrary;

/**
 * Created by man on 2018/1/22.
 */

public class RecyclerViewBin {

    public String type;//top 顶部 ，left 左边，right 右边

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RecyclerViewBin(String type) {
        this.type=type;
    }
}
