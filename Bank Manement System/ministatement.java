import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ministatement extends JFrame{
    ministatement(String pin){


        setTitle("Mini Statement");

        setLayout(null);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        JLabel text = new JLabel("My Bank");
        text.setBounds(150,20,100,20);
        text.setFont(new Font("railway",Font.BOLD,20));
        add(text);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,220);
        add(mini);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel blance = new JLabel();
        blance.setBounds(20,400,300,20);
        add(blance);

        try {
            database d = new database();
            ResultSet rs = d.s.executeQuery("select * from Login where pin = '"+pin+"'");
            while(rs.next()){
                card.setText("Card No : " + rs.getString("card").substring(0,4) +"XXXXXXXX"+ rs.getString("card").substring(12));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            database d = new database();
            ResultSet rs = d.s.executeQuery("select * from Transaction where pin = '"+pin+"'");
            while(rs.next()){
                mini.setText(mini.getText() +"<html>"+ rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount") +"<br><br><html>");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            database d = new database();
            int bal = 0;
            ResultSet rs = d.s.executeQuery("select * from Transaction where pin = '"+pin+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        bal +=  Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal -=  Integer.parseInt(rs.getString("amount"));
                    }

                }
                blance.setText("Your Current balance is Rs "+bal);
            
        }  catch (Exception e) {
            System.out.println(e);
        }

    }
     public static void main(String[] args) {
        new ministatement("");
    }
}