package com.example.asus.projectpmd.PagerFragment.Friend;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.projectpmd.PagerFragment.Chat.Chat;
import com.example.asus.projectpmd.PagerFragment.Chat.ChatActivity.ChatActivity;
import com.example.asus.projectpmd.PagerFragment.Friend.AddFriend.AddFriendList;
import com.example.asus.projectpmd.R;

import java.util.List;

/**
 * Created by Asus on 2017-12-07.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    public interface TambahChat{
        void addItemChat(Friend chat);
    }

    public static TambahChat tambahChat;

    List<Friend> friends;
    Context context;

    public FriendAdapter(List<Friend> friendList){
        this.friends = friendList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_friend, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Friend friend = friends.get(position);

        holder.textFriend.setText(friend.getNama());
        holder.descFriend.setText(friend.getDesc());
        holder.imgFriend.setImageResource(friend.getIcon());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ChatActivity.class);
                intent.putExtra("Nama", friend.getNama());

                if(tambahChat!=null){
                    tambahChat.addItemChat(friend);
                    notifyDataSetChanged();
                }
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgFriend;
        TextView textFriend;
        TextView descFriend;
        CardView cv;

        public ViewHolder(View itemView){
            super(itemView);
            imgFriend = (ImageView)itemView.findViewById(R.id.imgFriend);
            textFriend = (TextView)itemView.findViewById(R.id.textFriend);
            descFriend = (TextView)itemView.findViewById(R.id.descFriend);
            cv = (CardView)itemView.findViewById(R.id.cv);
        }

    }
}
