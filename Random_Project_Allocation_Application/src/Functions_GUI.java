
import java.awt.BorderLayout;
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
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.WindowConstants;

/**
 *
 * @author zeeshan
 */
public class Functions_GUI extends JFrame implements ActionListener {

    //instance of data_process & data_access classes
    Data_Process select_method = new Data_Process();
    Data_Access select_method_Data = new Data_Access();

    //frame
    private JFrame frame = new JFrame();

    //labels
    private JLabel studentlabel = new JLabel("Students");
    private JLabel projectlabel = new JLabel("Projects");
    private JLabel studentsprojectlabel = new JLabel("Students Allocated");

    //buttons
    private JButton LogoutButton = new JButton("logout");
    private JButton openstudentsbutton = new JButton("select students file");
    private JButton openprojectsbutton = new JButton("select projects file");
    private JButton readstudentsbutton = new JButton("read students");
    private JButton readprojectsbutton = new JButton("read projects");
    private JButton Allocatebutton = new JButton("allocate/assess student");
    private JButton Allocateallbutton = new JButton("allocate all");
    private JButton ReadAllocatdstudentsebutton = new JButton("read Allocated students");
    private JButton clearstudents = new JButton("reset");
    private JButton clearprojects = new JButton("reset");
    private JButton clearallocatedstudents = new JButton("reset");
    private JButton helpbutton = new JButton("help");
    private JButton closefilebutton = new JButton("close files");

    //panels
    private JPanel StudentPanel = new JPanel(new BorderLayout());
    private JPanel ProjectsPanel = new JPanel(new BorderLayout());
    private JPanel StudentsProjectsPanel = new JPanel(new BorderLayout());

    //buttonpanels
    private JPanel StudentbuttonPanel = new JPanel(new BorderLayout());
    private JPanel ProjectsbuttonPanel = new JPanel(new BorderLayout());
    private JPanel StudentsProjectsbuttonPanel = new JPanel(new BorderLayout());

    //textareas
    private JTextArea studentstextfield = new JTextArea();
    private JTextArea projectstextfield = new JTextArea();
    private JTextArea studentsallocatedtextfield = new JTextArea();

    //borders
    private Border borderblack = BorderFactory.createLineBorder(Color.BLACK, 1);
    private Border borderwhite = BorderFactory.createLineBorder(Color.WHITE, 2);

    //constructor for functions
    public Functions_GUI() {

        //panels
        StudentPanel.setBounds(40, 100, 250, 400);
        StudentPanel.setBackground(Color.GRAY);
        StudentPanel.setBorder(borderwhite);

        ProjectsPanel.setBounds(315, 100, 250, 400);
        ProjectsPanel.setBackground(Color.GRAY);
        ProjectsPanel.setBorder(borderwhite);

        StudentsProjectsPanel.setBounds(590, 100, 550, 400);
        StudentsProjectsPanel.setBackground(Color.GRAY);
        StudentsProjectsPanel.setBorder(borderwhite);

        //labels
        studentlabel.setBounds(0, 0, 100, 50);
        studentlabel.setForeground(Color.BLACK);
        studentlabel.setFont(new Font("Arial", Font.ITALIC, 16));
        studentlabel.setHorizontalAlignment(JLabel.CENTER);
        studentlabel.setVerticalAlignment(JLabel.CENTER);

        projectlabel.setBounds(0, 0, 100, 50);
        projectlabel.setForeground(Color.BLACK);
        projectlabel.setFont(new Font("Arial", Font.ITALIC, 16));
        projectlabel.setHorizontalAlignment(JLabel.CENTER);
        projectlabel.setVerticalAlignment(JLabel.CENTER);

        studentsprojectlabel.setBounds(0, 0, 100, 50);
        studentsprojectlabel.setForeground(Color.BLACK);
        studentsprojectlabel.setFont(new Font("Arial", Font.ITALIC, 16));
        studentsprojectlabel.setHorizontalAlignment(JLabel.CENTER);
        studentsprojectlabel.setVerticalAlignment(JLabel.CENTER);

        //textareas
        studentstextfield.setBounds(0, 0, 100, 50);
        studentstextfield.setForeground(Color.black);
        studentstextfield.setFont(new Font("Arial", Font.ITALIC, 14));
        studentstextfield.setLineWrap(true);
        studentstextfield.setRows(10);

        projectstextfield.setBounds(0, 0, 100, 50);
        projectstextfield.setForeground(Color.BLACK);
        projectstextfield.setFont(new Font("Arial", Font.ITALIC, 14));
        projectstextfield.setLineWrap(true);

        studentsallocatedtextfield.setBounds(0, 0, 100, 50);
        studentsallocatedtextfield.setForeground(Color.BLACK);
        studentsallocatedtextfield.setFont(new Font("Arial", Font.ITALIC, 14));
        studentsallocatedtextfield.setLineWrap(true);

        //Buttons
        LogoutButton.setBounds(1060, 10, 80, 24);
        LogoutButton.addActionListener(this);
        LogoutButton.setFocusable(false);
        LogoutButton.setBorder(borderblack);
        LogoutButton.setFont(new Font("Arial", Font.ITALIC, 16));
        LogoutButton.setForeground(Color.black);

        helpbutton.setBounds(975, 10, 80, 24);
        helpbutton.addActionListener(this);
        helpbutton.setFocusable(false);
        helpbutton.setBorder(borderblack);
        helpbutton.setFont(new Font("Arial", Font.ITALIC, 16));
        helpbutton.setForeground(Color.black);

        closefilebutton.setBounds(880, 10, 90, 24);
        closefilebutton.addActionListener(this);
        closefilebutton.setFocusable(false);
        closefilebutton.setBorder(borderblack);
        closefilebutton.setFont(new Font("Arial", Font.ITALIC, 16));
        closefilebutton.setForeground(Color.black);

        openstudentsbutton.addActionListener(this);
        openstudentsbutton.setFocusable(false);
        openstudentsbutton.setBorder(borderblack);
        openstudentsbutton.setFont(new Font("Arial", Font.ITALIC, 16));
        openstudentsbutton.setForeground(Color.black);

        readstudentsbutton.addActionListener(this);
        readstudentsbutton.setFocusable(false);
        readstudentsbutton.setBorder(borderblack);
        readstudentsbutton.setFont(new Font("Arial", Font.ITALIC, 16));
        readstudentsbutton.setForeground(Color.black);

        openprojectsbutton.addActionListener(this);
        openprojectsbutton.setFocusable(false);
        openprojectsbutton.setBorder(borderblack);
        openprojectsbutton.setFont(new Font("Arial", Font.ITALIC, 16));
        openprojectsbutton.setForeground(Color.black);

        readprojectsbutton.addActionListener(this);
        readprojectsbutton.setFocusable(false);
        readprojectsbutton.setBorder(borderblack);
        readprojectsbutton.setFont(new Font("Arial", Font.ITALIC, 16));
        readprojectsbutton.setForeground(Color.black);

        Allocatebutton.addActionListener(this);
        Allocatebutton.setFocusable(false);
        Allocatebutton.setBorder(borderblack);
        Allocatebutton.setFont(new Font("Arial", Font.ITALIC, 16));
        Allocatebutton.setForeground(Color.black);

        Allocateallbutton.addActionListener(this);
        Allocateallbutton.setFocusable(false);
        Allocateallbutton.setBorder(borderblack);
        Allocateallbutton.setFont(new Font("Arial", Font.ITALIC, 16));
        Allocateallbutton.setForeground(Color.black);

        ReadAllocatdstudentsebutton.addActionListener(this);
        ReadAllocatdstudentsebutton.setFocusable(false);
        ReadAllocatdstudentsebutton.setBorder(borderblack);
        ReadAllocatdstudentsebutton.setFont(new Font("Arial", Font.ITALIC, 16));
        ReadAllocatdstudentsebutton.setForeground(Color.black);

        clearstudents.addActionListener(this);
        clearstudents.setFocusable(false);
        clearstudents.setBorder(borderblack);
        clearstudents.setFont(new Font("Arial", Font.ITALIC, 16));
        clearstudents.setForeground(Color.black);

        clearprojects.addActionListener(this);
        clearprojects.setFocusable(false);
        clearprojects.setBorder(borderblack);
        clearprojects.setFont(new Font("Arial", Font.ITALIC, 16));
        clearprojects.setForeground(Color.black);

        clearallocatedstudents.addActionListener(this);
        clearallocatedstudents.setFocusable(false);
        clearallocatedstudents.setBorder(borderblack);
        clearallocatedstudents.setFont(new Font("Arial", Font.ITALIC, 16));
        clearallocatedstudents.setForeground(Color.black);

        //Add button components to button panels
        StudentbuttonPanel.add(readstudentsbutton, BorderLayout.CENTER);
        StudentbuttonPanel.add(openstudentsbutton, BorderLayout.NORTH);
        StudentbuttonPanel.add(clearstudents, BorderLayout.SOUTH);

        ProjectsbuttonPanel.add(readprojectsbutton, BorderLayout.CENTER);
        ProjectsbuttonPanel.add(openprojectsbutton, BorderLayout.NORTH);
        ProjectsbuttonPanel.add(clearprojects, BorderLayout.SOUTH);

        StudentsProjectsbuttonPanel.add(ReadAllocatdstudentsebutton, BorderLayout.CENTER);
        StudentsProjectsbuttonPanel.add(Allocatebutton, BorderLayout.NORTH);
        StudentsProjectsbuttonPanel.add(clearallocatedstudents, BorderLayout.SOUTH);

        //Add labels & button panels to each corresponding main panel
        StudentPanel.add(studentlabel, BorderLayout.PAGE_START);
        StudentPanel.add(StudentbuttonPanel, BorderLayout.PAGE_END);
        ProjectsPanel.add(projectlabel, BorderLayout.PAGE_START);
        ProjectsPanel.add(ProjectsbuttonPanel, BorderLayout.PAGE_END);
        StudentsProjectsPanel.add(studentsprojectlabel, BorderLayout.PAGE_START);
        StudentsProjectsPanel.add(StudentsProjectsbuttonPanel, BorderLayout.PAGE_END);

        //adding textareas to main panels
        StudentPanel.add(studentstextfield, BorderLayout.CENTER);
        ProjectsPanel.add(projectstextfield, BorderLayout.CENTER);
        StudentsProjectsPanel.add(studentsallocatedtextfield, BorderLayout.CENTER);

        //Add components to frame
        frame.add(LogoutButton);
        frame.add(helpbutton);
        frame.add(closefilebutton);
        frame.add(StudentPanel);
        frame.add(ProjectsPanel);
        frame.add(StudentsProjectsPanel);

        //frame config
        frame.setTitle("Functions page");
        frame.addWindowListener(exitwindow);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setLocation(new Point(400, 200));
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    //windowlistener adapter method, if user clicks on exit, optionmenu is shown
    WindowListener exitwindow = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            select_method.closewindow();
        }
    };

    @Override
    public void actionPerformed(ActionEvent e) {

        //open students file ActionEvent
        if (e.getSource().equals(openstudentsbutton)) {
            select_method.openstudents();
        }

        //read students file ActionEvent & passing JTextArea as argument
        if (e.getSource().equals(readstudentsbutton)) {
            select_method.readstudents(studentstextfield);
        }

        //open projects file ActionEvent
        if (e.getSource().equals(openprojectsbutton)) {
            select_method.openprojects();
        }

        //read students file ActionEvent & passing JTextArea as argument
        if (e.getSource().equals(readprojectsbutton)) {
            select_method.readprojects(projectstextfield);
        }

        //allocate and assess students ActionEvent
        if (e.getSource().equals(Allocatebutton)) {
            select_method.Allocate_and_Assess();
        }

        //read allocatedstudents ActionEvent file ActionEvent & passing JTextArea as argument
        if (e.getSource().equals(ReadAllocatdstudentsebutton)) {
            select_method.readallocatedstudents(studentsallocatedtextfield);
        }

        //clear fields ActionEvent & arguments are passed
        if (e.getSource().equals(clearstudents)) {
            select_method.resetstudents(studentstextfield);

        } else if (e.getSource().equals(clearprojects)) {
            select_method.resetprojects(projectstextfield);

        } else if (e.getSource().equals(clearallocatedstudents)) {
            select_method.resetallocatedstudents(studentsallocatedtextfield);
        }

        //help ActionEvent
        if (e.getSource().equals(helpbutton)) {
            select_method.help();
        }

        //close all files ActionEvent - & passing 3 JTexTAreas as arguments
        if (e.getSource().equals(closefilebutton)) {
            select_method.closefiles(studentstextfield, projectstextfield, studentsallocatedtextfield);
        }

        //logout ActionEvent - & passing frame as argument
        if (e.getSource().equals(LogoutButton)) {
            select_method_Data.logout(frame);
        }

    }

}
