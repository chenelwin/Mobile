package com.example.asus.projectpmd.PagerFragment.Chat;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.R;

import java.util.List;

/**
 * Created by Asus on 2018-01-07.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    List<Chat> chats;
    Context context;

    public ChatAdapter(List<Chat> chatList){
        this.chats = chatList;
    }

    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgChat;
        TextView textChat;
        TextView descChat;
        TextView time;
        CardView cv;

        public ViewHolder(View itemView){
            super(itemView);
            imgChat = (ImageView)itemView.findViewById(R.id.imgChat);
            textChat = (TextView)itemView.findViewById(R.id.textChat);
            descChat = (TextView)itemView.findViewById(R.id.descChat);
            time = (TextView)itemView.findViewById(R.id.timeChat);
            cv = (CardView)itemView.findViewById(R.id.cv);
        }
    }

}
