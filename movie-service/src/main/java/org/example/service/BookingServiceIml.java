package org.example.service;

import org.example.Model.Customer;
import org.example.Model.Movie;
import org.example.Model.Ticket;
import org.example.enums.BookingStatus;
import org.example.enums.TickectCategory;
import org.example.exception.InvalidBookingException;
import org.example.repository.BookingRepositoryImpl;
import org.example.repository.TicketRepositoryImpl;
import org.example.service.BookingService;
import org.example.util.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookingServiceIml implements BookingService {


    @Override
    public void bookTicket(int movie, int customer, TickectCategory tickectCategory) {
//        if(movie == null){
//            throw new InvalidBookingException("movie is null");
//        }
//        if(customer == null){
//            throw  new InvalidBookingException("Customer is null");
//        }
//        Ticket ticket = new Ticket(counter++,movie,customer,tickectCategory, BookingStatus.CONFIRMED);
//        bookingHistory.add(ticket);
        BookingRepositoryImpl bs = new BookingRepositoryImpl();
        bs.createTicket(movie,customer,tickectCategory,BookingStatus.CREATED);
    }

    @Override
    public List<Ticket> history() {
        BookingRepositoryImpl bs = new BookingRepositoryImpl();
        List<Ticket> bookingHistory = bs.getAllTickets();
        return bookingHistory;
    }



}
