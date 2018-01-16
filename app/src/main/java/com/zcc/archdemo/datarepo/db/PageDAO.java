package com.zcc.archdemo.datarepo.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

/**
 * Created by cc on 2018/1/16.
 */

@Dao
public interface PageDAO {

    @Query("select * from PageTable")
    public PageDBO[] queryAll();

}
