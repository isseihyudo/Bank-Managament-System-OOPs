package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balance, exit;
    String pin;
    
    Transaction(String pin){
        
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0 ,750, 750);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(165, 260 ,300, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(130, 345, 130,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(130, 375, 130,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(130, 405, 130,25);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(300, 345, 130,25);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(300, 375, 130,25);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(300, 405, 130,25);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(300, 435, 130,25);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(750,710);
        setLocation(250,0);
        setUndecorated(true); 
       
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true); 
        }else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource() == balance){
            setVisible(false);
            new Balance(pin).setVisible(true);
        }else if(ae.getSource() == miniStatement){
            new MiniStatement(pin).setVisible(true);
        }
    }

    public static void main(String args[]){
        new Transaction("");
        
    }
    
}