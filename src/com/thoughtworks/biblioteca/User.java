package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class User {
    private String libraryNumber;
    private String userName;
    private String password;
    private String emailId;
    private String phoneNumber;
    private UserRole role;

    public User(String libraryNumber, String userName, String password, String emailId, String phoneNumber, UserRole role) {
        this.libraryNumber = libraryNumber;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    @Override
    public boolean equals(Object that) {
        if (that == this)
            return true;
        if (that == null || that.getClass() != getClass())
            return false;
        User thatUser = (User) that;
        return (thatUser.libraryNumber.equals(libraryNumber));
    }

    public String getLibraryNumberHeader() {
        return "LIBRARY NUMBER";
    }

    public boolean validate(String password) {
        return this.password.equals(password);
    }

    public ArrayList<String> getMenuOptions() {
        return role.getMenuOptions();
    }

    public boolean isAuthenticatedUser() {
        return role.isAuthenticatedUser();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String[] getHeaderDetails() {
        String[] bookHeaderInfo = new String[3];
        bookHeaderInfo[0] = "USER NAME";
        bookHeaderInfo[1] = "EMAIL ID";
        bookHeaderInfo[2] = "PHONE NUMBER";
        return bookHeaderInfo;
    }
}
