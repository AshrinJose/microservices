package com.learningms.moviecatalogeservice.resources;/*
 * @created 16/06/2021 - 2:25 PM
 * @author ASHRIN ROSE JOSE
 */

import com.learningms.moviecatalogeservice.models.CatalogItem;
import com.learningms.moviecatalogeservice.models.Movie;
import com.learningms.moviecatalogeservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cataloge")
public class CatalogeResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogue(@PathVariable("userId") String userId){

        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 4)
        );
        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http:localhost:8082/movies/"+rating.getMovieId(),  Movie.class);
            return new CatalogItem(movie.getName(),"Desc", rating.getRating());
        }).collect(Collectors.toList());
    }
}

/* @Autowired
    private WebClient.Builder webClientBuilder; */
/* Movie movie = webClientBuilder.build()
              .get()
              .uri("http:localhost:8082/movies/"+rating.getMovieId())
              .retrieve()
              .bodyToMono(Movie.class)
              .block();
 */
