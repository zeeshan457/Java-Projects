
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author zeeshan
 */
public class Data_Process {

    //instance of data_process & data_access classes
    Data_Access select_method_Data = new Data_Access();

    //arraylists
    private ArrayList<String> projectList = new ArrayList<String>();
    private ArrayList<String> StudentsList = new ArrayList<String>();
    private ArrayList<String> randomprojects = new ArrayList<String>();

    //string builders
    private StringBuilder studentsID = new StringBuilder();
    private StringBuilder studentsfullname = new StringBuilder();

    //br and files
    private File file;
    private File file2;
    private File file3 = new File("student-project.dat");
    private BufferedReader BRstudents;
    private BufferedReader BRprojects;
    private BufferedReader BRallocate;

    //varables
    int int_marks;
    int int_ID;
    private String line = null;

    //open students file
    public void openstudents() {
        JFileChooser openstudents = new JFileChooser();
        openstudents.setCurrentDirectory(new File(System.getProperty("user.home")));

        //open only txt files (filter)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        openstudents.setAcceptAllFileFilterUsed(false);
        openstudents.setFileFilter(filter);
        openstudents.setFocusable(false);

        int result = openstudents.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            file = openstudents.getSelectedFile();

            JOptionPane.showMessageDialog(null, file.getName() + " has been selected, please read the file"
                    + "\n" + file.getAbsolutePath());

        } else {
            JOptionPane.showMessageDialog(null, "file opener closed");

        }

    }

    //read students file - passing JTextArea as parameter
    public void readstudents(JTextArea textfield) {

        try {
            if (file != null) {
                BRstudents = new BufferedReader(new FileReader(file));

                //read all lines in the file
                while ((line = BRstudents.readLine()) != null) {

                    StudentsList.add(line);
                    textfield.append(line);
                    textfield.append(System.getProperty("line.separator"));

                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "please select a students file", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "file not found", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    //open projects file
    public void openprojects() {
        JFileChooser openprojects = new JFileChooser();
        openprojects.setCurrentDirectory(new File(System.getProperty("user.home")));

        //open only txt files (filter)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        openprojects.setAcceptAllFileFilterUsed(false);
        openprojects.setFileFilter(filter);
        openprojects.setFocusable(false);

        int result = openprojects.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            file2 = openprojects.getSelectedFile();

            JOptionPane.showMessageDialog(null, file2.getName() + " has been selected, please read the file"
                    + "\n" + file2.getAbsolutePath());

        } else {
            JOptionPane.showMessageDialog(null, "file opener closed");

        }

    }

    //read projects file - passing JTextArea as parameter
    public void readprojects(JTextArea textfield) {

        try {
            if (file2 != null) {
                BRprojects = new BufferedReader(new FileReader(file2));

                //read all lines in the file
                while ((line = BRprojects.readLine()) != null) {

                    projectList.add(line);
                    textfield.append(line);
                    textfield.append(System.getProperty("line.separator"));

                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "please select a projects file", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "file not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    /* allocate students to projects - & writetofile method is called from 
    Data_Access*/
    public void Allocate_and_Assess() {
        if (file != null && file2 != null && BRstudents != null && BRprojects != null) {
            if (!projectList.isEmpty() && !StudentsList.isEmpty()) {

                //Input ID
                String ID = JOptionPane.showInputDialog(null, "type student ID you want to allocate");

                //randomising a project in the projectlist
                Random rnd = new Random();
                String randomproject = projectList.get(rnd.nextInt(projectList.size()));

                for (String students : StudentsList) {
                    try {
                        if (ID != null) {

                            //empty input validation 
                            if (ID.length() == 0) {
                                JOptionPane.showMessageDialog(null,
                                        "please type ID for a student", "ERROR", JOptionPane.ERROR_MESSAGE);
                                break;
                            }

                            if (ID.length() < 8) {
                                JOptionPane.showMessageDialog(null,
                                        "ID must be more than or equal to '8' numerical characters", "ERROR", JOptionPane.ERROR_MESSAGE);
                                break;
                            }

                            if (!ID.startsWith("18") && !ID.startsWith("19") && !ID.startsWith("20")) {
                                JOptionPane.showMessageDialog(null,
                                        "ID must be from the years '2018', '2019' and '2020'", "ERROR", JOptionPane.ERROR_MESSAGE);
                                break;
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Input Dialog has been closed");
                            break;
                        }

                        //validation for only positive numbers and input number validation
                        if (ID != null) {

                            int intID = Integer.parseInt(ID);
                            int_ID = intID;

                            if (int_ID < 0) {
                                JOptionPane.showMessageDialog(null,
                                        "ID must be positive numbers", "ERROR", JOptionPane.ERROR_MESSAGE);
                                break;

                            }

                        }
                    } catch (NumberFormatException n) {
                        JOptionPane.showMessageDialog(null,
                                "ID must be a number or exceeds value of integer", "ERROR", JOptionPane.ERROR_MESSAGE);
                        break;

                    }
                }

                //array to string
                for (String students : StudentsList) {

                    //split the students to find ID
                    String[] divide = students.split(" ", 0);

                    studentsID.append(divide[2]);
                    studentsID.append(System.getProperty("line.separator"));

                    //creating a string builder for fullname of a student
                    String firstname = divide[0] + "";
                    String surname = divide[1];
                    String name = firstname.concat(surname);
                    studentsfullname.append(name);
                    studentsfullname.append(System.getProperty("line.separator"));

                    //if ID in the students file match the ID for user input
                    if (divide[2].equals(ID)) {

                        JOptionPane.showMessageDialog(null, "randomly allocating a project to the student with this ID: " + ID);

                        //yes, no and cancel confirm dialog for assessment
                        int confirm = JOptionPane.showConfirmDialog(null, "Allocation was successful, do you want to assess the student?");
                        if (confirm == JOptionPane.YES_OPTION) {

                            //assessment input mark for a student after allocation
                            String string_mark = JOptionPane.showInputDialog(null, "type a mark out of /100 to assess the student with this ID: " + ID
                                    + "\n" + "marks must be less than 100 and must be a positive number");

                            try {
                                if (string_mark != null) {

                                    int intmarks = Integer.parseInt(string_mark);
                                    int_marks = intmarks;

                                    //empty input validation 
                                    if (string_mark.length() == 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "please type a mark for a student", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        break;
                                    }

                                    if (int_marks > 100) {
                                        JOptionPane.showMessageDialog(null,
                                                "assessment marks must be less than 100", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        break;

                                    } else if (int_marks < 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "assessment marks must be positive numbers", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        break;

                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "assessment Input Dialog closed", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } catch (NumberFormatException n) {
                                JOptionPane.showMessageDialog(null,
                                        "assessment marks must be a number or exceeds value of integer", "ERROR", JOptionPane.ERROR_MESSAGE);
                                break;

                            }

                            JOptionPane.showMessageDialog(null, "allocation & assessment success, read the allocated file");

                            //write to file method - & passing 3 arguments
                            WriteToFile(int_ID, randomproject, int_marks);
                            break;

                        } else if (confirm == JOptionPane.NO_OPTION) {

                            JOptionPane.showMessageDialog(null, "allocation success, read the allocated file");

                            //write to file - & passing 2 arguments
                            WriteToFileWithoutAssessment(int_ID, randomproject);
                            break;
                        }
                    }
                }

                //check if Students ID matches the ID a user has typed in the Dialog.
                if (ID != null) {
                    if (!studentsID.toString().contains(ID)) {
                        JOptionPane.showMessageDialog(null,
                                "ID does not match any records", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }

        } else {
            JOptionPane.showMessageDialog(null,
                    "the students and projects files must be read first, before allocating", "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    //write to file method - & passing 3 variables as parameters
    public void WriteToFile(int ID, String project, int marks) {
        try {
            FileOutputStream fos = new FileOutputStream(new File("student-project.dat"), true);

            String Data = "ID: " + ID + " " + " project: " + project + " "
                    + "Asessment mark: " + marks + "/100";

            byte[] bytes = Data.getBytes(StandardCharsets.UTF_8);

            //write to file
            fos.write(bytes);
            fos.write(System.getProperty("line.separator").getBytes());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "file not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    //write to file method - & passing 2 variables as parameters
    public void WriteToFileWithoutAssessment(int ID, String project) {
        try {
            FileOutputStream fos = new FileOutputStream(new File("student-project.dat"), true);

            String Data = "ID: " + ID + " " + " project: " + project;

            byte[] bytes = Data.getBytes(StandardCharsets.UTF_8);

            //write to file
            fos.write(bytes);
            fos.write(System.getProperty("line.separator").getBytes());

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "file not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    //read allocated students - JTextArea is passed as parameter
    public void readallocatedstudents(JTextArea textarea) {
        try {
            if (file3 != null) {
                BRallocate = new BufferedReader(new FileReader(file3));

                //read all lines in the file
                while ((line = BRallocate.readLine()) != null) {

                    textarea.append(line);
                    textarea.append(System.getProperty("line.separator"));

                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "the file was closed.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "file not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //close files method - passing 3 JTextArea as parameter
    public void closefiles(JTextArea s, JTextArea p, JTextArea as) {
        if (BRstudents != null && BRprojects != null && BRallocate != null) {
            try {
                int confirmclose = JOptionPane.showConfirmDialog(null, "Are you sure, you want to close the files?");
                if (confirmclose == JOptionPane.YES_OPTION) {

                    BRstudents.close();
                    file = null;
                    s.setText("");

                    BRprojects.close();
                    file2 = null;
                    p.setText("");

                    BRallocate.close();
                    as.setText("");
                    file3 = null;

                    JOptionPane.showMessageDialog(null, "files has been closed successfully");
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "file not found", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null,
                    "the files are empty, please open the files & read the files", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    //close window method
    public void closewindow() {
        int confirmexit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");

        if (confirmexit == JOptionPane.YES_OPTION) {
            System.exit(1);
        }
    }

    //help method
    public void help() {
        JOptionPane.showMessageDialog(null,
                "///////////////////////////////////////////////////////////"
                + "/////////////////////////////////////////////////"
                + "////////////////////////////////////////"
                + "\n" + "step 1: open students file"
                + "\n" + "step 2: read students"
                + "\n" + "step 3: open projects file"
                + "\n" + "step 4: read projects"
                + "\n" + "step 5: allocate a student by reading the UI and typing into input box"
                + "\n" + "step 6: assess the student by typing a mark"
                + "\n" + "step 7: read allocated students"
                + "\n" + "//////////////////////////////////////////////////"
                + "/////////////////////////////////////////////////"
                + "/////////////////////////////////////////////////",
                "How to use the program!", JOptionPane.DEFAULT_OPTION, null);
    }

    //reset fields methods - passing components as parameter
    public void resetstudents(JTextArea t) {
        t.setText("");
    }

    public void resetprojects(JTextArea t) {
        t.setText("");
    }

    public void resetallocatedstudents(JTextArea t) {
        t.setText("");
    }

    public void clearlogin(JTextField t, JPasswordField t2) {
        t.setText("");
        t2.setText("");

    }

}
