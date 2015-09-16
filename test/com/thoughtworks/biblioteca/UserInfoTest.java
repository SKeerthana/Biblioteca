package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserInfoTest {
    @Test
    public void shouldNotCompareWithNull() {
        UserInfo userInfo = new UserInfo("ABC", "ABC", "", "abc@gmail.com", Role.ADMIN);
        assertNotEquals(userInfo, null);
    }

    @Test
    public void shouldNotCompareWithAnotherObject() {
        UserInfo userInfo = new UserInfo("ABC", "ABC", "", "abc@gmail.com", Role.ADMIN);
        assertNotEquals(userInfo, "String Object");
    }

    @Test
    public void shouldReturnTrueWhenUserNameIsSame() {
        UserInfo userInfo1 = new UserInfo("ABC", "ABC", "", "abc@gmail.com", Role.ADMIN);
        UserInfo userInfo2 = new UserInfo("ABC", "ABC", "", "abc@gmail.com", Role.ADMIN);
        assertEquals(userInfo1, userInfo2);
    }

    @Test
    public void shouldReturnFlaseWhenUserNameIsDifferent() {
        UserInfo userInfo1 = new UserInfo("ABC12", "ABC23", "", "abc@gmail.com", Role.ADMIN);
        UserInfo userInfo2 = new UserInfo("ABC", "ABC", "", "abc@gmail.com", Role.ADMIN);
        assertNotEquals(userInfo1, userInfo2);
    }

    @Test
    public void shouldCompareWithItself() {
        UserInfo userInfo1 = new UserInfo("ABC12", "ABC23", "", "abc@gmail.com", Role.ADMIN);
        assertEquals(userInfo1, userInfo1);
    }

    @Test
    public void shouldReturnTrueForSamePassword() {
        UserInfo userInfo1 = new UserInfo("ABC12", "ABC23", "ABC", "abc@gmail.com", Role.ADMIN);
        assertTrue(userInfo1.validate("ABC"));
    }

    @Test
    public void shouldReturnFlaseForDifferentPassword() {
        UserInfo userInfo1 = new UserInfo("ABC12", "ABC23", "", "abc@gmail.com", Role.ADMIN);
        assertFalse(userInfo1.validate("ABC12"));
    }
}
