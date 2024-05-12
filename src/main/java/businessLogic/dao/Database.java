package businessLogic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is responsible for managing the database connection and initialization.
 */
public class Database {
    // JDBC URL for H2 database
    private static String jdbcURL = "jdbc:h2:~/test";
    // Username for H2 database
    private static String jdbcUsername = "sa";
    // Password for H2 database
    private static String jdbcPassword = "";

    /**
     * Establishes a connection to the database.
     *
     * @return a Connection object
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver"); // Load the H2 driver
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Initializes the database by establishing a connection.
     * If the connection fails, it attempts to create the database.
     */
    public static void initializeDatabase() {
        // Create the database only if it doesn't exist
        try (Connection connection = getConnection()) {
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            createDatabase();
        }
    }

    /**
     * Creates the database.
     */
    private static void createDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test;IFEXISTS=TRUE", jdbcUsername, jdbcPassword)) {
            System.out.println("Database created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}