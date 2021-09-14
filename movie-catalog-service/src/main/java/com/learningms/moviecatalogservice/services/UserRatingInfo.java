package com.learningms.moviecatalogservice.services;/*
 * @created 21/06/2021 - 3:05 PM
 * @author ASHRIN ROSE JOSE
 */

import com.learningms.moviecatalogservice.models.Rating;
import com.learningms.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"), //wait for 2000 and then timeout
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),//threshold of no of request to see before timeout
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),//percentage of requests failed
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")//howlong the circuit breaker sleeps before it picks up again
    })
    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject("http://ratings-data-service/ratingsData/users/" + userId, UserRating.class);
    }

    private UserRating getFallbackUserRating(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRatings(Arrays.asList(new Rating("0",0)));
        return userRating;
    }
}
