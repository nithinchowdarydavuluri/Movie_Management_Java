package org.example.serviceIn;

import org.example.Model.Customer;
import org.example.Model.Movie;
import org.example.Model.Ticket;
import org.example.enums.BookingStatus;
import org.example.enums.TickectCategory;
import org.example.exception.InvalidBookingException;
import org.example.service.BookingService;

import java.util.LinkedList;
import java.util.List;

public class BookingServiceIml implements BookingService {

    private  final LinkedList<Ticket> bookingHistory = new LinkedList<>();
    private static int counter = 1;

    @Override
    public Ticket bookTicket(Movie movie, Customer customer, TickectCategory tickectCategory) {
        if(movie == null){
            throw new InvalidBookingException("movie is null");
        }
        if(customer == null){
            throw  new InvalidBookingException("Customer is null");
        }
        Ticket ticket = new Ticket(counter++,movie,customer,tickectCategory, BookingStatus.CONFIRMED);
        bookingHistory.add(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> history() {
        return bookingHistory;
    }
}
