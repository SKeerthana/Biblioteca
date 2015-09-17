package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserViewTest {
    private User currentUser = new User("lib-0001", "abc", "abc", "abc@gmail.com", "9944172304", new LoggedInUserRole());

    @Test
    public void shouldDisplayUserInformation() {
        UserView userView = new UserView(currentUser);
        assertEquals("abc abc@gmail.com 9944172304", userView.getFormattedUserDetails());
    }
}
