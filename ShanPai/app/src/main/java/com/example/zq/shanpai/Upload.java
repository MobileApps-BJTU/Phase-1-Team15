package com.example.zq.shanpai;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;

/**
 * Created by ZQ on 2015/3/29.
 */
public class Upload extends BaseActivity {
    private ImageView uploadImage;
    private Button back,upload;
    private String url;
    private EditText price,desc;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);
        back=(Button)findViewById(R.id.uploadBack);
        upload=(Button)findViewById(R.id.uploadbtn);
        uploadImage=(ImageView)findViewById(R.id.uploadImage);
        price=(EditText)findViewById(R.id.price);
        desc=(EditText)findViewById(R.id.upload_desc);

        //button 监听
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 创建退出对话框
                AlertDialog isExit = new AlertDialog.Builder(Upload.this).create();
                // 设置对话框标题
                isExit.setTitle(R.string.systemMessage);
                // 设置对话框消息
                isExit.setMessage(getResources().getString(R.string.exitupload));
                // 添加选择按钮并注册监听
                isExit.setButton(getResources().getString(R.string.ok),listener);
                isExit.setButton2(getResources().getString(R.string.cancel), listener);
                // 显示对话框
                isExit.show();
            }

    });


        upload.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // 创建退出对话框
                AlertDialog isExit = new AlertDialog.Builder(Upload.this).create();
                // 设置对话框标题
                isExit.setTitle(R.string.systemMessage);
                // 设置对话框消息
                isExit.setMessage(getResources().getString(R.string.uploadsucess));
                // 添加选择按钮并注册监听
                isExit.setButton(getResources().getString(R.string.ok),listener);
                isExit.setButton2(getResources().getString(R.string.cancel), listener);
                // 显示对话框
                isExit.show();
            }
        });

        //image view 监听
        uploadImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Bitmap bitmap = GetLocalOrNetBitmap(url);
                Intent intent = new Intent();
                /* 开启Pictures画面Type设定为image */
                intent.setType("image/*");
                /* 使用Intent.ACTION_GET_CONTENT这个Action */
                intent.setAction(Intent.ACTION_GET_CONTENT);
                /* 取得相片后返回本画面 */
                startActivityForResult(intent, 1);
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

    @Override
    public void processMessage(Message message) {

    }


    /**监听exit对话框里面的button点击事件*/
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            BaseActivity.info.setUri(uri);
            Log.e("uri", uri.toString());
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                /* 将Bitmap设定到ImageView */
                uploadImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
