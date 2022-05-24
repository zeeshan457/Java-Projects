package MySQL;

import javax.swing.JComboBox;

/**
 *
 * @author zeeshan
 */
public class Data_Processing_SQL {

    // clear book staff
    public void clearBookformStaff(JComboBox building, JComboBox desk,
            JComboBox time, JComboBox duration) {
        building.setSelectedIndex(0);
        desk.removeAllItems();
        time.setSelectedIndex(0);
        duration.setSelectedIndex(0);
    }

    // clear cancel for staff
    public void clearCancelformStaff(JComboBox building, JComboBox desk) {
        building.setSelectedIndex(0);
        desk.setSelectedIndex(0);
    }

    // clear book for manager
    public void clearBookformManager(JComboBox staff, JComboBox building,
            JComboBox desk, JComboBox time, JComboBox duration) {

        staff.setSelectedIndex(0);
        building.setSelectedIndex(0);
        desk.removeAllItems();
        time.setSelectedIndex(0);
        duration.setSelectedIndex(0);
    }

    // clear cancel for manager
    public void clearCancelformManager(JComboBox staff, JComboBox building, JComboBox desk) {
        building.setSelectedIndex(0);
        desk.setSelectedIndex(0);
        staff.setSelectedIndex(0);
    }

}
