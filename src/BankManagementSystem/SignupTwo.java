package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField panText, aadharText;
    JRadioButton sYes,sNo,eYes,eNo;
    JButton next;
    JComboBox religionCombo, categoryCombo,incomeCombo,educationCombo,occupationCombo;
    String form_no;

    SignupTwo(String form_no) {
        this.form_no = form_no;
        setLayout(null);
        setTitle("New Account Application: Page 2");

        JLabel formNo = new JLabel("Application Form No. "+form_no);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,140,100,30);
        add(religion);
        String valReligion [] = {"Hindu", "Muslim", "Christian", "Sikh", "Other"};
        religionCombo = new JComboBox(valReligion);
        religionCombo.setBounds(300,140,400,30);
        religionCombo.setBackground(Color.WHITE);
        add(religionCombo);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,190,200,30);
        add(category);
        String valCategory [] = {"General", "SC", "ST", "OBC", "PWD", "Other"};
        categoryCombo = new JComboBox(valCategory);
        categoryCombo.setBounds(300,190,400,30);
        categoryCombo.setBackground(Color.WHITE);
        add(categoryCombo);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,240,200,30);
        add(income);
        String valIncome [] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", " upto 1,00,000", ">10 Lakhs"};
        incomeCombo = new JComboBox(valIncome);
        incomeCombo.setBounds(300,240,400,30);
        incomeCombo.setBackground(Color.WHITE);
        add(incomeCombo);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100,290,200,30);
        add(educational);
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        String valEducation [] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        educationCombo = new JComboBox(valEducation);
        educationCombo.setBounds(300,315,400,30);
        educationCombo.setBackground(Color.WHITE);
        add(educationCombo);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,365,200,30);
        add(occupation);
        String valOccupation [] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Others"};
        occupationCombo = new JComboBox(valOccupation);
        occupationCombo.setBounds(300,365,400,30);
        occupationCombo.setBackground(Color.WHITE);
        add(occupationCombo);

        JLabel panNumber = new JLabel("Pan Number:");
        panNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        panNumber.setBounds(100,415,200,30);
        add(panNumber);
        panText = new JTextField();
        panText.setFont(new Font("Raleway", Font.BOLD, 14));
        panText.setBounds(300,415,400,30);
        add(panText);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100,465,200,30);
        add(aadhar);
        aadharText = new JTextField();
        aadharText.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharText.setBounds(300,465,400,30);
        add(aadharText);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100,515,200,30);
        add(senior);
        sYes = new JRadioButton("Yes");
        sYes.setFont(new Font("Raleway", Font.BOLD, 14));
        sYes.setBounds(300,515,60,30);
        sYes.setBackground(Color.WHITE);
        add(sYes);

        sNo = new JRadioButton("No");
        sNo.setFont(new Font("Raleway", Font.BOLD, 14));
        sNo.setBounds(450,515,60,30);
        sNo.setBackground(Color.WHITE);
        add(sNo);

        ButtonGroup sCitizen = new ButtonGroup();
        sCitizen.add(sYes);
        sCitizen.add(sNo);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100,565,200,30);
        add(existing);

        eYes = new JRadioButton("Yes");
        eYes.setFont(new Font("Raleway", Font.BOLD, 14));
        eYes.setBounds(300,565,60,30);
        eYes.setBackground(Color.WHITE);
        add(eYes);

        eNo = new JRadioButton("No");
        eNo.setFont(new Font("Raleway", Font.BOLD, 14));
        eNo.setBounds(450,565,60,30);
        eNo.setBackground(Color.WHITE);
        add(eNo);

        ButtonGroup eacc = new ButtonGroup();
        eacc.add(eYes);
        eacc.add(eNo);

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
        String sReligion = (String)religionCombo.getSelectedItem();
        String sCategory = (String)categoryCombo.getSelectedItem();
        String sIncome = (String)incomeCombo.getSelectedItem();
        String sEducation = (String)educationCombo.getSelectedItem();
        String sOccupation = (String)occupationCombo.getSelectedItem();
        String seniorCitizen = null;
        if(sYes.isSelected()){
            seniorCitizen = "Yes";
        } else if (sNo.isSelected()) {
            seniorCitizen = "No";
        }
        String existingAcc = null;
        if(eYes.isSelected()){
            existingAcc = "Yes";
        } else if (eNo.isSelected()) {
            existingAcc = "No";
        }
        String pan = panText.getText();
        String aadharNo = aadharText.getText();

        try{
            if(pan.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter your Pan Number");
            }else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + form_no + "', '" + sReligion + "', '" + sCategory + "', '" + sIncome + "', '" + sEducation + "', '" + sOccupation + "', '" + pan + "', '" + aadharNo + "', '" + existingAcc + "', '" + seniorCitizen + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signupThree(form_no);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
