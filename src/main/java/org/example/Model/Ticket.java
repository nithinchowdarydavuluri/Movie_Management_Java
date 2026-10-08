package org.example.Model;


import org.example.enums.BookingStatus;
import org.example.enums.TickectCategory;

public class Ticket extends BaseEntity {
    private Movie movie;
    private Customer customer;
    private TickectCategory category;
    private BookingStatus status;
    public Ticket() {


    }
    public Ticket(
            int id, Movie movie, Customer customer, TickectCategory category, BookingStatus status) {

        super(id);

        this.movie = movie;
        this.customer = customer;
        this.category = category;
        this.status = status;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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
                ", movie=" + movie.getName() +
                ", customer=" + customer.getName() +
                ", category=" + category +
                ", status=" + status +
                '}';
    }
}