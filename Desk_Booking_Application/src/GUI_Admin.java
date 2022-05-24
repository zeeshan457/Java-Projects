
import java.awt.Point;
import MySQL.*;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author zeeshan
 */
public class GUI_Admin extends javax.swing.JFrame {

    // instance of class
    Data_Access access = new Data_Access();
    Data_Processing process = new Data_Processing();
    Admin_SQL s_access = new Admin_SQL();

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
    public GUI_Admin(Component parent, String username) {
        initComponents();
        this.parent = parent;
        this.username = username;

        // adding date to fields
        User_label.setText("User: " + getUsername(username));
        current_date_label.setText("Date: " + current_time);
        Date date = new Date();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Register_Button = new javax.swing.JButton();
        date_label3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logout_button = new javax.swing.JButton();
        User_label = new javax.swing.JLabel();
        current_date_label = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookings_table = new javax.swing.JTable();
        show_desks_button = new javax.swing.JButton();
        clear_button = new javax.swing.JButton();
        building_options = new javax.swing.JComboBox<>();
        idupdate_label = new javax.swing.JLabel();
        id_field3 = new javax.swing.JTextField();
        update_db_button = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        manage_label3 = new javax.swing.JLabel();
        duration_label = new javax.swing.JLabel();
        start_time_label2 = new javax.swing.JLabel();
        date_label = new javax.swing.JLabel();
        status_label2 = new javax.swing.JLabel();
        staff_field = new javax.swing.JTextField();
        duration_field = new javax.swing.JTextField();
        time_field3 = new javax.swing.JTextField();
        date_field = new javax.swing.JTextField();
        status_field2 = new javax.swing.JTextField();
        cancel_button3 = new javax.swing.JButton();
        Update_button = new javax.swing.JButton();
        name_label3 = new javax.swing.JLabel();
        id_field1 = new javax.swing.JTextField();
        ID_label = new javax.swing.JLabel();
        desk_label = new javax.swing.JLabel();
        desk_field = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        show_users_button = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        user_type_options = new javax.swing.JComboBox<>();
        clear_button2 = new javax.swing.JButton();
        idupdate_label1 = new javax.swing.JLabel();
        update_db_button1 = new javax.swing.JButton();
        id_field4 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        manage_label1 = new javax.swing.JLabel();
        user_type_label = new javax.swing.JLabel();
        staff_field1 = new javax.swing.JTextField();
        user_type_field = new javax.swing.JTextField();
        clear_user_field = new javax.swing.JButton();
        update_button2 = new javax.swing.JButton();
        username_label = new javax.swing.JLabel();
        managed_by_label = new javax.swing.JLabel();
        time_field2 = new javax.swing.JTextField();
        password_label2 = new javax.swing.JLabel();
        password_field = new javax.swing.JTextField();
        id_label2 = new javax.swing.JLabel();
        id_field2 = new javax.swing.JTextField();

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

        date_label3.setText("Date");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Page");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Panel");

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
                .addGap(419, 419, 419)
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

        bookings_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bookings_table.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bookings_table.setForeground(new java.awt.Color(0, 0, 0));
        bookings_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Staff name", "Desk name", "Date", "Start time", "Duration", "Status"
            }
        ));
        bookings_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookings_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookings_table);

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

        clear_button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        clear_button.setText("Clear");
        clear_button.setToolTipText("");
        clear_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        clear_button.setFocusable(false);
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });

        building_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Building", "richmond_building", "horton_building", "norcroft_centre" }));

        idupdate_label.setText("ID");

        id_field3.setEditable(false);

        update_db_button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        update_db_button.setText("Update booking");
        update_db_button.setToolTipText("");
        update_db_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        update_db_button.setFocusable(false);
        update_db_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_db_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clear_button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(idupdate_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_field3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_db_button, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(building_options, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(show_desks_button, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(show_desks_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idupdate_label)
                        .addComponent(id_field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(update_db_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(building_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clear_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        manage_label3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        manage_label3.setText("Manage bookings");

        duration_label.setText("Duration");

        start_time_label2.setText("Start time");

        date_label.setText("Date");

        status_label2.setText("Status");

        status_field2.setEditable(false);

        cancel_button3.setText("Cancel");
        cancel_button3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cancel_button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_button3ActionPerformed(evt);
            }
        });

        Update_button.setText("Update");
        Update_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_buttonActionPerformed(evt);
            }
        });

        name_label3.setText("Staff Name");

        id_field1.setEditable(false);

        ID_label.setText("ID");

        desk_label.setText("Desk Name");

        desk_field.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addComponent(ID_label)
                            .addGap(60, 60, 60))
                        .addComponent(date_label))
                    .addComponent(start_time_label2)
                    .addComponent(duration_label)
                    .addComponent(status_label2)
                    .addComponent(desk_label)
                    .addComponent(name_label3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_field)
                    .addComponent(staff_field)
                    .addComponent(desk_field, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(id_field1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(duration_field)
                        .addComponent(status_field2)
                        .addComponent(time_field3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_button3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(manage_label3)
                .addGap(15, 15, 15))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manage_label3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ID_label))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(staff_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(name_label3)))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(id_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(desk_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(desk_label))
                                    .addGap(12, 12, 12)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(date_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date_label))
                                    .addGap(12, 12, 12)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(time_field3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(start_time_label2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(duration_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(duration_label))
                                    .addGap(12, 12, 12)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(status_field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(status_label2))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(Update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancel_button3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        show_users_button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        show_users_button.setText("Show users");
        show_users_button.setToolTipText("");
        show_users_button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        show_users_button.setFocusable(false);
        show_users_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_users_buttonActionPerformed(evt);
            }
        });

        user_table.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "User type", "Managed by", "Password"
            }
        ));
        user_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(user_table);

        user_type_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User Type", "Staff", "Manager", "Administrator" }));

        clear_button2.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        clear_button2.setText("Clear");
        clear_button2.setToolTipText("");
        clear_button2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        clear_button2.setFocusable(false);
        clear_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_button2ActionPerformed(evt);
            }
        });

        idupdate_label1.setText("ID");

        update_db_button1.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        update_db_button1.setText("Update user");
        update_db_button1.setToolTipText("");
        update_db_button1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        update_db_button1.setFocusable(false);
        update_db_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_db_button1ActionPerformed(evt);
            }
        });

        id_field4.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(idupdate_label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_field4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_db_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(307, 307, 307)
                        .addComponent(user_type_options, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clear_button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(show_users_button, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(show_users_button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user_type_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idupdate_label1)
                        .addComponent(id_field4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(update_db_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        manage_label1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        manage_label1.setText("Manage users");

        user_type_label.setText("User type");

        user_type_field.setEditable(false);

        clear_user_field.setText("Clear");
        clear_user_field.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        clear_user_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_user_fieldActionPerformed(evt);
            }
        });

        update_button2.setText("Update");
        update_button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        update_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_button2ActionPerformed(evt);
            }
        });

        username_label.setText("Username");

        managed_by_label.setText("Managed by");

        password_label2.setText("Password");

        id_label2.setText("ID");

        id_field2.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(password_label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(managed_by_label))
                            .addComponent(user_type_label)
                            .addComponent(username_label)
                            .addComponent(id_label2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_field2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(time_field2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                        .addComponent(user_type_field, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(staff_field1, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(update_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clear_user_field, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(manage_label1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(update_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear_user_field, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(manage_label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_label2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(staff_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(username_label))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(user_type_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user_type_label))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(time_field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(managed_by_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password_label2))))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
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

    private void show_desks_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_desks_buttonActionPerformed
        s_access.ShowAllBokings(building_options, bookings_table);
    }//GEN-LAST:event_show_desks_buttonActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        process.clearTable(bookings_table);
    }//GEN-LAST:event_clear_buttonActionPerformed

    private void show_users_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_show_users_buttonActionPerformed
        s_access.ShowUsers(user_type_options, user_table);
    }//GEN-LAST:event_show_users_buttonActionPerformed

    private void clear_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_button2ActionPerformed
        process.clearTable(user_table);
    }//GEN-LAST:event_clear_button2ActionPerformed

    private void bookings_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookings_tableMouseClicked
        s_access.getBookingTableRow(bookings_table, id_field3, id_field1, staff_field, desk_field, date_field, time_field3, duration_field, status_field2);
    }//GEN-LAST:event_bookings_tableMouseClicked

    private void Update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_buttonActionPerformed
        s_access.UpdateBookingTableRow(bookings_table, id_field1, staff_field, desk_field, date_field, time_field3, duration_field, status_field2);
    }//GEN-LAST:event_Update_buttonActionPerformed

    private void user_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_tableMouseClicked
        s_access.getUserTableRow(user_table, id_field4, id_field2, staff_field1, user_type_field, time_field2, password_field);
    }//GEN-LAST:event_user_tableMouseClicked

    private void update_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_button2ActionPerformed
        s_access.UpdateUserTableRow(user_table, id_field2, staff_field1, user_type_field, time_field2, password_field);
    }//GEN-LAST:event_update_button2ActionPerformed

    private void update_db_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_db_buttonActionPerformed
        s_access.UpdateRowDB(bookings_table, building_options);
    }//GEN-LAST:event_update_db_buttonActionPerformed

    private void update_db_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_db_button1ActionPerformed
        s_access.UpdateRowUsersDB(user_table, user_type_options);
    }//GEN-LAST:event_update_db_button1ActionPerformed

    private void cancel_button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_button3ActionPerformed
        s_access.CancelBookingToFields(bookings_table, id_field1, staff_field, desk_field, date_field, time_field3, duration_field, status_field2);
    }//GEN-LAST:event_cancel_button3ActionPerformed

    private void clear_user_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_user_fieldActionPerformed
        s_access.ClearUserToFields(user_table, id_field2, staff_field1, user_type_field, time_field2, password_field);
    }//GEN-LAST:event_clear_user_fieldActionPerformed

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
    private javax.swing.JLabel ID_label;
    private javax.swing.JButton Register_Button;
    private javax.swing.JButton Update_button;
    private javax.swing.JLabel User_label;
    private javax.swing.JTable bookings_table;
    private javax.swing.JComboBox<String> building_options;
    private javax.swing.JButton cancel_button3;
    private javax.swing.JButton clear_button;
    private javax.swing.JButton clear_button2;
    private javax.swing.JButton clear_user_field;
    private javax.swing.JLabel current_date_label;
    private javax.swing.JTextField date_field;
    private javax.swing.JLabel date_label;
    private javax.swing.JLabel date_label3;
    private javax.swing.JTextField desk_field;
    private javax.swing.JLabel desk_label;
    private javax.swing.JTextField duration_field;
    private javax.swing.JLabel duration_label;
    private javax.swing.JTextField id_field1;
    private javax.swing.JTextField id_field2;
    private javax.swing.JTextField id_field3;
    private javax.swing.JTextField id_field4;
    private javax.swing.JLabel id_label2;
    private javax.swing.JLabel idupdate_label;
    private javax.swing.JLabel idupdate_label1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout_button;
    private javax.swing.JLabel manage_label1;
    private javax.swing.JLabel manage_label3;
    private javax.swing.JLabel managed_by_label;
    private javax.swing.JLabel name_label3;
    private javax.swing.JTextField password_field;
    private javax.swing.JLabel password_label2;
    private javax.swing.JButton show_desks_button;
    private javax.swing.JButton show_users_button;
    private javax.swing.JTextField staff_field;
    private javax.swing.JTextField staff_field1;
    private javax.swing.JLabel start_time_label2;
    private javax.swing.JTextField status_field2;
    private javax.swing.JLabel status_label2;
    private javax.swing.JTextField time_field2;
    private javax.swing.JTextField time_field3;
    private javax.swing.JButton update_button2;
    private javax.swing.JButton update_db_button;
    private javax.swing.JButton update_db_button1;
    private javax.swing.JTable user_table;
    private javax.swing.JTextField user_type_field;
    private javax.swing.JLabel user_type_label;
    private javax.swing.JComboBox<String> user_type_options;
    private javax.swing.JLabel username_label;
    // End of variables declaration//GEN-END:variables
}
