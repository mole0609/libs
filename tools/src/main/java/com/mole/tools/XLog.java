/**
 * Copyright (c) 2021- Autolink
 * All Rights Reserved by Autolink Software Technology Co., Ltd and its affiliates.
 * You may not use, copy, distribute, modify, transmit in any form this file
 * except in compliance with Autolink in writing by applicable law.
 * <p>
 * author:vincent xiong
 */

package com.mole.tools;

import android.util.Log;

/**
 * Log util.
 *
 * @hide
 */
public class XLog {

    private XLog() {
    }

    private static final String LOG_TAG = "XLog";

    private static boolean sIsShowLog = true;

    private static final int ELEMENT = 5;

    public static void setShowLog(boolean isShowLog) {
        sIsShowLog = isShowLog;
    }

    public static void verbose() {
        outputLog(Log.VERBOSE, LOG_TAG, null, null);
    }

    public static void verbose(String message, Object... args) {
        outputLog(Log.VERBOSE, LOG_TAG, maybeFormat(message, args), null);
    }

    public static void verbose(Throwable throwable, String message, Object... args) {
        outputLog(Log.VERBOSE, LOG_TAG, maybeFormat(message, args), throwable);
    }

    public static void debug() {
        outputLog(Log.DEBUG, LOG_TAG, null, null);
    }

    public static void d(String tag, String message) {
        debug(message);
    }

    public static void debug(String message, Object... args) {
        outputLog(Log.DEBUG, LOG_TAG, maybeFormat(message, args), null);
    }


    public static void debug(Throwable throwable, String message, Object... args) {
        outputLog(Log.DEBUG, LOG_TAG, maybeFormat(message, args), throwable);
    }

    public static void info() {
        outputLog(Log.INFO, LOG_TAG, null, null);
    }

    public static void info(String message, Object... args) {
        outputLog(Log.INFO, LOG_TAG, maybeFormat(message, args), null);
    }

    public static void info(Throwable throwable, String message, Object... args) {
        outputLog(Log.INFO, LOG_TAG, maybeFormat(message, args), throwable);
    }

    public static void warning() {
        outputLog(Log.WARN, LOG_TAG, null, null);
    }

    public static void warning(String message, Object... args) {
        outputLog(Log.WARN, LOG_TAG, maybeFormat(message, args), null);
    }

    public static void warning(Throwable throwable, String message, Object... args) {
        outputLog(Log.WARN, LOG_TAG, maybeFormat(message, args), throwable);
    }

    public static void error() {
        outputLog(Log.ERROR, LOG_TAG, null, null);
    }

    public static void error(String message, Object... args) {
        outputLog(Log.ERROR, LOG_TAG, maybeFormat(message, args), null);
    }

    public static void error(Throwable throwable, String message, Object... args) {
        outputLog(Log.ERROR, LOG_TAG, maybeFormat(message, args), throwable);
    }

    private static void outputLog(int type, String tag, String message, Throwable throwable) {
        if (!sIsShowLog) {
            return;
        }

        if (message == null) {
            message = getStackTraceInfo();
        } else {
            message = getStackTraceInfo() + message;
        }

        switch (type) {
            case Log.VERBOSE:
                Log.v(tag, message, throwable);
                break;
            case Log.DEBUG:
                Log.d(tag, message, throwable);
                break;
            case Log.INFO:
                Log.i(tag, message, throwable);
                break;
            case Log.WARN:
                Log.w(tag, message, throwable);
                break;
            case Log.ERROR:
                Log.e(tag, message, throwable);
                break;
            default:
                break;
        }
    }

    static String getStackTraceInfo() {
        StackTraceElement element = Thread.currentThread().getStackTrace()[ELEMENT];

        String fullName = element.getClassName();
        String className = fullName.substring(fullName.lastIndexOf(".") + 1);
        String methodName = element.getMethodName();
        int lineNumber = element.getLineNumber();

        return "<<" + className + "#" + methodName + "#lineNumber:" + lineNumber + ">> ";
    }

    /**
     * printTrackInfo.
     */
    public static void printTrackInfo() {
        StringBuilder sb = new StringBuilder("");
        StackTraceElement[] stackElements = new Throwable().getStackTrace();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                sb.append(stackElements[i].toString() + "\n");
            }
        }
        outputLog(Log.DEBUG, LOG_TAG, sb.toString(), null);
    }

    private static String maybeFormat(String message, Object... args) {
        // If no varargs are supplied, treat it as a request to log the string without formatting.
        return args.length == 0 ? message : String.format(message, args);
    }
}

