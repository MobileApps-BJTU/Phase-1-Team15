package com.example.zq.shanpai;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;

/**
 * Created by ZQ on 2015/3/28.
 */
public class PhotoDetail extends BaseActivity  {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_detial);
        String id = "";

        Intent intent1 = this.getIntent();

        id = intent1.getStringExtra("id");
        Bundle bundle=new Bundle();
        int item_id = Integer.parseInt(id);
        bundle.putInt(PhotoDetailFragment.item_id, item_id);
        PhotoDetailFragment fragment= new PhotoDetailFragment();
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fragment_holder,fragment).commit();
    }
    @Override
    public void processMessage(Message message) {

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
}
