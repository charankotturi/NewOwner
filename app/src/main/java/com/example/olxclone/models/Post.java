package com.example.olxclone.models;

public class Post {
    private int postID;
    private String postTitle;
    private String postLongDes;
    private String postCategory;
    private String postImageUrl;
    private int postRate;
    private Author author;

    public Post(int postID, String postTitle, String postLongDes, String postCategory, String postImageUrl, int postRate, Author author) {
        this.postID = postID;
        this.postTitle = postTitle;
        this.postLongDes = postLongDes;
        this.postCategory = postCategory;
        this.postImageUrl = postImageUrl;
        this.postRate = postRate;
        this.author = author;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostLongDes() {
        return postLongDes;
    }

    public void setPostLongDes(String postLongDes) {
        this.postLongDes = postLongDes;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public int getPostRate() {
        return postRate;
    }

    public void setPostRate(int postRate) {
        this.postRate = postRate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", postTitle='" + postTitle + '\'' +
                ", postLongDes='" + postLongDes + '\'' +
                ", postCategory='" + postCategory + '\'' +
                ", postImageUrl='" + postImageUrl + '\'' +
                ", postRate=" + postRate +
                ", author=" + author +
                '}';
    }
}
