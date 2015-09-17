package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class User {
    private String libraryNumber;
    private String userName;
    private String password;
    private String emailId;
    private UserRole role;

    public User(String libraryNumber, String userName, String password, String emailId, UserRole role) {
        this.libraryNumber = libraryNumber;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.role = role;
    }

    @Override
    public boolean equals(Object that){
        if(that == this)
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
}
