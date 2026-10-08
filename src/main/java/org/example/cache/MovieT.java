package org.example.cache;

import org.example.Model.Movie;

import java.time.LocalDateTime;

public class MovieT {
    Movie movie;
    LocalDateTime time;

    public MovieT(Movie movie,LocalDateTime time) {
        this.movie = movie;
        this.time = time;
    }
}
