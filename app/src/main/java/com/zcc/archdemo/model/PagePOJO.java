package com.zcc.archdemo.model;

import android.text.TextUtils;

/**
 * Created by cc on 2018/1/16.
 */

public class PagePOJO {
    private String text;
    private long time;

    public String getText() {
        return TextUtils.isEmpty(text) ? "" : text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
