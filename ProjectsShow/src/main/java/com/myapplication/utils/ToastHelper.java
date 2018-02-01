package com.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Introduction:
 * Author：LC
 * Date: 2017/2/15
 */
public class ToastHelper {
    /**
     * 显示TOAST
     * @param context
     * @param text
     */
    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
