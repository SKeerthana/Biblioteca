package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Bibilioteca contains the list of available and checked out books
public class Biblioteca {

    private ArrayList<LibraryItem> availableItems;
    private ArrayList<LibraryItem> checkedOutItems;

    public Biblioteca(ArrayList<LibraryItem> availableItems, ArrayList<LibraryItem> checkedOutItems) {
        this.availableItems = availableItems;
        this.checkedOutItems = checkedOutItems;
    }

    public boolean containsBookInAvailableList(Book bookName) {
        if (availableItems.contains(bookName))
            return true;
        return false;
    }

    public boolean containsBookInCheckedOutList(Book bookName) {
        if (checkedOutItems.contains(bookName))
            return true;
        return false;
    }

    public void checkOutBook(Book bookName) {
        int index = availableItems.indexOf(bookName);
        checkedOutItems.add(availableItems.get(index));
        availableItems.remove(bookName);
    }

    public void returnBook(Book bookToBeReturned) {
        int index = checkedOutItems.indexOf(bookToBeReturned);
        availableItems.add(checkedOutItems.get(index));
        checkedOutItems.remove(bookToBeReturned);
    }

    public List<LibraryItem> getAvailableItems() {
        return availableItems;
    }
}
