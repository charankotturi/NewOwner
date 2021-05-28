package com.example.olxclone.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.olxclone.R;
import com.example.olxclone.StartActivity;
import com.example.olxclone.utilities.Utils;


import java.util.Objects;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        view.findViewById(R.id.btnLogOut).setOnClickListener(onClick -> {
//            FirebaseAuth auth = FirebaseAuth.getInstance();
//            auth.signOut();
            Utils.clearSharedPreferences(getContext());
            startActivity(new Intent(getActivity(), StartActivity.class));
        });

        return view;
    }
}