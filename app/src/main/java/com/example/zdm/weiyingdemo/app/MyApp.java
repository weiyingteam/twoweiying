package com.example.zdm.weiyingdemo.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

    }
}
