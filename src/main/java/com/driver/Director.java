package com.driver;

public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    public Director(String name, int numberOfMovies, double imdbRating) {
        setName(name);
        setImdbRating(imdbRating);
        setNumberOfMovies(numberOfMovies);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
