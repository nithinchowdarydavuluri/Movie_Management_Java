package org.example.Model;


public class BookingDetails {
    private int TicketId;
    private  int CustomerId;
    private String customerName; private String category; private String status; private String movieName; private String genre; private double price;
    public BookingDetails() {

    }
    public BookingDetails(int TicketId,int CustomerId ,String customerName, String category, String status, String movieName, String genre, double price) {
        this.TicketId = TicketId;
        this.customerName = customerName;
        this.category = category;
        this.status = status;
        this.movieName = movieName;
        this.genre = genre; this.price = price;
        this.CustomerId = CustomerId;
    }
    public int getMovieId() { return TicketId; }
    public void setMovieId(int movieId) { this.TicketId = movieId; } public String getCustomerName() { return customerName; } public void setCustomerName(String customerName) { this.customerName = customerName; } public String getCategory() { return category; } public void setCategory(String category) { this.category = category; } public String getStatus() { return status; } public void setStatus(String status) { this.status = status; } public String getMovieName() { return movieName; } public void setMovieName(String movieName) { this.movieName = movieName; } public String getGenre() { return genre; } public void setGenre(String genre) { this.genre = genre; } public double getPrice() { return price; } public void setPrice(double price) { this.price = price; }
    public  int getCustomerId(){return CustomerId;}
    public  void setCustomerId(int id){
        this.CustomerId = id;
    }

}
