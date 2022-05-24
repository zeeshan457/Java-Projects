
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Aneef
 */
public class main_GUI extends JFrame implements ActionListener {

    Data_Access DA = new Data_Access();
    Data_Logic DL = new Data_Logic();

    //frame
    private JFrame frame = new JFrame();

    //labels
    private JLabel titlelabel = new JLabel("Student Support Form");
    private JLabel namelabel = new JLabel("Name");
    private JLabel addresslabel = new JLabel("Address");
    private JLabel numberlabel = new JLabel("Number");
    private JLabel timelabel = new JLabel("Time");
    private JLabel helplabel = new JLabel("Help");

    //input
    private JTextField name;
    private JTextField address;
    private JTextField number;
    private JTextField time;
    private JTextField help;

    //buttons
    private JButton edit = new JButton("edit record");
    private JButton delete = new JButton("delete record");
    private JButton submit = new JButton("submit");
    private JButton clear = new JButton("clear");
    private JButton connect = new JButton("Connect to DB");

    //constructor
    public main_GUI() {

        //labels
        titlelabel.setFont(new Font("Arial", Font.ITALIC, 25));
        titlelabel.setSize(320, 30);
        titlelabel.setLocation(190, 10);
        titlelabel.setForeground(Color.black);
        frame.add(titlelabel);

        namelabel.setFont(new Font("Arial", Font.ITALIC, 20));
        namelabel.setSize(100, 20);
        namelabel.setLocation(100, 100);
        namelabel.setForeground(Color.black);
        frame.add(namelabel);

        addresslabel.setFont(new Font("Arial", Font.ITALIC, 20));
        addresslabel.setSize(100, 20);
        addresslabel.setLocation(100, 150);
        addresslabel.setForeground(Color.black);
        frame.add(addresslabel);

        numberlabel.setFont(new Font("Arial", Font.ITALIC, 20));
        numberlabel.setSize(100, 20);
        numberlabel.setLocation(100, 200);
        numberlabel.setForeground(Color.black);
        frame.add(numberlabel);

        timelabel.setFont(new Font("Arial", Font.ITALIC, 20));
        timelabel.setSize(100, 20);
        timelabel.setLocation(100, 250);
        timelabel.setForeground(Color.black);
        frame.add(timelabel);

        helplabel.setFont(new Font("Arial", Font.ITALIC, 20));
        helplabel.setSize(100, 20);
        helplabel.setLocation(100, 300);
        helplabel.setForeground(Color.black);
        frame.add(helplabel);

        //input
        name = new JTextField();
        name.setFont(new Font("Arial", Font.ITALIC, 15));
        name.setSize(190, 20);
        name.setLocation(200, 100);
        name.setForeground(Color.black);
        frame.add(name);

        address = new JTextField();
        address.setFont(new Font("Arial", Font.ITALIC, 15));
        address.setSize(190, 20);
        address.setLocation(200, 150);
        address.setForeground(Color.black);
        frame.add(address);

        number = new JTextField();
        number.setFont(new Font("Arial", Font.ITALIC, 15));
        number.setSize(190, 20);
        number.setLocation(200, 200);
        number.setForeground(Color.black);
        frame.add(number);

        time = new JTextField();
        time.setFont(new Font("Arial", Font.ITALIC, 15));
        time.setSize(190, 20);
        time.setLocation(200, 250);
        time.setForeground(Color.black);
        frame.add(time);

        help = new JTextField();
        help.setFont(new Font("Arial", Font.ITALIC, 15));
        help.setSize(190, 20);
        help.setLocation(200, 300);
        help.setForeground(Color.black);
        frame.add(help);

        //buttons
        submit.setBounds(300, 350, 90, 24);
        submit.addActionListener(this);
        submit.setFocusable(false);
        submit.setFont(new Font("Arial", Font.ITALIC, 16));
        submit.setForeground(Color.black);
        frame.add(submit);

        clear.setBounds(200, 350, 90, 24);
        clear.addActionListener(this);
        clear.setFocusable(false);
        clear.setFont(new Font("Arial", Font.ITALIC, 16));
        clear.setForeground(Color.black);
        frame.add(clear);

        connect.setBounds(10, 10, 160, 24);
        connect.addActionListener(this);
        connect.setFocusable(false);
        connect.setFont(new Font("Arial", Font.ITALIC, 16));
        connect.setForeground(Color.black);
        frame.add(connect);

        //frame config
        frame.setTitle("Main page");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(550, 600);
        frame.setLocation(new Point(600, 150));
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(submit)) {
            try {
                DA.Insert(name, address, number, time, help);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "DB connection Error // Insert Error", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource().equals(connect)) {
            try {
                DA.connectDB();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,
                        "DB connection Error", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource().equals(clear)) {
            DL.clear(name, address, number, time, help);
        }
    }

}
