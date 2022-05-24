
import java.awt.Point;
import javax.swing.ImageIcon;

/**
 *
 * @author zeeshan
 */
public class GUI_Main_Menu extends javax.swing.JFrame {

    public GUI_Main_Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Register_Button1 = new javax.swing.JButton();
        main_panel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        Login_Button = new javax.swing.JButton();
        Register_Button2 = new javax.swing.JButton();
        Exit_Button = new javax.swing.JButton();

        Register_Button1.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        Register_Button1.setText("Register");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        main_panel.setBackground(new java.awt.Color(255, 255, 255));

        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Desk Booking Menu");

        Login_Button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        Login_Button.setText("Login");
        Login_Button.setToolTipText("");
        Login_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Login_Button.setFocusable(false);
        Login_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_ButtonActionPerformed(evt);
            }
        });

        Register_Button2.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        Register_Button2.setText("Register");
        Register_Button2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Register_Button2.setFocusable(false);
        Register_Button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register_Button2ActionPerformed(evt);
            }
        });

        Exit_Button.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        Exit_Button.setText("Exit");
        Exit_Button.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Exit_Button.setFocusable(false);
        Exit_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout main_panelLayout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(main_panelLayout);
        main_panelLayout.setHorizontalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(Exit_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Register_Button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main_panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(Login_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        main_panelLayout.setVerticalGroup(
            main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_panelLayout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(Register_Button2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Exit_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(main_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(main_panelLayout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(Login_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(100, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_ButtonActionPerformed
        GUI_Login login = new GUI_Login();
        login.setTitle("Login Page");
        login.setVisible(true);
        login.setLocation(new Point(300, 150));
        login.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_Login_ButtonActionPerformed

    private void Register_Button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register_Button2ActionPerformed
        GUI_Register register = new GUI_Register();
        register.setTitle("Register page");
        register.setVisible(true);
        register.setLocation(new Point(300, 150));
        register.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_Register_Button2ActionPerformed

    private void Exit_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit_ButtonActionPerformed
        System.exit(0);
        this.dispose();

    }//GEN-LAST:event_Exit_ButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ImageIcon icon = new ImageIcon("src/Images/logo_uni.png");
        setIconImage(icon.getImage());
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Main_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit_Button;
    private javax.swing.JButton Login_Button;
    private javax.swing.JButton Register_Button1;
    private javax.swing.JButton Register_Button2;
    private javax.swing.JPanel main_panel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
