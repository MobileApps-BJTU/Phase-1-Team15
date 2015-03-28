package com.example.zq.info;

import com.example.zq.shanpai.R;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by ZQ on 2015/3/28.
 */
public class photoContent {

//    public int id;
    public static class photo{
        public String desc;
        public int imageid;
        public int id;
        public photo (String desc, int imageid,int id){
            this.desc=desc;
            this.imageid=imageid;
            this.id=id;
        }

    }

    public static List<photo> item= new ArrayList<photo>();
    public static Map<Integer,photo> item_map=new Hashtable<Integer,photo>();
    static{
        addItem(new photo("jiang",R.drawable.view1,1));
        addItem(new photo("dong",R.drawable.view2,2));
        addItem(new photo("yu",R.drawable.view3,3));
        addItem(new photo("zhou",R.drawable.view4,5));
        addItem(new photo("qi",R.drawable.people1,5));
    }

    private static void addItem(photo photo){
        item.add(photo);
        item_map.put(photo.id, photo);
    }

}


