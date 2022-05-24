
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Aneef
 */
public class Data_Access {

    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "";

    public static void connectDB() throws SQLException {
        /* 
        TO-DO
        driver needed for db
         */

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                java.sql.Statement EXECUTE = conn.createStatement();) {

        }
    }

    public void Insert(JTextField name, JTextField address, JTextField number,
            JTextField time, JTextField help) throws SQLException {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                java.sql.Statement EXECUTE = conn.createStatement();) {

            if (name.getText() == "" || address.getText() == ""
                    || number.getText() == "" || time.getText() == ""
                    || help.getText() == "") {

                JOptionPane.showMessageDialog(null,
                        "The input field cant be empty", "ERROR", JOptionPane.ERROR_MESSAGE);

            }

            String Data = "INSERT INTO student_table VALUES (name, address, "
                    + "number, time, help)";

            EXECUTE.executeUpdate(Data);

        }

    }

    public void Delete() {

    }

    public void Edit() {

    }

}
