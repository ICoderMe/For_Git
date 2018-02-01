package com.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.R;

/**
 * Created by lenovo on 2016/8/25.
 */
public class Details_ZhidanwangActivity extends Activity implements View.OnClickListener{
    private ImageView iv_back;
    private TextView btn_play;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_zhioa);
        iv_back = (ImageView) findViewById(R.id.iv_details_back);
        btn_play = (TextView) findViewById(R.id.tv_play);

        iv_back.setOnClickListener(this);
        btn_play.setOnClickListener(this);

        id= getIntent().getIntExtra("id",0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_details_back:
                Details_ZhidanwangActivity.this.finish();
                break;
            case R.id.tv_play:
                Intent intent = new Intent(Details_ZhidanwangActivity.this,WebViewActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
