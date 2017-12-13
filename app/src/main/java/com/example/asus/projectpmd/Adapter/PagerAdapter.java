package com.example.asus.projectpmd.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.asus.projectpmd.PagerFragment.Chat.TabChat;
import com.example.asus.projectpmd.PagerFragment.Friend.TabFriend;
import com.example.asus.projectpmd.PagerFragment.TabMore;
import com.example.asus.projectpmd.PagerFragment.TabNews;
import com.example.asus.projectpmd.PagerFragment.TabTimeline;

/**
 * Created by Asus on 2017-11-28.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int NoOfTabs;
    public PagerAdapter(FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.NoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                TabFriend tabFriend = new TabFriend();
                return tabFriend;
            case 1:
                TabChat tabChat = new TabChat();
                return tabChat;
            case 2:
                TabTimeline tabTimeline = new TabTimeline();
                return tabTimeline;
            case 3:
                TabNews tabNews = new TabNews();
                return tabNews;
            case 4:
                TabMore tabMore = new TabMore();
                return tabMore;
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return NoOfTabs;
    }
}
