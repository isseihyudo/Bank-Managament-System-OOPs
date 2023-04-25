package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    
    String pin;
    
    MiniStatement(String pin){
        this.pin = pin;
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel text = new JLabel();
        add(text);
        
        JLabel cardNo = new JLabel();
        //cardNo.setFont(new Font("System", Font.BOLD , Color.BLACK));
        cardNo.setBounds(35, 25, 300, 50);
        add(cardNo);
        
        JLabel statement = new JLabel();
        statement.setBounds(35, 60, 400, 400);
        add(statement);
        
        JLabel balance = new JLabel();
        balance.setBounds(50 , 450 , 300, 20);
        add(balance);
        
        
      
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinNo1 ='"+pin+"'");
            while(rs.next()){
                cardNo.setText("Card Number : " + rs.getString("cardNo1").substring(0, 4) + "XXXX"+rs.getString("cardNo1").substring(8, 12)); 
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        try{
            
            Conn conn = new Conn();
            int bal = 0;            
            ResultSet rs = conn.s.executeQuery("select * from atm where pin ='"+pin+"'");
            while(rs.next()){
                statement.setText(statement.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
        
            balance.setText("Your Current Account Balance : Rs."+ bal );
            

        }catch(Exception e){
            System.out.println(e);
        }
        
        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    
    
    
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
