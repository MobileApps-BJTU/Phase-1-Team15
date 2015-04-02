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

/**
 * Created by ZQ on 2015/3/29.
 */
public class Mine extends BaseActivity {

    private Button hot,mine,follow;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine);
        hot=(Button)findViewById(R.id.mhot);
        mine=(Button)findViewById(R.id.mmine);
        follow=(Button)findViewById(R.id.minefollow);
        mine.setBackgroundColor(Color.YELLOW);
        //button 监听
        follow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
                BaseActivity.popActivity();
                mine.setBackgroundColor(Color.WHITE);
                Intent intent=new Intent(Mine.this,follow.class);
                startActivity(intent);

            }
        });
        hot.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
                BaseActivity.popActivity();
                mine.setBackgroundColor(Color.WHITE);
                Intent intent=new Intent(Mine.this,hot.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void processMessage(Message message) {
        
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
                    java.lang.System.exit(0);
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };
}