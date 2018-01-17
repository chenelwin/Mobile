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

import com.example.asus.projectpmd.PagerFragment.Chat.ChatActivity.ChatActivity;
import com.example.asus.projectpmd.PagerFragment.Friend.AddFriend.AddFriendAdapter;
import com.example.asus.projectpmd.PagerFragment.Friend.Friend;
import com.example.asus.projectpmd.PagerFragment.Friend.FriendAdapter;
import com.example.asus.projectpmd.PagerFragment.Friend.FriendList;
import com.example.asus.projectpmd.R;

import java.util.ArrayList;
import java.util.List;

public class TabChat extends Fragment implements FriendAdapter.TambahChat{
    public View view;
    public static List<Friend> chatList;
    private RecyclerView rvChat;
    private ChatAdapter chatAdapter;
    private TabChat.OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_chat, container, false);

        rvChat = (RecyclerView) view.findViewById(R.id.RvChat);

        chatList = (ArrayList)ChatList.createListItems();
        chatAdapter = new ChatAdapter(chatList);

        rvChat.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvChat.setItemAnimator(new DefaultItemAnimator());
        rvChat.setAdapter(chatAdapter);

        FriendAdapter.tambahChat = this;
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

    @Override
    public void addItemChat(Friend chat) {
        boolean a = true;
        for(Friend tempChat: chatList) {
            if(tempChat.getNama().equals(chat.getNama())) {
                a = false;
                break;
            }
        }
        if (a) {
            chatList.add(chat);
            chatAdapter.notifyDataSetChanged();
        }
    }
}
