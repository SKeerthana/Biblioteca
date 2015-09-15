package com.thoughtworks.biblioteca;

import org.apache.commons.lang3.ArrayUtils;

public class CheckedOutBook extends Book{
    private UserInfo userInfo;

    public CheckedOutBook(Book book, UserInfo userInfo) {
        super(book);
        this.userInfo = userInfo;
    }

    @Override
    public String[] getHeaderDetails() {
        String[] bookHeaderDetails = super.getHeaderDetails();
        String[] userHeaderDetails = new String[]{userInfo.getUserNameHeader()};
        return ArrayUtils.addAll(bookHeaderDetails, userHeaderDetails);
    }
}
