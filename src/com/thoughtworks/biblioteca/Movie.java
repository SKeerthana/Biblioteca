package com.thoughtworks.biblioteca;

public class Movie {
    private String movieName;
    private int yearPublished;
    private String director;
    private int unRated;

    public Movie(String movieName, int yearPublished, String director, int unRated) {
        this.unRated = unRated;
        this.movieName = movieName;
        this.yearPublished = yearPublished;
        this.director = director;
    }

    @Override
    public boolean equals(Object that) {
        if(that == null)
            return false;
        return true;
    }
}
