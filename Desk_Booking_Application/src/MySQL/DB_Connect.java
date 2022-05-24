package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author zeeshan
 */
public class DB_Connect {

    private static String URL = "jdbc:mysql://127.0.0.1:3306/desk_booking_db";
    private static String Driver_name = "com.mysql.cj.jdbc.Driver";
    private static String Username = "root";
    private static String Password = "";
    private static Connection con = null;

    public static Connection Connect() {

        try {
            Class.forName(Driver_name);
            con = DriverManager.getConnection(URL, Username, Password);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Driver not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL error", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}
