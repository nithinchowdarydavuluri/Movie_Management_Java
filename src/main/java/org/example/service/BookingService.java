package org.example.service;

import org.example.Model.Customer;
import org.example.Model.Movie;
import org.example.Model.Ticket;
import org.example.enums.TickectCategory;

import java.util.List;

public interface BookingService {
    Ticket bookTicket(Movie movie, Customer customer, TickectCategory tickectCategory);
    List<Ticket> history();
}
