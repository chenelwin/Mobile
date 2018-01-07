package com.example.asus.projectpmd.PagerFragment.Chat;

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

import com.example.asus.projectpmd.PagerFragment.Friend.AddFriend.AddFriendAdapter;
import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.PagerFragment.Friend.FriendAdapter;
import com.example.asus.projectpmd.PagerFragment.Friend.FriendList;
import com.example.asus.projectpmd.R;

import java.util.ArrayList;
import java.util.List;

public class TabChat extends Fragment {
    public View view;
    private List<Chat> chatList;
    private RecyclerView rvChat;
    private ChatAdapter chatAdapter;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_chat, container, false);

        rvChat = (RecyclerView) view.findViewById(R.id.RvChat);

        chatList = (ArrayList) ChatList.createListItems();
        chatAdapter = new ChatAdapter(chatList);

        rvChat.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvChat.setItemAnimator(new DefaultItemAnimator());
        rvChat.setAdapter(chatAdapter);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
