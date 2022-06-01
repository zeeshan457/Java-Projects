import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main 
{
   public static void main(String[] args) 
   {
       System.out.println("Hello World");
       MainMenu mm=new MainMenu();
       mm.menu();
   }
}

class MainMenu extends JFrame
{
    private JButton NewAccount;
    private JButton Deposit;
    private JButton Display;
    private JButton Withdrawal;
    private JButton DeleteAcc;
    private JPanel panel;
    private JLabel label;    
    
    void menu()
    {
        System.out.println("Creating Main Menu");
        
        panel = new JPanel();
        
        label = new JLabel("Main Menu");
        NewAccount = new JButton("New Account");
        Deposit = new JButton("Deposit");
        Display = new JButton("Display");
        Withdrawal = new JButton("Withdrawal");
        DeleteAcc = new JButton("DeleteAcc");
        
        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());
        
        panel.setLayout(new GridLayout(6,1,20,20));
        
        panel.add(label);
        panel.add(NewAccount);
        panel.add(Deposit);
        panel.add(Display);
        panel.add(Withdrawal);
        panel.add(DeleteAcc);
        
        cont.add(panel,BorderLayout.CENTER);   
        
        ButtonHandler handler = new ButtonHandler();
        NewAccount.addActionListener(handler);
        Deposit.addActionListener(handler);
        Display.addActionListener(handler);
        Withdrawal.addActionListener(handler);
        DeleteAcc.addActionListener(handler);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setBounds(100,100,212,300);
        setResizable(false);
        setVisible(true);
    }

    private class ButtonHandler implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == NewAccount)
            {
                setVisible(false);
                new NewAccount();
            }
            if(e.getSource() == Deposit)
            {
                setVisible(false);
                new Deposit();
            }
            if(e.getSource() == Display)
            {
                setVisible(false);
                new Display();
            }
            if(e.getSource() == Withdrawal)
            {
                setVisible(false);
                new Withdrawal();
            }
            if(e.getSource() == DeleteAcc)
            {
                setVisible(false);
                new DeleteAcc();
            }
        }
    }
}

