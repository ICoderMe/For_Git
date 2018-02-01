package com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.bean.DataBeans;

import java.util.List;

/**
 * Created by lenovo on 2016/8/25.
 */
public class GridViewAdapter extends BaseAdapter {
    private List<DataBeans>list;
    private Context context;
    private Animation animation;

    public GridViewAdapter(List<DataBeans> list, Context context) {
        this.list = list;
        this.context = context;
        animation = AnimationUtils.loadAnimation(context,R.anim.gv_scale);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder;
        if (convertView == null){
            vHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.gv_item,null);
            vHolder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            vHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            vHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            convertView.setTag(vHolder);
        }else {
            vHolder = (ViewHolder) convertView.getTag();
        }
        DataBeans dataBeans = list.get(position);
        vHolder.iv_icon.setImageResource(dataBeans.getIcon());
        vHolder.tv_title.setText(dataBeans.getTitle());
        vHolder.tv_date.setText(dataBeans.getDate());
        convertView.startAnimation(animation);

        return convertView;
    }


    class ViewHolder{
        ImageView iv_icon;
        TextView tv_title,tv_date;
    }
}
