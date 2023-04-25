package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Signup2 extends JFrame implements ActionListener{
    //Declaring variables globally
    JTextField pan1, aadhar1, senior1, existingAccount1 ;
    JComboBox religion1, category1, income1, education1, occupation1;
    JRadioButton yes1, no1, yes2, no2;
    JButton next;
    String formNo;
    
    Signup2(String formNo){
        
        this.formNo = formNo;
        setLayout(null);        
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        //Creating Labels
        JLabel additionalDetails = new JLabel("PAGE 2 : ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD , 38));
        additionalDetails.setBounds(140 ,20 ,600 ,40);
        add(additionalDetails);
        
//        JLabel personalDetails = new JLabel("PAGE 1: PERSONAL DETAILS");
//        personalDetails.setFont(new Font("Raleway", Font.BOLD ,22));
//        personalDetails.setBounds(265 , 80, 400, 30);
//        add(personalDetails);
        
        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD , 20));
        religion.setBounds(180 ,80 , 100 , 30);
        add(religion);
        
        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(170 , 130 , 150 , 30);
        add(category);
        
        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD, 20));
        income.setBounds(185 , 180 , 150 , 30);
        add(income);
        
        JLabel education = new JLabel("Educational \nQualification :");
        education.setFont(new Font("Raleway",Font.BOLD , 20));
        education.setBounds(20 ,230 , 280 , 30);
        add(education);
        
        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway",Font.BOLD , 20));
        occupation.setBounds(145 ,280 , 220 , 30);
        add(occupation);
        
        JLabel pan = new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway",Font.BOLD , 20));
        pan.setBounds(135 ,330 , 180 , 30);
        add(pan);
        
        JLabel aadhar = new JLabel("Aadhar Number :");
        aadhar.setFont(new Font("Raleway",Font.BOLD , 20));
        aadhar.setBounds(105 ,380 , 190 , 30);
        add(aadhar);
        
        JLabel senior = new JLabel("Senior Citizen :");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(120, 430 , 150 , 30);
        add(senior);
                         
        JLabel existingAccount = new JLabel("Existing Account :");
        existingAccount.setFont(new Font("Raleway",Font.BOLD , 20));
        existingAccount.setBounds(90 ,480 , 200 , 30);
        add(existingAccount);
        
        
        
        
        
        
//        JLabel pincode = new JLabel("Pincode :");
//        pincode.setFont(new Font("Raleway",Font.BOLD , 20));
//        pincode.setBounds(163 ,530 , 100 , 30);
//        add(pincode);
        
        
        
        
        //Creating text fields for taking user input
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion1 = new JComboBox(valReligion); //Using combo box for drop down input
        religion1.setBounds(280 , 80 , 450 , 30 );
        religion1.setBackground(Color.WHITE);
        add(religion1);
        
        String valCategory[] = {"General","OBC", "SC", "ST", "Others"};
        category1 = new JComboBox(valCategory);
        category1.setBounds(280 , 130 , 450 , 30 );
        category1.setBackground(Color.WHITE);
        add(category1);
        
        String valIncome[] = {"Null", ">1,50,000",">2,50,000",">5,00,000","Upto 10,00,000"};
        income1 = new JComboBox(valIncome);
        income1.setBounds(280 , 180 , 450 , 30 );
        income1.setBackground(Color.WHITE);
        add(income1);
        
        String valEducation[] = {"None","Non-Graduate","Graduate","Post-Graduate","Doctorate","Others"};
        education1 = new JComboBox(valEducation);
        education1.setBounds(280 , 230 , 450 , 30 );
        education1.setBackground(Color.WHITE);
        add(education1);
        
        String valOccupation[] = {"Salaried", "Self-Employed", "Business", "Retired", "Student", "Others"};
        occupation1 = new JComboBox(valOccupation);
        occupation1.setBounds(280 , 280 , 450 , 30 );
        occupation1.setBackground(Color.WHITE);
        add(occupation1);
        
        pan1 = new JTextField();
        pan1.setBounds(280 , 330 , 450 , 30 );
        add(pan1);
        
        aadhar1 = new JTextField();
        aadhar1.setBounds(280 , 380 , 450 , 30 );
        add(aadhar1);
        
        //Radio Button for citizenship type input
        yes1 = new JRadioButton("Yes");
        yes1.setBounds(280 , 430 , 70 , 30);
        yes1.setBackground(Color.WHITE);
        add(yes1);
        
        no1 = new JRadioButton("No");
        no1.setBounds(380 , 430 , 70 , 30);
        no1.setBackground(Color.WHITE);
        add(no1);
                        
        //Adding buttongroup for choosing single option only
        ButtonGroup senior1 = new ButtonGroup();
        senior1.add(yes1);
        senior1.add(no1);
                                
        //Radio Button for taking existing account input
        yes2 = new JRadioButton("Yes");
        yes2.setBounds(280 , 480 , 70 , 30);
        yes2.setBackground(Color.WHITE);
        add(yes2);
        
        no2 = new JRadioButton("No");
        no2.setBounds(380 , 480 , 100 , 30);
        no2.setBackground(Color.WHITE);
        add(no2);
        
        //Adding buttongroup for choosing single option only
        ButtonGroup existingAccount1 = new ButtonGroup();
        existingAccount1.add(yes2);
        existingAccount1.add(no2);

        
        
        
        
        
        
        
        
        
        
        
        next = new JButton("Next");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD, 18));
        next.setBounds(400, 550, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
     
        
        
        //Creating frame
        getContentPane().setBackground(Color.WHITE);
        setSize(850 , 650);
        setLocation(250 ,10); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        //Storing inputs taken from the user
        String religion = (String) religion1.getSelectedItem();
        String category = (String) category1.getSelectedItem();
        String senior = null;
        if(yes1.isSelected()){
            senior = "Yes";
        }else if(no1.isSelected()){
            senior = "No";
        }
        
        String income = (String) income1.getSelectedItem();
        
        String existingAccount = null;
        if(yes2.isSelected()){
            existingAccount = "Yes";
        }else if(no2.isSelected()){
            existingAccount = "No";
        }
        
        String education = (String) education1.getSelectedItem();
        
        String occupation = (String) occupation1.getSelectedItem();
        
        String pan = pan1.getText();
        
        String aadhar = aadhar1.getText();
        
        
        
        Conn c = new Conn();
        try{
            //Adding validation for letting user know that certain information is not filled out
            if (category.equals("")){
                JOptionPane.showMessageDialog(null, "Religion is required");
            }else if(category.equals("")){
                JOptionPane.showMessageDialog(null, "Category is required");
            }else if(income.equals("")){
                JOptionPane.showMessageDialog(null, "Income is required");
            }else if(education.equals("")){
                JOptionPane.showMessageDialog(null, "Educational Qualification is required");
            }else if(occupation.equals("")){
                JOptionPane.showMessageDialog(null, "Occupation is required");
            }else if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN Number is required");
            }else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhar Number is required");
            }else{
                //Conn c = new Conn();
                String query = "insert into signup2 values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+existingAccount+"','"+senior+"')";
                c.s.executeUpdate(query); 
                setVisible(false);
                //Signup3 object
                
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        new Signup3(formNo).setVisible(true);
    }
    
    public static void main(String[] args) {
      
        new Signup2("");
        
    }

   
}

