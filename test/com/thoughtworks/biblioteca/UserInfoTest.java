package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class UserInfoTest {
    @Test
    public void shouldNotCompareWithNull() {
        UserInfo userInfo = new UserInfo("ABC", "ABC", "abc@gmail.com");
        assertNotEquals(userInfo, null);
    }

    @Test
    public void shouldNotCompareWithAnotherObject() {
        UserInfo userInfo = new UserInfo("ABC", "ABC", "abc@gmail.com");
        assertNotEquals(userInfo, "String Object");
    }

    @Test
    public void shouldReturnTrueWhenUserNameIsSame() {
        UserInfo userInfo1 = new UserInfo("ABC", "ABC", "abc@gmail.com");
        UserInfo userInfo2 = new UserInfo("ABC", "abd", "gsdjsjahjk");
        assertEquals(userInfo1, userInfo2);
    }

    @Test
    public void shouldReturnFlaseWhenUserNameIsDifferent() {
        UserInfo userInfo1 = new UserInfo("ABC", "ABC", "abc@gmail.com");
        UserInfo userInfo2 = new UserInfo("ABC23", "abd", "gsdjsjahjk");
        assertNotEquals(userInfo1, userInfo2);
    }

    @Test
    public void shouldCompareWithItself() {
        UserInfo userInfo1 = new UserInfo("ABC", "ABC", "abc@gmail.com");
        assertEquals(userInfo1, userInfo1);
    }

    @Test
    public void shouldReturnTrueForSamePassword() {
        UserInfo userInfo1 = new UserInfo("ABC", "ABC", "abc@gmail.com");
        assertTrue(userInfo1.validate("ABC"));
    }
}