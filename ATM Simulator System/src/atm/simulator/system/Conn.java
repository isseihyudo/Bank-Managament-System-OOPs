package atm.simulator.system;
//Steps for JDB Connectivity
//1 Register the driver
//2 Create connection
//3 Create statement
//4 Execute query
//5 Close connection

import java.sql.*;


public class Conn{
    
Connection c;
Statement s;
//Constructor Connection
    public Conn(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver); //Driver registration
           
            c = DriverManager.getConnection("jdbc:mysql:///atmsimulatorsystem","root","appleappl");//DB connection
            s = c.createStatement();//Statement creation
        }catch(Exception e){
            System.out.println(e);
        }
        
    }


    
   
   
}
