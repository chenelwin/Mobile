package com.example.asus.projectpmd.PagerFragment.Friend;

import android.support.v4.app.FragmentManager;

import com.example.asus.projectpmd.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2017-12-07.
 */

public class FriendList {
    public static final String[] namas = {"Friend One", "Friend Two", "Friend Three", "Friend Four", "Friend Five"};
    public static final String[] descs = {"Hi", "Hello", "lol", "test", "abcd"};
    public static final int[] icons = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};

    public static List<Friend> createListItems(){
        ArrayList<Friend> items = new ArrayList<>();
        for(int i=0 ; i<namas.length; i++){
            Friend friend = new Friend();

            friend.setNama(namas[i]);
            friend.setIcon(icons[i]);
            friend.setDesc(descs[i]);
            items.add(friend);
        }
        return items;
    }
}
