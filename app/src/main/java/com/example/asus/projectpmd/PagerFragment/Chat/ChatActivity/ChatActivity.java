package com.example.asus.projectpmd.PagerFragment.Chat.ChatActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.projectpmd.PagerFragment.Chat.ChatList;
import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.PagerFragment.Friend.FriendList;
import com.example.asus.projectpmd.PagerFragment.Friend.TabFriend;
import com.example.asus.projectpmd.R;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity{

    public RecyclerView RvChatMes;
    public ChatActivityAdapter chatActivityAdapter;
    public static List<ChatKanan> chatKananList = new ArrayList<>();
    public TextView chatName;
    public EditText chatMes;
    public ImageView chatSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatName = (TextView)findViewById(R.id.chatName);
        chatName.setText(getIntent().getStringExtra("Nama"));

        chatMes = (EditText) findViewById(R.id.chatMes);
        chatSend = (ImageView)findViewById(R.id.chatSend);
        RvChatMes = (RecyclerView)findViewById(R.id.RvChatMes);

        chatActivityAdapter = new ChatActivityAdapter(this, chatKananList);
        RvChatMes.setAdapter(chatActivityAdapter);
        RvChatMes.setLayoutManager(new LinearLayoutManager(this));
        chatSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempMes = chatMes.getText().toString();
                chatKananList.add(new ChatKanan(tempMes, "00:00", "Read"));
                chatActivityAdapter.notifyDataSetChanged();
                chatMes.setText("");
                System.out.println(chatKananList.size());
            }
        });


    }
}
