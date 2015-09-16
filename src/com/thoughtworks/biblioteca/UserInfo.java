package com.thoughtworks.biblioteca;

public class UserInfo {
    private String libraryNumber;
    private String userName;
    private String password;
    private String emailId;
    private Role role;

    public UserInfo(String libraryNumber, String userName, String password, String emailId, Role role) {
        this.libraryNumber = libraryNumber;
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.role = role;
    }

    @Override
    public boolean equals(Object that){
        if(that == this)
            return true;
        if (that == null || that.getClass() != getClass())
            return false;
        UserInfo thatUserInfo = (UserInfo) that;
        return (thatUserInfo.userName.equals(userName));
    }

    public String getUserNameHeader() {
        return "USER NAME";
    }

    public boolean validate(String password) {
        return this.password.equals(password);
    }
}
