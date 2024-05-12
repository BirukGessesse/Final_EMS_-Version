package businessLogic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String jdbcURL = "jdbc:h2:~/test";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "";
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
    public static void initializeDatabase() {
	// Create the database only if it doesn't exist
	try (Connection connection = getConnection()) {
	    System.out.println("Database connected successfully!");
	} catch (SQLException e) {
	    createDatabase();
	}
    }
    private static void createDatabase() {
	try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test;IFEXISTS=TRUE", jdbcUsername, jdbcPassword)) {
	    System.out.println("Database created successfully!");
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
