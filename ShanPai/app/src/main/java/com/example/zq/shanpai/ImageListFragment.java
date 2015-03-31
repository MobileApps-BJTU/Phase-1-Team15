package com.example.zq.shanpai;

import android.app.Activity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import com.example.zq.info.photoContent;
import com.example.zq.shanpai.dummy.DummyContent;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class ImageListFragment extends ListFragment {

    private OnFragmentInteractionListener mListener;
//    private String[] desc= new String[]{
//            "jiang","dong","yu","zhou","qi"
//    };
//    private int[] iamgeids= new int[]{
//            R.drawable.view1, R.drawable.view2, R.drawable.view3, R.drawable.view4, R.drawable.people1
//    };
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ImageListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<Map<String,Object>> listItems= new ArrayList<Map<String, Object>>();
        for(int i=0;i<photoContent.item.size();i++){
            Map<String,Object> item= new HashMap<String,Object>();
            photoContent.photo p=photoContent.item.get(i);
//            item.put("header",iamgeids[i]);
//            item.put("image_desc",desc[i]);
            item.put("header",p.imageid);
            item.put("image_desc",p.desc);
            listItems.add(item);
        }

        // TODO: Change Adapter to display your content
        SimpleAdapter sa=new SimpleAdapter(getActivity(),listItems,R.layout.image_list_item,
                new String[] {"header","image_desc"},
                new int[] {R.id.header,R.id.image_desc});

        setListAdapter(sa);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
//            mListener.onFragmentInteraction(DummyContent.ITEMS.get(position).id);
            mListener.onFragmentInteraction(String.valueOf(position+1));

        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

}
