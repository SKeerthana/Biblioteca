package com.thoughtworks.biblioteca.user;

import java.util.ArrayList;

public class LoggedInUserRole implements UserRole {
    private ArrayList<String> listOfMenuOptions;

    public LoggedInUserRole() {
        this.listOfMenuOptions = new ArrayList<String>() {{
            add("List Books");
            add("Quit");
            add("CheckOut Book");
            add("Return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("User Information");
            add("Log out");
        }};
    }

    @Override
    public ArrayList<String> getMenuOptions() {
        return listOfMenuOptions;
    }

    @Override
    public boolean isAuthenticatedUser() {
        return true;
    }
}
