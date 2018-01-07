package com.example.asus.projectpmd.PagerFragment.Chat;

import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2018-01-07.
 */

public class ChatList {
    public static final String[] namas = {"Friend One", "Friend Two", "Friend Three", "Friend Four", "Friend Five"};
    public static final String[] descs = {"Hi", "Hello", "lol", "test", "abcd"};
    public static final int[] icons = {R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile, R.drawable.profile};
    public static final String[] times = {"01:00", "02:00", "03:00", "04:00", "05:00"};

    public static List<Chat> createListItems(){
        ArrayList<Chat> items = new ArrayList<>();
        for(int i=0 ; i<namas.length; i++){
            Chat chat = new Chat();

            chat.setNama(namas[i]);
            chat.setIcon(icons[i]);
            chat.setDesc(descs[i]);
            chat.setTime(times[i]);
            items.add(chat);
        }
        return items;
    }

}
