package MySQL;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * @author zeeshan
 */
public class Staff_SQL {

    private static Connection con = null;
    private static ResultSet rs = null;
    private static PreparedStatement pst = null;
    Data_Processing_SQL process = new Data_Processing_SQL();

    // Adds desk data from database to JComboBox
    public void Add_data_Desks(JComboBox desk, JComboBox building) {
        // Connect to database
        con = DB_Connect.Connect();
        String s_buildings = building.getSelectedItem().toString();

        try {
            if (validate_desk(building)) {
                String query = "SELECT desk_name FROM " + s_buildings
                        + " WHERE status = 'Not reserved'";
                Statement stm = con.createStatement();
                rs = stm.executeQuery(query);
                desk.removeAllItems();

                while ((rs != null) && (rs.next())) {
                    desk.addItem(rs.getString("desk_name"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL error data was not added to component", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Add_data_desks_booked(JTextField name, JComboBox desk, JComboBox building) {
        // Connect to database
        con = DB_Connect.Connect();

        try {
            String s_name = name.getText();
            String s_buildings = building.getSelectedItem().toString();

            if (validate_desk(building)) {
                String query = "SELECT desk_name FROM " + s_buildings
                        + " WHERE status = 'Reserved' AND staff_name = " + "'" + s_name + "'";
                Statement stm = con.createStatement();
                rs = stm.executeQuery(query);
                desk.removeAllItems();

                while ((rs != null) && (rs.next())) {
                    desk.addItem(rs.getString("desk_name"));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL error data was not added to component", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean validate_desk(JComboBox building) {
        String s_buildings = building.getSelectedItem().toString();

        if (s_buildings.equals("Select Building")) {
            JOptionPane.showMessageDialog(null,
                    "select a building name", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;

        }
    }

    // Adds all desk data from database to JTable
    public void Show_desks(JComboBox features, JComboBox buidling, JTable data) {
        // Connect to database
        con = DB_Connect.Connect();
        String s_building = buidling.getSelectedItem().toString();
        String s_features = features.getSelectedItem().toString();

        try {
            if (validate_Show_Desks(features, buidling)) {
                String query = "SELECT desk_name, features, status FROM " + s_building
                        + " WHERE status = 'Not reserved' AND "
                        + "features = " + "'" + s_features + "'";
                Statement stm = con.createStatement();
                rs = stm.executeQuery(query);

                while (rs.next()) {
                    String s_desk_name = rs.getString("desk_name");
                    String s_features1 = rs.getString("features");
                    String s_status = rs.getString("status");
                    String tbData[] = {s_desk_name, s_features, s_status};
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

    public boolean validate_Show_Desks(JComboBox features, JComboBox building) {
        String s_building = building.getSelectedItem().toString();
        String s_features = features.getSelectedItem().toString();

        if (s_features.equals("Select Features")) {
            JOptionPane.showMessageDialog(null,
                    "select a desk feature", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;

        } else if (s_building.equals("Select Building")) {
            JOptionPane.showMessageDialog(null,
                    "select a building", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    // Booking methods
    public void Book(JTextField username, JComboBox building, JComboBox desk,
            JDateChooser date, JComboBox time, JComboBox duration) {
        // Connect to database
        String s_username = username.getText();
        String s_building = building.getSelectedItem().toString();
        String s_time = time.getSelectedItem().toString();
        String s_duration = duration.getSelectedItem().toString();

        try {
            con = DB_Connect.Connect();
            // catch null for desks and date values
            String s_desk = desk.getSelectedItem().toString();
            String s_date = date.getDate().toString();

            if (ValidateBook(username, building, desk, date, time, duration)) {
                String query = "UPDATE " + s_building
                        + " SET staff_name = ?,"
                        + " date_time = ?,"
                        + " start_time = ?,"
                        + " duration = ?,"
                        + " status = 'Reserved'"
                        + " WHERE desk_name = " + "'" + s_desk + "'";

                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, s_username);
                statement.setString(2, s_date);
                statement.setString(3, s_time);
                statement.setString(4, s_duration);
                int count = statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Booking successful!"
                        + System.lineSeparator() + System.lineSeparator()
                        + "User: " + s_username + System.lineSeparator()
                        + "Building: " + s_building + System.lineSeparator()
                        + "Desk: " + s_desk + System.lineSeparator()
                        + "Date: " + s_date);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL booking error", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null,
                    "date is null", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Boolean ValidateBook(JTextField username, JComboBox building, JComboBox desk,
            JDateChooser date, JComboBox time, JComboBox duration) {

        try {
            String s_username = username.getText();
            String s_building = building.getSelectedItem().toString();
            String s_desk = desk.getSelectedItem().toString();
            String s_date = date.getName().toString();
            String s_time = time.getSelectedItem().toString();
            String s_duration = duration.getSelectedItem().toString();

            // get the day from the date object, convert it to LDT, then query it.
            LocalDateTime ldt = date.getDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            // get current day, validating this based on what date is choosed.
            DayOfWeek day = ldt.getDayOfWeek();

            // comparing 2 dates (current and user input) then finding difference.
            Date current_date = new Date();
            Date user_input_date = date.getDate();

            // get month of both dates and comparing
            int current_month = current_date.getMonth();
            int user_input_month = user_input_date.getMonth();
            int month_difference = user_input_month - current_month;

            // adding 1 month to current date (Apache commons library needed)
            Date one_month_advance_date = DateUtils.addMonths(current_date, 1);

            // difference in time then converting into days
            Long DiffMilliSeconds = Math.abs(user_input_date.getTime() - current_date.getTime());
            Long DayDifference = TimeUnit.DAYS.convert(DiffMilliSeconds, TimeUnit.MILLISECONDS);

            if (s_building.equals("Select Building")) {
                JOptionPane.showMessageDialog(null,
                        "select a building", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;

            } else if (s_desk.equals("Select Desk Name")) {
                JOptionPane.showMessageDialog(null,
                        "select desk name", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;

            } else if (s_date.equals(" ")) {
                JOptionPane.showMessageDialog(null,
                        "select a date", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;

            } else if (day.name().toLowerCase().equals("saturday")
                    || day.name().toLowerCase().equals("sunday")) {
                JOptionPane.showMessageDialog(null,
                        "desks must be booked on Mon-Fri", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;

            } else if (user_input_date.after(one_month_advance_date)) {
                JOptionPane.showMessageDialog(null,
                        "desks can only be booked one month in advance."
                        + " Days difference: " + String.valueOf(DayDifference)
                        + " | Month difference: " + month_difference, "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;

            } else if (s_time.equals("Select Start Time")) {
                JOptionPane.showMessageDialog(null,
                        "select a start time", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;

            } else if (s_duration.equals("Select Duration")) {
                JOptionPane.showMessageDialog(null,
                        "select a duration", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;

            } else if (s_building.equals("richmond_building")
                    || s_building.equals("norcroft_centre") || s_building.equals("horton_building")) {

                String query_status = "SELECT staff_name, desk_name, status FROM " + s_building;
                Statement stm = con.createStatement();
                rs = stm.executeQuery(query_status);

                // checking desk bookings
                while (rs.next()) {
                    String d_status = rs.getString("status");
                    String d_desk = rs.getString("desk_name");
                    String d_username = rs.getString("staff_name");

                    if (d_status.equals("Reserved")
                            && s_username.equals(d_username) && s_desk.equals(d_desk)) {
                        JOptionPane.showMessageDialog(null,
                                "Desk has been booked", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                }

            } else {
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL validation error", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return true;

    }

    // Cancel booking method
    public void Cancel(JTextField username, JComboBox building, JComboBox desk) {
        // Connect to database

        try {
            String s_building = building.getSelectedItem().toString();
            String s_desk = desk.getSelectedItem().toString();

            con = DB_Connect.Connect();
            if (ValidateCancel(username, building, desk)) {
                String query = "UPDATE " + s_building
                        + " SET staff_name = ?,"
                        + " date_time = ?,"
                        + " start_time = ?,"
                        + " duration = ?,"
                        + " status = ?"
                        + " WHERE desk_name = " + "'" + s_desk + "'";

                PreparedStatement statement = con.prepareStatement(query);
                statement.setString(1, "");
                statement.setString(2, "");
                statement.setString(3, "");
                statement.setString(4, "");
                statement.setString(4, "");
                statement.setString(5, "Not reserved");
                int count = statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Booking cancelled");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "MySQL cancel error", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null,
                    "desks are null", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    // validate cancel booking
    public Boolean ValidateCancel(JTextField username, JComboBox building, JComboBox desk) {
        String s_username = username.getText();
        String s_building = building.getSelectedItem().toString();
        String s_desk = desk.getSelectedItem().toString();

        if (s_building.equals("Select Building")) {
            JOptionPane.showMessageDialog(null,
                    "select a building", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;

        } else if (s_desk.equals("Select Desk Name")) {
            JOptionPane.showMessageDialog(null,
                    "select desk name", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;

        } else if (s_desk.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "select a desk name", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // show bookings methods
    public void ShowBookings(JComboBox building, JTable data, JTextField username) {
        // Connect to database
        con = DB_Connect.Connect();
        String s_building = building.getSelectedItem().toString();
        String s_username = username.getText();

        try {
            if (ValidateShowBookings(building)) {
                String query = "SELECT staff_name, desk_name, features, date_time, start_time, duration, "
                        + "status FROM " + s_building
                        + " WHERE status = 'Reserved' AND staff_name = " + "'" + s_username + "'";
                Statement stm = con.createStatement();
                rs = stm.executeQuery(query);

                while (rs.next()) {
                    String s_staff_name = rs.getString("staff_name");
                    String s_desk_name = rs.getString("desk_name");
                    String s_features = rs.getString("features");
                    String s_date = rs.getString("date_time");
                    String s_time = rs.getString("start_time");
                    String s_duration = rs.getString("duration");
                    String s_status = rs.getString("status");

                    String tbData[] = {s_staff_name, s_desk_name, s_features,
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
    public Boolean ValidateShowBookings(JComboBox building) {

        String s_building = building.getSelectedItem().toString();

        if (s_building.equals("Select Building")) {
            JOptionPane.showMessageDialog(null,
                    "select a building", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
}
