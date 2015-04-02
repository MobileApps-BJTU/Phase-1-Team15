package com.example.zq.shanpai;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.example.zq.info.Information;

/**
 * Created by ZQ on 2015/3/27.
 */
public class login extends BaseActivity{
    private String pwd,name;
    private Button ok;
    private Button register;
    private EditText id;
    private EditText password;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        ok=(Button)findViewById(R.id.Ok);
        register=(Button)findViewById(R.id.Register);
        id=(EditText)findViewById(R.id.IDName);
        password=(EditText)findViewById(R.id.pwd);
//        id.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus){
//                    // 隐藏输入法
//                    InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                    // 显示或者隐藏输入法
//                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//                }
//
//            }
//        });
//        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus){
//                    // 隐藏输入法
//                    InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//                    // 显示或者隐藏输入法
//                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//                }
//            }
//        });


        init();// 初始化
        ok.setOnClickListener(okButtonListener);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,register.class);
                startActivity(intent);	//启动intent对应的Activity
            }
        });

    }

    public OnClickListener okButtonListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            name = ((EditText)findViewById(R.id.IDName)).getText().toString();
            pwd = ((EditText)findViewById(R.id.pwd)).getText().toString();
            if("".equals(name)){
                Toast.makeText(login.this,  R.string.inputID, Toast.LENGTH_SHORT).show();
            }
            else if("".equals(pwd)){
                Toast.makeText(login.this, R.string.inputPWD, Toast.LENGTH_SHORT).show();
            }else{
                if(name.equals("haha")&&pwd.equals("haha")) {
                    BaseActivity.info.setId("haha");
                    BaseActivity.info.setPwd("haha");
                    BaseActivity.info.setBalance(100.0);
                    Intent intent=new Intent(login.this,hot.class);
                    startActivity(intent);
                }

            }
        }
    };

    private void init() {
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
