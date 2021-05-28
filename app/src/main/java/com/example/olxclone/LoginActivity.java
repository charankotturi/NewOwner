package com.example.olxclone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import  com.example.olxclone.databinding.ActivityLoginBinding;
import com.example.olxclone.models.User;
import com.example.olxclone.utilities.Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private ActivityLoginBinding binding;

    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    private final int MIN_LEN = 4;
    private final int MAX_LEN = 12;

    private String email;
    private String password;
    private ArrayList<String> savedList = new ArrayList<>();
    private ArrayList<String> likedList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initUI();

        binding.btnLogin.setOnClickListener( onClick -> {
            validateUI();
        });

    }

    private void validateUI(){

        if (binding.editTxtEmail.getText() == null){
            alertWarning("Enter proper email-id!");
            return;
        }else {
            email = binding.editTxtEmail.getText().toString();
        }

        if (binding.editTxtPassword.getText() == null || binding.editTxtPassword.getText().toString().length() <= MIN_LEN) {
            alertWarning("Enter a valid password!");
            return;
        }else {
            password = binding.editTxtPassword.getText().toString();
        }

        binding.btnLogin.setEnabled(false);
        binding.progressBar.setVisibility(View.VISIBLE);

        signIn();
    }

    private void signIn() {

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( task -> {

                    binding.btnLogin.setEnabled(true);
                    binding.progressBar.setVisibility(View.GONE);

                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        assert user != null;
                        getDataFromFireStore(user);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else {
                        alertWarning("Invalid email-id or password!");
                    }
                }).addOnFailureListener( failure -> {

            binding.btnLogin.setEnabled(true);
            binding.progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "Network issue!", Toast.LENGTH_SHORT).show();
        });

    }

    private void getDataFromFireStore(FirebaseUser user) {
        db.collection("Users")
                .document(user.getUid())
                .get()
                .addOnSuccessListener(task -> {
                    if (task.exists()) {
                        String name = (String) task.get("userName");

                        User user1 = new User(user.getUid(), email, name, (String) task.get("profileUrl")
                        ,(ArrayList<String>) task.get("savedPostsLinks"), (ArrayList<String>) task.get("likedPostsLinks"));

                        Utils.setUser(this, user1);

                    }
                }).addOnFailureListener(failure -> {
            Log.e(TAG, "getDataFromFireStore: user not found>>>>>>>.", failure);
        });
    }


    private void alertWarning(String text) {
        new AlertDialog.Builder(this)
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Ok", (dialogInterface, i) -> {
                }).create().show();
    }

    private void initUI() {

        binding.btnFaceLogin.setOnClickListener(view ->
                Toast.makeText(LoginActivity.this, "This feature will be available soon!", Toast.LENGTH_SHORT).show());

        binding.imgLBack.setOnClickListener(view -> onBackPressed());

        binding.txtLoginToSignIn.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this, CreateAccActivity.class));
            finish();
        });

    }
}