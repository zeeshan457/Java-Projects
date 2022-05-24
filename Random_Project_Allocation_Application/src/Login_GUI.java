
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author zeeshan
 */
public class Login_GUI extends JFrame implements ActionListener {

    //instance of data_process & data_access classes
    Data_Access Select_Method_Data = new Data_Access();
    Data_Process select_method = new Data_Process();

    //frame and panel
    private JFrame frame = new JFrame();
    private JPanel loginpanel = new JPanel();

    //buttons
    private JButton loginbutton = new JButton("LOGIN");
    private JButton resetbutton = new JButton("RESET");

    //text and password field
    private JTextField usernamefield = new JTextField();
    private JPasswordField userpasswordfield = new JPasswordField();

    //labels
    private JLabel usernameLabel = new JLabel("username");
    private JLabel passwordLabel = new JLabel("password");
    private JLabel title = new JLabel("FYP module coordinator: Login");

    //border
    private Border borderblack = BorderFactory.createLineBorder(Color.BLACK, 2);
    private Border borderwhite = BorderFactory.createLineBorder(Color.WHITE, 2);

    //constructor for login
    public Login_GUI() {

        //username/password/title
        usernameLabel.setBounds(275, 200, 100, 25);
        usernameLabel.setForeground(Color.black);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        passwordLabel.setBounds(275, 230, 100, 50);
        passwordLabel.setForeground(Color.black);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        title.setBounds(300, 70, 300, 150);
        title.setForeground(Color.black);
        title.setFont(new Font("Arial", Font.ITALIC, 18));

        //username text field
        usernamefield.setBounds(360, 200, 225, 25);
        usernamefield.setFont(new Font("Arial", Font.PLAIN, 16));
        usernamefield.setForeground(Color.black);

        //password field
        userpasswordfield.setBounds(360, 243, 225, 25);
        userpasswordfield.setFont(new Font("Arial", Font.PLAIN, 16));
        userpasswordfield.setForeground(Color.black);

        //Buttons
        loginbutton.setBounds(360, 280, 100, 28);
        loginbutton.addActionListener(this);
        loginbutton.setFocusable(false);
        loginbutton.setBorder(borderwhite);
        loginbutton.setFont(new Font("Arial", Font.PLAIN, 16));
        loginbutton.setForeground(Color.black);

        resetbutton.setBounds(485, 280, 100, 30);
        resetbutton.addActionListener(this);
        resetbutton.setFocusable(false);
        resetbutton.setBorder(borderwhite);
        resetbutton.setFont(new Font("Arial", Font.PLAIN, 16));
        resetbutton.setForeground(Color.black);

        //Panel
        loginpanel.setBounds(250, 100, 375, 300);
        loginpanel.setBackground(Color.gray);
        loginpanel.setBorder(borderwhite);

        //add components to the frame
        frame.add(usernameLabel);
        frame.add(passwordLabel);
        frame.add(passwordLabel);
        frame.add(usernamefield);
        frame.add(userpasswordfield);
        frame.add(loginbutton);
        frame.add(resetbutton);
        frame.add(title);
        frame.add(loginpanel);

        //frame configs
        frame.setTitle("Login Form");
        frame.addWindowListener(exitwindow);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLocation(new Point(500, 200));
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }
    //windowlistener adapter method, if user clicks on exit, adding this to frame
    WindowListener exitwindow = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            select_method.closewindow();
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {

        /*login ActionEvent, passing attributes as arguments (username, password, 
        getting login data, frame)
         */
        if (e.getSource().equals(loginbutton)) {
            Select_Method_Data.checklogin(usernamefield, userpasswordfield, Select_Method_Data.getLogindata(), frame);
        }

        //reset ActionEvent, passing username and password fields as arguments
        if (e.getSource().equals(resetbutton)) {
            select_method.clearlogin(usernamefield, userpasswordfield);
        }

    }

}
