import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    String pin;
    JPasswordField pintext, repintext;
    JButton conform, back;

    Pinchange(String pin){
        this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,800,750);
        add(label);

        JLabel massege = new JLabel(" CHANGE YOUR PIN HERE ");
        massege.setBounds(50,10,700,40);
        massege.setFont(new Font("New Times Roman", Font.BOLD,50));
        massege.setForeground(Color.WHITE);
        label.add(massege);

        JLabel pinno = new JLabel("Enter New Pin");
        pinno.setBounds(50,100,250,30);
        pinno.setFont(new Font("New Times Roman",Font.BOLD,30));
        pinno.setBackground(Color.BLACK);
        pinno.setForeground(Color.WHITE);
        label.add(pinno);

        pintext = new JPasswordField();
        pintext.setBounds(350,100,200,30);
        label.add(pintext);

        JLabel repin = new JLabel("Re-Enter New Pin");
        repin.setBounds(50,150,350,30);
        repin.setFont(new Font("New Times Roman",Font.BOLD,30));
        repin.setBackground(Color.BLACK);
        repin.setForeground(Color.WHITE);
        label.add(repin); 

        repintext = new JPasswordField();
        repintext.setBounds(350,150,200,30);
        label.add(repintext);

        conform = new JButton("Conform");
        conform.setBounds(400,300,300,40);
        conform.setFont(new Font("calebri",Font.BOLD,30));
        conform.setBackground(Color.BLACK);
        conform.setForeground(Color.WHITE);
        conform.addActionListener(this);
        label.add(conform);

        back = new JButton("Back");
        back.setBounds(50,300,300,40);
        back.setFont(new Font("calebri",Font.BOLD,30));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        label.add(back);

        getContentPane().setBackground(Color.WHITE);
        setSize(750,600);
        setLocation(280,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == conform){
            try {
                String epin = pintext.getText();
                String erpin = repintext.getText();
                if(!epin.equals(erpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN Does Not Match");
                    return;
                }
                if(epin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }
                if(erpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }
                database d = new database();
                String query1 = "update Transction set pin = '"+epin+"' where pin = '"+pin+"'";
                String query2 = "update Login set pin = '"+epin+"' where pin = '"+pin+"'";
                String query3 = "update accountDetails set pin = '"+epin+"' where pin = '"+pin+"'";

                d.s.executeUpdate(query1);
                d.s.executeUpdate(query2);
                d.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Your PIN Changed Succesfull");

                setVisible(false);
                new Function(epin).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }

        }else if (ae.getSource() == back){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Pinchange("");
    }
    
}
