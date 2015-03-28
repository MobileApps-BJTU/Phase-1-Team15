package com.example.zq.shanpai;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * Created by ZQ on 2015/3/27.
 */
public class register extends BaseActivity{
    private Button r_ok;
    private Button r_back;
    private ImageView RImage;
    private String url;
    private EditText rid,rpwd,rpwd1;

    @Override
    public void processMessage(Message message) {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        r_ok=(Button)findViewById(R.id.R_ok);
        r_back=(Button)findViewById(R.id.R_back);
        RImage=(ImageView)findViewById(R.id.RheadIma);
        rid=(EditText)findViewById(R.id.RIDName);
        rpwd=(EditText)findViewById(R.id.Rpwd);
        rpwd1=(EditText)findViewById(R.id.Rpwd1);

//        rid.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus)
//                    rid.setText("");
//                else
//                    rid.setText(R.string.username);
//            }
//        });
//
//        rpwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus)
//                    rpwd.setText("");
//                else
//                    rpwd.setText(R.string.password);
//            }
//        });
//
//        rpwd1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(hasFocus)
//                    rpwd1.setText("");
//                else
//                    rpwd.setText(R.string.password);
//            }
//        });



        RImage.setOnClickListener(new OnClickListener(){

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

        r_ok.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(rid.getText().toString().equals("")){
                    Toast.makeText(register.this, R.string.inputID, Toast.LENGTH_SHORT).show();
                }else if(rpwd.getText().toString().equals("")){
                    Toast.makeText(register.this, R.string.inputPWD, Toast.LENGTH_SHORT).show();
                }else if(rpwd1.getText().toString().equals("")){
                    Toast.makeText(register.this, R.string.inputPWD1, Toast.LENGTH_SHORT).show();
                }else if(!rpwd.getText().toString().equals(rpwd1.getText().toString())){
                    Toast.makeText(register.this, R.string.differentPWD, Toast.LENGTH_SHORT).show();
                }else{
                    BaseActivity.info.setId(rid.getText().toString());
                    BaseActivity.info.setPwd(rpwd.getText().toString());
                    finish();
                    BaseActivity.popActivity();
                    Intent intent=new Intent(register.this,hot.class);
                    startActivity(intent);

                }

            }
        });
        r_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity.popActivity();
                finish();
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            BaseActivity.popActivity();
           finish();

        }

        return false;
    }
    //打开本地本地文件，将本地文件转化为bitmap
    public Bitmap GetLocalOrNetBitmap(String url){
        Bitmap bitmap = null;
        InputStream in = null;
        BufferedOutputStream out = null;
        try
        {
            in = new BufferedInputStream(new URL(url).openStream(),2*1024);
            final ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
            out = new BufferedOutputStream(dataStream, 2*1024);
            copy(in, out);
            out.flush();
            byte[] data = dataStream.toByteArray();
            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            data = null;
            return bitmap;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    //copy
    private void copy(InputStream in, BufferedOutputStream out) throws IOException {
        byte[] b = new byte[2*1024];
        int read;
        while ((read = in.read(b)) != -1) {
            out.write(b, 0, read);
        }
    }
    //将图片切换为圆形
    public Bitmap toRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
        if (width <= height) {
            roundPx = width / 2;
            top = 0;
            bottom = width;
            left = 0;
            right = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }

        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int) left, (int) top, (int) right,
                (int) bottom);
        final Rect dst = new Rect((int) dst_left, (int) dst_top,
                (int) dst_right, (int) dst_bottom);
        final RectF rectF = new RectF(dst);

        paint.setAntiAlias(true);

        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, src, dst, paint);
        return output;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            BaseActivity.info.setUri(uri);
            Log.e("uri", uri.toString());
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                bitmap=toRoundBitmap(bitmap);
                /* 将Bitmap设定到ImageView */
                RImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
