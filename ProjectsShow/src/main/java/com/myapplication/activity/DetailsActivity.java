package com.myapplication.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.R;

import java.util.List;

/**
 * Created by lenovo on 2016/8/25.
 */
public class DetailsActivity extends Activity implements View.OnClickListener{
    private ImageView iv_back;
    private TextView btn_play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        iv_back = (ImageView) findViewById(R.id.iv_details_back);
        btn_play = (TextView) findViewById(R.id.tv_play);

        iv_back.setOnClickListener(this);
        btn_play.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_details_back:
                DetailsActivity.this.finish();
                break;
            case R.id.tv_play:
                Intent intent = new Intent(DetailsActivity.this,WebViewActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    //已知包名,启动另一个app
    private void doStartApplicationWithPackageName(String packagename) {

        // 通过包名获取此APP详细信息，包括Activities、services、versioncode、name等等
        PackageInfo packageinfo = null;
        try {
            packageinfo = getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageinfo == null) {
            return;
        }

        // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(packageinfo.packageName);

        // 通过getPackageManager()的queryIntentActivities方法遍历
        List<ResolveInfo> resolveinfoList = getPackageManager()
                .queryIntentActivities(resolveIntent, 0);

        ResolveInfo resolveinfo = resolveinfoList.iterator().next();
        if (resolveinfo != null) {
            // packagename = 参数packname
            String packageName = resolveinfo.activityInfo.packageName;
            // 这个就是我们要找的该APP的LAUNCHER的Activity[组织形式：packagename.mainActivityname]
            String className = resolveinfo.activityInfo.name;
            // LAUNCHER Intent
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);

            // 设置ComponentName参数1:packagename参数2:MainActivity路径
            ComponentName cn = new ComponentName(packageName, className);
            Log.i("classname>>>>>>>>>>>>>",className);
            intent.setComponent(cn);
            startActivity(intent);
        }
    }
}
