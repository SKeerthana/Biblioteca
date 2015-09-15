package com.thoughtworks.biblioteca;

public class MovieView implements LibraryView{
    private Biblioteca movieDataLibrary;

    public MovieView(Biblioteca movieDataLibrary) {
        this.movieDataLibrary = movieDataLibrary;
    }

    public String getFormattedListOfItems() {
        return "movie data";
    }
}
