package com.example.zq.shanpai;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener {
    private RelativeLayout main;
    private Timer time_intent;
    private AnimationDrawable animationDrawable1;
    private ImageView logoShow;
    private TimerTask tt_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time_intent = new Timer();
        main = (RelativeLayout) findViewById(R.id.main);
        main.setOnTouchListener(this);
        //init();
        tt_intent = new TimerTask() {
            public void run() {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,login.class);
                startActivity(intent);
                time_intent.cancel();
                finish();
                //结束当前activity
            }
        };
        time_intent.schedule(tt_intent, 3000);
    }

    private void init() {
        logoShow=(ImageView) findViewById(R.id.logoShow);
        animationDrawable1 = (AnimationDrawable) logoShow.getBackground();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Intent intent = new Intent(MainActivity.this,login.class);
        startActivity(intent);
        time_intent.cancel();
        tt_intent.cancel();
        finish();
        return false;
    }

}
