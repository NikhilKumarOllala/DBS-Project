package easemytrip;


import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            //c =DriverManager.getConnection("jdbc:mysql:///tms","root","root"); 
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/easymytrip","root","Nikhil@02"); 
            
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
} 