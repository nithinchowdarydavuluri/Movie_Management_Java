package org.example.repository;

import org.example.Model.Customer;
import org.example.Model.Movie;
import org.example.exception.MovieNotFoundException;
import org.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl {
    public List<Customer> findAll() {
        String sql = "select * from customer";
        List<Customer> alist = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                Customer movie =
                        new Customer(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("email"),
                                resultSet.getFloat("amount")
                        );

                alist.add(movie);
            }
            return alist;

        } catch (Exception e) {
            throw  new MovieNotFoundException("unalbe to find the Customers");
        }

    }
}
