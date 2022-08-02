package com.mole.tools;

public class LibManager {

    private LibListener listener;
    private LibCallBack computeCallBack;

    public void register(LibListener listener) {
        this.listener = listener;
    }

    public void onClick(String s) {
        listener.sendData(s);
    }

    private static LibManager instance;

    public static LibManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("MyClickManager is null");
        }
        return instance;
    }

    public void  init(){
        instance = this;
    }

    public void compute(int n, LibCallBack callback) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
        callback.onComputeEnd();
    }

    public void sendData(String s) {
        computeCallBack.sendData(s);
    }

    public String getData() {
        return "getData";
    }
    public void registerListener(LibListener listener, LibCallBack computeCallBack) {
        this.listener = listener;
        this.computeCallBack = computeCallBack;
    }
    public void unRegisterListener() {
        this.listener = null;
        this.computeCallBack = null;
    }

}
