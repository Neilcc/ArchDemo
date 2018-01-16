package com.zcc.archdemo.datarepo.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.text.TextUtils;

/**
 * Created by cc on 2018/1/16.
 */

@Entity(tableName = "PageTable")
public class PageDBO {
    @Ignore
    Bitmap bitmap;
    private String text;
    @PrimaryKey
    private long time;
    private String mark;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

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

    public String getMark() {
        return TextUtils.isEmpty(mark) ? "" : mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
