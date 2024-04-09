import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton sinup, clear, Login;
    JTextField phoneTextField, cardTextField;
    JPasswordField pinTextField;

    static Login(){
        setTitle("Bank Desktop aap");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/download.jfif"));
        Image i2 = i1.getImage().getScaledInstance(80, 80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(65,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to Bank");
        text.setFont(new Font("calibri",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel Phone = new JLabel("Phone Nmber");
        add(Phone);
        Phone.setFont(new Font("calibri",Font.BOLD,24));
        Phone.setBounds(120,100,150,30);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(300,100,220,30);
        add(phoneTextField);

        JLabel cardnumber = new JLabel("Card Number");
        add(cardnumber);
        cardnumber.setFont(new Font("calibri",Font.BOLD,24));
        cardnumber.setBounds(120,150,150,40);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,220,30);
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        add(pin);
        pin.setFont(new Font("calibri",Font.BOLD,24));
        pin.setBounds(120,200,150,40);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,200,220,30);
        add(pinTextField);

        
        Login = new JButton("Sing In");
        Login.setBounds(300,250,100,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);
        
        clear = new JButton("Clear");
        clear.setBounds(420,250,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        sinup = new JButton("Singup");
        sinup.setBounds(300,300,220,30);
        sinup.setBackground(Color.BLACK);
        sinup.setForeground(Color.WHITE);
        sinup.addActionListener(this);
        add(sinup);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clear){
            phoneTextField.setText("");
            cardTextField.setText("");
            pinTextField.setText("");

        }
        else if(ae.getSource() == Login){
            database d = new database();
            String cardno = cardTextField.getText();
            String pinno = pinTextField.getText();
            String mobile = phoneTextField.getText();
            String query = "select * from Login where card ='"+cardno+"' and pin = '"+pinno+"' and mobileno = '"+mobile+"'";
            try {
                ResultSet rs = d.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Function(pinno).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin");
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == sinup){
            setVisible(false);
            new SinupOne().setVisible(true);

        }
    }
public static void main(String[] args) {
        new Login();
    }
}