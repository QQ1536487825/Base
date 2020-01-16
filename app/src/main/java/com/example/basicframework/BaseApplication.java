package com.example.basicframework;

import android.app.Application;

import org.xutils.x;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /*Xutils初始化*/
        x.Ext.init(this);
    }
}
