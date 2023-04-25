package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener{
    
    
    JPasswordField newPin, newPin1;
    JButton back, change;
    String pin1, pin2;
    String pin;
    
    PinChange(String pin){
        
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0 ,750, 750);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(205, 260 ,300, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel text1 = new JLabel("NEW PIN :");
        text1.setBounds(215, 330 ,100, 25);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System", Font.BOLD, 14));
        image.add(text1);
        
        JLabel text2 = new JLabel("RE-ENTER NEW PIN :");
        text2.setBounds(140, 375 ,150, 25);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System", Font.BOLD, 14));
        image.add(text2);
        
        newPin = new JPasswordField();
        newPin.setFont(new Font("Raleway", Font.BOLD, 20));
        newPin.setBounds(290,330,100,25);
        image.add(newPin);
        
        newPin1 = new JPasswordField();
        newPin1.setFont(new Font("Raleway", Font.BOLD, 20));
        newPin1.setBounds(290,375 ,100,25);
        image.add(newPin1);
        
        back = new JButton("Back");
        back.setBounds(130, 435, 130,25);
        back.addActionListener(this);
        image.add(back);
        
        
        change = new JButton("Change");
        change.setBounds(300, 435, 130,25);
        change.addActionListener(this);
        image.add(change);
        
        
        setSize(750,710);
        setLocation(250,0);
        setUndecorated(true);
        setVisible(true);
       
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
            
            if(ae.getSource() == change){
                try{
                    pin1 = newPin.getText();
                    pin2 = newPin1.getText();

                    if(!pin1.equals(pin2)){
                        JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                        return;
                    }
                    
                    if(pin1.equals("")){
                        JOptionPane.showMessageDialog(null, "Please enter new PIN");
                        return;          
                    }
                    
                    if(pin2.equals("")){
                        JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                        return;
                    }
                    
                    Conn conn = new Conn();
                    
                    String query1 = "update atm set pin = '"+pin2+"' where pin = '"+pin+"'";
                    String query2 = "update login set pinNo1 = '"+pin2+"' where pinNo1 = '"+pin+"'";
                    String query3 = "update signup3 set pinNo1 = '"+pin2+"' where pinNo1 = '"+pin+"'";
                    
                  
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "New PIN set successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);


                    }catch(Exception e){
                        System.out.println(e);
                    }
            
            }else if(ae.getSource() == back){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                    
            }
                
        }
        
            
    

    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
    
}
