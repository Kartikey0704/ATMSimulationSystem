package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton fiveH, oneTh, twoTh, fifteenH, tenTh, fiveTh, back;
    String cardNo;
    String pinNo;
    FastCash(String cardNo,String pinNo){
        this.cardNo = cardNo;
        this.pinNo = pinNo;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select Withdrawl amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        fiveH = new JButton("500");
        fiveH.setBounds(170,415,150,30);
        fiveH.addActionListener(this);
        image.add(fiveH);

        oneTh = new JButton("1000");
        oneTh.setBounds(355,415,150,30);
        oneTh.addActionListener(this);
        image.add(oneTh);

        fifteenH = new JButton("1500");
        fifteenH.setBounds(170,450,150,30);
        fifteenH.addActionListener(this);
        image.add(fifteenH);

        twoTh = new JButton("2000");
        twoTh.setBounds(355,450,150,30);
        twoTh.addActionListener(this);
        image.add(twoTh);

        fiveTh = new JButton("5000");
        fiveTh.setBounds(170,485,150,30);
        fiveTh.addActionListener(this);
        image.add(fiveTh);

        tenTh = new JButton("10000");
        tenTh.setBounds(355,485,150,30);
        tenTh.addActionListener(this);
        image.add(tenTh);

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
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(cardNo,pinNo).setVisible(true);
        }else{
            String amt = ((JButton)ae.getSource()).getText();
            Conn c= new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where CardNo='"+cardNo+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!= back && balance<Integer.parseInt(amt)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date =new Date();
                String Query = "insert into bank values('"+cardNo+"', '"+date+"','Withdrawl', '"+amt+"')";
                c.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null,"Rs "+amt+" debited Successful");
                setVisible(false);
                new Transactions(cardNo,pinNo).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("","");
    }
}
