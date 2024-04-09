import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposite, back;
    String pin;
    Deposit (String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,700,700);
        add(label);

        JLabel massege = new JLabel("WELCOME TO OUR BANK");
        massege.setBounds(20,50,700,40);
        massege.setFont(new Font("New Times Roman", Font.BOLD,50));
        massege.setForeground(Color.WHITE);
        label.add(massege);

        JLabel text = new JLabel("Enter the Amount you want to Deposite");
        text.setBounds(30,150,700,40);
        text.setFont(new Font("New Times Roman", Font.PLAIN,35));
        text.setForeground(Color.WHITE);
        label.add(text);

        amount = new JTextField();
        amount.setBounds(30,200,600,40);
        amount.setBackground(Color.WHITE);
        label.add(amount);

        deposite = new JButton("Deposit");
        deposite.setBounds(400,500,200,45);
        deposite.setFont(new Font("New Times Roman", Font.BOLD,25));
        deposite.setBackground(Color.WHITE);
        deposite.setForeground(Color.BLACK);
        deposite.addActionListener(this);
        label.add(deposite);

        back = new JButton("Back");
        back.setBounds(400,550,200,45);
        back.setFont(new Font("New Times Roman", Font.BOLD,25));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        label.add(back);


     
        setSize(700,700);
        setVisible(true);
        setLocation(350,10);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == deposite){
            String money = amount.getText();
            Date date = new Date();
            if(money.equals("")){
                JOptionPane.showMessageDialog(null, "Plese Enter money for Deposit");

            }else {
                try {

                    database d = new database();
                    String query = "insert into Transction values('"+pin+"','"+date+"','Deposit','"+money+"')";
                    d.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+money+" is Deposited succsesfull !");
                    setVisible(false);
                    new Function(pin).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }else if(ae.getSource() == back){
            setVisible(false);
            new Function("").setVisible(true);

        }

    }
    public static void main(String[] args) {
        new Deposit("");
        
    }
}