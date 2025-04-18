package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupThree extends JFrame implements ActionListener {
    JRadioButton sAcc, fdAcc, cAcc, rAcc;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit,cancel;
    String form_no;
    signupThree(String form_no){
        this.form_no = form_no;
        setLayout(null);
        setTitle("New Account Application: Page 3");
        JLabel formNo = new JLabel("Application Form No. " + form_no);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280,80,400,30);
        add(l1);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100,140,200,30);
        add(accountType);

        sAcc = new JRadioButton("Saving Account");
        sAcc.setFont(new Font("Raleway", Font.BOLD, 14));
        sAcc.setBounds(100,180,150,30);
        sAcc.setBackground(Color.WHITE);
        add(sAcc);

        fdAcc = new JRadioButton("Fixed Deposit Account");
        fdAcc.setFont(new Font("Raleway", Font.BOLD, 14));
        fdAcc.setBounds(350,180,250,30);
        fdAcc.setBackground(Color.WHITE);
        add(fdAcc);

        cAcc = new JRadioButton("Current Account");
        cAcc.setFont(new Font("Raleway", Font.BOLD, 14));
        cAcc.setBounds(100,220,150,30);
        cAcc.setBackground(Color.WHITE);
        add(cAcc);

        rAcc = new JRadioButton("Recurring Deposit Account");
        rAcc.setFont(new Font("Raleway", Font.BOLD, 14));
        rAcc.setBounds(350,220,250,30);
        rAcc.setBackground(Color.WHITE);
        add(rAcc);

        ButtonGroup acc = new ButtonGroup();
        acc.add(sAcc);
        acc.add(fdAcc);
        acc.add(cAcc);
        acc.add(rAcc);

        JLabel Card = new JLabel("Card Number");
        Card.setFont(new Font("Raleway", Font.BOLD, 22));
        Card.setBounds(100,300,200,30);
        add(Card);
        JLabel Number = new JLabel("XXXX-XXXX-XXXX-4184");
        Number.setFont(new Font("Raleway", Font.BOLD, 22));
        Number.setBounds(330,300,300,30);
        add(Number);
        JLabel details = new JLabel("Your 16 digit Card Number");
        details.setFont(new Font("Raleway", Font.BOLD, 12));
        details.setBounds(100,330,300,20);
        add(details);

        JLabel pin = new JLabel("PIN Number");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNumber.setBounds(330,370,300,30);
        add(pinNumber);
        JLabel pindetails = new JLabel("Your 4 digit PIN Number");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100,400,300,20);
        add(pindetails);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100,450,400,30);
        add(services);
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,500,200,30);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,500,200,30);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,550,200,30);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("Email and SMS alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,550,200,30);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,600,200,30);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6 = new JCheckBox("e-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,600,200,30);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above mentioned details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100,680,600,30);
        c7.setBackground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit){
           String accounttype = null;
           if(sAcc.isSelected()){
               accounttype = "Saving Account";
           }else if(fdAcc.isSelected()) {
               accounttype = "Fixed Deposit Account";
           }else if(cAcc.isSelected()){
               accounttype = "Current Account";
           }else if(rAcc.isSelected()){
               accounttype = "Recurring Deposit Account";
           }
           Random random = new Random();
           String cardNo = "" + Math.abs((random.nextLong() % 90000000L)+5040936000000000L);
           String pinNo = "" + Math.abs((random.nextLong() % 9000L)+1000L);
           String services = "";
           if(c1.isSelected()){
               services += " ATM Card";
           }else if(c2.isSelected()){
               services += " Internet Banking";
           }else if(c3.isSelected()){
               services += " Mobile Banking";
           }else if(c4.isSelected()){
               services += " Email and SMS alerts";
           }else if(c5.isSelected()){
               services += " Cheque Book";
           }else if(c6.isSelected()){
               services += " E-Statement";
           }
           try {
               if(accounttype.equals("")){
                   JOptionPane.showMessageDialog(null, "Please enter account type");
               }else{
                   Conn c = new Conn();
                   String query1 = "insert into signupthree values('" + form_no + "', '" + accounttype + "', '" + cardNo + "', '" + pinNo + "', '" + services + "')";
                   String query2 = "insert into login values('" + form_no + "', '" + cardNo + "', '" + pinNo + "')";
                   c.s.executeUpdate(query1);
                   c.s.executeUpdate(query2);
                   JOptionPane.showMessageDialog(null, "Account Created Successfully"+"\nCard Number:"+cardNo+"\nPin:"+pinNo);
                   setVisible(false);
                   new Deposit(cardNo,pinNo).setVisible(true);
               }
           }catch (Exception e) {
               System.out.println(e);
           }
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new signupThree("");
    }
}
