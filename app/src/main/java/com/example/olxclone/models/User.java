package com.example.olxclone.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;


import java.util.ArrayList;

public class User {

    private String userID;
    private String userEmail;
    private String userName;
    private String profileUrl;
    private ArrayList<String> SavedPostsLinks;
    private ArrayList<String> LikedPostsLinks;

    public User() {
    }

    public User(String userID, String userEmail, String userName, String profileUrl, ArrayList<String> savedPostsLinks, ArrayList<String> likedPostsLinks) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userName = userName;
        this.profileUrl = profileUrl;
        this.SavedPostsLinks = savedPostsLinks;
        this.LikedPostsLinks = likedPostsLinks;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                ", savedPostsLinks=" + SavedPostsLinks +
                ", likedPostsLinks=" + LikedPostsLinks +
                '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public ArrayList<String> getSavedPostsLinks() {
        return SavedPostsLinks;
    }

    public void setSavedPostsLinks(ArrayList<String> savedPostsLinks) {
        this.SavedPostsLinks = savedPostsLinks;
    }

    public ArrayList<String> getLikedPostsLinks() {
        return LikedPostsLinks;
    }

    public void setLikedPostsLinks(ArrayList<String> likedPostsLinks) {
        this.LikedPostsLinks = likedPostsLinks;
    }
}
