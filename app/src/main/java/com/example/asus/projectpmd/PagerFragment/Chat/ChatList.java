package com.example.asus.projectpmd.PagerFragment.Chat;

import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2018-01-07.
 */

public class ChatList {
    public static List<Friend> items = new ArrayList();
    public static final String[] ChatNama = {};
    public static final String[] ChatDesc = {};
    public static final int[] ChatIcon = {};
    public static final String[] ChatTime = {};

    public static List<Friend> createListItems(){
        items = new ArrayList<>();
        for(int i=0 ; i<ChatNama.length; i++){
            Friend chat = new Friend();

            chat.setNama(ChatNama[i]);
            chat.setIcon(ChatIcon[i]);
            chat.setDesc(ChatDesc[i]);
            items.add(chat);
        }
        return items;
    }
}
