import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Balanceenquery extends JFrame implements ActionListener {
    JButton back;
    String pin;

    Balanceenquery(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,800,750);
        add(label);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        label.add(back);
        database d = new database();
        int balance = 0;
        try {

            ResultSet rs = d.s.executeQuery("select * from Transction where pin = '"+pin+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance +=  Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -=  Integer.parseInt(rs.getString("amount"));
                    }

                }
            
        } catch (Exception e) {
            System.out.println(e);
        }

            JLabel text = new JLabel("Your Current Account Ballance is Rs "+balance);
            text.setBounds(50,300,400,40);
            text.setForeground(Color.WHITE);
            label.add(text);



        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Function(pin).setVisible(true);
    }

    public static void main(String[] args) {
       new Balanceenquery("");
        
    }
    
}
