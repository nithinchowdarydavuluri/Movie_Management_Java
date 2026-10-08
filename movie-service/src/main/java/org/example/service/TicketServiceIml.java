package org.example.service;

import org.example.Model.BookingDetails;
import org.example.Model.Ticket;
import org.example.repository.TicketRepositoryImpl;

import java.util.List;

public class TicketServiceIml {

    public List<BookingDetails> getByCustomerId(int id){
        TicketRepositoryImpl tr = new TicketRepositoryImpl();
        return  tr.getById(id);
    }

    public void paynow(int id,int Customerid,float amount){
        TicketRepositoryImpl tr = new TicketRepositoryImpl();
        tr.BookById(id,Customerid,amount);

    }

    public BookingDetails getByTicketId(int id){
        TicketRepositoryImpl tr = new TicketRepositoryImpl();
        return tr.getBy(id);
    }



}
