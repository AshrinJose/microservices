package com.learningms.moviecatalogservice.resources;/*
 * @created 16/06/2021 - 2:25 PM
 * @author ASHRIN ROSE JOSE
 */

import com.learningms.moviecatalogservice.models.CatalogItem;
import com.learningms.moviecatalogservice.models.UserRating;
import com.learningms.moviecatalogservice.services.MovieInfo;
import com.learningms.moviecatalogservice.services.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cataloge")
public class CatalogeResource {

    @Autowired
    MovieInfo movieInfo;

    @Autowired
    UserRatingInfo userRatingInfo;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogue(@PathVariable("userId") String userId){
        UserRating userRating = userRatingInfo.getUserRating(userId);
        return userRating.getRatings().stream()
                .map(rating -> movieInfo.getCatalogItem(rating))
                .collect(Collectors.toList());
    }
}





/* Using Web Client instead of Rest Template
    @Autowired
    private WebClient.Builder webClientBuilder;
     Movie movie = webClientBuilder.build()
              .get()
              .uri("http:localhost:8082/movies/"+rating.getMovieId())
              .retrieve()
              .bodyToMono(Movie.class)
              .block();
 */
