package com.swati.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    //@Autowired  --not using field injection
    private MovieRepository movieRepository;

    //constructor injection
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getSingleMovie(ObjectId id){
        return movieRepository.findById(id);
    }

    public Optional<Movie> getMovieByImdbId(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }
    
}
