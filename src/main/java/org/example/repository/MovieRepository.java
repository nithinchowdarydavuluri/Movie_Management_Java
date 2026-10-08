package org.example.repository;

import org.example.Model.Movie;

import java.util.List;

public interface MovieRepository {
    void    save(Movie movie);
    Movie findById(int id);
    List<Movie> findAll();
    void update(Movie movie);
    boolean delete(int id);
}
