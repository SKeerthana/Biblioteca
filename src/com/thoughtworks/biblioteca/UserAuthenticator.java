package com.thoughtworks.biblioteca;

import java.util.HashMap;

//authenticates users using the list of predefined users
public class UserAuthenticator {
    private HashMap<String, User> listOfUsers;

    public UserAuthenticator(HashMap<String, User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    public User authenticate(String libraryNumber, String password) {
        if (listOfUsers.containsKey(libraryNumber)) {
            User user = listOfUsers.get(libraryNumber);
            if (user.validate(password)) {
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
