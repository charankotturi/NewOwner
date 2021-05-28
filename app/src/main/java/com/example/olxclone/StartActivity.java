package com.example.olxclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import  com.example.olxclone.databinding.ActivityStartBinding;
import com.example.olxclone.utilities.Utils;


import okhttp3.internal.Util;

public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding binding;
//    private final FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
//
//        Utils.initialiseSharedPreferences(this);
//
//        if (null == auth.getCurrentUser()) {
//            initUI();
//        }else {
//            startActivity(new Intent(StartActivity.this, MainActivity.class));
//        }

    }

    private void initUI() {
        binding.btnSLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, LoginActivity.class));
            }
        });

        binding.btnSSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, CreateAccActivity.class));
            }
        });

        binding.txtSSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, MainActivity.class));
            }
        });
    }
}