package com.example.asus.projectpmd.PagerFragment.Chat.ChatActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.projectpmd.PagerFragment.Chat.ChatAdapter;
import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Asus on 2018-01-08.
 */

public class ChatActivityAdapter extends RecyclerView.Adapter<ChatActivityAdapter.ViewHolderKanan> {


    List<ChatKanan> chatkanans;
    Context context;

    public ChatActivityAdapter(Context context, List<ChatKanan> chatKananList){
        this.context = context;
        this.chatkanans = chatKananList;
    }

    /*
    @Override
    public int getItemViewType(int position) {
        return 1;

        ChatKanan chatKanan = (ChatKanan) chatkanans.get(position);

        if (chatKanan.getSender().getUserId().equals(SendBird.getCurrentUser().getUserId())) {
            // If the current user is the sender of the message
            return VIEW_TYPE_MESSAGE_SENT;
        } else {
            // If some other user sent the message
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }*/

    @Override
    public ViewHolderKanan onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.rv_chatright, parent, false);
        return new ViewHolderKanan(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderKanan holder, int position) {
        ChatKanan chatKanan = chatkanans.get(position);
        holder.chatRightText.setText(chatKanan.getText());
        holder.chatRightTime.setText(chatKanan.getTime());
        holder.chatRightRead.setText(chatKanan.getRead());
    }

    @Override
    public int getItemCount() {
        return chatkanans.size();
    }


    public class ViewHolderKanan extends RecyclerView.ViewHolder{
        TextView chatRightRead;
        TextView chatRightTime;
        TextView chatRightText;
        CardView cvright;

        public ViewHolderKanan(View itemView){
            super(itemView);
            chatRightRead = (TextView)itemView.findViewById(R.id.chatRightRead);
            chatRightTime = (TextView)itemView.findViewById(R.id.chatRightTime);
            chatRightText = (TextView)itemView.findViewById(R.id.chatRightText);
            cvright = (CardView)itemView.findViewById(R.id.cvright);
        }

        /*
        void bind(ChatKanan chatKanan){
            chatRightText.setText(chatKanan.getText());
            chatRightRead.setText(chatKanan.getRead());
            chatRightTime.setText(chatKanan.getTime());
        }*/
    }

    /*
    public class ViewHolderKiri extends RecyclerView.ViewHolder{
        CircleImageView chatLeftProf;
        TextView chatLeftTime;
        TextView chatLeftText;
        CardView cvright;

        public ViewHolderKiri(View itemView){
            super(itemView);
            chatLeftProf = (CircleImageView) itemView.findViewById(R.id.chatLeftProf);
            chatLeftTime = (TextView)itemView.findViewById(R.id.chatLeftTime);
            chatLeftText = (TextView)itemView.findViewById(R.id.chatLeftText);
            cvright = (CardView)itemView.findViewById(R.id.cvright);
        }

        void bind(ChatKiri chatKiri){
            chatLeftText.setText(chatKiri.getText());
            chatLeftTime.setText(chatKiri.getTime());
            chatLeftProf.setImageResource(chatKiri.getIcon());
        }
    }*/
}
