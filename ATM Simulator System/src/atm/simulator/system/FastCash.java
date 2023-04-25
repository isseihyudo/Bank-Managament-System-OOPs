package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton amount1,amount2, amount3, amount4, amount5, amount6, back;
    String pin;
    
    FastCash(String pin){
        
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0 ,750, 750);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount :");
        text.setBounds(165, 260 ,300, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        amount1 = new JButton("Rs.100");
        amount1.setBounds(130, 345, 130,25);
        amount1.addActionListener(this);
        image.add(amount1);
        
        amount2 = new JButton("Rs.500");
        amount2.setBounds(130, 375, 130,25);
        amount2.addActionListener(this);
        image.add(amount2);
        
        amount3 = new JButton("Rs.1000");
        amount3.setBounds(130, 405, 130,25);
        amount3.addActionListener(this);
        image.add(amount3);
        
        amount4 = new JButton("Rs.2000");
        amount4.setBounds(300, 345, 130,25);
        amount4.addActionListener(this);
        image.add(amount4);
        
        amount5 = new JButton("Rs.5000");
        amount5.setBounds(300, 375, 130,25);
        amount5.addActionListener(this);
        image.add(amount5);
        
        amount6 = new JButton("Rs.10000");
        amount6.setBounds(300, 405, 130,25);
        amount6.addActionListener(this);
        image.add(amount6);
        
        back = new JButton("Back");
        back.setBounds(300, 435, 130,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(750,710);
        setLocation(250,0);
        setUndecorated(true); 
       
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }else{
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from atm where pin = '"+pin+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
            if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            
            Date date = new Date();
            String query = "insert into atm values('"+pin+"','"+date+"','Withdrawl', '"+amount+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs."+amount + " Debited Successfully");
            
            setVisible(false);
            new Transaction(pin).setVisible(true);
                        
            }catch(Exception e){
                System.out.println(e);
            }
                    
        }
    }

    public static void main(String args[]){
        new FastCash("");
        
    }
    
}