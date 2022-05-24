package MySQL;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JComboBox;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zeeshan
 */
public class Manager_SQL_QueriesTest {

    // new object class
    Manager_SQL manager;
    private static Connection con = null;
    private static ResultSet rs = null;
    private static PreparedStatement pst = null;

    // components needed for testing and passing as parameter
    private JComboBox name = new JComboBox();
    private JComboBox building = new JComboBox();
    private JComboBox desk = new JComboBox();
    private JDateChooser choose_date = new JDateChooser();
    private JComboBox time = new JComboBox();
    private JComboBox duration = new JComboBox();
    Date date = new Date();

    @Before
    public void setUp() {
        manager = new Manager_SQL();
    }

    @After
    public void tearDown() {
        manager = null;
    }

    /**
     * Test of Book method, of class Manager_SQL_Queries.
     */
    @Test
    public void testBook() {

        try {
            con = DB_Connect.Connect();

            // test cases. Testing second desk.
            name.addItem("manager_test");
            building.addItem("richmond_building");
            desk.addItem("RB-001-HQ");
            choose_date.setDate(date);
            time.addItem("test");
            duration.addItem("test");

            // Get string from the components
            String s_username = name.getItemAt(0).toString();
            String s_building = building.getItemAt(0).toString();
            String s_desk = desk.getItemAt(0).toString();
            String s_date = choose_date.getDate().toString();
            String s_time = time.getItemAt(0).toString();
            String s_duration = duration.getItemAt(0).toString();

            // method call for test
            manager.Book(name, building, desk, choose_date, time, duration);

            // select all information from this building
            String query = "SELECT * FROM " + s_building;
            Statement stm = con.createStatement();
            rs = stm.executeQuery(query);

            if (rs.next()) {
                // getting string data from table
                String s_d_name = rs.getString("staff_name");
                String s_d_desk = rs.getString("desk_name");
                String s_d_date = rs.getString("date_time");
                String s_d_time = rs.getString("start_time");
                String s_d_duration = rs.getString("duration");

                // assert true if a record exists
                assertTrue(rs.next());

                // Assert these to test the booking data (expected and actual).
                assertEquals(s_username, s_d_name);
                assertEquals(s_desk, s_d_desk);
                assertEquals(s_date, s_d_date);
                assertEquals(s_time, s_d_time);
                assertEquals(s_duration, s_d_duration);
            }

        } catch (SQLException ex) {
            System.out.println("SQL test error");
        }

    }
}
