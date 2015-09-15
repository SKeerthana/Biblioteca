package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInfoTest {
    @Test
    public void shouldNotCompareWithNull() {
        UserInfo userInfo = new UserInfo("ABC", "ABC", "abc@gmail.com");
        assertEquals(userInfo, null);
    }
}
