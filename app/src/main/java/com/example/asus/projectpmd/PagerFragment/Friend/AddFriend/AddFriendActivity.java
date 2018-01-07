package com.example.asus.projectpmd.PagerFragment.Friend.AddFriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.R;

import java.util.ArrayList;

public class AddFriendActivity extends AppCompatActivity {

    RecyclerView AddFriends;
    AddFriendAdapter addFriendAdapter;
    ArrayList<Friend> addFriends;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        addFriends = (ArrayList) AddFriendList.items;

        addFriendAdapter = new AddFriendAdapter(addFriends);
        AddFriends = (RecyclerView)findViewById(R.id.RvAddFriend);

        AddFriends.setLayoutManager(new LinearLayoutManager(this));
        AddFriends.setItemAnimator(new DefaultItemAnimator());
        AddFriends.setAdapter(addFriendAdapter);
    }
}
