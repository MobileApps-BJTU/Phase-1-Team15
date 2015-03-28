package com.example.zq.info;

import android.net.Uri;

/**
 * Created by ZQ on 2015/3/28.
 */
public class Information {
    private Uri uri;
    private String id;
    private String pwd;

    public Information(){
            id="";
            pwd="";
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
