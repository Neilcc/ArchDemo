package com.zcc.archdemo.datarepo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by cc on 2018/1/16.
 */

@Database(entities = {PageDBO.class}, version = 1)
public abstract class PageDataBase extends RoomDatabase {


    public abstract PageDAO getDAO();
}
