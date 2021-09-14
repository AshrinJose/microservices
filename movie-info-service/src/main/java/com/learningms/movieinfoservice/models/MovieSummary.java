package com.learningms.movieinfoservice.models;/*
 * @created 16/06/2021 - 3:07 PM
 * @author ASHRIN ROSE JOSE
 */

public class MovieSummary {
    private String id;
    private String title;
    private String overview;

    public MovieSummary(String id, String title, String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
