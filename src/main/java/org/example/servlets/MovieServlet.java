package org.example.servlets;

import org.example.Model.Movie;
import org.example.cache.InMemoryCache;
import org.example.database.DatabaseConnection;
import org.example.repository.MovieRepository;
import org.example.repository.MovieRepositoryImpl;
import org.example.service.MovieService;
import org.example.serviceIn.MovieServiceIml;
import org.example.util.JsonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Class.forName;

@WebServlet("/movie/*")
public class MovieServlet extends HttpServlet {
    List<Movie> ml = new ArrayList<>();
    @Override
    public void init() throws ServletException {
        super.init();
        MovieRepositoryImpl mr = new MovieRepositoryImpl();
        InMemoryCache ic = new InMemoryCache(mr);
        ml = ic.loadToCache();
        System.out.println("new one started");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String val = req.getPathInfo();



//        String val = req.getPathInfo();
//
//
//        int c = Integer.parseInt(val.split("/")[1]);
//
//        System.out.println("Movie ID = " + c);
//
//        MovieRepository movieRepository = new MovieRepositoryImpl();
//        MovieServiceIml movieService = new MovieServiceIml(movieRepository);
//        Movie mv = movieService.getByMovieId(c);
//        resp.setContentType("text/html");
//        resp.getWriter().println("<p>Name:"+ mv.getName()+"/nGenre:"+mv.getGenre()+"/nprice:"+mv.getPrice()+"</p>");
//        String name = "Nithin";
//
//        req.setAttribute("name", name);
//        System.out.println(name);
//        RequestDispatcher dispatcher =
//                req.getRequestDispatcher("/WEB-INF/hello.jsp");
//
//        dispatcher.forward(req, resp);
        if(val != null){
            String  c = val.split("/")[1];
            MovieRepository movieRepository = new MovieRepositoryImpl();
            MovieServiceIml movieService = new MovieServiceIml(movieRepository);
            req.setAttribute("movielist",ml);
            System.out.println(ml+"============");
            req.getRequestDispatcher("/WEB-INF/Movies.jsp")
                    .forward(req, resp);


        }else{
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/form.jsp");

            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String genre = req.getParameter("genre");
        double price = Double.parseDouble(req.getParameter("price"));

        Movie movie = new Movie();

        movie.setName(name);
        movie.setGenre(genre);
        movie.setPrice(price);

//        Movie movie  = JsonUtil.jsonToObject(body);
        MovieRepository movieRepository = new MovieRepositoryImpl();
        MovieServiceIml movieService = new MovieServiceIml(movieRepository);
        movieService.addMovie(movie);

        resp.setContentType("text/html");
        resp.getWriter().println("Sucessfully added");
        init();

    }
}
