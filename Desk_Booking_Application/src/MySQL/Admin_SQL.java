package MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zeeshan
 */
public class Admin_SQL {

    private static Connection con = null;
    private static ResultSet rs = null;
    private static PreparedStatement pst = null;

    // show bookings methods
    public void ShowAllBokings(JComboBox building, JTable data) {
        // Connect to database
        con = DB_Connect.Connect();
        String s_building = building.getSelectedItem().toString();
        try {
            if (ValidateAllBookings(building)) {
                String query = "SELECT *"
                        + " FROM " + s_building
                        + " WHERE status = 'Reserved'";
                Statement stm = con.createStatement();
                rs = stm.executeQuery(query);
                while (rs.next()) {
                    String s_ID = rs.getString("ID");
                    String s_staff_name = rs.getString("staff_name");
                    String s_desk_name = rs.getString("desk_name");
                    String s_date = rs.getString("date_time");
                    String s_time = rs.getString("start_time");
                    String s_duration = rs.getString("duration");
                    String s_status = rs.getString("status");

                    String tbData[] = {s_ID, s_staff_name, s_desk_name,
                        s_date, s_time, s_duration, s_status};
                    DefaultTableModel model = (DefaultTableModel) data.getModel();
                    // Adding data to the model
                    model.addRow(tbData);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL error data was not added to component", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // validate show bookings
    public Boolean ValidateAllBookings(JComboBox c_data) {
        String s_c_data = c_data.getSelectedItem().toString();
        if (s_c_data.equals("Select Building")) {
            JOptionPane.showMessageDialog(null,
                    "select a building", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public void ShowUsers(JComboBox users, JTable data) {
        // Connect to database
        con = DB_Connect.Connect();
        String s_users = users.getSelectedItem().toString();

        try {
            if (ValidateUsersTable(users)) {
                String query = "SELECT *"
                        + " FROM users"
                        + " WHERE user_type = " + "'" + s_users + "'";
                Statement stm = con.createStatement();
                rs = stm.executeQuery(query);
                while (rs.next()) {
                    String s_ID = rs.getString("ID");
                    String s_username = rs.getString("username");
                    String s_user_type = rs.getString("user_type");
                    String s_managed_by = rs.getString("managed_by");
                    String s_password = rs.getString("password");

                    String tbData[] = {s_ID, s_username, s_user_type,
                        s_managed_by, s_password};
                    DefaultTableModel model = (DefaultTableModel) data.getModel();
                    // Adding data to the model
                    model.addRow(tbData);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL error data was not added to component", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // validate show bookings
    public Boolean ValidateUsersTable(JComboBox users) {
        String s_users = users.getSelectedItem().toString();
        if (s_users.equals("Select User Type")) {
            JOptionPane.showMessageDialog(null,
                    "select a user type", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    // Booking table methods
    public void UpdateBookingTableRow(JTable data, JTextField id, JTextField name,
            JTextField desk, JTextField date, JTextField start_time, JTextField duration,
            JTextField status) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();

        if (data.getSelectedRowCount() == 1) {
            // get text field data
            String s_id = id.getText();
            String s_name = name.getText();
            String s_desk = desk.getText();
            String s_date = date.getText();
            String s_start_time = start_time.getText();
            String s_duration = duration.getText();
            String s_status = status.getText();

            // set table row text field data
            model.setValueAt(s_id, data.getSelectedRow(), 0);
            model.setValueAt(s_name, data.getSelectedRow(), 1);
            model.setValueAt(s_desk, data.getSelectedRow(), 2);
            model.setValueAt(s_date, data.getSelectedRow(), 3);
            model.setValueAt(s_start_time, data.getSelectedRow(), 4);
            model.setValueAt(s_duration, data.getSelectedRow(), 5);
            model.setValueAt(s_status, data.getSelectedRow(), 6);

            JOptionPane.showMessageDialog(null, "Row " + data.getSelectedRow()
                    + " was updated " + "you can now update the database record.");

        } else {

            if (data.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null,
                        "table is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "select a single row", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void getBookingTableRow(JTable data, JTextField id_update, JTextField id, JTextField name,
            JTextField desk, JTextField date, JTextField start_time, JTextField duration,
            JTextField status) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();

        if (data != null) {
            // get row data
            String t_ID = model.getValueAt(data.getSelectedRow(), 0).toString();
            String t_name = model.getValueAt(data.getSelectedRow(), 1).toString();
            String t_desk = model.getValueAt(data.getSelectedRow(), 2).toString();
            String t_date = model.getValueAt(data.getSelectedRow(), 3).toString();
            String t_start_time = model.getValueAt(data.getSelectedRow(), 4).toString();
            String t_duration = model.getValueAt(data.getSelectedRow(), 5).toString();
            String t_status = model.getValueAt(data.getSelectedRow(), 6).toString();

            // set values to text fields
            id.setText(t_ID);
            id_update.setText(t_ID);
            name.setText(t_name);
            desk.setText(t_desk);
            date.setText(t_date);
            start_time.setText(t_start_time);
            duration.setText(t_duration);
            status.setText(t_status);
        }
    }

    // user table methods
    public void UpdateUserTableRow(JTable data, JTextField id,
            JTextField name, JTextField user_type, JTextField managed_by, JTextField password) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();

        if (data.getSelectedRowCount() == 1) {
            // get text field data
            String s_id = id.getText();
            String s_name = name.getText();
            String s_user_type = user_type.getText();
            String s_managed_by = managed_by.getText();
            String s_password = password.getText();

            // set table row text field data
            model.setValueAt(s_id, data.getSelectedRow(), 0);
            model.setValueAt(s_name, data.getSelectedRow(), 1);
            model.setValueAt(s_user_type, data.getSelectedRow(), 2);
            model.setValueAt(s_managed_by, data.getSelectedRow(), 3);
            model.setValueAt(s_password, data.getSelectedRow(), 4);

            JOptionPane.showMessageDialog(null, "Row " + data.getSelectedRow()
                    + " was updated you can now update the database record.");
        } else {
            if (data.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null,
                        "table is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "select a single row", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void getUserTableRow(JTable data, JTextField id_update, JTextField id,
            JTextField name, JTextField user_type, JTextField managed_by, JTextField password) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();
        if (data != null) {
            // get row data
            String t_id = model.getValueAt(data.getSelectedRow(), 0).toString();
            String t_name = model.getValueAt(data.getSelectedRow(), 1).toString();
            String t_user_type = model.getValueAt(data.getSelectedRow(), 2).toString();
            String t_managed_by = model.getValueAt(data.getSelectedRow(), 3).toString();
            String t_dpassword = model.getValueAt(data.getSelectedRow(), 4).toString();

            // set values to text fields
            id_update.setText(t_id);
            id.setText(t_id);
            name.setText(t_name);
            user_type.setText(t_user_type);
            managed_by.setText(t_managed_by);
            password.setText(t_dpassword);
        }
    }

    public void UpdateRowDB(JTable data, JComboBox building) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();
        String s_building = building.getSelectedItem().toString();

        if (data.getSelectedRowCount() == 1) {
            String t_ID = model.getValueAt(data.getSelectedRow(), 0).toString();
            String t_name = model.getValueAt(data.getSelectedRow(), 1).toString();
            String t_desk = model.getValueAt(data.getSelectedRow(), 2).toString();
            String t_date = model.getValueAt(data.getSelectedRow(), 3).toString();
            String t_start_time = model.getValueAt(data.getSelectedRow(), 4).toString();
            String t_duration = model.getValueAt(data.getSelectedRow(), 5).toString();
            String t_status = model.getValueAt(data.getSelectedRow(), 6).toString();

            try {
                if (ValidateUpdateBookingsDB(data, building)) {
                    String query = "UPDATE " + s_building
                            + " SET ID = ?,"
                            + " staff_name = ?,"
                            + " desk_name = ?,"
                            + " date_time = ?,"
                            + " start_time = ?,"
                            + " duration = ?,"
                            + " status = ? "
                            + " WHERE ID = " + "'" + t_ID + "'";

                    PreparedStatement statement = con.prepareStatement(query);
                    statement.setString(1, t_ID);
                    statement.setString(2, t_name);
                    statement.setString(3, t_desk);
                    statement.setString(4, t_date);
                    statement.setString(5, t_start_time);
                    statement.setString(6, t_duration);
                    statement.setString(7, t_status);

                    int count = statement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Updated row "
                            + data.getSelectedRow() + " from " + s_building
                            + " table.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "MySQL update bookings table error", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            if (data.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null,
                        "table is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "select a single row", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean ValidateUpdateBookingsDB(JTable data, JComboBox building) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();
        String s_building = building.getSelectedItem().toString();

        if (s_building.equals("Select Building")) {
            JOptionPane.showMessageDialog(null,
                    "select a building", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;

        }

        return true;
    }

    public void UpdateRowUsersDB(JTable data, JComboBox users) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();
        String s_user = users.getSelectedItem().toString();

        if (data.getSelectedRowCount() == 1) {
            String t_ID = model.getValueAt(data.getSelectedRow(), 0).toString();
            String t_name = model.getValueAt(data.getSelectedRow(), 1).toString();
            String t_usertype = model.getValueAt(data.getSelectedRow(), 2).toString();
            String t_managedby = model.getValueAt(data.getSelectedRow(), 3).toString();
            String t_password = model.getValueAt(data.getSelectedRow(), 4).toString();

            try {
                if (ValidateUpdateUsersDB(data, users)) {
                    String query = "UPDATE users"
                            + " SET ID = ?,"
                            + " username = ?,"
                            + " user_type = ?,"
                            + " managed_by = ?,"
                            + " password = ?"
                            + " WHERE ID = " + "'" + t_ID + "'"
                            + " AND user_type = " + "'" + s_user + "'";

                    PreparedStatement statement = con.prepareStatement(query);
                    statement.setString(1, t_ID);
                    statement.setString(2, t_name);
                    statement.setString(3, t_usertype);
                    statement.setString(4, t_managedby);
                    statement.setString(5, t_password);

                    int count = statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Updated row "
                            + data.getSelectedRow() + " for " + s_user
                            + " user");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "MySQL update user table error", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            if (data.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null,
                        "table is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "select a single row", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean ValidateUpdateUsersDB(JTable data, JComboBox users) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();
        String s_users = users.getSelectedItem().toString();

        if (s_users.equals("Select User Type")) {
            JOptionPane.showMessageDialog(null,
                    "select a user", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // cancel booking
    public void CancelBookingToFields(JTable data, JTextField id, JTextField name,
            JTextField desk, JTextField date, JTextField start_time, JTextField duration,
            JTextField status) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();

        if (data.getSelectedRowCount() == 1) {
            // re-setting fields
            name.setText("");
            date.setText("");
            start_time.setText("");
            duration.setText("");
            status.setText("Not reserved");

            // get text field data
            String s_id = id.getText();
            String s_name = name.getText();
            String s_desk = desk.getText();
            String s_date = date.getText();
            String s_start_time = start_time.getText();
            String s_duration = duration.getText();
            String s_status = status.getText();

            // set table row text field data
            model.setValueAt(s_id, data.getSelectedRow(), 0);
            model.setValueAt(s_name, data.getSelectedRow(), 1);
            model.setValueAt(s_desk, data.getSelectedRow(), 2);
            model.setValueAt(s_date, data.getSelectedRow(), 3);
            model.setValueAt(s_start_time, data.getSelectedRow(), 4);
            model.setValueAt(s_duration, data.getSelectedRow(), 5);
            model.setValueAt(s_status, data.getSelectedRow(), 6);

            JOptionPane.showMessageDialog(null, "Row " + data.getSelectedRow()
                    + " was cancelled you can now update the database record.");
        } else {
            if (data.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null,
                        "table is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "select a single row", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void ClearUserToFields(JTable data, JTextField id,
            JTextField name, JTextField user_type, JTextField managed_by, JTextField password) {
        DefaultTableModel model = (DefaultTableModel) data.getModel();

        if (data.getSelectedRowCount() == 1) {

            // set text
            name.setText("");
            managed_by.setText("");
            password.setText("");

            // get text field data
            String s_id = id.getText();
            String s_name = name.getText();
            String s_user_type = user_type.getText();
            String s_managed_by = managed_by.getText();
            String s_password = password.getText();

            // set table row text field data
            model.setValueAt(s_id, data.getSelectedRow(), 0);
            model.setValueAt(s_name, data.getSelectedRow(), 1);
            model.setValueAt(s_user_type, data.getSelectedRow(), 2);
            model.setValueAt(s_managed_by, data.getSelectedRow(), 3);
            model.setValueAt(s_password, data.getSelectedRow(), 4);

            JOptionPane.showMessageDialog(null, "Row " + data.getSelectedRow()
                    + " was cleared you can now update the database record.");
        } else {
            if (data.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null,
                        "table is empty", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "select a single row", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
