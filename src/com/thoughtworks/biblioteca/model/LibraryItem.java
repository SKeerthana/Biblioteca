package com.thoughtworks.biblioteca.model;

public interface LibraryItem {
    String[] getHeaderDetails();
    boolean equals(Object that);
    int hashCode();
}
