package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private BasicDataSource dataSource;

    public DataManager(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Actor> getActorByLastName(String lastName) {
        List<Actor> actors = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT actor_id, first_name, last_name FROM actor WHERE last_name = ?")) {
            statement.setString(1, lastName);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    int actor_id = results.getInt("actor_id");
                    String firstName = results.getString("first_name");
                    String last_name = results.getString("last_name");
                    Actor a = new Actor(actor_id, firstName, last_name);
                    actors.add(a);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return actors;
    }

    public List<Film> getMoviesByActor(String firstName, String lastName) {
        List<Film> movies = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("""
                     SELECT f.* FROM film AS f
                     INNER JOIN film_actor AS fa
                     ON f.film_id = fa.film_id
                     INNER JOIN actor AS a
                     ON fa.actor_id = a.actor_id
                     WHERE a.first_name = ? AND a.last_name = ?""")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    int filmId = results.getInt("film_id");
                    String title = results.getString("title");
                    String description = results.getString("description");
                    int releaseYear = results.getInt("release_year");
                    int length = results.getInt("length");
                    Film f = new Film(filmId, title, description, releaseYear, length);
                    movies.add(f);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return movies;
    }
}
