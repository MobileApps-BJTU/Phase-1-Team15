package com.example.zq.shanpai;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by ZQ on 2015/3/28.
 */
public class ImageList extends BaseActivity implements ImageListFragment.OnFragmentInteractionListener{
    private Button goback;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagelist);
        goback=(Button)findViewById(R.id.goback);
        goback.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                    finish();
                    BaseActivity.popActivity();
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


    @Override
    public void processMessage(Message message) {

    }

    @Override
    public void onFragmentInteraction(String id) {
        Intent intent=new Intent(ImageList.this,PhotoDetail.class);
        intent.putExtra("id", id);

        startActivity(intent);

    }
}
