package com.swati.movies;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    private MovieService movieService;

    //constructor injection
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovie() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<>(movieService.getSingleMovie(id), HttpStatus.OK);
    }
    
    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
    
    
}
