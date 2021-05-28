package com.example.olxclone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.olxclone.databinding.ActivityCreateAccBinding;
import com.google.android.material.snackbar.Snackbar;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateAccActivity extends AppCompatActivity {

    private static final String TAG = "CreateAccountActivity";
    private ActivityCreateAccBinding binding;
    private String email, password, username;
    private String profileUrl = null;
    private ArrayList<String> savedList = new ArrayList<>();
    private ArrayList<String> likedLists = new ArrayList<>();

    private final int MIN_LEN = 4;
    private final int MAX_LEN = 12;

//    private final FirebaseAuth auth = FirebaseAuth.getInstance();
//    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initUI();

        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateUI();
            }
        });

        //TODO: set profile pic while creating account!- adding in both fireStore and firebase!
        //addProfileUrl();

    }

    private void validateUI() {

        if (binding.editTxtUserName.getText() == null ||
                binding.editTxtUserName.getText().toString().length() <= MIN_LEN) {
            alertDialog("Invalid username!\n(min length 4)");
            return;
        }else {
            username = binding.editTxtUserName.getText().toString();
        }
        if (binding.editTxtCEmail.getText() == null ||
                binding.editTxtCEmail.getText().toString().length() <= MIN_LEN) {
            alertDialog("Invalid Email-id!");
            return;
        }else {
            email = binding.editTxtCEmail.getText().toString();
        }
        if (binding.editTxtUserName.getText() == null ||
                binding.editTxtUserName.getText().toString().length() <= MIN_LEN ||
                binding.editTxtUserName.getText().toString().length() >= MAX_LEN ) {
            alertDialog("Invalid password!\n(min length 4 and max length 12 characters)");
            return;
        }else {
            password = binding.editTxtCPassword.getText().toString();
        }
        if (!password.equals(binding.editTxtCCPassword.getText().toString())) {
            alertDialog("Confirm password and password don't match!");
            return;
        }

        binding.btnSignIn.setEnabled(false);
        binding.accountLoading.setVisibility(View.VISIBLE);

        logIn();
    }

    private void logIn() {

//        auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(task -> {
//                    binding.btnSignIn.setEnabled(true);
//                    binding.accountLoading.setVisibility(View.GONE);
//                    if (task.isSuccessful()) {
//                        FirebaseUser user = auth.getCurrentUser();
//                        Log.i(TAG, "logIn: " + user);
//                        createAccountInFireStore(user.getUid());
//                        //TODO: add the user to room database!
//                        //UpdateUi(user);
//                        startActivity(new Intent(CreateAccActivity.this, MainActivity.class));
//                        finish();
//                    }else {
//                        alertDialog("User might already exist!");
//                    }
//                }).addOnFailureListener(failure-> {
//            binding.btnSignIn.setEnabled(true);
//            binding.accountLoading.setVisibility(View.GONE);
//        });

    }

    private void createAccountInFireStore(String uid) {

        Map<String, Object> user = new HashMap<>();
        user.put("profileUrl", profileUrl);
        user.put("userName", username);
        user.put("savedPostsLinks", savedList);
        user.put("likedPostsLinks", likedLists);

//        db.collection("Users")
//                .document(uid)
//                .set(user)
//                .addOnSuccessListener(task -> {
//                    Log.i(TAG, "createAccountInFireStore: user added successfully! >>>> " + task);
//                }).addOnFailureListener(failure -> {
//            Log.i(TAG, "createAccountInFireStore: " + "failed!");
//        });

    }

    private void alertDialog(String text) {
        new AlertDialog.Builder(this)
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Ok", (onClick, i) -> {
                }).create().show();
    }

    private void initUI() {

        binding.btnFaceSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CreateAccActivity.this, "feature coming soon!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.imgCBack.setOnClickListener(view -> onBackPressed());

        binding.txtSigInInToLogin.setOnClickListener(view -> {
            startActivity(new Intent(CreateAccActivity.this, LoginActivity.class));
            finish();
        });

    }
}