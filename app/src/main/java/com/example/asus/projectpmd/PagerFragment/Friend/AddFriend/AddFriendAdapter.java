package com.example.asus.projectpmd.PagerFragment.Friend.AddFriend;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.PagerFragment.Friend.FriendList;
import com.example.asus.projectpmd.R;

import java.util.List;

/**
 * Created by Asus on 2017-12-09.
 */

public class AddFriendAdapter extends RecyclerView.Adapter<AddFriendAdapter.ViewHolder> {

    public interface TambahTeman{
        void addItem(Friend friend);
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
    public void onBindViewHolder(AddFriendAdapter.ViewHolder holder, final int position) {
        final AddFriendAdapter.ViewHolder tempHolder = holder;
        final Friend addFriend = addFriends.get(position);


        holder.addFriendName.setText(addFriend.getNama());
        holder.addFriendDesc.setText(addFriend.getDesc());
        holder.addFriendIcon.setImageResource(addFriend.getIcon());

        holder.btnAddFriend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage("Processing...");
                progressDialog.show();

                tempHolder.cv.setVisibility(View.GONE);
                Toast.makeText(context, "The position is: "+position, Toast.LENGTH_SHORT).show();
                if(tambahTeman!=null){
                    tambahTeman.addItem(addFriend);
                }
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
