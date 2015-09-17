package com.thoughtworks.biblioteca;

public class UserView {
    private User user;

    public UserView(User user) {
        this.user = user;
    }

    public String getFormattedUserDetails() {
        String userDetailsToDisplay = "=====================================================================================\n";
        userDetailsToDisplay += String.format("%-50s %-25s %-15s\n", user.getHeaderDetails());
        userDetailsToDisplay += "=====================================================================================\n";
        userDetailsToDisplay += String.format("%-50s %-25s %-15s\n", user.getUserName(), user.getEmailId(), user.getPhoneNumber());
        userDetailsToDisplay += "=====================================================================================\n";
        return userDetailsToDisplay;
    }
}
