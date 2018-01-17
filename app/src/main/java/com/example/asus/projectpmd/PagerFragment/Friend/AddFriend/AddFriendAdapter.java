package com.example.asus.projectpmd.PagerFragment.Friend.AddFriend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.projectpmd.MainActivity;
import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.PagerFragment.Friend.FriendList;
import com.example.asus.projectpmd.R;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Asus on 2017-12-09.
 */

public class AddFriendAdapter extends RecyclerView.Adapter<AddFriendAdapter.ViewHolder> {

    public interface TambahTeman{
        void addItemFriend(Friend friend);
    }

    public static TambahTeman tambahTeman;

    List<Friend> addFriends;
    Context context;

    public AddFriendAdapter(List<Friend> addFriendList){this.addFriends = addFriendList;}


    @Override
    public AddFriendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_addfriend, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final AddFriendAdapter.ViewHolder holder, int position) {
        final Friend addFriend = addFriends.get(holder.getAdapterPosition());

        holder.addFriendName.setText(addFriend.getNama());
        holder.addFriendDesc.setText(addFriend.getDesc());
        holder.addFriendIcon.setImageResource(addFriend.getIcon());

        holder.btnAddFriend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                final ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage("Processing...");
                progressDialog.show();

                Thread thread = new Thread(){
                    @Override
                    public void run(){
                        try{
                            sleep(1500);
                            progressDialog.hide();
                            sleep(500);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(context, "The position is: "+position, Toast.LENGTH_SHORT).show();
                        if(tambahTeman!=null){
                            tambahTeman.addItemFriend(addFriend);
                            AddFriendList.deleteItem(addFriend);
                            notifyDataSetChanged();
                        }
                    }
                }, 1600);
            }
        });

    }

    @Override
    public int getItemCount() {
        return addFriends.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView addFriendIcon;
        TextView addFriendName;
        TextView addFriendDesc;
        ImageView btnAddFriend;
        CardView cv;

        public ViewHolder(View itemView){
            super(itemView);
            addFriendIcon = (ImageView)itemView.findViewById(R.id.addFriendIcon);
            addFriendName = (TextView)itemView.findViewById(R.id.addFriendName);
            addFriendDesc = (TextView)itemView.findViewById(R.id.addFriendDesc);
            btnAddFriend = (ImageView)itemView.findViewById(R.id.btnAddFriend);
            cv = (CardView)itemView.findViewById(R.id.cv);
        }

    }
}
