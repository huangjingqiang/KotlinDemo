package com.hjq.kotlin;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by hjq on 17-4-18.
 */

public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
