package com.thoughtworks.biblioteca.user;

import java.util.ArrayList;

public interface UserRole {
    ArrayList<String> getMenuOptions();
    boolean isAuthenticatedUser();

}
