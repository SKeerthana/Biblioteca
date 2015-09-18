package com.thoughtworks.biblioteca.user;

import java.util.ArrayList;

public class GuestRole implements UserRole {
    private ArrayList<String> listOfMenuOptions;

    public GuestRole() {
        this.listOfMenuOptions = new ArrayList<String>() {{
            add("List Books");
            add("Quit");
            add("CheckOut Book");
            add("Return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("Log in");
        }};
    }

    @Override
    public ArrayList<String> getMenuOptions() {
        return listOfMenuOptions;
    }

    @Override
    public boolean isAuthenticatedUser() {
        return false;
    }
}
