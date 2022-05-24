
import java.awt.Point;
import MySQL.Staff_SQL;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author zeeshan
 */
public class GUI_Staff extends javax.swing.JFrame {

    // instance of class
    Data_Access access = new Data_Access();
    Data_Processing process = new Data_Processing();
    Staff_SQL s_access = new Staff_SQL();

    // attributes
    public static String username;
    public static Component parent;
    String current_time = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

    // getting username
    public String getUsername(String str) {
        str = username;
        return str;
    }

    // passing parent and username as argument to pass username and child from DataAccess.
    public GUI_Staff(Component parent, String username) {
        initComponents();
        this.parent = parent;
        this.username = username;

        // adding date to fields
        name_field.setText(getUsername(username));
        name_field1.setText(getUsername(username));
        User_label.setText("User: " + getUsername(username));
        current_date_label.setText("Date: " + current_time);

        // Date validation
        Date date = new Date();
        date_chooser.setDate(date);
        date_chooser.getJCalendar().setMinSelectableDate(date);
        date_chooser.setMinSelectableDate(date);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Register_Button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        book_button = new javax.swing.JButton();
        desk_name_label = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        building_label = new javax.swing.JLabel();
        building_options_1 = new javax.swing.JComboBox<>();
        desk_name_options = new javax.swing.JComboBox<>();
        name_label = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        time_label = new javax.swing.JLabel();
        date_chooser = new com.toedter.calendar.JDateChooser();
        duration_label = new javax.swing.JLabel();
        time_options = new javax.swing.JComboBox<>();
        duration_options = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        Cancel_button = new javax.swing.JButton();
        name_label2 = new javax.swing.JLabel();
        building_label_2 = new javax.swing.JLabel();
        desk_name_label_2 = new javax.swing.JLabel();
        name_field1 = new javax.swing.JTextField();
        desk_name_options1 = new javax.swing.JComboBox<>();
        building_options_2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logout_button = new javax.swing.JButton();
        User_label = new javax.swing.JLabel();
        current_date_label = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desk_table = new javax.swing.JTable();
        show_desks_button = new javax.swing.JButton();
        my_booking_button2 = new javax.swing.JButton();
        building_options_3 = new javax.swing.JComboBox<>();
        features_options = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        my_bookings_table = new javax.swing.JTable();
        bookings_button = new javax.swing.JButton();
        my_booking_button3 = new javax.swing.JButton();
        building_options_4 = new javax.swing.JComboBox<>();

        Register_Button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        Register_Button.setText("Register");
        Register_Button.setToolTipText("");
        Register_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Register_Button.setFocusable(false);
        Register_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_ButtonActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Staff Page");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        book_button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        book_button.setText("Book");
        book_button.setToolTipText("");
        book_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        book_button.setFocusable(false);
        book_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_buttonActionPerformed(evt);
            }
        });

        desk_name_label.setText("Desk name");

        date_label.setText("Date");

        building_label.setText("Building");

        building_options_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building", "richmond_building", "horton_building", "norcroft_centre" }));
        building_options_1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                building_options_1ItemStateChanged(evt);
            }
        });

        desk_name_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Desk Name" }));

        name_label.setText("Name");

        name_field.setEditable(false);
        name_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                name_fieldMouseClicked(evt);
            }
        });
        name_field.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                name_fieldPropertyChange(evt);
            }
        });

        jLabel6.setText("Booking form");

        time_label.setText("Time");

        date_chooser.setDateFormatString("dd-MM-yyyy");

        duration_label.setText("Duration");

        time_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Start Time", "7:00 AM", "7:30 AM", "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM" }));

        duration_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Duration", "30:00 Minutes", "1:00 hour", "2:00 hour" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(building_label)
                            .addComponent(name_label))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(building_options_1, 0, 178, Short.MAX_VALUE)
                            .addComponent(name_field, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(time_label)
                            .addComponent(date_label)
                            .addComponent(desk_name_label)
                            .addComponent(duration_label))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(desk_name_options, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(book_button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(time_options, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(duration_options, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_label))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(building_options_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(building_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desk_name_label)
                    .addComponent(desk_name_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(date_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(time_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(time_label)))
                    .addComponent(date_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duration_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duration_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(book_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Cancel_button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        Cancel_button.setText("Cancel");
        Cancel_button.setToolTipText("");
        Cancel_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Cancel_button.setFocusable(false);
        Cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel_buttonActionPerformed(evt);
            }
        });

        name_label2.setText("Name");

        building_label_2.setText("Building");

        desk_name_label_2.setText("Desk name");

        name_field1.setEditable(false);

        desk_name_options1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Desk Name" }));

        building_options_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building", "richmond_building", "horton_building", "norcroft_centre" }));
        building_options_2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                building_options_2ItemStateChanged(evt);
            }
        });

        jLabel10.setText("Cancel form");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel10)
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(desk_name_label_2)
                                .addGap(19, 19, 19)
                                .addComponent(desk_name_options1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(building_label_2)
                                    .addComponent(name_label2))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(building_options_2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(name_field1))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(building_options_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(building_label_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desk_name_options1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desk_name_label_2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Staff booking");

        logout_button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        logout_button.setText("Logout");
        logout_button.setToolTipText("");
        logout_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        logout_button.setFocusable(false);
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        User_label.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        User_label.setText("user: ? ");

        current_date_label.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        current_date_label.setText("Date: ? ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(User_label)
                    .addComponent(current_date_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(441, 441, 441)
                .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logout_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(current_date_label)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(User_label)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        desk_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desk_table.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        desk_table.setForeground(new java.awt.Color(0, 0, 0));
        desk_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Desk name", "Features", "Status"
            }
        ));
        desk_table.setEnabled(false);
        jScrollPane1.setViewportView(desk_table);

        show_desks_button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        show_desks_button.setText("Show desks");
        show_desks_button.setToolTipText("");
        show_desks_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        show_desks_button.setFocusable(false);
        show_desks_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_desks_buttonActionPerformed(evt);
            }
        });

        my_booking_button2.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        my_booking_button2.setText("Clear");
        my_booking_button2.setToolTipText("");
        my_booking_button2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        my_booking_button2.setFocusable(false);
        my_booking_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                my_booking_button2ActionPerformed(evt);
            }
        });

        building_options_3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building", "richmond_building", "horton_building", "norcroft_centre" }));

        features_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Features", "Height adjustable and quiet", "Height adjustable and normal", "Normal" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 883, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(my_booking_button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(features_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(building_options_3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(show_desks_button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(show_desks_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(building_options_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(features_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(my_booking_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        my_bookings_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        my_bookings_table.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        my_bookings_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Desk name", "Features", "Date", "Start time", "Duration"
            }
        ));
        my_bookings_table.setToolTipText("");
        my_bookings_table.setEnabled(false);
        jScrollPane2.setViewportView(my_bookings_table);

        bookings_button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        bookings_button.setText("Bookings");
        bookings_button.setToolTipText("");
        bookings_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bookings_button.setFocusable(false);
        bookings_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookings_buttonActionPerformed(evt);
            }
        });

        my_booking_button3.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        my_booking_button3.setText("Clear");
        my_booking_button3.setToolTipText("");
        my_booking_button3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        my_booking_button3.setFocusable(false);
        my_booking_button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                my_booking_button3ActionPerformed(evt);
            }
        });

        building_options_4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building", "richmond_building", "horton_building", "norcroft_centre" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 616, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(my_booking_button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(building_options_4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bookings_button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(building_options_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookings_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(my_booking_button3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Register_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_ButtonActionPerformed
    }//GEN-LAST:event_Register_ButtonActionPerformed

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        GUI_Main_Menu menu = new GUI_Main_Menu();
        menu.setTitle("Main Menu");
        menu.setVisible(true);
        menu.setLocation(new Point(500, 150));
        menu.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_logout_buttonActionPerformed

    private void book_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_book_buttonActionPerformed
        s_access.Book(name_field, building_options_1, desk_name_options, date_chooser, time_options, duration_options);
    }//GEN-LAST:event_book_buttonActionPerformed

    private void Cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel_buttonActionPerformed
        s_access.Cancel(name_field1, building_options_2, desk_name_options1);

    }//GEN-LAST:event_Cancel_buttonActionPerformed

    private void show_desks_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_desks_buttonActionPerformed
        s_access.Show_desks(features_options, building_options_3, desk_table);
    }//GEN-LAST:event_show_desks_buttonActionPerformed

    private void my_booking_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_my_booking_button2ActionPerformed
        process.clearTable(desk_table);
    }//GEN-LAST:event_my_booking_button2ActionPerformed

    private void bookings_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookings_buttonActionPerformed
        s_access.ShowBookings(building_options_4, my_bookings_table, name_field);
    }//GEN-LAST:event_bookings_buttonActionPerformed

    private void my_booking_button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_my_booking_button3ActionPerformed
        process.clearTable(my_bookings_table);

    }//GEN-LAST:event_my_booking_button3ActionPerformed

    private void building_options_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_building_options_1ItemStateChanged
        s_access.Add_data_Desks(desk_name_options, building_options_1);
    }//GEN-LAST:event_building_options_1ItemStateChanged

    private void name_fieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name_fieldMouseClicked

    }//GEN-LAST:event_name_fieldMouseClicked

    private void name_fieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_name_fieldPropertyChange

    }//GEN-LAST:event_name_fieldPropertyChange

    private void building_options_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_building_options_2ItemStateChanged
        s_access.Add_data_desks_booked(name_field1, desk_name_options1, building_options_2);

    }//GEN-LAST:event_building_options_2ItemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImageIcon icon = new ImageIcon("src/Images/logo_uni.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Staff(parent, username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel_button;
    private javax.swing.JButton Register_Button;
    private javax.swing.JLabel User_label;
    private javax.swing.JButton book_button;
    private javax.swing.JButton bookings_button;
    private javax.swing.JLabel building_label;
    private javax.swing.JLabel building_label_2;
    private javax.swing.JComboBox<String> building_options_1;
    private javax.swing.JComboBox<String> building_options_2;
    private javax.swing.JComboBox<String> building_options_3;
    private javax.swing.JComboBox<String> building_options_4;
    private javax.swing.JLabel current_date_label;
    private com.toedter.calendar.JDateChooser date_chooser;
    private javax.swing.JLabel date_label;
    private javax.swing.JLabel desk_name_label;
    private javax.swing.JLabel desk_name_label_2;
    private javax.swing.JComboBox<String> desk_name_options;
    private javax.swing.JComboBox<String> desk_name_options1;
    private javax.swing.JTable desk_table;
    private javax.swing.JLabel duration_label;
    private javax.swing.JComboBox<String> duration_options;
    private javax.swing.JComboBox<String> features_options;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout_button;
    private javax.swing.JButton my_booking_button2;
    private javax.swing.JButton my_booking_button3;
    private javax.swing.JTable my_bookings_table;
    private javax.swing.JTextField name_field;
    private javax.swing.JTextField name_field1;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel name_label2;
    private javax.swing.JButton show_desks_button;
    private javax.swing.JLabel time_label;
    private javax.swing.JComboBox<String> time_options;
    // End of variables declaration//GEN-END:variables
}
