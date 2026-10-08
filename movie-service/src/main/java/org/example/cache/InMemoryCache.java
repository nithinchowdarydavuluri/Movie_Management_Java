package org.example.cache;

import org.example.Model.Movie;
import org.example.repository.MovieRepository;

import java.util.*;

public class InMemoryCache {
    static  Map<Integer, Movie> amap = new HashMap<>();

    static final int sizze = 10;
    static Queue<Integer> queue = new PriorityQueue<>();
    private  static MovieRepository movieRepository;

    public InMemoryCache(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static  List<Movie> loadToCache(){
        List<Movie> alist = movieRepository.findAll();
        for(Movie li : alist){
            if(!amap.containsKey(li.getId())){

                amap.put(li.getId(),amap.getOrDefault(li.getId(),li));
            }

        }
        return  alist;
    }
    public static void addToCache(Movie movie){
        if(!amap.containsKey(movie.getId())){
            amap.put(movie.getId(),amap.getOrDefault(movie.getId(),movie));
        }
    }

    public static List<Movie> getmovies(){
        return  amap.values().stream().toList();
    }


}
