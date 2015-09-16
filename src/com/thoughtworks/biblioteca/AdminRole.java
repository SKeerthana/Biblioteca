package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class AdminRole implements UserRole{
    private ArrayList<String> listOfMenuOptions;

    public AdminRole() {
        this.listOfMenuOptions = new ArrayList<String>() {{
            add("List Books");
            add("Quit");
            add("CheckOut Book");
            add("Return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("User Information");
            add("Book Status");
            add("Log out");
        }};
    }

    @Override
    public ArrayList<String> getMenuOptions() {
        return listOfMenuOptions;
    }
}
