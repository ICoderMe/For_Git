package com.myapplication.utils;

import android.util.Log;

/**
 * Created by lenovo on 2016/9/29.
 */
public class LogUtils {
    /**
     * 是否打印log
     */
    public static boolean oIsLog = true;

//    public static String TAG = "test";
//
//    public static void setTag(String tag){
//        TAG = tag;
//    }
    public static void d(String TAG,String strings) {
        if (oIsLog) {
            Log.d(TAG, strings);
        }
    }
    public static void i(String TAG,String strings) {
        if (oIsLog) {
            Log.i(TAG, strings);
        }
    }
    public static void e(String TAG,String strings) {
        if (oIsLog) {
            Log.e(TAG, strings);

        }
    }

}
