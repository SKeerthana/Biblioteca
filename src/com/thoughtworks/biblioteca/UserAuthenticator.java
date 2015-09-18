package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

//authenticates users using the list of predefined users
public class UserAuthenticator {
    private ArrayList<User> listOfUsers;

    public UserAuthenticator(ArrayList<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public User authenticate(String libraryNumber, String password) {
        for (User user : listOfUsers) {
            if (user.validate(libraryNumber, password)) {
                return user;
            }
        }
        return new User("guest-001", "", "", "", "", new GuestRole());
    }

    public User loginUser(ConsoleDisplay consoleDisplay) {
        consoleDisplay.printMessage("Enter library Number : ");
        String libraryNumber = consoleDisplay.getInputFromUser();
        consoleDisplay.printMessage("Enter password : ");
        String password = consoleDisplay.getInputFromUser();
        return authenticate(libraryNumber, password);
    }

    public User logOut() {
        return new User("guest-001", "", "", "", "", new GuestRole());
    }
}
