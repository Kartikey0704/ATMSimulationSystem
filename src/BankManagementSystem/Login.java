package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardText;
    JPasswordField pintext;
    Login() {//constructor
        setTitle("ATM Login");
        setLayout(null);
        setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);//to add this icon to frame using label.

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel  cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        cardText = new JTextField();
        cardText.setBounds(300,150,230,30);
        cardText.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardText);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        pintext = new JPasswordField();
        pintext.setBounds(300,220,230,30);
        pintext.setFont(new Font("Arial", Font.BOLD, 14));
        add(pintext);

        login = new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 480);//frame size
        setLocation(350,200);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear) {
            cardText.setText("");
            pintext.setText("");
        }else if(ae.getSource() == login) {
            Conn conn = new Conn();
            String cardno = cardText.getText();
            String pin = pintext.getText();
            String query = "select * from login where cardNo='"+cardno+"' and pin='"+pin+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Transactions(cardno,pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }
            }catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
