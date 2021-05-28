package com.example.olxclone.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.olxclone.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Utils {

    private static Gson gson = new Gson();
    private static final String DATA_BASE = "DATA_BASE";

    private static Type userType = new TypeToken<User>(){}.getType();

    private static final String USER_KEY = "USER_KEY";

    private static Utils INSTANCE;

    private Utils(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_BASE, Context.MODE_PRIVATE);
        User user = gson.fromJson(sharedPreferences.getString(USER_KEY, null), userType);

        if (user == null) {
            user = new User();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_KEY, gson.toJson(user));
        editor.commit();

    }

    public static User getUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_BASE, Context.MODE_PRIVATE);
        User user = gson.fromJson(sharedPreferences.getString(USER_KEY, null), userType);
        return user;
    }

    public static void setUser(Context context, User user) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_BASE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_KEY, gson.toJson(user));
        editor.commit();
    }

    public static Utils initialiseSharedPreferences(Context context) {
        if (INSTANCE == null) {
            return new Utils(context);
        }

        return INSTANCE;
    }

    public static void clearSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATA_BASE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

    }

}
