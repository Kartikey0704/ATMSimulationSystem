package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    MiniStatement(String cardNo, String pinNo){
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bankName = new JLabel("Bank Name");
        bankName.setBounds(150,20,100,20);
        add(bankName);

        JLabel cardNumber = new JLabel("Card Number: "+cardNo.substring(0,4)+"XXXXXXXX"+cardNo.substring(12));
        cardNumber.setBounds(20,80,300,20);
        add(cardNumber);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        Conn conn = new Conn();
        try{
            StringBuilder statement = new StringBuilder("<html>");
            ResultSet rs = conn.s.executeQuery("SELECT * FROM (SELECT * FROM bank WHERE cardNo='" + cardNo + "' ORDER BY date DESC LIMIT 5) AS temp ORDER BY date ASC");
                while (rs.next()) {
                    statement.append(rs.getString("date"))
                            .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append(rs.getString("type"))
                            .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                            .append(rs.getString("amount"))
                            .append("<br><br>");
                }
                statement.append("</html>");
                mini.setText(statement.toString());
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where cardNo ='" + cardNo + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance: "+bal);
        }catch (Exception e){
            System.out.println(e);
        }

        mini.setBounds(20,140,400,180);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {}
    public static void main(String[] args) {
        new MiniStatement("","");
    }
}

