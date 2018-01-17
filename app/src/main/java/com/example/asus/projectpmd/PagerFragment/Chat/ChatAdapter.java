package com.example.asus.projectpmd.PagerFragment.Chat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.projectpmd.PagerFragment.Chat.ChatActivity.ChatActivity;
import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.PagerFragment.Friend.FriendAdapter;
import com.example.asus.projectpmd.R;

import java.util.List;

/**
 * Created by Asus on 2018-01-07.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    List<Friend> chats;
    Context context;

    public ChatAdapter(List<Friend> chatList){
        this.chats = chatList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_chat, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Friend chat = chats.get(position);

        holder.textChat.setText(chat.getNama());
        holder.descChat.setText("");
        holder.imgChat.setImageResource(chat.getIcon());
//        holder.time.setText(chat.getTime());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ChatActivity.class);
                intent.putExtra("Nama", chat.getNama());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chats.size();
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
            cv = (CardView)itemView.findViewById(R.id.cv);
        }
    }

}
