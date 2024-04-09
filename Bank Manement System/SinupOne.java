import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SinupOne extends JFrame implements ActionListener{
    long random;
    JLabel fullname, fathername, mothername, dob, gender, email, maritial, address, city,
    state, pin;
    JRadioButton male, fmale, other, married, unmarried, mother;

    JTextField nameTextField, fathernameTextField, mothernameTextField, emailTextField,
    addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JDateChooser datechooser;

    SinupOne() {

        setLayout(null);
        Random ram = new Random();
        random = Math.abs(ram.nextLong() % 9000L) +1000L;
        JLabel formno = new JLabel("APPLICATION FORM NO: "+ random );
        formno.setFont(new Font("calibri",Font.BOLD,40));
        formno.setBounds(120,20,600,40);
        add(formno);

        JLabel text = new JLabel("Page 1:- personal Details ");
        add(text);
        text.setBounds(200,70,400,20);
        text.setFont(new Font("New Times Roman", Font.BOLD,20));

        fullname = new JLabel("Enter Full Name");
        add(fullname);
        fullname.setBounds(50,100,250,30);
        fullname.setFont(new Font("New Times Roman",Font.BOLD,30));

        nameTextField = new JTextField();
        nameTextField.setBounds(300,100,300,30);
        add(nameTextField);

        fathername = new JLabel("Father's Name");
        add(fathername);
        fathername.setBounds(50,150,350,30);
        fathername.setFont(new Font("New Times Roman",Font.BOLD,30)); 

        fathernameTextField= new JTextField();
        fathernameTextField.setBounds(300,150,300,30);
        add(fathernameTextField);

        mothername = new JLabel("Mother's Name");
        add(mothername);
        mothername.setBounds(50,200,450,30);
        mothername.setFont(new Font("New Times Roman",Font.BOLD,30));

        mothernameTextField = new JTextField();
        mothernameTextField.setBounds(300,200,300,30);
        add(mothernameTextField); 

        dob = new JLabel("Date of Birth :");
        add(dob);
        dob.setBounds(50,250,450,30);
        dob.setFont(new Font("New Times Roman",Font.BOLD,30));

        datechooser = new JDateChooser();
        datechooser.setBounds(300,250,300,30);
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);

        gender = new JLabel("Gender ");
        add(gender);
        gender.setBounds(50,300,450,30);
        gender.setFont(new Font("New Times Roman",Font.BOLD,30));

        male = new JRadioButton("Male");
        male.setBounds(300,300,100,30);
        male.setFont(new Font("calibri",Font.BOLD,22));
        add(male);

        fmale = new JRadioButton("Female");
        fmale.setBounds(420,300,100,30);
        fmale.setFont(new Font("calibri",Font.BOLD,22));
        add(fmale);

        other = new JRadioButton("Other");
        other.setBounds(540,300,100,30);
        other.setFont(new Font("calibri",Font.BOLD,22));
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(fmale);
        genderGroup.add(other);

        maritial = new JLabel("Maritial Status");
        add(maritial);
        maritial.setBounds(50,350,450,30);
        maritial.setFont(new Font("New Times Roman",Font.BOLD,30));

        married = new JRadioButton("Married");
        married.setBounds(300,350,100,30);
        married.setFont(new Font("calibri",Font.BOLD,22));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(420,350,100,30);
        unmarried.setFont(new Font("calibri",Font.BOLD,22));
        add(unmarried);

        mother = new JRadioButton("Other");
        mother.setBounds(540,350,100,30);
        mother.setFont(new Font("calibri",Font.BOLD,22));
        add(mother);

        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unmarried);
        marriedGroup.add(mother);


        email = new JLabel("Email Address ");
        add(email);
        email.setBounds(50,400,450,30);
        email.setFont(new Font("New Times Roman",Font.BOLD,30));

        emailTextField = new JTextField();
        emailTextField.setBounds(300,400,300,30);
        add(emailTextField);

        
        address = new JLabel("Address : ");
        add(address);
        address.setBounds(50,450,450,30);
        address.setFont(new Font("New Times Roman",Font.BOLD,30));

        addressTextField = new JTextField();
        addressTextField.setBounds(300,450,300,30);
        add(addressTextField);

        city = new JLabel("City ");
        add(city);
        city.setBounds(50,500,450,30);
        city.setFont(new Font("New Times Roman",Font.BOLD,30));

        cityTextField = new JTextField();
        cityTextField.setBounds(300,500,300,30);
        add(cityTextField);

        state = new JLabel("State ");
        add(state);
        state.setBounds(50,550,450,30);
        state.setFont(new Font("New Times Roman",Font.BOLD,30));

        stateTextField = new JTextField();
        stateTextField.setBounds(300,550,300,30);
        add(stateTextField);

        pin = new JLabel("PIN Code ");
        add(pin);
        pin.setBounds(50,600,650,30);
        pin.setFont(new Font("New Times Roman",Font.BOLD,30));

        pinTextField = new JTextField();
        pinTextField.setBounds(300,600,300,30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBounds(450,650,150,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("calibri",Font.BOLD,24));
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(750,800);
        setLocation(350,10);
        setVisible(true);

    }  
    public void actionPerformed(ActionEvent ae){
       String name = nameTextField.getText();
       String fathername = fathernameTextField.getText();
       String mothername = mothernameTextField.getText();
       String email = emailTextField.getText();
       String address = addressTextField.getText();
       String pin = pinTextField.getText();
       String city = cityTextField.getText();
       String state = stateTextField.getText();
       String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
       String gender = null;
       if(male.isSelected()){
        gender = "Male";
       }
       else if (fmale.isSelected()){
        gender = "Female";

       }else if (other.isSelected()){
        gender = "Other";
       }
       String maritial = null;
       if (married.isSelected()){
        maritial = "Married";
       }
       else if (unmarried.isSelected()){
        maritial = "Unmarreid";
       }
       else if (mother.isSelected()){
        maritial = "Other";
       }
       String formno =Long.toString(random);

       try {

        if(name.equals("") || fathername.equals("") || mothername.equals("")
         || email.equals("") || address.equals("") || dob.equals("") || address.equals("") ||
        city.equals("") || state.equals("") || pin.equals("")){

            JOptionPane.showMessageDialog(null,"These all  Details is Required");

        }
        else{
            database d = new database();
            String query = "insert into sinup values ('"+formno+"','"+name+"','"+fathername+"','"+mothername+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
            d.s.executeUpdate(query);
            setVisible(false);
            new Sinuptwo(formno).setVisible(true);
        }

       } catch (Exception e) {
        System.out.println(e);
       }

    }

    public static void main(String[] args) {
        new SinupOne();

    }
    
}
