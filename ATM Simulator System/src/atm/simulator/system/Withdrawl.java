package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw, back;
    String pin;
    
    Withdrawl(String pin){
        
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0 ,750, 750);
        add(image);
        
        JLabel text = new JLabel("Enter the amount to be withdrawn :");
        text.setBounds(150, 260 ,300, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        amount.setBounds(210,300,150,40);
        image.add(amount);
        
        back = new JButton("Back");
        back.setBounds(130, 435, 130,25);
        back.addActionListener(this);
        image.add(back);
        
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(300, 435, 130,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        
        setSize(750,710);
        setLocation(250,0);
        setUndecorated(true);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        int balance = 0;
        if(ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
            }else{
                    try{
                        Conn conn = new Conn();
                        
                        
                       
                            String query = "insert into atm values('"+pin+"','"+date+"','Withdrawl','"+number+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Rs. "+number+" Withdrawn Successfully");
                        setVisible(false);
                        new Transaction(pin).setVisible(true);
                        
                        
                    }catch(Exception e){
                        System.out.println(e);
                    }
        }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
    }
    }
    
    
    public static void main(String args[]){
        new Withdrawl("");
    }
    
}

