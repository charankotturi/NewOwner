package com.example.olxclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.olxclone.databinding.ActivityMainBinding;
import com.example.olxclone.utilities.Utils;

import okhttp3.internal.Util;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.text.setText(Utils.getUser(this).getUserName());

        controller = Navigation.findNavController(this, R.id.fragment);

        NavigationUI.setupWithNavController(binding.bottomNavigation, controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(controller, (Openable) null);
    }
}