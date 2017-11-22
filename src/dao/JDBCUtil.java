package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCUtil {

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void close(ResultSet rs, PreparedStatement stmt){
        close(rs);
        close(stmt);
    }
    
        public static void close(PreparedStatement stmt, Connection conn){
        close(stmt);
        close(conn);
    }
    
    public static void close(ResultSet rs, PreparedStatement stmt,Connection conn){
        close(conn);
        close(stmt);
        close(rs);
    }
    

}
