package com.zcc.archdemo.datarepo;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.zcc.archdemo.datarepo.db.PageDAO;
import com.zcc.archdemo.datarepo.db.PageDBO;
import com.zcc.archdemo.datarepo.db.PageDataBase;
import com.zcc.archdemo.model.PagePOJO;

/**
 * Created by cc on 2018/1/16.
 */

public class PageRepo {

    PageDAO pageDAO;
    PageDataBase pageDataBase;
    private MutableLiveData<PagePOJO> mData;
    private Context appContext;

    public PageRepo(Context context) {
        appContext = context.getApplicationContext();
        mData = new MutableLiveData<>();
        pageDataBase = Room.databaseBuilder(appContext, PageDataBase.class, "page").build();
    }

    public LiveData<PagePOJO> getData() {
        if (!fetch()) {
            loadLocal();
        }
        return mData;
    }

    private boolean fetch() {
        return false;
    }

    @SuppressLint("StaticFieldLeak")
    private void loadLocal() {
        pageDAO = pageDataBase.getDAO();
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                PageDBO[] datas = pageDAO.queryAll();
                if (datas != null)
                    Log.d("test", datas.toString());
                else
                    Log.d("test", " null db ");
                return null;
            }
        }.execute();

    }

    public void upDateText(String text) {
        PagePOJO p = mData.getValue();
        if (p == null) p = new PagePOJO();
        p.setText(text);
        mData.setValue(p);
    }


}
