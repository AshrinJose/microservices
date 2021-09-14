package com.learningms.moviecatalogservice.services;/*
 * @created 21/06/2021 - 3:04 PM
 * @author ASHRIN ROSE JOSE
 */

import com.learningms.moviecatalogservice.models.CatalogItem;
import com.learningms.moviecatalogservice.models.Movie;
import com.learningms.moviecatalogservice.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    private RestTemplate restTemplate;

    /* creating BulkHead
        @HystrixCommand(
            fallbackMethod = "getFallbackCatalogItem",
            threadPoolKey = "movieInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"), // set property for thread pool size; here it is specified to 20
                    @HystrixProperty(name = "maxQueueSize", value = "10") //set queue limit for thread pool wait how many req are waiting in queue before it get a thread.
                    //if there is more requests coming than thread pool and queue size, then the subsequent req will go to fallback method!
            }
    )*/
    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rating.getMovieId(),  Movie.class);
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
    }

    private CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found", "", rating.getRating());
    }

}
