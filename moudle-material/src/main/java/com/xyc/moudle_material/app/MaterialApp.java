package com.xyc.moudle_material.app;

import android.app.Application;

import com.xyc.base.BaseApp;

/**
 * Created by xieyusheng on 2019/1/2.
 */

public class MaterialApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        initModuleApp(this);
        initModuleData(this);
    }

    @Override
    public void initModuleApp(Application application) {
    }

    @Override
    public void initModuleData(Application application) {

    }
}

