package com.example.aes.fragments;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.aes.R;
import com.example.aes.presetup.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;


public class HomeFragment extends Fragment {
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    //ImageView logout;
    public HomeFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();
        ImageView imageView = (ImageView) rootView.findViewById(R.id.logout);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
