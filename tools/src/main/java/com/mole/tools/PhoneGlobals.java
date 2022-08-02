package com.mole.tools;

import android.content.Context;
import android.content.ContextWrapper;

public class PhoneGlobals extends ContextWrapper {
    private static final String TAG = PhoneGlobals.class.getSimpleName();
    private static PhoneGlobals instance;
    private Context context;

    public PhoneGlobals(Context base) {
        super(base);
        this.context = base;
        instance = this;
    }

    public void onCreate() {
        XLog.d(TAG, "onCreate()");
    }

    public Context getContext() {
        return context;
    }

    public static PhoneGlobals getInstance() {
        if (instance == null) {
            throw new IllegalArgumentException("Here is no PhoneGlobals!");
        }
        return instance;
    }
}
