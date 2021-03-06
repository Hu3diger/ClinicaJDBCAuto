package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Martin_Ruediger
 */
public final class ConnectionManager {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/clinica";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static final ConnectionManager mngr;

    static {
        mngr = new ConnectionManager();
    }

    public static ConnectionManager getInstance() {
        return mngr;
    }

    private ConnectionManager() {
    }

    public Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
