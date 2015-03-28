package com.example.zq.shanpai;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_detail,container,false);
        if(photo!=null){
            ((ImageView)view.findViewById(R.id.photo_id)).setImageResource(photo.imageid);
            ((TextView)view.findViewById(R.id.photo_desc)).setText(photo.desc);
        }
        return view;
    }


}
