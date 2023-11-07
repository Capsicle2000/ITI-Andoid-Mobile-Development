package com.example.customlistview;

public class Contact {
    private String name;
    private String number;
    private int profileImage;

    public Contact(String name, String number, int profileImage) {
        this.name = name;
        this.number = number;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getProfileImage() {
        return profileImage;
    }
}