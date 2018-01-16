package com.zcc.archdemo.datarepo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.zcc.archdemo.model.PagePOJO;

/**
 * Created by cc on 2018/1/16.
 */

public class PageRepo {

    private MutableLiveData<PagePOJO> mData;

    public PageRepo() {
        mData = new MutableLiveData<>();
    }

    public LiveData<PagePOJO> getData() {
        if (!fetch()) {
            loadLocal();
        }
        return mData;
    }

    private boolean fetch() {
        return true;
    }

    private void loadLocal() {

    }

    public void upDateText(String text) {
        PagePOJO p = mData.getValue();
        if (p == null) p = new PagePOJO();
        p.setText(text);
        mData.setValue(p);
    }


}
