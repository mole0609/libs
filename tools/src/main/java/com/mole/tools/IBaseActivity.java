package com.mole.tools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class IBaseActivity extends AppCompatActivity {
    protected String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XLog.d(TAG, "onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        XLog.d(TAG, "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        XLog.d(TAG, "onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        XLog.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        XLog.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XLog.d(TAG, "onDestroy()");
    }
}
