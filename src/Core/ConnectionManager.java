package Core;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

    private static final String DATABASE = "company";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";

    public static java.sql.Connection getConnection() {
        java.sql.Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

//            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(java.sql.Connection conn, Statement stmt) {

        try {
            if (conn != null) {
                conn.close();
            }
            if(stmt != null) {
                stmt.close();
            }

        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}