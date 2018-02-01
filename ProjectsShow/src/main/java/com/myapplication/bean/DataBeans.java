package com.myapplication.bean;

/**
 * Created by lenovo on 2016/8/25.
 */
public class DataBeans {
    private int icon;
    private String title;
    private String date;

    public DataBeans(int icon, String title, String date) {
        this.icon = icon;
        this.title = title;
        this.date = date;
    }

    public DataBeans() {

    }

    public int getIcon() {

        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
