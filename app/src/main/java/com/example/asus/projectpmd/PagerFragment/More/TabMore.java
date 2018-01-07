package com.example.asus.projectpmd.PagerFragment.More;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.projectpmd.PagerFragment.More.ProfileActivity.ProfileActivity;
import com.example.asus.projectpmd.R;
import com.example.asus.projectpmd.db.SessionManager;

import de.hdodenhof.circleimageview.CircleImageView;


public class TabMore extends Fragment {

    public View view;
    public CircleImageView moreprofile;
    private OnFragmentInteractionListener mListener;

    private SessionManager sessionManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_more, container, false);
        moreprofile = (CircleImageView) view.findViewById(R.id.moreprofile);
        sessionManager = new SessionManager(getActivity());

        if(!sessionManager.imageBitmap().equals("")){
            byte[] b = Base64.decode(sessionManager.imageBitmap(), Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            moreprofile.setImageBitmap(bitmap);
        }

        moreprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });
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
