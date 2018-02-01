package com.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.myapplication.R;

/**
 * Created by lenovo on 2016/8/24.
 */
public class StartActivity extends Activity {
    private ImageView iv_page;
    private static final int GOTO_MAIN_ACTIVITY = 0;

    Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;

                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        iv_page = (ImageView) findViewById(R.id.iv_page);

//        int mheight = iv_page.getHeight();
//
//        AnimationSet animationSet = new AnimationSet(true);

        //初始化
//        TranslateAnimation animation = new TranslateAnimation(0f, 0f,0f,mheight);
//
//        animation.setDuration(3000);//设置动画持续时间
//        animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
//        animation.setStartOffset(100);//执行前的等待时间
//        animationSet.addAnimation(animation);
//        iv_page.startAnimation(animationSet);

        mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 3000);
    }
}
