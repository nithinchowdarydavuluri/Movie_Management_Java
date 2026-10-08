package org.example.repository;

import org.example.Model.Customer;
import org.example.Model.Movie;

import org.example.Model.Ticket;
import org.example.enums.BookingStatus;
import org.example.enums.TickectCategory;
import org.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingRepositoryImpl {

    public List<Ticket> getAllTickets() {
        List<Ticket> alist = new ArrayList<>();
        String sql = "select * from ticket";
        try(Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("movieId"),
                        resultSet.getInt("cusomerId"),
                        TickectCategory.getByName(resultSet.getString("category")),
                        BookingStatus.valueOf(resultSet.getString("status"))
                );
                alist.add(ticket);

            }
            return  alist;
        }catch (Exception e){
            throw new RuntimeException("unable to get the movies");
        }
    }

    public void createTicket(int movie, int customer, TickectCategory tickectCategory, BookingStatus bookingStatus) {
        String sql = "INSERT INTO ticket(movieId,customerId,category,status) values(?,?,?,?);";
        System.out.println("movieID:"+movie+" customerId:"+customer);
        try(Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,movie);
            preparedStatement.setInt(2,customer);
            preparedStatement.setString(3,tickectCategory.toString());
            preparedStatement.setString(4,bookingStatus.toString());
            int result = preparedStatement.executeUpdate();
            if(result == 0){
                throw  new RuntimeException("something went wrong it is not updated");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
