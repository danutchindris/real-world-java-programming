package com.skytravelr.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

    private static final String QUERY = "select id, email, firstname, lastname, city from user";

    private static final String INSERT_QUERY = "insert into message (email, name, subject, text) values (?, ?, ?, ?)";

    private static final String DELETE_QUERY = "delete from message where subject = ?";

    // TODO
    private static final String UPDATE_QUERY = "update ";

    public static void main(String[] args) {

        try (
                Connection connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3307/wecaredb?"
                                + "user=testuser&password=testpassword&serverTimezone=Europe/Bucharest");
                // PreparedStatement - ne protejeaza de SQL Injection
                PreparedStatement statement = connection.prepareStatement(QUERY);
                ResultSet result = statement.executeQuery()
        ) {
            // TODO extrage functionalitatea de "select" si afisare intr-o metoda separata
            // afiseaza inregistrarile din tabela user
            while (result.next()) {
                Integer id = result.getInt("id");
                String email = result.getString("email");
                String firstName = result.getString("firstname");
                String lastName = result.getString("lastname");
                String city = result.getString("city");
                System.out.println(id + " " + email + " " + firstName + " " +
                        lastName + " " + city);
            }

            // insert in tabela message
            //int insertResult = insertRecord(connection, INSERT_QUERY);
            //System.out.println("Insert result: " + insertResult);

            // delete din tabela message
            int deleteResult = deleteRecord(connection, DELETE_QUERY);
            System.out.println("Delete result: " + deleteResult);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // TODO
    private static int selectRecords() {
        int result = 0;
        return result;
    }

    private static int insertRecord(final Connection connection, final String query) {
        int result = 0;
        try (
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, "maria.pop@test.com");
            statement.setString(2, "Maria");
            statement.setString(3, "This is my subject");
            statement.setString(4, "This is the actual message");
            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    private static int deleteRecord(final Connection connection, final String query) {
        int result = 0;
        try (
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, "This is my subject");
            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
