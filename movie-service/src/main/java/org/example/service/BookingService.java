package org.example.service;

import org.example.Model.Customer;
import org.example.Model.Movie;
import org.example.Model.Ticket;
import org.example.enums.TickectCategory;

import java.util.List;

public interface BookingService {
    void bookTicket(int movie, int customer, TickectCategory tickectCategory);
    List<Ticket> history();
}
