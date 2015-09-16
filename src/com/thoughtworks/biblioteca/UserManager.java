package com.thoughtworks.biblioteca;

import java.util.HashMap;

public class UserManager {
    private HashMap<String, UserInfo> listOfUsers;

    public UserManager(HashMap<String, UserInfo> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public boolean authenticate(String libraryNumber, String password) {
        if (listOfUsers.containsKey(libraryNumber)) {
            UserInfo userInfo = listOfUsers.get(libraryNumber);
            return userInfo.validate(password);
        }
        return false;
    }
}
