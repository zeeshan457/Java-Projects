
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteAcc
{
    DeleteAcc()
    {
        Acc_Dele AD = new Acc_Dele();
        AD.Delete();
    }
}

class Acc_Dele extends JFrame
{
    
    private JTextField Acc_Num;
    private JButton DELETE;
    private JButton CANCEL;
    private JLabel jlabel;
    private JPanel jpanel1;
    private JPanel jpanel2;
    private JPanel jpanel3;    
    
    Database db = new Database(); 
    
    public void Delete()
    {
        System.out.println("Account Deletion");
        
        Acc_Num = new JTextField(10);
        DELETE = new JButton("DELETE");
        CANCEL = new JButton("CANCEL");
        jlabel = new JLabel("Enter Account Number");
        jpanel1 = new JPanel();
        jpanel2 = new JPanel();
        jpanel3 = new JPanel();
        
        jpanel1.setLayout(new GridLayout(3,1,1,1));
        jpanel1.add(jlabel);
        
        jpanel2.setLayout(new GridLayout(3,1,1,1));
        jpanel2.add(Acc_Num);
        
        jpanel3.setLayout(new GridLayout(1,1,1,1));
        jpanel3.add(DELETE);
        jpanel3.add(CANCEL);
        
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(jpanel1);
        
        Container container1 = getContentPane();
        container1.setLayout(new FlowLayout());
        container1.add(jpanel2);
        
        Container container3 = getContentPane();
        container3.setLayout(new FlowLayout());
        container3.add(jpanel3);
        
        setVisible(true);
        setTitle("Delete Account");
        setBounds(100,100,270,130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DELETE.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                db.DELETE_ACCEntry(Acc_Num.getText());
                MainMenu mm=new MainMenu();
                mm.menu();
            }
        });
        
        CANCEL.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                MainMenu mm=new MainMenu();
                mm.menu();
            }
        });
    }
}