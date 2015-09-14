package com.thoughtworks.biblioteca;

public interface LibraryItem {
    String[] getHeaderDetails();
    boolean equals(Object that);
    int hashCode();
}
