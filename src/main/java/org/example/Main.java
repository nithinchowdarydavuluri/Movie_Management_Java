package org.example;

import org.example.Model.Customer;
import org.example.Model.Movie;
import org.example.Model.Ticket;
import org.example.enums.TickectCategory;
import org.example.repository.MovieRepository;
import org.example.repository.MovieRepositoryImpl;
import org.example.service.BookingService;

import org.example.serviceIn.BookingServiceIml;
import org.example.serviceIn.MovieServiceIml;
import org.example.util.CSVUtil;
import org.example.util.FileUtil;
import org.example.util.JsonUtil;
import org.example.util.VelocityUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Repository
//        MovieRepository movieRepository = new MovieRepositoryImpl();
//
////        service
//        MovieServiceIml movieService = new MovieServiceIml(movieRepository);
//
////        Movie movie1 = new Movie(0, "Avengers", "Action", 250);
////        Movie movie2 = new Movie(0, "Inception", "Sci-Fi", 350);
////
////        movieService.addMovie(movie1);
////        movieService.addMovie(movie2);
//
//        List<Movie> movies = movieService.getAll();
//
//
//        System.out.println("\nALL MOVIES");
//        movies.forEach(
//                System.out::println
//        );
//        Customer customer = new Customer(1, "Nithin", "nithin@example.com");
//        BookingService bookingService = new BookingServiceIml();
//        Ticket ticket = bookingService.bookTicket(movie1, customer, TickectCategory.VIP);
//        System.out.println("\nBOOKING SUCCESSFUL");
//
//
//        System.out.println(ticket);
//        String json = JsonUtil.ObjectToJson(ticket);
//        System.out.println("json->"+ json);
//        String str = """
//{
//    "id": 1,
//    "movie": {
//        "id": 33,
//        "name": "Avengers",
//        "genre": "Action",
//        "price": 250.0
//    },
//    "customer": {
//        "id": 1,
//        "name": "Nithin",
//        "email": "nithin@example.com"
//    },
//    "category": "VIP",
//    "status": "CONFIRMED"
//}
//""";
//        System.out.println("Object->"+JsonUtil.jsonToObject(str));
//
//
//        CSVUtil.writeMovies(movies, "movies.csv");
//
//        System.out.println(
//                "\nCSV FILE CREATED"
//        );
//
//
//        FileUtil.writeToFile(
//
//                "application.txt",
//
//                "Movie Ticket Management System"
//        );
//
//        VelocityUtil.generateTicket(
//
//                ticket,
//
//                "ticket.html"
//        );
//
//
//        System.out.println(
//                "HTML TICKET GENERATED"
//        );
    }
}