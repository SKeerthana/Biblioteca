package com.thoughtworks.biblioteca;

public class UserInfo {
    private String userName;
    private String password;
    private String emailId;

    public UserInfo(String userName, String password, String emailId) {
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
    }

    @Override
    public boolean equals(Object that){
        if (that != null)
            return false;
        return true;
    }
}
