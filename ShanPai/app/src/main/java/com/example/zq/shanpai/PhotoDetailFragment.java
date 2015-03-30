package com.example.zq.shanpai;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zq.info.photoContent;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhotoDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String item_id="item_id";
    private Button buy;
    private double lovemoney=0.0;
    photoContent.photo photo;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhotoDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PhotoDetailFragment newInstance(String param1, String param2) {
        PhotoDetailFragment fragment = new PhotoDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public PhotoDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey("item_id")) {
            photo=photoContent.item_map.get(getArguments().getInt(item_id));
            lovemoney=photo.price*photo.percent;

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_detail,container,false);
        if(photo!=null){
            ((ImageView)view.findViewById(R.id.photo_id)).setImageResource(photo.imageid);
            ((TextView)view.findViewById(R.id.photo_desc)).setText(photo.desc);
            ((TextView)view.findViewById(R.id.currentprice)).setText(Double.toString(photo.price));
            ((TextView)view.findViewById(R.id.currentpercent)).setText(Double.toString(photo.percent));
            buy=(Button)view.findViewById(R.id.buy);
            buy.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(BaseActivity.info.getBalance()>=photo.price) {
                        // 创建退出对话框
                        AlertDialog isExit = new AlertDialog.Builder(getActivity()).create();
                        // 设置对话框标题
                        isExit.setTitle(R.string.systemMessage);
                        // 设置对话框消息
                        isExit.setMessage(getResources().getString(R.string.surebuy)+"\n"+getResources().getString(R.string.balance)+BaseActivity.info.getBalance());
                        // 添加选择按钮并注册监听
                        isExit.setButton(getResources().getString(R.string.ok), listener);
                        isExit.setButton2(getResources().getString(R.string.cancel), listener);
                        // 显示对话框
                        isExit.show();
                    }else{
                        // 创建退出对话框
                        AlertDialog isExit = new AlertDialog.Builder(getActivity()).create();
                        // 设置对话框标题
                        isExit.setTitle(R.string.systemMessage);
                        // 设置对话框消息
                        isExit.setMessage(getResources().getString(R.string.buyerror));
                        // 添加选择按钮并注册监听
                        isExit.setButton(getResources().getString(R.string.ok), listener1);
                        // 显示对话框
                        isExit.show();
                    }
                }
            });


        }
        return view;
    }
    /**监听对话框里面的button点击事件*/
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    BaseActivity.info.setBalance(BaseActivity.info.getBalance()-photo.price);
                    // 创建退出对话框
                    AlertDialog isExit = new AlertDialog.Builder(getActivity()).create();
                    // 设置对话框标题
                    isExit.setTitle(R.string.systemMessage);
                    // 设置对话框消息
                    isExit.setMessage(getResources().getString(R.string.buysucess)+"\n"+getResources().getString(R.string.donate)+lovemoney+"\n"+getResources().getString(R.string.balance)+BaseActivity.info.getBalance());
                    // 添加选择按钮并注册监听
                    isExit.setButton(getResources().getString(R.string.ok), listener1);
                    // 显示对话框
                    isExit.show();

                   break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };

    /**监听对话框里面的button点击事件*/
    DialogInterface.OnClickListener listener1 = new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    break;

                default:
                    break;
            }
        }
    };


}
