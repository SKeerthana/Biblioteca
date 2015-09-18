package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    AdminRole adminRole = new AdminRole();

    @Test
    public void shouldNotCompareWithNull() {
        User user = new User("ABC", "ABC", "", "abc@gmail.com", "9944172304", adminRole);
        assertNotEquals(user, null);
    }

    @Test
    public void shouldNotCompareWithAnotherObject() {
        User user = new User("ABC", "ABC", "", "abc@gmail.com", "9944172304", adminRole);
        assertNotEquals(user, "String Object");
    }

    @Test
    public void shouldReturnTrueWhenUserNameIsSame() {
        User user1 = new User("ABC", "ABC", "", "abc@gmail.com", "9944172304", adminRole);
        User user2 = new User("ABC", "ABC", "", "abc@gmail.com", "9944172304", adminRole);
        assertEquals(user1, user2);
    }

    @Test
    public void shouldReturnFlaseWhenUserNameIsDifferent() {
        User user1 = new User("ABC12", "ABC23", "", "abc@gmail.com", "9944172304", adminRole);
        User user2 = new User("ABC", "ABC", "", "abc@gmail.com", "9944172304", adminRole);
        assertNotEquals(user1, user2);
    }

    @Test
    public void shouldCompareWithItself() {
        User user1 = new User("ABC12", "ABC23", "", "abc@gmail.com", "9944172304", adminRole);
        assertEquals(user1, user1);
    }

    @Test
    public void shouldReturnTrueForSamePassword() {
        User user1 = new User("ABC12", "ABC23", "ABC", "abc@gmail.com", "9944172304", adminRole);
        assertTrue(user1.validate("ABC12", "ABC"));
    }

    @Test
    public void shouldReturnFalseForDifferentPassword() {
        User user1 = new User("ABC12", "ABC23", "abc", "abc@gmail.com", "9944172304", adminRole);
        assertFalse(user1.validate("ABC12", "ABC12"));
    }

    @Test
    public void shouldReturnTrueForCheckOutBookOptionForAdmin() {
        User user1 = new User("ABC12", "ABC23", "", "abc@gmail.com", "9944172304", adminRole);
        assertTrue(user1.isAuthenticatedUser());
    }
}
