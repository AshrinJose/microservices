package com.learningms.ratingsdataservice.models;/*
 * @created 16/06/2021 - 3:08 PM
 * @author ASHRIN ROSE JOSE
 */

public class Rating {
    private String movieId;
    private int rating;

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
