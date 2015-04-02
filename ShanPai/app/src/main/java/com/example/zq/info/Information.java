package com.example.zq.info;

import android.net.Uri;

/**
 * Created by ZQ on 2015/3/28.
 */
public class Information {
    private Uri uri;
    private String id;
    private String pwd;
    private double balance;

    public Information(){
            id="";
            pwd="";
            balance=0.0;
            uri=null;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public Uri getUri() {
        return uri;
    }
}
