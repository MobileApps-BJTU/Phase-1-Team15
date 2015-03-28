package com.example.zq.shanpai;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;

import com.example.zq.info.Information;

import java.util.LinkedList;

/**
 * Created by ZQ on 2015/3/27.
 */
public abstract class BaseActivity  extends Activity {
    //将生成的Activity都放到LinkList集合中
    protected static LinkedList<BaseActivity> queue = new LinkedList<BaseActivity>();
    public static Information info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        info=new Information();
        //判断该Activity是否在LinkedList中，没有在的话就添加上
        if (!queue.contains(this)) {
            queue.add(this);
            System.out.println("将" + queue.getLast() + "添加到list中去");
        }

    }

    public static void popActivity(){
        if(queue!=null)
        queue.pop();
    }

    public abstract void processMessage(Message message);
}
