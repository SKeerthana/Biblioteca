package com.thoughtworks.biblioteca;

public class UserView {
    private User user;

    public UserView(User user) {
        this.user = user;
    }

    public String getFormattedUserDetails() {
        return String.format("%-50s %-25s %-15s\n", user.getUserName(), user.getEmailId(), user.getPhoneNumber());
    }
}
