
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zeeshan
 */
public class Data_Processing {

    // Clear registration fields
    public void clearRegistration(JTextField username,
            JPasswordField password, JPasswordField r_password) {
        username.setText("");
        password.setText("");
        r_password.setText("");
    }

    // Clear login fields
    public void clearLogin(JTextField username, JComboBox data,
            JPasswordField password) {
        data.getItemAt(0);
        username.setText("");
        password.setText("");

    }

    // Clear table fields
    public void clearTable(JTable data) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();
        model.setRowCount(0);
    }

    // Clear combo box 
    public void clearCombobox(JComboBox data) {
        data.removeAllItems();
    }



}
