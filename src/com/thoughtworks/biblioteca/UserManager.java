package com.thoughtworks.biblioteca;

import java.util.HashMap;

public class UserManager {
    private HashMap<String, UserInfo> listOfUsers;
    private String currentUserLibraryNumber;

    public UserManager(HashMap<String, UserInfo> listOfUsers) {
        this.listOfUsers = listOfUsers;
        this.currentUserLibraryNumber = null;
    }

    public boolean login(String userName, String password) {
        return true;
    }
}
