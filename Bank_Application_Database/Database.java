   
import java.sql.*;
import java.io.*;

public class Database
{
    Display2 displayinfo = new Display2();
    String acc,date,age,name,add,bala;
    String SQLStatement;
    
    public void AddCustomerEntry(String s1,String s2,String s3,String s4)
    {
        System.out.println(" "+s1+" "+s2+" "+s3+" "+s4);
        
        String url="jdbc:odbc:BankDatabase";
        String driver="sun.jdbc.odbc.JdbcOdbcDriver";
        
        int i=0;
        
        try
        {
            String acc;
            FileReader fr = new FileReader("ACCOUNT_NUMBER.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((acc = br.readLine()) != null) 
            {
                System.out.println(acc); 
                try
                {
                    i = Integer.parseInt(acc);
                    i++;
                }
                catch(NumberFormatException e2)
                { }
                try
                {
                
                    String SQLStatement="INSERT INTO CustomerInfo VALUES" +
                        "('"+s1+"','"+acc+"','"+s2+"','"+s3+"','"+s4+"')";
                    System.out.println(SQLStatement);
                    Class.forName(driver);
                    Connection connection=DriverManager.getConnection(url);
                    Statement statement=connection.createStatement();
                    statement.executeUpdate(SQLStatement);
                    connection.close();
                }

                catch(ClassNotFoundException cnfe)
                {
                    System.out.println(cnfe);
                }

                catch(SQLException squl)
                {
                    System.out.println("HI"+squl);
                }
                
            try
            {
                String s = "0";
                 String SQLStatement="INSERT INTO BalanceInfo VALUES" +
                 "('"+s1+"','"+acc+"','"+s+"')";
                 System.out.println(SQLStatement);
                 Class.forName(driver);
                 Connection connection1=DriverManager.getConnection(url);
                 Statement statement=connection1.createStatement();
                 statement.executeUpdate(SQLStatement);
                 connection1.close();
            }
            catch(ClassNotFoundException cnfe)
            {
                System.out.println(cnfe);
            }

            catch(SQLException squl)
            {
                System.out.println("HI"+squl);
            }
            }    
        }
        catch(IOException e)
        {
            System.out.println("File Not Found");
        }
        try
        {
            String str = Integer.toString(i);
            FileWriter fw = new FileWriter("ACCOUNT_NUMBER.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();
        }
        catch(IOException e1)
        { }     
    }
    
    public void AddAmmountEntry(String s1,String s2,String s3,String s4)
    {
        System.out.println(" "+s1+" "+s2+" "+s3+" "+s4);
        String Balance = null;
        String url="jdbc:odbc:BankDatabase";
        String driver="sun.jdbc.odbc.JdbcOdbcDriver";
        String name = null;
        ResultSet Result = null;
        
        try
        {
             String SQLStatement="SELECT Name FROM CustomerInfo WHERE Account_Num='"+s1+"'";
             System.out.println(SQLStatement);
             Class.forName(driver);
             Connection connection1=DriverManager.getConnection(url);
             Statement statement=connection1.createStatement();
             Result = statement.executeQuery(SQLStatement);
             
             while(Result.next()) 
             {
                name = Result.getObject(1).toString();
                System.out.println(" "+name);
             }
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }

        catch(SQLException squl)
        {
            System.out.println("HI"+squl);
        }
        
        try
        {
             String SQLStatement = "INSERT INTO DepositInfo VALUES" +
             "('"+name+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
             String SQLStatement2 = "SELECT Balance FROM BalanceInfo WHERE Account_Num ='"+s1+"'"; 
             System.out.println(SQLStatement);
             Class.forName(driver);
             Connection connection1=DriverManager.getConnection(url);
             Statement statement=connection1.createStatement();
             statement.executeUpdate(SQLStatement);
             Result = statement.executeQuery(SQLStatement2);
             
             while(Result.next()) 
             {
                Balance = Result.getObject(1).toString();
                 System.out.println("HI"+Balance);
             }
             
             connection1.close();
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }

        catch(SQLException squl)
        {
            System.out.println("HI"+squl);
        }
        
        System.out.println("HI"+Balance);
        try
        {
             int s41 = Integer.parseInt(s4);
             int Balance1 = Integer.parseInt(Balance);
             Balance1 = Balance1+s41;
             String Balance2 = Integer.toString(Balance1);
             String SQLStatement="UPDATE BalanceInfo SET Balance = '"+Balance2+"' WHERE Account_Num='"+s1+"'";
             System.out.println(SQLStatement);
             Class.forName(driver);
             Connection connection1=DriverManager.getConnection(url);
             Statement statement=connection1.createStatement();
             statement.executeUpdate(SQLStatement);
             connection1.close();
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }

        catch(SQLException squl)
        {
            System.out.println("HI"+squl);
        }
     }
    
    public void DELETE_ACCEntry(String s1)
    {
        System.out.println(" "+s1);
        
        String url="jdbc:odbc:BankDatabase";
        String driver="sun.jdbc.odbc.JdbcOdbcDriver";
        int acc = Integer.parseInt(s1);
        
        try
        {
             String SQLStatement="DELETE * FROM CustomerInfo WHERE Account_Num='"+s1+"'";
             System.out.println(SQLStatement);
             System.out.println(acc);
             Class.forName(driver);
             Connection connection1=DriverManager.getConnection(url);
             Statement statement=connection1.createStatement();
             statement.executeUpdate(SQLStatement);
             connection1.close();
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }

        catch(SQLException squl)
        {
            System.out.println("HI"+squl);
        }
     }
    
    public void WithdrawAmmountEntry(String s1,String s2,String s3,String s4)
    {
        System.out.println(" "+s4);
        
        String url="jdbc:odbc:BankDatabase";
        String driver="sun.jdbc.odbc.JdbcOdbcDriver";
        String amm = null;
        String name = null;
        ResultSet Result = null;
        
        try
        {
             String SQLStatement="SELECT Name,Balance FROM BalanceInfo WHERE Account_Num='"+s1+"'";
             System.out.println(SQLStatement);
             Class.forName(driver);
             Connection connection1=DriverManager.getConnection(url);
             Statement statement=connection1.createStatement();
             Result = statement.executeQuery(SQLStatement);
             
             while(Result.next()) 
             {
                amm = Result.getObject(2).toString();
                name = Result.getObject(1).toString();
                System.out.println(amm+" "+name);
             }
             
             int amm1 = Integer.parseInt(amm);
             int s41 = Integer.parseInt(s4);
             
             if(amm1 >= s41)
             {
                 amm1 = amm1-s41;
                 String amm2 = Integer.toString(amm1);
                 try
                 {
                     String SQLStatement1="UPDATE BalanceInfo SET Balance = '"+amm2+"' WHERE Account_Num='"+s1+"'";
                     System.out.println(SQLStatement1);
                     Class.forName(driver);
                     Connection connection2=DriverManager.getConnection(url);
                     Statement statement1=connection2.createStatement();
                     statement1.executeQuery(SQLStatement1);
                 
                     connection2.close();
                 }
                catch(ClassNotFoundException cnfe)
                {
                     System.out.println(cnfe);
                }

                catch(SQLException squl)
                {
                     System.out.println("HI"+squl);
                }
            }

        connection1.close();
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }

        catch(SQLException squl)
        {
            System.out.println("HI"+squl);
        }
        
        try
        {
             String SQLStatement="INSERT INTO WithdrawInfo VALUES" +
             "('"+name+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
             System.out.println(SQLStatement);
             Class.forName(driver);
             Connection connection1=DriverManager.getConnection(url);
             Statement statement=connection1.createStatement();
             statement.executeUpdate(SQLStatement);
             connection1.close();
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }

        catch(SQLException squl)
        {
            System.out.println("HI"+squl);
        }
     }
    
    public void DisplayInfo(String s,int i)
    {
        System.out.println("HHH"+s);
        String url="jdbc:odbc:BankDatabase";
        String driver="sun.jdbc.odbc.JdbcOdbcDriver";
        ResultSet Result;
        
        try
        {
            if(i==1)
             SQLStatement="SELECT * FROM CustomerInfo WHERE Account_Num='"+s+"'";
            else if(i==2)
             SQLStatement="SELECT * FROM BalanceInfo WHERE Account_Num='"+s+"'";
             System.out.println(SQLStatement);
             Class.forName(driver);
             Connection connection1=DriverManager.getConnection(url);
             Statement statement=connection1.createStatement();
             Result = statement.executeQuery(SQLStatement);
             
             if(i==1)
             {
                while(Result.next()) 
                {
                    name = Result.getObject(1).toString();
                    acc = Result.getObject(2).toString();
                    date = Result.getObject(3).toString();
                    add = Result.getObject(4).toString();
                    age = Result.getObject(5).toString();
                }
             }
             else if(i==2)
             {
                 while(Result.next()) 
                {
                    name = Result.getObject(1).toString();
                    acc = Result.getObject(2).toString();
                    bala = Result.getObject(3).toString();
                }
             }
             connection1.close();
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }

        catch(SQLException squl)
        {
            System.out.println("HI"+squl);
        }
        if(i==1)
         displayinfo.displayaccount(name,acc,date,add,age);
        else if(i==2)
         displayinfo.displaybalance(name,acc,bala);  
    }
}
