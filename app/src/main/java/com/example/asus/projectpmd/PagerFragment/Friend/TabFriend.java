package com.example.asus.projectpmd.PagerFragment.Friend;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.projectpmd.PagerFragment.Chat.TabChat;
import com.example.asus.projectpmd.PagerFragment.Friend.AddFriend.AddFriendActivity;
import com.example.asus.projectpmd.PagerFragment.Friend.AddFriend.AddFriendAdapter;
import com.example.asus.projectpmd.R;

import java.util.ArrayList;
import java.util.List;

public class TabFriend extends Fragment implements AddFriendAdapter.TambahTeman{
    public View view;
    private List<Friend> friendList;
    private RecyclerView rvFriend;
    private FriendAdapter friendAdapter;
    private TabFriend.OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_friend, container, false);

        rvFriend = (RecyclerView) view.findViewById(R.id.RvFriend);

        friendList = (ArrayList)FriendList.createListItems();
        friendAdapter = new FriendAdapter(friendList);

        rvFriend.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvFriend.setItemAnimator(new DefaultItemAnimator());
        rvFriend.setAdapter(friendAdapter);

        AddFriendAdapter.tambahTeman = this;
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TabChat.OnFragmentInteractionListener) {
            mListener = (TabFriend.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void addItem(Friend friend) {
        friendList.add(friend);
        friendAdapter.notifyDataSetChanged();
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
