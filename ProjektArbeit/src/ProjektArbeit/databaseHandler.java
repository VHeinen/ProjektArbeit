package ProjektArbeit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseHandler {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Projektarbeit";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "test";

    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
