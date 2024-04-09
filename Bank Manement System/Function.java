import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Function extends JFrame implements ActionListener{
    JButton deposite, withdraw, fastcash, pinchange, ministatement, balance, exit;
    String pin;
    Function(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,800,750);
        add(label);

        JLabel massege = new JLabel("WELCOME TO OUR BANK");
        massege.setBounds(80,10,700,40);
        massege.setFont(new Font("New Times Roman", Font.BOLD,50));
        massege.setForeground(Color.WHITE);
        label.add(massege);

        JLabel text = new JLabel("Please Selected your Transection ");
        text.setBounds(100,200,600,40);
        text.setFont(new Font("New Times Roman", Font.BOLD,35));
        text.setForeground(Color.WHITE);
        label.add(text);

        deposite = new JButton("Deposite Money");
        deposite.setBounds(150,300,250,40);
        deposite.setFont(new Font("Calibri",Font.BOLD,30));
        deposite.setForeground(Color.BLACK);
        deposite.addActionListener(this);
        label.add(deposite);

        withdraw = new JButton("withdraw Money");
        withdraw.setBounds(450,300,250,40);
        withdraw.setFont(new Font("Calibri",Font.BOLD,30));
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        label.add(withdraw);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150,350,250,40);
        fastcash.setFont(new Font("Calibri",Font.BOLD,30));
        fastcash.setForeground(Color.BLACK);
        fastcash.addActionListener(this);
        label.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(450,350,250,40);
        ministatement.setFont(new Font("Calibri",Font.BOLD,30));
        ministatement.setForeground(Color.BLACK);
        ministatement.addActionListener(this);
        label.add(ministatement);

        pinchange = new JButton("PIN Change");
        pinchange.setBounds(150,400,250,40);
        pinchange.setFont(new Font("Calibri",Font.BOLD,30));
        pinchange.setForeground(Color.BLACK);
        pinchange.addActionListener(this);
        label.add(pinchange);

        balance = new JButton("Blance Enquery");
        balance.setBounds(450,400,250,40);
        balance.setFont(new Font("Calibri",Font.BOLD,30));
        balance.setForeground(Color.BLACK);
        balance.addActionListener(this);
        label.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(450,450,150,40);
        exit.setFont(new Font("Calibri",Font.BOLD,30));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        label.add(exit);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setUndecorated(true);
        setVisible(true);
        setLocation(300,0);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);

        }else if(ae.getSource() == deposite){
            setVisible(false);
            new Deposit(pin).setVisible(true);

        }else if(ae.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pin).setVisible(true);

        }else if (ae.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pin).setVisible(true);
           

        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new Pinchange(pin).setVisible(true);

        }else if (ae.getSource() == ministatement){
            new ministatement(pin).setVisible(true);

        }else if (ae.getSource() == balance){
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

           JOptionPane.showMessageDialog(null,"Your Current Balance is Rs "+balance);

        }

    }
    public static void main(String[] args) {
        new Function("");
    }
    
}
