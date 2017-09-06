package com.example.mvpdemo.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by hasee on 2017/9/5.
 */

public class MyAppcation extends Application {

    private static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    public static Context appContext() {
        return appContext;
    }
}
