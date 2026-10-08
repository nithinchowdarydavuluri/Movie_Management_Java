package org.example.Model;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Movie extends  BaseEntity {
    private int id;
    private String name;
    private  String genre;
    private  double price;
    private Timestamp time_stamp;
    public Movie(){

    }
    public Movie(int id, String name, String genre, double price,Timestamp time_stamp){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.time_stamp = time_stamp;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;

    }
    public String getName(){
        return name;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public String getGenre(){
        return genre;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public void setTimeStamp(Timestamp time_stamp){
        this.time_stamp = time_stamp;
    }
    public Timestamp getTime_stamp(){
        return time_stamp;
    }


    public String rStr(){
         return "Movie{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", genre='" + genre + '\'' +
                 ", price=" + price +
                 '}';
    }

}
