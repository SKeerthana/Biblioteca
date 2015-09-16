package com.thoughtworks.biblioteca;

import java.util.HashMap;

public class UserAuthenticator {
    private HashMap<String, User> listOfUsers;

    public UserAuthenticator(HashMap<String, User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public boolean authenticate(String libraryNumber, String password) {
        if (listOfUsers.containsKey(libraryNumber)) {
            User user = listOfUsers.get(libraryNumber);
            if (user.validate(password)) {
                return true;
            }
        }
        return false;
    }
}
