package org.example.repository;

import org.example.Model.Movie;
import org.example.cache.InMemoryCache;
import org.example.exception.MovieNotFoundException;
import org.example.util.PostgresDatabaseConnection;

import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

public class PostgreSQLMovieRepositoryImpl implements MovieRepository {

    @Override
    public void save(Movie movie) {

        String sql = """
                INSERT INTO movies (name, genre, price, time_stamp)
                VALUES (?, ?, ?, ?)
                """;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        try (
                Connection connection =
                        PostgresDatabaseConnection.getInstance().getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        )
        ) {

            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setDouble(3, movie.getPrice());
            preparedStatement.setTimestamp(4, timestamp);

            int result = preparedStatement.executeUpdate();

            System.out.println("Rows affected: " + result);

            try (ResultSet resultSet =
                         preparedStatement.getGeneratedKeys()) {

                if (resultSet.next()) {
                    movie.setId(resultSet.getInt(1));
                }
            }

            InMemoryCache.addToCache(movie);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(
                    "Error in saving movie: " + e.getMessage(), e
            );
        }
    }


    @Override
    public Movie findById(int id) {

        String sql = "SELECT * FROM movies WHERE id = ?";

        try (
                Connection connection =
                        PostgresDatabaseConnection.getInstance().getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet =
                         preparedStatement.executeQuery()) {

                if (resultSet.next()) {

                    return new Movie(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("genre"),
                            resultSet.getDouble("price"),
                            resultSet.getTimestamp("time_stamp")
                    );
                }
            }

        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(
                    "Error while finding movie", e
            );
        }

        throw new MovieNotFoundException(
                "Movie not found with id: " + id
        );
    }


    @Override
    public List<Movie> findAll() {

        String sql = "SELECT * FROM movies";

        List<Movie> movieList = new ArrayList<>();

        try (
                Connection connection =
                        PostgresDatabaseConnection.getInstance().getConnection();

                Statement statement =
                        connection.createStatement();

                ResultSet resultSet =
                        statement.executeQuery(sql)
        ) {

            while (resultSet.next()) {

                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("genre"),
                        resultSet.getDouble("price"),
                        resultSet.getTimestamp("time_stamp")
                );

                movieList.add(movie);
            }

            return movieList;

        } catch (SQLException | ClassNotFoundException e) {

            throw new MovieNotFoundException(
                    "Unable to find movies"
            );
        }
    }


    @Override
    public void update(Movie movie) {

        String sql = """
                UPDATE movies
                SET name = ?,
                    genre = ?,
                    price = ?
                WHERE id = ?
                """;

        try (
                Connection connection =
                        PostgresDatabaseConnection.getInstance().getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setDouble(3, movie.getPrice());
            preparedStatement.setInt(4, movie.getId());

            int result = preparedStatement.executeUpdate();

            System.out.println(
                    "Number of rows affected: " + result
            );

            if (result == 0) {
                throw new MovieNotFoundException(
                        "Movie not found with id: " + movie.getId()
                );
            }

            InMemoryCache.addToCache(movie);

        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(
                    "Error while updating movie", e
            );
        }
    }


    @Override
    public boolean delete(int id) {

        String sql = "DELETE FROM movies WHERE id = ?";

        try (
                Connection connection =
                        PostgresDatabaseConnection.getInstance().getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println(
                        "Movie deleted successfully: " + id
                );
                return true;
            }

            return false;

        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(
                    "Error while deleting movie", e
            );
        }
    }
}
