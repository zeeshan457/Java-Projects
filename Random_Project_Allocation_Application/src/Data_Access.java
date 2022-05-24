
import java.awt.Frame;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author zeeshan
 */
public class Data_Access {

    //HashMaps attributes
    private HashMap<String, String> logindata = new HashMap<>();
    private HashMap<String, String> login = new HashMap();

    //constructor method for HashMap
    public Data_Access() {
        logindata.put("admin", "admin");
    }

    //getter method for HashMap
    protected HashMap<String, String> getLogindata() {
        return logindata;
    }

    //login method - checking if data matches HashMap - variables are passed
    public void checklogin(JTextField username, JPasswordField password, HashMap<String, String> loginargument, Frame f) {

        login = loginargument;

        //assigning strings to input fields
        String user = username.getText();
        String pass = String.valueOf(password.getPassword());

        //validation for empty input fields
        if (user.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "provide a user name", "ERROR", JOptionPane.ERROR_MESSAGE);

        } else if (pass.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "provide a password", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        //check user and pass is equal in HashMap
        if (login.containsKey(user)) {
            if (login.get(user).equals(pass)) {

                JOptionPane.showMessageDialog(null, "Login Successfull");
                f.dispose();
                Functions_GUI function = new Functions_GUI();

            } else {
                JOptionPane.showMessageDialog(null,
                        "The user name or password is incorrect", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null,
                    "The user name or password is incorrect", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    //logout method
    public void logout(Frame f) {
        JOptionPane.showMessageDialog(null, "sucessfully logged out");
        f.dispose();
        Login_GUI login = new Login_GUI();
    }

}
