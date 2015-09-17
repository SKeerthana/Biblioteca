package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserViewTest {
    private User currentUser = new User("lib-0001", "abc", "abc", "abc@gmail.com", "9944172304", new LoggedInUserRole());

    @Test
    public void shouldDisplayUserInformation() {
        UserView userView = new UserView(currentUser);
        String userDetailsToDisplay = "=====================================================================================\n";
        userDetailsToDisplay += String.format("%-50s %-25s %-15s\n", "USER NAME","EMAIL ID","PHONE NUMBER");
        userDetailsToDisplay += "=====================================================================================\n";
        userDetailsToDisplay += String.format("%-50s %-25s %-15s\n" ,"abc", "abc@gmail.com", "9944172304");
        userDetailsToDisplay += "=====================================================================================\n";
        assertEquals(userDetailsToDisplay, userView.getFormattedUserDetails());
    }
}
