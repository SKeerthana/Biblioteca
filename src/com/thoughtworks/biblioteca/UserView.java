package com.thoughtworks.biblioteca;

public class UserView {
    private User user;

    public UserView(User user) {
        this.user = user;
    }

    public String getFormattedUserDetails() {
        return user.getUserName() + " " + user.getEmailId() + " " + user.getPhoneNumber();
    }
}
