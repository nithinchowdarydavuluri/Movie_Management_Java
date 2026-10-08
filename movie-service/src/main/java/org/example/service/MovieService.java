package org.example.service;

import org.example.Model.Movie;

import java.util.List;

public interface MovieService {
    void addMovie(Movie movie,String db_type);

    Movie getByMovieId(int id);

    List<Movie> getAll();

    List<Movie> getMovieByGenre(String genre);
    void updateMovie(Movie movie);
}
