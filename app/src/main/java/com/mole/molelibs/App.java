package com.mole.molelibs;

import android.app.Application;

import com.mole.tools.LibManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new LibManager().init();
    }
}
