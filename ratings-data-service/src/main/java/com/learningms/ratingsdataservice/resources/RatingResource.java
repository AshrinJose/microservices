package com.learningms.ratingsdataservice.resources;/*
 * @created 17/06/2021 - 10:42 AM
 * @author ASHRIN ROSE JOSE
 */

import com.learningms.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsData")
public class RatingResource {

    @GetMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId){
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }
}
