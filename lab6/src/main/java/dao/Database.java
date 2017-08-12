package dao;

/**
 * Created by Dezval on 7/29/2017.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static final String database = "cs3220_test"; //cs3220xstu21
    public static final String url = "jdbc:mysql://localhost/" + database; // stays the same
    public static final String username = "root";//cs3220xstu21
    public static final String password = "11235813";// PASSWORD IN EMAIL

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch( ClassNotFoundException e ) {
            throw new IllegalStateException(e);
        }
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
