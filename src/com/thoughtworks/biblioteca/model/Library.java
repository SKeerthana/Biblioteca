package com.thoughtworks.biblioteca.model;

import java.util.ArrayList;
import java.util.List;

//Bibilioteca contains the list of available and checked out books
public class Library {

    private ArrayList<LibraryItem> availableItems;
    private ArrayList<LibraryItem> checkedOutItems;

    public Library(ArrayList<LibraryItem> availableItems, ArrayList<LibraryItem> checkedOutItems) {
        this.availableItems = availableItems;
        this.checkedOutItems = checkedOutItems;
    }

    public int getIndexOfLibraryItemInAvailableList(LibraryItem libraryItem) {
        return availableItems.indexOf(libraryItem);
    }

    public LibraryItem removeLibraryItemFromAvailableList(int index) {
        return availableItems.remove(index);
    }

    public void addLibraryItemToCheckedOutList(LibraryItem libraryItem) {
        checkedOutItems.add(libraryItem);
    }

    public int getIndexOfLibraryItemInCheckedOutItems(LibraryItem libraryItem) {
        return checkedOutItems.indexOf(libraryItem);
    }

    public LibraryItem removeLibraryItemFromCheckedOutList(int index) {
        return checkedOutItems.remove(index);
    }

    public void addLibraryItemToAvailableList(LibraryItem libraryItem) {
        availableItems.add(libraryItem);
    }

    public List<LibraryItem> getAvailableItems() {
        return availableItems;
    }

    public ArrayList<LibraryItem> getCheckedOutItems() {
        return checkedOutItems;
    }
}
