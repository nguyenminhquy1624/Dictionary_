/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dictionary.connection;

//import com.sun.jdi.connect.spi.Connection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MINH QUY
 */
public class JDBCConnection {
    public static Connection getJDBCConnection {
        final String url = "jdbc:mysql://localhost:3306/Dictionary";
        final String user = "root";
        final String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
