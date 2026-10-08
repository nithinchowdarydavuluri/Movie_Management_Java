package org.example.serviceIn;

import org.example.Model.Movie;
import org.example.cache.InMemoryCache;
import org.example.cache.MovieT;
import org.example.exception.MovieNotFoundException;
import org.example.repository.MovieRepository;
import org.example.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MovieServiceIml implements MovieService {

    private final MovieRepository movieRepository;

    private static final Logger logger = LoggerFactory.getLogger(MovieServiceIml.class);

    public MovieServiceIml(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


//    private  final List<Movie> movies = new ArrayList<>();
    @Override
    public void addMovie(Movie movie) {
        logger.info(
                "Adding movie: {}",
                movie.getName()
        );

        movieRepository.save(movie);
    }

    @Override
    public Movie getByMovieId(int id) {
        logger.debug(
                "Searching movie with id: {}",
                id
        );
        System.out.println("step1");
        List<Movie> movies = InMemoryCache.getmovies();
        if(!movies.isEmpty()){
            for(Movie movie:movies){
                System.out.println(movie.getName()+" "+movie.getId());
                if(movie.getId() == id){
                    System.out.println("From Cache!----->"+movie.getName());
                    return movie;
                }
            }

        }

        Movie movie = movieRepository.findById(id);
        System.out.println("step-2"+movie);
        if (movie == null) {

            logger.error(
                    "Movie not found: {}",
                    id
            );

            throw new MovieNotFoundException(
                    "Movie not found with id: " +
                            id
            );
        }
        movie.setId(id);
        InMemoryCache.addToCache(movie);
        return  movie;

    }



    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMovieByGenre(String genre) {
        return movieRepository.findAll().stream().filter((al)->al.getGenre().equalsIgnoreCase(genre)).toList();
    }

    @Override
    public void updateMovie(Movie movie) {
        getByMovieId(movie.getId());

        movieRepository.update(movie);
    }
}
