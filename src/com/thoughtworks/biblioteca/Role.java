package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.List;

public enum Role {
    ADMIN {
        @Override
        public List<String> getMenuOptions() {
            return new ArrayList<String>() {{
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
    };

    public List<String> getMenuOptions() {
        return new ArrayList<String>() {{
            add("List Books");
            add("Quit");
            add("CheckOut Book");
            add("Return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("Log in");
        }};
    }
}
