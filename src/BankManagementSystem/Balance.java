package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {
    String cardNo;
    String pinNo;
    JButton back;
    int balance = 0;
    Balance(String cardNo, String pinNo) {
        this.cardNo = cardNo;
        this.pinNo = pinNo;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        Conn c= new Conn();
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where cardNo ='" + cardNo + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel l1 = new JLabel("Your Current Account Balance is Rs "+balance);
        l1.setForeground(Color.WHITE);
        l1.setBounds(170,300,400,30);
        image.add(l1);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,850);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(cardNo, pinNo).setVisible(true);
    }
    public static void main(String[] args) {
        new Balance("","");
    }
}
