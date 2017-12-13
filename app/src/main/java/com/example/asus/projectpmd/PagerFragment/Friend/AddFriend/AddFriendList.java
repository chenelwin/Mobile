package com.example.asus.projectpmd.PagerFragment.Friend.AddFriend;

import android.os.Parcelable;

import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2017-12-09.
 */

public class AddFriendList {
    public static final String[] AddNama = {"Tambah1", "Tambah2", "Tambah3", "Tambah4", "Tambah5"};
    public static final String[] AddDesc = {"test1", "test2", "test3", "test4", "test5"};
    public static final int[] AddIcon = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};

    public static List<Friend> createListItems(){
        List<Friend> items = new ArrayList<>();

        for(int i=0 ; i<AddNama.length; i++){
            Friend addFriend = new Friend();

            addFriend.setNama(AddNama[i]);
            addFriend.setIcon(AddIcon[i]);
            addFriend.setDesc(AddDesc[i]);
            items.add(addFriend);
        }
        return items;
    }


}
