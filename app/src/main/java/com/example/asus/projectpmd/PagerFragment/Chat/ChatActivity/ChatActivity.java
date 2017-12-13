package com.example.asus.projectpmd.PagerFragment.Chat.ChatActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.projectpmd.R;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        TextView chatName = (TextView)findViewById(R.id.chatName);
        ImageView btnAddFriend = (ImageView)findViewById(R.id.btnAddFriend);
        chatName.setText(getIntent().getStringExtra("Nama"));
    }
}
