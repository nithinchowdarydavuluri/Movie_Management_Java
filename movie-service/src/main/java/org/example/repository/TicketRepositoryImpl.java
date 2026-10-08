package org.example.repository;

import org.example.Model.BookingDetails;
import org.example.Model.Ticket;
import org.example.enums.BookingStatus;
import org.example.enums.TickectCategory;
import org.example.exception.InvalidBookingException;
import org.example.util.DatabaseConnection;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl {
    private static final Logger log = LoggerFactory.getLogger(TicketRepositoryImpl.class);

    public List<BookingDetails> getById(int id){
        List<BookingDetails> alist = new ArrayList<>();
        String sql = "with temp as (select customer.id as C_id,ticket.id,ticket.movieId,customer.name,ticket.category,ticket.status from ticket join customer on ticket.customerid=customer.id)\n" +
                "\n" +
                "select temp.id AS TicketId,temp.C_id as CustomerId,temp.name as customerName,temp.category,temp.status,movies.name,movies.genre,movies.price from temp join movies on temp.movieId=movies.id where temp.C_id = ?;\n" +
                "\n"  +
                "\n";

        try(Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                BookingDetails bd = new BookingDetails(
                        resultSet.getInt("TicketId"),
                        resultSet.getInt("CustomerId"),
                        resultSet.getString("customerName"),
                        resultSet.getString("category"),
                        resultSet.getString("status"),
                        resultSet.getString("name"),
                        resultSet.getString("genre"),
                        resultSet.getDouble("price")

                );
                alist.add(bd);
            }
            return  alist;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void BookById(int id,int Customerid,float price){
        String sql1 = "update customer set amount=amount-? where id = ?;";
        String sql2 = "update ticket set status=? where id =?;";

        try(Connection connection = DatabaseConnection.getInstance().getConnection()){
            connection.setAutoCommit(false);
            String sql ="select amount from customer where id=?;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,Customerid);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                System.out.println("checking "+ resultSet.getFloat("amount") +":"+price);
                if(resultSet.getFloat("amount") < price){
                    System.out.println("No amount sufficient amount of balance");
                    connection.rollback();
                    throw new RuntimeException("No amount sufficient amount of balance");
                }
            }



            try {

                PreparedStatement preparedStatement = connection.prepareStatement(sql1);
                preparedStatement.setDouble(1,price);
                preparedStatement.setInt(2,Customerid);
                int result = preparedStatement.executeUpdate();

            } catch (Exception e) {
                connection.rollback();
                throw new RuntimeException(e+"transansion 1 fails");

            }

            try{
                PreparedStatement preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setString(1, BookingStatus.CONFIRMED.toString());
                preparedStatement.setInt(2,id);
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                connection.rollback();
                throw new RuntimeException(e+"Transaction 2 fails");
            }
            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BookingDetails getBy(int id) {

        String sql =
                "SELECT ticket.id AS TicketId, " +
                        "customer.id as CustomerId,"+
                        "       customer.name AS customerName, " +
                        "       ticket.category, " +
                        "       ticket.status, " +
                        "       movies.name AS movieName, " +
                        "       movies.genre, " +
                        "       movies.price " +
                        "FROM ticket " +
                        "JOIN customer ON ticket.customerId = customer.id " +
                        "JOIN movies ON ticket.movieId = movies.id " +
                        "WHERE ticket.id = ?";

        try (Connection connection =
                     DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    return new BookingDetails(
                            resultSet.getInt("TicketId"),
                            resultSet.getInt("CustomerId"),
                            resultSet.getString("customerName"),
                            resultSet.getString("category"),
                            resultSet.getString("status"),
                            resultSet.getString("movieName"),
                            resultSet.getString("genre"),
                            resultSet.getDouble("price")
                    );
                }

                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
