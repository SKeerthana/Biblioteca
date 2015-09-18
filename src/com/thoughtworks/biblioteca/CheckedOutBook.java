package com.thoughtworks.biblioteca;

import org.apache.commons.lang3.ArrayUtils;

public class CheckedOutBook extends Book {
    private User user;

    public CheckedOutBook(Book book, User user) {
        super(book);
        this.user = user;
    }

    @Override
    public String[] getHeaderDetails() {
        String[] bookHeaderDetails = super.getHeaderDetails();
        String[] userHeaderDetails = new String[]{user.getLibraryNumberHeader()};
        return ArrayUtils.addAll(bookHeaderDetails, userHeaderDetails);
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object that) {
        if (that == this)
            return true;
        if (that == null || that.getClass() != getClass())
            return false;
        CheckedOutBook thatBookName = (CheckedOutBook) that;
        return bookName.equals(thatBookName.bookName) && user.equals(thatBookName.user);
    }

    @Override
    public int hashCode() {
        return bookName.hashCode();
    }

}
