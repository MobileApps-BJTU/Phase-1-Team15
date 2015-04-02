package com.example.zq.shanpai;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by ZQ on 2015/3/28.
 */
public class hot extends BaseActivity {
    private ImageButton professional;
    private ImageButton wellsold;
    private ImageButton people;
    private ImageButton view;
    private ImageButton daily;
    private ImageButton news;
    private ImageButton upload;
    private Button follow,mine,hot;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        upload=(ImageButton)findViewById(R.id.upload);
        professional=(ImageButton)findViewById(R.id.professional);
        wellsold=(ImageButton)findViewById(R.id.well_sold);
        people=(ImageButton)findViewById(R.id.people);
        view=(ImageButton)findViewById(R.id.view);
        news=(ImageButton)findViewById(R.id.news);
        daily=(ImageButton)findViewById(R.id.daily);
        follow=(Button)findViewById(R.id.follow);
        mine=(Button)findViewById(R.id.mine);
        hot=(Button)findViewById(R.id.hot);
        //button 监听
        hot.setBackgroundColor(Color.YELLOW);
        mine.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
                BaseActivity.popActivity();
                hot.setBackgroundColor(Color.WHITE);
                Intent intent=new Intent(hot.this,Mine.class);
                startActivity(intent);

            }
        });
        follow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
                BaseActivity.popActivity();
                Intent intent=new Intent(hot.this,follow.class);
                startActivity(intent);
                hot.setBackgroundColor(Color.WHITE);

            }
        });
        //image button 监听
        professional.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hot.this,ImageList.class);
                startActivity(intent);
            }
        });
        view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hot.this,ImageList.class);
                startActivity(intent);
            }
        });
        news.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hot.this,ImageList.class);
                startActivity(intent);
            }
        });
        daily.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hot.this,ImageList.class);
                startActivity(intent);
            }
        });
        people.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hot.this,ImageList.class);
                startActivity(intent);
            }
        });
        wellsold.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hot.this,ImageList.class);
                startActivity(intent);
            }
        });
        upload.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hot.this,Upload.class);
                startActivity(intent);
            }
        });

    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle(R.string.systemMessage);
            // 设置对话框消息
            isExit.setMessage(getResources().getString(R.string.exit));
            // 添加选择按钮并注册监听
            isExit.setButton(getResources().getString(R.string.ok),listener);
            isExit.setButton2(getResources().getString(R.string.cancel), listener);
            // 显示对话框
            isExit.show();

        }

        return false;
    }

    /**监听对话框里面的button点击事件*/
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    BaseActivity.popActivity();
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void processMessage(Message message) {

    }
}
