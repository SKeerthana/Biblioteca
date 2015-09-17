package com.thoughtworks.biblioteca;

import java.util.HashMap;

public class UserAuthenticator {
    private HashMap<String, User> listOfUsers;

    public UserAuthenticator(HashMap<String, User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    private User authenticate(String libraryNumber, String password) {
        if (listOfUsers.containsKey(libraryNumber)) {
            User user = listOfUsers.get(libraryNumber);
            if (user.validate(password)) {
                return user;
            }
        }
        return new User("", "", "", "", new GuestRole());
    }

    public User loginUser(ConsoleDisplay consoleDisplay) {
        consoleDisplay.printMessage("Enter library Number : ");
        String libraryNumber = consoleDisplay.getInputFromUser();
        consoleDisplay.printMessage("Enter password : ");
        String password = consoleDisplay.getInputFromUser();
        return authenticate(libraryNumber, password);
    }
}
