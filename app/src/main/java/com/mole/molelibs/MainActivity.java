package com.mole.molelibs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;


import com.mole.tools.LibCallBack;
import com.mole.tools.LibListener;
import com.mole.tools.LibManager;
import com.mole.tools.message.MsgBaseHandler;
import com.mole.tools.message.MsgHandlerCenter;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LibManager.getInstance().onClick("hahaha");
            }
        });

        //注册
        LibManager.getInstance().registerListener(listener, callBack);

        MsgHandlerCenter.registerMessageHandler(new LocalHandler(this));
    }

    private static class LocalHandler extends MsgBaseHandler {
        private final WeakReference<Activity> reference;

        public LocalHandler(Activity activity) {
            super();
            reference = new WeakReference<>(activity);
        }

        public LocalHandler(Looper looper, Activity activity) {
            super(looper);
            reference = new WeakReference<>(activity);
        }

        @Override
        public void careAbout() {
            addMsg(1);
            addMsg(2);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (reference.get() != null) {
                switch (msg.what) {
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销注册
        LibManager.getInstance().unRegisterListener();
    }

    //回调数据
    private LibCallBack callBack = new LibCallBack() {
        @Override
        public void onComputeEnd() {

        }

        @Override
        public void sendData(String s) {

        }
    };

    //发送数据
    private LibListener listener = new LibListener() {
        @Override
        public void sendData(String s) {
            TextView view1;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                ((TextView) findViewById(R.id.halo)).setText(s);
            }
        }
    };
}