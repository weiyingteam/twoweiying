package com.example.zdm.weiyingdemo.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.yolo.beautycamera.beauty_preview.BeautyCamera;
import com.yolo.livesdk.YoloLiveNative;

/**
 * author:Created by WeiWeiFeng on 2018/7/6.
 */
public class MyApp extends Application {
    private RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();

        // 底层lib初始化
        YoloLiveNative.init(this, false);
        // 美颜相机初始化
        BeautyCamera.init(getApplicationContext(), true);

        Fresco.initialize(this);
        refWatcher= setupLeakCanary();
    }
    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApp leakApplication = (MyApp) context.getApplicationContext();
        return leakApplication.refWatcher;
    }
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Fresco.initialize(this);
//
//    }
}
