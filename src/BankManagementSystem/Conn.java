package BankManagementSystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Kartikey@9837");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
