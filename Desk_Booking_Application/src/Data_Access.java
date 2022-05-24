
import MySQL.DB_Connect;
import java.awt.Component;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author zeeshan
 */
public class Data_Access {

    public String name = null;
    public Component child;

    // instance of processing class
    Data_Processing process = new Data_Processing();

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    // Register method 
    public void register(JTextField username,
            JComboBox data, JPasswordField password, JPasswordField r_password) {
        
       
        // Connect to database
        con = DB_Connect.Connect();
        String s_username = username.getText();
        String s_data = data.getSelectedItem().toString();
        String s_passsword = String.valueOf(password.getPassword());
        String s_r_password = String.valueOf(r_password.getPassword());
        String empty = " ";

        try {
            String query_user = "SELECT username FROM users";
            Statement stm = con.createStatement();
            rs = stm.executeQuery(query_user);

            //stm.close();
            if (Register_Validation(username, data, password, r_password, s_username)) {

                String query = "INSERT INTO users (username, user_type,  managed_by, password) values ('"
                        + s_username + "', '" + s_data + "', '" + empty + "','" + s_passsword + "')";
                pst = con.prepareStatement(query);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Registration Successful");
                process.clearRegistration(username, password, r_password);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL error query", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Validate the registration
    public boolean Register_Validation(JTextField username,
            JComboBox data, JPasswordField password, JPasswordField r_password,
            String user_input) {

        try {
            String s_username = username.getText();
            String s_data = data.getSelectedItem().toString();
            String s_passsword = String.valueOf(password.getPassword());
            String s_r_password = String.valueOf(r_password.getPassword());

            while (rs.next()) {
                String username_db = rs.getString("username");
                if (user_input.equals(username_db)) {
                    JOptionPane.showMessageDialog(null,
                            "Username is taken", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            if (s_username.length() == 0 || s_data.equals("Select User Type")
                    || s_passsword.length() == 0 || s_r_password.length() == 0) {
                JOptionPane.showMessageDialog(null,
                        "one or more fields are empty", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (!s_passsword.equals(s_r_password)) {
                JOptionPane.showMessageDialog(null,
                        "The password must match", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (!s_username.startsWith("staff") && !s_username.startsWith("admin")
                    && !s_username.startsWith("manager")) {
                JOptionPane.showMessageDialog(null,
                        "The username must begin with one of the following words: "
                        + "'staff, \"manager, ' or 'admin.'", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL validation error query", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    // Login method
    public boolean Login(JTextField username, JComboBox data, JPasswordField password) {
        con = DB_Connect.Connect();
        name = username.getText();
        String s_user_type = data.getSelectedItem().toString();
        String s_passsword = String.valueOf(password.getPassword());

        try {
            if (Login_Validation(username, data, password)) {
                String query = "SELECT * FROM users WHERE username=? AND user_type =? AND password =?";
                pst = con.prepareCall(query);
                pst.setString(1, name);
                pst.setString(2, s_user_type);
                pst.setString(3, s_passsword);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String Get_user = rs.getString("user_type");
                    if (Get_user.equals("Staff") && s_user_type.equals("Staff")) {
                        JOptionPane.showMessageDialog(null, "Staff: Login Successful");
                        GUI_Staff staff = new GUI_Staff(child, name);
                        staff.setVisible(true);
                        staff.setLocation(new Point(75, 50));
                        staff.setResizable(false);
                        return true;
                    } else if (Get_user.equals("Manager") && s_user_type.equals("Manager")) {
                        JOptionPane.showMessageDialog(null, "Manager: Login Successful");
                        GUI_Manager manager = new GUI_Manager(child, name);
                        manager.setVisible(true);
                        manager.setLocation(new Point(75, 50));
                        manager.setResizable(false);
                        return true;
                    } else if (Get_user.equals("Administrator") && s_user_type.equals("Administrator")) {
                        JOptionPane.showMessageDialog(null, "Admin: Login Successful");
                        GUI_Admin admin = new GUI_Admin(child, name);
                        admin.setVisible(true);
                        admin.setLocation(new Point(75, 25));
                        admin.setResizable(false);
                        return true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "The username or password was incorrect", "LOGIN ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL error", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }

    // Validate the login
    public boolean Login_Validation(JTextField username,
            JComboBox data, JPasswordField password) {
        String s_username = username.getText();
        String s_data = data.getSelectedItem().toString();
        String s_passsword = String.valueOf(password.getPassword());

        if (s_username.length() == 0 || s_data.equals("Select User Type")
                || s_passsword.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "one or more fields are empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!s_username.startsWith("staff") && !s_username.startsWith("admin")
                && !s_username.startsWith("manager")) {
            JOptionPane.showMessageDialog(null,
                    "The username must begin with one of the following words: "
                    + "'staff, \"manager, ' or 'admin.'", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
}
