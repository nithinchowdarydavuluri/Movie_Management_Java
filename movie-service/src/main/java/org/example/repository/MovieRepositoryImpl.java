package org.example.repository;

import org.example.Model.Movie;
import org.example.cache.InMemoryCache;
import org.example.cache.MovieT;

import org.example.exception.MovieNotFoundException;
import org.example.util.DatabaseConnection;

import javax.smartcardio.TerminalFactory;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MovieRepositoryImpl implements MovieRepository{

    @Override
    public void save(Movie movie) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String sql = "INSERT INTO movies (name,genre,price,time_stamp) VALUES(?,?,?,?)";
        try(Connection connection = DatabaseConnection.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,movie.getName());
            preparedStatement.setString(2,movie.getGenre());
            preparedStatement.setDouble(3,movie.getPrice());
            preparedStatement.setTimestamp(4, timestamp);

            int result = preparedStatement.executeUpdate();
            System.out.println("rows efferted:"+result);
            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                if (resultSet.next()) {

                    movie.setId(
                            resultSet.getInt(1)
                    );
                }
                InMemoryCache.addToCache(movie);
            }

        }catch (Exception e){
            throw new RuntimeException("Error in saving the movie:"+e.getMessage());
        }
    }

    @Override
    public Movie findById(int id) {
        String sql = "SELECT * FROM movies where id = ?";
        try(Connection connection = DatabaseConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setInt(1,id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return new Movie(resultSet.getInt("id"),

                            resultSet.getString("name"),

                            resultSet.getString("genre"),

                            resultSet.getDouble("price"),
                            resultSet.getTimestamp("time_stamp"));
                }

            }
        }catch (Exception e){
//            throw new MovieNotFoundException("move not found");
            e.printStackTrace();
            throw new RuntimeException("Error while finding movie", e);
        }
        return null;
    }

    @Override
    public  List<Movie> findAll() {
        String sql = "select * from movies";
        List<Movie> alist = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getInstance().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            while(resultSet.next()){
                Movie movie =
                        new Movie(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("genre"),
                                resultSet.getDouble("price"),
                                resultSet.getTimestamp("time_stamp")
                        );

                alist.add(movie);
            }
            return alist;

        } catch (Exception e) {
            throw  new MovieNotFoundException("unalbe to find the movies");
        }

    }

    @Override
    public void update(Movie movie) {
         String sql = "update movies set name = ?,genre=?,price=? where id = ?";
         try(Connection connection = DatabaseConnection.getInstance().getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)){
             preparedStatement.setString(1,movie.getName());
             preparedStatement.setString(2, movie.getGenre());
             preparedStatement.setDouble(3,movie.getPrice());
             int result = preparedStatement.executeUpdate();
             System.out.println("number of rows effected: "+result);

         } catch (Exception e) {
             throw new RuntimeException(e);
         }
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
