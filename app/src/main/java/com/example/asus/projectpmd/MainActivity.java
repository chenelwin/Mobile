package com.example.asus.projectpmd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.projectpmd.Adapter.PagerAdapter;
import com.example.asus.projectpmd.PagerFragment.Chat.TabChat;
import com.example.asus.projectpmd.PagerFragment.Friend.AddFriend.AddFriendActivity;
import com.example.asus.projectpmd.PagerFragment.Friend.AddFriend.AddFriendList;
import com.example.asus.projectpmd.PagerFragment.Friend.TabFriend;
import com.example.asus.projectpmd.PagerFragment.More.TabMore;
import com.example.asus.projectpmd.PagerFragment.TabNews;
import com.example.asus.projectpmd.PagerFragment.TabTimeline;

public class MainActivity extends AppCompatActivity implements TabFriend.OnFragmentInteractionListener, TabChat.OnFragmentInteractionListener, TabTimeline.OnFragmentInteractionListener, TabNews.OnFragmentInteractionListener, TabMore.OnFragmentInteractionListener {
    int posisi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddFriendList.createListItems();
        final TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tabfriendactive));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tabchat));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tabtimeline));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tabnews));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tabmore));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        final TextView header = (TextView)findViewById(R.id.header);
        final ImageView headbtn1 = (ImageView)findViewById(R.id.headbtn1);
        final ImageView headbtn2 = (ImageView)findViewById(R.id.headbtn2);
        final ImageView headbtn3 = (ImageView)findViewById(R.id.headbtn3);

        headbtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (posisi == 0) {
                    startActivity(new Intent(MainActivity.this, AddFriendActivity.class));
                }
            }
        });

        final Context context;

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                posisi = tab.getPosition();
                switch(tab.getPosition()){
                    case 0:
                        header.setText("Friends");
                        headbtn1.setVisibility(View.VISIBLE); headbtn1.setImageResource(R.drawable.friendaddfriend);
                        headbtn2.setVisibility(View.VISIBLE); headbtn2.setImageResource(R.drawable.search);
                        headbtn3.setVisibility(View.VISIBLE); headbtn3.setImageResource(R.drawable.more);
                        tabLayout.getTabAt(0).setIcon(R.drawable.tabfriendactive);
                        tabLayout.getTabAt(1).setIcon(R.drawable.tabchat);
                        tabLayout.getTabAt(2).setIcon(R.drawable.tabtimeline);
                        tabLayout.getTabAt(3).setIcon(R.drawable.tabnews);
                        tabLayout.getTabAt(4).setIcon(R.drawable.tabmore);
                        break;
                    case 1:
                        header.setText("Chats");
                        headbtn1.setVisibility(View.VISIBLE); headbtn1.setImageResource(R.drawable.chatchoosefriend);
                        headbtn2.setVisibility(View.VISIBLE); headbtn2.setImageResource(R.drawable.search);
                        headbtn3.setVisibility(View.VISIBLE); headbtn3.setImageResource(R.drawable.more);
                        tabLayout.getTabAt(0).setIcon(R.drawable.tabfriend);
                        tabLayout.getTabAt(1).setIcon(R.drawable.tabchatactive);
                        tabLayout.getTabAt(2).setIcon(R.drawable.tabtimeline);
                        tabLayout.getTabAt(3).setIcon(R.drawable.tabnews);
                        tabLayout.getTabAt(4).setIcon(R.drawable.tabmore);
                        break;
                    case 2:
                        header.setText("Timeline");
                        headbtn1.setVisibility(View.VISIBLE); headbtn1.setImageResource(R.drawable.timelinenotif);
                        headbtn2.setVisibility(View.VISIBLE); headbtn2.setImageResource(R.drawable.timelinewrite);
                        headbtn3.setVisibility(View.VISIBLE); headbtn3.setImageResource(R.drawable.timelinesquare);
                        tabLayout.getTabAt(0).setIcon(R.drawable.tabfriend);
                        tabLayout.getTabAt(1).setIcon(R.drawable.tabchat);
                        tabLayout.getTabAt(2).setIcon(R.drawable.tabtimelineactive);
                        tabLayout.getTabAt(3).setIcon(R.drawable.tabnews);
                        tabLayout.getTabAt(4).setIcon(R.drawable.tabmore);
                        break;
                    case 3:
                        header.setText("LINE TODAY");
                        headbtn1.setVisibility(View.INVISIBLE);
                        headbtn2.setVisibility(View.INVISIBLE);
                        headbtn3.setVisibility(View.VISIBLE); headbtn3.setImageResource(R.drawable.newsmore);
                        tabLayout.getTabAt(0).setIcon(R.drawable.tabfriend);
                        tabLayout.getTabAt(1).setIcon(R.drawable.tabchat);
                        tabLayout.getTabAt(2).setIcon(R.drawable.tabtimeline);
                        tabLayout.getTabAt(3).setIcon(R.drawable.tabnewsactive);
                        tabLayout.getTabAt(4).setIcon(R.drawable.tabmore);
                        break;
                    case 4:
                        header.setText("More");
                        headbtn1.setVisibility(View.INVISIBLE);
                        headbtn2.setVisibility(View.INVISIBLE);
                        headbtn3.setVisibility(View.VISIBLE); headbtn3.setImageResource(R.drawable.moresetting);
                        tabLayout.getTabAt(0).setIcon(R.drawable.tabfriend);
                        tabLayout.getTabAt(1).setIcon(R.drawable.tabchat);
                        tabLayout.getTabAt(2).setIcon(R.drawable.tabtimeline);
                        tabLayout.getTabAt(3).setIcon(R.drawable.tabnews);
                        tabLayout.getTabAt(4).setIcon(R.drawable.tabmoreactive);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        }

        );
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
