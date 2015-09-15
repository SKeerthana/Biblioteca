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

    public boolean containsLibraryItemInAvailableList(LibraryItem libraryItem) {
        if (availableItems.contains(libraryItem))
            return true;
        return false;
    }

    public boolean containsLibraryItemInCheckedOutList(Book libraryItem) {
        if (checkedOutItems.contains(libraryItem))
            return true;
        return false;
    }

    public void checkOutLibraryItem(LibraryItem libraryItem) {
        int index = availableItems.indexOf(libraryItem);
        checkedOutItems.add(availableItems.get(index));
        availableItems.remove(libraryItem);
    }

    public void returnLibraryItem(Book libraryItem) {
        int index = checkedOutItems.indexOf(libraryItem);
        availableItems.add(checkedOutItems.get(index));
        checkedOutItems.remove(libraryItem);
    }

    public List<LibraryItem> getAvailableItems() {
        return availableItems;
    }
}
