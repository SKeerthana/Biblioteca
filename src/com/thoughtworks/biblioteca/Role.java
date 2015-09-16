package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.List;

public enum Role {
    ADMIN {
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
