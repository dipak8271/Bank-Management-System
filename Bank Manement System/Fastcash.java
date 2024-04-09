import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    JButton deposite, withdraw, fastcash, pinchange, ministatement, balance, back;
    String pin;
    Fastcash(String pin){
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

        deposite = new JButton("Rs 100");
        deposite.setBounds(150,300,250,40);
        deposite.setFont(new Font("Calibri",Font.BOLD,30));
        deposite.setForeground(Color.BLACK);
        deposite.addActionListener(this);
        label.add(deposite);

        withdraw = new JButton("Rs 200");
        withdraw.setBounds(450,300,250,40);
        withdraw.setFont(new Font("Calibri",Font.BOLD,30));
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        label.add(withdraw);

        fastcash = new JButton("Rs 500");
        fastcash.setBounds(150,350,250,40);
        fastcash.setFont(new Font("Calibri",Font.BOLD,30));
        fastcash.setForeground(Color.BLACK);
        fastcash.addActionListener(this);
        label.add(fastcash);

        ministatement = new JButton("Rs 1000");
        ministatement.setBounds(450,350,250,40);
        ministatement.setFont(new Font("Calibri",Font.BOLD,30));
        ministatement.setForeground(Color.BLACK);
        ministatement.addActionListener(this);
        label.add(ministatement);

        pinchange = new JButton("Rs 2000");
        pinchange.setBounds(150,400,250,40);
        pinchange.setFont(new Font("Calibri",Font.BOLD,30));
        pinchange.setForeground(Color.BLACK);
        pinchange.addActionListener(this);
        label.add(pinchange);

        balance = new JButton("Rs 5000");
        balance.setBounds(450,400,250,40);
        balance.setFont(new Font("Calibri",Font.BOLD,30));
        balance.setForeground(Color.BLACK);
        balance.addActionListener(this);
        label.add(balance);

        back = new JButton("Back");
        back.setBounds(450,450,150,40);
        back.setFont(new Font("Calibri",Font.BOLD,30));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        label.add(back);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setUndecorated(true);
        setVisible(true);
        setLocation(300,0);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Function(pin).setVisible(true);

        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            database d = new database();
            try {
                ResultSet rs = d.s.executeQuery("select * from Transction where pin = '"+pin+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance +=  Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -=  Integer.parseInt(rs.getString("amount"));
                    }

                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;

                }else{
                    Date date = new Date();
                    String query = "insert into Transction values('"+pin+"','"+date+"','Withdraw','"+amount+"')";
                    d.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" is Withdraw succesfull");
                    setVisible(false);
                    new Function(pin).setVisible(true);
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
    public static void main(String[] args) {
        new Fastcash("");
    }
    
}
