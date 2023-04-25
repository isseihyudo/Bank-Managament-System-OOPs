
package atm.simulator.system;
import javax.swing.*; //importing java swing packages
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login ,clear ,signup; //Defining the buttons globally
    JTextField card; //Defining the buttons globally
    JPasswordField pinNo; //Defining as password field for hiding the password
    
    String pin;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE"); //Setting the title of the frame
        
        setLayout(null); //Removing the default layout
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm/simulator/system/Icons/Login.jfif"));//Applying image on the frame
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //Creating object for image class and scaling the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        
        label.setBounds(70,10,100,100); //Changing the loaction of icon on the frame
        add(label); //Placing image on the frame
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Castellar",Font.BOLD,30)); //Setting font characteristics
        text.setBounds(200 ,40 ,400 ,40); //Setting the location of the text
        add(text);//Adding text on the frame
        
        JLabel cardNo = new JLabel("Card Number :");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28)); //Setting font characteristics
        cardNo.setBounds(120 ,150 ,220 ,40); //Setting the location of the text
        add(cardNo);//Adding text on the frame
        
        card = new JTextField(); //Creating box for taking input from the user
        card.setBounds(330 , 150 , 210 ,40);
        card.setFont(new Font("Calibri",Font.BOLD,28));//Setting font characteristics of the input from the user
        add(card);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28)); //Setting font characteristics
        pin.setBounds(250 ,220 ,200 ,40); //Setting the location of the text
        add(pin);//Adding text on the frame
        
        pinNo = new JPasswordField(); //Creating box for taking input from the user
        pinNo.setBounds(330 , 220 , 210 ,40);
        pinNo.setFont(new Font("Calibri",Font.BOLD,28)); //Setting font characteristics of the input from the user
        add(pinNo);
        
        login = new JButton("Sign In");
        login.setBounds(330, 300 , 100 , 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); //Add action to the button
        add(login);
        
        clear = new JButton("Clear All");
        clear.setBounds(440, 300 , 100 , 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this); //Adding action to the button
        add(clear);
        
        signup = new JButton("Sign Up");
        signup.setBounds(330, 350 , 210 , 40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this); //Adding action to the button
        add(signup);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480); //Creating a frame and setting its dimension
        setVisible(true); //Displaying the frame
        setLocation(350, 200); //Changing the origin location of the frame
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear){
            card.setText("");
            pinNo.setText("");
            
        }else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardNo = card.getText();
            pin = pinNo.getText();
            String query = "select * from login where cardNo1 = '"+cardNo+"' and pinNo1 = '"+pin+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true); 
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Credentials");
                }
                
            }catch(Exception e){
                System.out.println(e);
                }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new Signup1().setVisible(true);
        }
    } //Method overriding
    
    
    public static void main(String args[]){
        new Login();
    }
}
