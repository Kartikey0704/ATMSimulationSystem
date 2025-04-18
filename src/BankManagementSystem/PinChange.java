package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    String cardNo;
    String pinNo;
    JButton change,back;
    JPasswordField newPin,rePin;
    PinChange(String cardNo,String pin) {
        this.cardNo = cardNo;
        this.pinNo = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CREATE NEW PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pinText = new JLabel("Enter New Pin");
        pinText.setBounds(165,320,180,25);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(pinText);

        newPin = new JPasswordField();
        newPin.setFont(new Font("Raleway", Font.BOLD, 25));
        newPin.setBounds(330,320,180,25);
        image.add(newPin);

        JLabel repinText = new JLabel("Re-Enter New Pin");
        repinText.setBounds(165,360,180,25);
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        image.add(repinText);

        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 25));
        rePin.setBounds(330,360,180,25);
        image.add(rePin);

        change = new JButton("Change Pin");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

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
        if(ae.getSource() == change) {
            try{
                String newPinText = newPin.getText();
                String rePinText = rePin.getText();
                if(!newPinText.equals(rePinText)) {
                    JOptionPane.showMessageDialog(null,"Entered PIN DOES NOT MATCH");
                    return;
                }
                if(newPinText.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN ");
                    return;
                }
                if(rePinText.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter PIN ");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update login set pin = '"+newPinText+"' where cardNo = '"+cardNo+"'";
                String query2 = "update signupthree set pin = '"+newPinText+"' where cardNo = '"+cardNo+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");
                setVisible(false);
                new Transactions(cardNo,newPinText).setVisible(true);
            }catch (Exception e) {
                System.out.println(e);
            }
        }else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(cardNo,pinNo).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("","").setVisible(true);
    }
}
