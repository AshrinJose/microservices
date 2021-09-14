package com.learningms.ratingsdataservice.models;/*
 * @created 16/06/2021 - 3:12 PM
 * @author ASHRIN ROSE JOSE
 */

import java.util.Arrays;
import java.util.List;

public class UserRating {
    private String userId;
    private List<Rating> ratings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void initData(String userId) {
        this.setUserId(userId);
        this.setRatings(Arrays.asList(
                new Rating("100", 3),
                new Rating("200", 4)
        ));
    }
}
