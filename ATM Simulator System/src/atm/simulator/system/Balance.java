package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Balance extends JFrame implements ActionListener{
    
    String pin;
    JButton back;
    
    Balance(String pin){
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0 ,750, 750);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(300, 435, 130,25);
        back.addActionListener(this);
        image.add(back);
        
        int balance = 0;
        Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from atm where pin = '"+pin+"'");
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                            }
                    }
                }catch(Exception e){
                        System.out.println(e);
                    }
            
        JLabel text = new JLabel("Your current Account Balance : Rs."+balance);
        text.setBounds(160, 260 ,300, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 12));
        image.add(text);
        
        
        
        setSize(750,710);
        setLocation(250,0);
        setUndecorated(true); 
       
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
        
        
    }
    
    public static void main(String args[]){
        new Balance("");
        
    }
}
