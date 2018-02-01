package com.myapplication.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import com.myapplication.R;
import com.myapplication.adapter.GridViewAdapter;
import com.myapplication.bean.DataBeans;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    private GridView gridView;
    //gridview资源
    private int[] icons = new int[]{R.mipmap.huo_owner, R.mipmap.huo_driver, R.mipmap.zhidanoa, R.mipmap.zhidanwang,R.mipmap.zhibuluo_yezhu, R.mipmap.zhibuluo_shop, R.mipmap.zhibuluo_wuye,R.mipmap.zhibuluo_wuye,R.mipmap.songjiulang,R.mipmap.zhicaibao};
    private String[] titles = new String[]{"货运宝(货主端)","货运宝(司机端)","智旦OA","智旦网","智部落(业主端)","智部落(商铺端)","智部落(物业管理)","智部落(物业调度)", "送酒郎","智财宝"};
    private String[] dates = new String[]{"TIME:2016-01-13", "TIME:2016-01-13", "TIME:2016-03-15","TIME:2016-03-18", "TIME:2016-04-16", "TIME:2016-04-16", "TIME:2016-04-16","TIME:2016-04-16","TIME:2016-06-11","TIME:2017-2-20"};

    private List<DataBeans> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gv);

        gridView.setOnItemClickListener(this);
        iniData();
        GridViewAdapter adapter = new GridViewAdapter(list, this);
        gridView.setAdapter(adapter);
    }

    public void iniData() {
        for (int i = 0; i < icons.length; i++) {
            list.add(new DataBeans(icons[i], titles[i], dates[i]));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0://货运宝(货主端)
                Intent intent0 = new Intent(MainActivity.this,Details_Huo_OwnerActivity.class);
                intent0.putExtra("id",position);
                startActivity(intent0);
                break;
            case 1://货运宝(司机端)
                Intent intent1 = new Intent(MainActivity.this,Details_Huo_DriverActivity.class);
                intent1.putExtra("id",position);
                startActivity(intent1);
                break;
            case 2://智旦OA
                Intent intent2 = new Intent(MainActivity.this,Details_ZhioaActivity.class);
                intent2.putExtra("id",position);
                startActivity(intent2);
                break;
            case 3://智旦网
                Intent intent3 = new Intent(MainActivity.this,WebView_ZhidanwangActivity.class);
                intent3.putExtra("id",position);
                startActivity(intent3);
                break;
            case 4://智部落(业主端)
                Intent intent4 = new Intent(MainActivity.this,Details_ZDCLAN_yezhuActivity.class);
                intent4.putExtra("id",position);
                startActivity(intent4);
                break;
            case 5://智部落(商铺端)
                Intent intent5 = new Intent(MainActivity.this,Details_ZDCLAN_shopActivity.class);
                intent5.putExtra("id",position);
                startActivity(intent5);
                break;
            case 6://智部落(物业管理)
                Intent intent6 = new Intent(MainActivity.this,Details_ZDCLAN_guanliActivity.class);
                intent6.putExtra("id",position);
                startActivity(intent6);
                break;
            case 7://智部落(物业调度)
                Intent intent7 = new Intent(MainActivity.this,Details_ZDCLAN_diaoduActivity.class);
                intent7.putExtra("id",position);
                startActivity(intent7);
                break;
            case 8://送酒郎
                Intent intent8 = new Intent(MainActivity.this,Details_SongjiulangActivity.class);
                intent8.putExtra("id",position);
                startActivity(intent8);
                break;
            case 9://智财宝
                Intent intent9 = new Intent(MainActivity.this,Details_ZhicaibaoActivity.class);
                intent9.putExtra("id",position);
                startActivity(intent9);
                break;
            default:
                break;
        }

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ){
            dialogExitShow(this,"提示","是否确认退出?","确定","取消");

        }
        return false;
    }
    public void dialogExitShow(final Context context, String title, String message, String sure, String cancle){
        //先new出一个监听器，设置好监听
        DialogInterface.OnClickListener dialogOnclicListener=new DialogInterface.OnClickListener(){
            @Override
            public void onClick(final DialogInterface dialog, int which) {
                switch(which){
                    case Dialog.BUTTON_POSITIVE:
                        dialog.dismiss();
                        finish();
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        dialog.dismiss();
                        break;
                    default:
                        break;
                }
            }
        };
        //dialog参数设置
        AlertDialog.Builder builder=new AlertDialog.Builder(context);  //先得到构造器
        builder.setTitle(title); //设置标题
        builder.setMessage(message); //设置内容
        builder.setPositiveButton(sure,dialogOnclicListener);
        builder.setNegativeButton(cancle, dialogOnclicListener);
        builder.create().show();
    }

}
