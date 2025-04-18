package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdraw, miniStatement,fastcash,balance,pinChange,exit;
    String cardNo;
    String pinNo;
    Transactions(String cardNo, String pinNo){
        this.cardNo = cardNo;
        this.pinNo = pinNo;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balance = new JButton("Balance");
        balance.setBounds(355,485,150,30);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,850);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(cardNo,pinNo).setVisible(true);
        }else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdrawl(cardNo,pinNo).setVisible(true);
        }else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(cardNo,pinNo).setVisible(true);
        }else if (ae.getSource() == miniStatement) {
            new MiniStatement(cardNo,pinNo).setVisible(true);
        }else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(cardNo,pinNo).setVisible(true);
        }else if (ae.getSource() == balance) {
            setVisible(false);
            new Balance(cardNo,pinNo).setVisible(true);
        }else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Transactions("","");
    }
}
