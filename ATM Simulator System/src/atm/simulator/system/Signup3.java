package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {

    Conn conn = new Conn();
    
    JRadioButton saving, fixed, current, recurring;
    JCheckBox atmCard, internetBanking, mobileBanking, emailAlert, chequeBook, eStatement, declaration;
    JButton submit, cancel;

    String accountType1, facility;

    String formNo;


    Signup3(String formNo) {
        this.formNo = formNo;
        setSize(700, 570);
        setLocation(250, 0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setLayout(null);

        JLabel accountDetails = new JLabel("PAGE 3 : ACCOUNT DETAILS");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 38));
        accountDetails.setBounds(75, 20, 600, 40);
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type :");
        accountType.setFont(new Font("Raleway", Font.BOLD, 18));
        accountType.setBounds(100, 100, 180, 30);
        add(accountType);

        saving = new JRadioButton("Savings Account");
        saving.setBounds(140, 150, 200, 30);
        saving.setBackground(Color.WHITE);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(360, 150, 210, 30);
        fixed.setBackground(Color.WHITE);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setBounds(140, 190, 210, 30);
        current.setBackground(Color.WHITE);
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(360, 190, 210, 30);
        recurring.setBackground(Color.WHITE);
        add(recurring);

        ButtonGroup groupAccount = new ButtonGroup();
        groupAccount.add(saving);
        groupAccount.add(fixed);
        groupAccount.add(current);
        groupAccount.add(recurring);

        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 240, 180, 30);
        add(services);

        atmCard = new JCheckBox("ATM Card ");
        atmCard.setBackground(Color.WHITE);
        atmCard.setBounds(140, 280, 100, 30);
        add(atmCard);

        internetBanking = new JCheckBox("Internet Banking ");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setBounds(360, 280, 200, 30);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking ");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setBounds(140, 320, 200, 30);
        add(mobileBanking);

        emailAlert = new JCheckBox("E-Mail / SMS Alert ");
        emailAlert.setBackground(Color.WHITE);
        emailAlert.setBounds(360, 320, 250, 30);
        add(emailAlert);

        chequeBook = new JCheckBox("Cheque Book ");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setBounds(140, 360, 150, 30);
        add(chequeBook);

        eStatement = new JCheckBox("E-Statement ");
        eStatement.setBackground(Color.WHITE);
        eStatement.setBounds(360, 360, 150, 30);
        add(eStatement);

        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        declaration.setFont(new Font("Arial", Font.PLAIN, 12));
        declaration.setBackground(Color.WHITE);
        declaration.setBounds(100, 410, 600, 30);
        add(declaration);

        submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(200, 460, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(360, 460, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        //Generation of card number and 4 digit pin number

}
public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType1 = null;
            if(saving.isSelected()){
                accountType1 = "SavingsAccount";
            }else if(fixed.isSelected()){
                accountType1 = "FixedDepositAccount";
            }else if(current.isSelected()){
                accountType1 = "CurrentAccount";
            }else if(recurring.isSelected()){
                accountType1 = "RecurringDepositAccount";
            }
            Random rn = new Random();
            String cardNo1 = "" + Math.abs(rn.nextLong() % 900000000000L);
            String pinNo1 = "" + Math.abs(rn.nextLong() % 9000L);
            
            facility = "";
            
            if(atmCard.isSelected()){
                facility += " ATMCard";
            }if(internetBanking.isSelected()){
                facility += " InternetBanking";
            }if(mobileBanking.isSelected()){
                facility += " MobileBanking";
            }if(emailAlert.isSelected()){
                facility += " E-Mail/SmsAlert";
            }if(chequeBook.isSelected()){
                facility += " ChequeBook";
            }if(eStatement.isSelected()){
                facility += " E-Statement";
            }
            
            try{
                if(ae.getSource() == submit){
                    if(accountType1.equals("")){
                        JOptionPane.showMessageDialog(null, "Account Type is not selected");
                    }
                    else{
                       
                        String query1 = "insert into Signup3 values('"+formNo+"','"+accountType1+"','"+cardNo1+"','"+pinNo1+"','"+facility+"');";
                        String query2 = "insert into login values('"+formNo+"','"+cardNo1+"','"+pinNo1+"');";
                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "Card Number: "+cardNo1+"\n"+"Pin: "+pinNo1);
                        
                        setVisible(false);
                        new Login().setVisible(true);
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }   
}
    
    
    public static void main(String[] args) {
        new Signup3("");
    }
}
