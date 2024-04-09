import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Sinupthree extends JFrame implements ActionListener{
    JRadioButton saving, fixed, current, recurring, atm, internet, mobile, email, check, 
    estatement, declare;
    JButton submit, cancel;
    JTextField mobileno;
    String formno;

    Sinupthree(String formno){
      this.formno = formno;

        setLayout(null);

        JLabel text = new JLabel("Page 3:- Account Details ");
        text.setBounds(200,10,400,35);
        text.setFont(new Font("New Times Roman", Font.BOLD,30));
        add(text);

        JLabel account = new JLabel("Account Type");
        account.setBounds(50,100,200,20);
        account.setFont(new Font("New Times Roman", Font.BOLD,25));
        add(account);

        saving = new JRadioButton("Saving Account ");
        saving.setBounds(100,150,200,30);
        saving.setFont(new Font("ralway",Font.BOLD,20));
        saving.setBackground(Color.WHITE);
        saving.setForeground(Color.BLACK);
        add(saving);

        fixed = new JRadioButton("Fixed Account ");
        fixed.setBounds(400,150,200,30);
        fixed.setFont(new Font("ralway",Font.BOLD,20));
        fixed.setBackground(Color.WHITE);
        fixed.setForeground(Color.BLACK);
        add(fixed);

        current = new JRadioButton("Current Account ");
        current.setBounds(100,200,200,30);
        current.setFont(new Font("ralway",Font.BOLD,20));
        current.setBackground(Color.WHITE);
        current.setForeground(Color.BLACK);
        add(current);

        recurring = new JRadioButton("Recurring Account ");
        recurring.setBounds(400,200,250,30);
        recurring.setFont(new Font("ralway",Font.BOLD,20));
        recurring.setBackground(Color.WHITE);
        recurring.setForeground(Color.BLACK);
        add(recurring);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(saving);
        accountgroup.add(current);
        accountgroup.add(fixed);
        accountgroup.add(recurring);

        JLabel cardno = new JLabel("Card Number");
        cardno.setBounds(50,250,200,30);
        cardno.setFont(new Font("New Times Roman", Font.BOLD,25));
        cardno.setBackground(Color.WHITE);
        cardno.setForeground(Color.BLACK);
        add(cardno);

        JLabel cardinfo = new JLabel("XXXX-XXXX-XXXX-4534");
        cardinfo.setBounds(300,250,300,30);
        cardinfo.setFont(new Font("New Times Roman", Font.BOLD,25));
        cardinfo.setBackground(Color.WHITE);
        cardinfo.setForeground(Color.BLACK);
        add(cardinfo);

        JLabel cardmassege = new JLabel("(Your 16 digit card number)");
        cardmassege.setBounds(90,280,200,20);
        cardmassege.setFont(new Font("New Times Roman", Font.BOLD,15));
        cardmassege.setBackground(Color.WHITE);
        cardmassege.setForeground(Color.BLACK);
        add(cardmassege);

        JLabel pinno = new JLabel("PIN Number");
        pinno.setBounds(50,320,200,30);
        pinno.setFont(new Font("New Times Roman", Font.BOLD,25));
        pinno.setBackground(Color.WHITE);
        pinno.setForeground(Color.BLACK);
        add(pinno);

        JLabel pininfo = new JLabel("XXX4");
        pininfo.setBounds(300,320,300,30);
        pininfo.setFont(new Font("New Times Roman", Font.BOLD,25));
        pininfo.setBackground(Color.WHITE);
        pininfo.setForeground(Color.BLACK);
        add(pininfo);

        JLabel pinmassege = new JLabel("(Your 4 digit PIN number)");
        pinmassege.setBounds(90,350,200,20);
        pinmassege.setFont(new Font("New Times Roman", Font.BOLD,15));
        pinmassege.setBackground(Color.WHITE);
        pinmassege.setForeground(Color.BLACK);
        add(pinmassege);

        JLabel service = new JLabel("Service Required");
        service.setBounds(50,400,400,30);
        service.setFont(new Font("New Times Roman", Font.BOLD,25));
        service.setBackground(Color.WHITE);
        service.setForeground(Color.BLACK);
        add(service);

        atm = new JRadioButton("ATM Card ");
        atm.setBounds(100,450,200,30);
        atm.setFont(new Font("ralway",Font.BOLD,20));
        atm.setBackground(Color.WHITE);
        atm.setForeground(Color.BLACK);
        add(atm);

        internet = new JRadioButton("Internet Banking ");
        internet.setBounds(400,450,200,30);
        internet.setFont(new Font("ralway",Font.BOLD,20));
        internet.setBackground(Color.WHITE);
        internet.setForeground(Color.BLACK);
        add(internet);

        mobile = new JRadioButton("Mobile Banking ");
        mobile.setBounds(100,500,200,30);
        mobile.setFont(new Font("ralway",Font.BOLD,20));
        mobile.setBackground(Color.WHITE);
        mobile.setForeground(Color.BLACK);
        add(mobile);

        email = new JRadioButton("Email Alerts ");
        email.setBounds(400,500,200,30);
        email.setFont(new Font("ralway",Font.BOLD,20));
        email.setBackground(Color.WHITE);
        email.setForeground(Color.BLACK);
        add(email);

        JTextArea mobilenoArea = new JTextArea("Mobile No:");
        mobilenoArea.setBounds(50,550,200,40);
        mobilenoArea.setFont(new Font("ralway",Font.BOLD,30));
        mobilenoArea.setBackground(Color.WHITE);
        mobilenoArea.setForeground(Color.BLACK);
        add(mobilenoArea);

        mobileno = new JTextField();
        mobileno.setBounds(250,550,200,30);
        mobileno.setFont(new Font("ralway",Font.BOLD,30));
        mobileno.setBackground(Color.WHITE);
        mobileno.setForeground(Color.BLACK);
        add(mobileno);

        declare = new JRadioButton("I hereby declares that the above entered details correct to the best of my knowledge.");
        declare.setBounds(50,600,700,30);
        declare.setFont(new Font("ralway",Font.BOLD,12));
        declare.setBackground(Color.WHITE);
        declare.setForeground(Color.BLACK);
        add(declare);

        submit = new JButton("Submit");
        submit.setBounds(100,650,200,35);
        submit.setFont(new Font("ralway",Font.BOLD,30));
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(400,650,200,35);
        cancel.setFont(new Font("ralway",Font.BOLD,30));
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);
        setSize(750,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accounttype = null;
            if (saving.isSelected()){
                accounttype = "Saving";
             }else if(current.isSelected()){
                accounttype = "Current";
             }else if (fixed.isSelected()){
                accounttype = "Fixed";
             }else if (recurring.isSelected()){
                accounttype = "Recurring";
             }
             Random random = new Random();
             String card = "" + Math.abs((random.nextLong() % 90000000L) + 6754678000000000L);
             String pin = "" + Math.abs((random.nextLong()% 9000L) + 1000L);
             System.out.println(pin);

             String service = "";
             if (atm.isSelected()){
                service = service +" ATM Card";
             }else if(internet.isSelected()){
                service = service + " Internet Service";
             }else if(mobile.isSelected()){
                service = service + " Mobile Banking";
             }else if (email.isSelected()){
                service = service +" Email Alerts";
             }else if(check.isSelected()){
                service = service + " Check Book";
             }else if(estatement.isSelected()){
                service = service + " E-Statement";
             }
             String mobilen = mobileno.getText();
             try {
                if(accounttype.equals("") || service.equals("")){
                    JOptionPane.showMessageDialog(null,"Service and Account Type must be select");
                }
                else{
                    database d = new database();
                    String query1 = "insert into accountDetails values ('"+formno+"','"+accounttype+"','"+card+"','"+pin+"','"+service+"','"+mobilen+"')";
                    String query2 = "insert into Login values ('"+formno+"','"+card+"','"+pin+"','"+mobilen+"')";
                    d.s.executeUpdate(query1);
                    d.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card number: "+card+ "\nPIN number: "+pin);

                    setVisible(false);
                    new Deposit(pin).setVisible(true);
                }
                
             } catch (Exception e) {
               System.out.println(e);
             }

        }else if(ae.getSource() == cancel){
         setVisible(false);
         new Login().setVisible(true);
         
        }

    }
    public static void main(String[] args) {
        new Sinupthree("");
        
    }
}