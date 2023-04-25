package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class Signup1 extends JFrame implements ActionListener{
    //Declaring variables globally
    Long random;
    JTextField name1 , fname1, email1, address1, city1, state1, pincode1;
    JRadioButton male, female, other1, married, unmarried, other2;
    JDateChooser dob1;
    JButton next;
    
    Signup1(){
        setLayout(null);
        
        
        
        Random rn = new Random();
        random = Math.abs(rn.nextLong() %9000L)+1000L;
        
        
        //Creating Labels
        JLabel formNo = new JLabel("APPLICATION FORM NO. "+random);
        formNo.setFont(new Font("Raleway", Font.BOLD , 38));
        formNo.setBounds(140 ,20 ,600 ,40);
        add(formNo);
        
        JLabel personalDetails = new JLabel("PAGE 1: PERSONAL DETAILS");
        personalDetails.setFont(new Font("Raleway", Font.BOLD ,22));
        personalDetails.setBounds(265 , 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD , 20));
        name.setBounds(198 ,140 , 100 , 30);
        add(name);
        
        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(115 , 190 , 150 , 30);
        add(fname);
        
        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(130 , 240 , 150 , 30);
        add(dob);
        
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(178, 290 , 150 , 30);
        add(gender);
         
        JLabel email = new JLabel("E-Mail Address :");
        email.setFont(new Font("Raleway",Font.BOLD , 20));
        email.setBounds(104 ,340 , 180 , 30);
        add(email);
         
        JLabel mstatus = new JLabel("Marital Status :");
        mstatus.setFont(new Font("Raleway",Font.BOLD , 20));
        mstatus.setBounds(115 ,390 , 150 , 30);
        add(mstatus);
        
        JLabel address = new JLabel("Residential Address :");
        address.setFont(new Font("Raleway",Font.BOLD , 20));
        address.setBounds(55 ,440 , 220 , 30);
        add(address);
        
        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD , 20));
        city.setBounds(205 ,490 , 100 , 30);
        add(city);
        
        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD , 20));
        state.setBounds(193 ,540 , 100 , 30);
        add(state);
        
        JLabel pincode = new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway",Font.BOLD , 20));
        pincode.setBounds(163 ,590 , 100 , 30);
        add(pincode);
        
        
        
        
        //Creating text fields for taking user input
        name1 = new JTextField();
        name1.setBounds(280 , 140 , 450 , 30 );
        add(name1);
        
        fname1 = new JTextField();
        fname1.setBounds(280 , 190 , 450 , 30 );
        add(fname1);
        
        dob1 = new JDateChooser();
        dob1.setBounds(280 ,240 ,450 , 30);
        dob1.setForeground(new Color(105, 105, 105));
        add(dob1);
        
        //Radio Button for gender input
        male = new JRadioButton("Male");
        male.setBounds(280 , 290 , 70 , 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(380 , 290 , 70 , 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other1 = new JRadioButton("Others");
        other1.setBounds(500 , 290 , 70 , 30);
        other1.setBackground(Color.WHITE);
        add(other1);
        
        //Adding buttongroup for choosing single gender only
        ButtonGroup gender1 = new ButtonGroup();
        gender1.add(male);
        gender1.add(female);
        gender1.add(other1);
          
       
        email1 = new JTextField();
        email1.setBounds(280 , 340 , 450 , 30 );
        add(email1);
        
        //Radio Button for taking marital status input
        married = new JRadioButton("Married");
        married.setBounds(280 , 390 , 70 , 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(380 , 390 , 100 , 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other2 = new JRadioButton("Others");
        other2.setBounds(500 , 390 , 70 , 30);
        other2.setBackground(Color.WHITE);
        add(other2);
        
        //Adding buttongroup for choosing single option only
        ButtonGroup mstatus1 = new ButtonGroup();
        mstatus1.add(married);
        mstatus1.add(unmarried);
        mstatus1.add(other2);
        
        address1 = new JTextField();
        address1.setBounds(280 , 440 , 450 , 30 );
        add(address1);
        
        city1 = new JTextField();
        city1.setBounds(280 , 490 , 450 , 30 );
        add(city1);
        
        state1 = new JTextField();
        state1.setBounds(280 , 540 , 450 , 30 );
        add(state1);
        
        pincode1 = new JTextField();
        pincode1.setBounds(280 , 590 , 450 , 30 );
        add(pincode1);
        
        
        
        
        next = new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD, 18));
        next.setBounds(375, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
     
        
        
        //Creating frame
        getContentPane().setBackground(Color.WHITE);
        setSize(850 , 750);
        setLocation(250 ,10); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        //Storing inputs taken from the user
        String formNo = ""+random;
        String name = name1.getText();
        String fname = fname1.getText();
        String dob = ((JTextField)dob1.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }else if(other1.isSelected()){
            gender = "Others";
        }
        
        String email = email1.getText();
        
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else if(other2.isSelected()){
            marital = "Others";
        }
        
        String address = address1.getText();
        
        String city = city1.getText();
        
        String state = state1.getText();
        
        String pincode = pincode1.getText();
        
        Conn c = new Conn();
        try{
            //Adding validation for letting user know that certain information is not filled out
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's name is required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth is required");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City name is required");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State name is required");
            }else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null, "Pincode is required");
            }else{
                
                String query = "insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup2(formNo).setVisible(true);
                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
      
        new Signup1();
        
    }

   
}
