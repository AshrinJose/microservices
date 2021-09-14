package com.learningms.moviecatalogeservice.models;/*
 * @created 16/06/2021 - 2:53 PM
 * @author ASHRIN ROSE JOSE
 */

public class Movie {
    private String movieId;
    private String name;
    private String description;

    public Movie() {

    }

    public Movie(String movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
