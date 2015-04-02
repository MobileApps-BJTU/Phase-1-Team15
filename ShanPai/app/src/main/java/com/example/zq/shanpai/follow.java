package com.example.zq.shanpai;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.provider.CalendarContract;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by ZQ on 2015/3/28.
 */
public class follow extends BaseActivity implements ImageListFragment.OnFragmentInteractionListener{
    private Button hot,mine,follow;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.follow);
        hot=(Button)findViewById(R.id.fhot);
        mine=(Button)findViewById(R.id.fmine);
        follow=(Button)findViewById(R.id.mfollow);
        follow.setBackgroundColor(Color.YELLOW);
        //button 监听
        mine.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
                BaseActivity.popActivity();
                follow.setBackgroundColor(Color.WHITE);
                Intent intent=new Intent(follow.this,Mine.class);
                startActivity(intent);

            }
        });
        hot.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
                BaseActivity.popActivity();
                follow.setBackgroundColor(Color.WHITE);
                Intent intent=new Intent(follow.this,hot.class);
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

    @Override
    public void onFragmentInteraction(String id) {
        Intent intent=new Intent(follow.this,PhotoDetail.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
