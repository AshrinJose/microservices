package com.learningms.movieinfoservice.resources;/*
 * @created 17/06/2021 - 10:41 AM
 * @author ASHRIN ROSE JOSE
 */

import com.learningms.movieinfoservice.models.Movie;
import com.learningms.movieinfoservice.models.MovieSummary;
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
@RequestMapping("/movies")
public class MovieResource {

    private final RestTemplate restTemplate;

    public MovieResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        List<MovieSummary> movieSummList = Arrays.asList(
                new MovieSummary("100","Avengers", "Excellent"),
                new MovieSummary("200","Avengers End Game", "Good")
        );
        List<MovieSummary> movieSummaryList = movieSummList.stream().filter(movieSumm -> movieSumm.getId().contains(movieId)).collect(Collectors.toList());
        return new Movie(movieId, movieSummaryList.get(0).getTitle(), movieSummaryList.get(0).getOverview());
        /*
        MovieSummary movieSummary = restTemplate.getForObject("" + movieId, MovieSummary.class);
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
        **/
    }

}
