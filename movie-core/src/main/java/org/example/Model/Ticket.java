package org.example.Model;


import org.example.enums.BookingStatus;
import org.example.enums.TickectCategory;

public class Ticket extends BaseEntity {
    private int movie;
    private int customer;
    private TickectCategory category;
    private BookingStatus status;
    public Ticket() {


    }
    public Ticket(
            int id, int movie, int customer, TickectCategory category, BookingStatus status) {

        super(id);

        this.movie = movie;
        this.customer = customer;
        this.category = category;
        this.status = status;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public TickectCategory getCategory() {
        return category;
    }

    public void setCategory(TickectCategory category) {
        this.category = category;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Ticket{" +
                "id=" + id +
                ", movie=" + movie+
                ", customer=" + customer+
                ", category=" + category +
                ", status=" + status +
                '}';
    }
}