/**
 *
 */
package co.com.grupoasd.payroll.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Date: 17/06/2022
 *
 * @author jsherreram
 * @version 1.0
 */
public class Conexion {

//    private static final String JDBC_URL = "jdbc:mysql://10.0.4.104:3306/tokio_test?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_URL = "jdbc:mysql://10.0.4.104:3306/tokio_test";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "XanderCage72584";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
