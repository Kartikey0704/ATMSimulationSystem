package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameText,fnameText,emailText,addressText,cityText,stateText,pinCodeText;
    JDateChooser dateChooser;
    JRadioButton male,female,married,unmarried,others;
    JButton next;

    SignupOne() {
        setLayout(null);
        setTitle("New Account Application: Page 1");

        Random ran  = new Random();
        random = Math.abs((ran.nextLong()%9000L)+1000L);

        JLabel form_no = new JLabel("Application Form No. "+random);
        form_no.setFont(new Font("Raleway", Font.BOLD, 38));
        form_no.setBounds(140,20,600,40);
        add(form_no);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        nameText.setBounds(300,140,400,30);
        add(nameText);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        fnameText = new JTextField();
        fnameText.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameText.setBounds(300,190,400,30);
        add(fnameText);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 14));
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 14));
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        emailText.setBounds(300,340,400,30);
        add(emailText);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 14));
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 14));
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        others = new JRadioButton("Other");
        others.setFont(new Font("Raleway", Font.BOLD, 14));
        others.setBounds(630,390,100,30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD, 14));
        addressText.setBounds(300,440,400,30);
        add(addressText);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        cityText.setBounds(300,490,400,30);
        add(cityText);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        stateText.setBounds(300,540,400,30);
        add(stateText);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        pinCodeText = new JTextField();
        pinCodeText.setFont(new Font("Raleway", Font.BOLD, 14));
        pinCodeText.setBounds(300,590,400,30);
        add(pinCodeText);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,200);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String form_no = ""+random;
        String name = nameText.getText();
        String fName = fnameText.getText();
        String email = emailText.getText();
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pinCode = pinCodeText.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = male.isSelected()?"Male":"Female";
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        }else if(others.isSelected()){
            marital = "Other";
        }

        try{
            if(name.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter your name");
            }else {
                Conn c = new Conn();
                String query = "insert into signup values('" + form_no + "', '" + name + "', '" + fName + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + pinCode + "', '" + state + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(form_no).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
