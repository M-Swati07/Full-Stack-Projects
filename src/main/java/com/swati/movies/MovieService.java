package com.swati.movies;

import java.util.List;
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
    
}
