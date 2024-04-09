import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Sinuptwo extends JFrame implements ActionListener {
    JRadioButton yes, no, ayes, ano;
    JButton next;
    JComboBox relegiontext, categorytext, incometext, educationtext, occupationtext;
    JTextField pantext, adhartext;
    String formno;

    Sinuptwo(String formno) {
        this.formno = formno;

        setTitle("APPLICATION FORM - PAGE 2");

        JLabel text = new JLabel("Page:-2 Additional Details ");
        text.setBounds(200, 10, 450, 30);
        text.setFont(new Font("new times roman", Font.BOLD, 30));
        text.setForeground(Color.GREEN);
        add(text);

        JLabel relegion = new JLabel("Relegion ");
        relegion.setBounds(50, 80, 150, 30);
        relegion.setFont(new Font("calibri", Font.PLAIN, 30));
        relegion.setForeground(Color.BLACK);
        add(relegion);

        String valreligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        relegiontext = new JComboBox(valreligion);
        relegiontext.setBounds(350, 80, 300, 30);
        add(relegiontext);

        JLabel category = new JLabel("Category ");
        category.setBounds(50, 130, 150, 30);
        category.setFont(new Font("calibri", Font.PLAIN, 30));
        category.setForeground(Color.BLACK);
        add(category);

        String valcategory[] = { "Genral", "Obc", "Sc", "St", "Other" };

        categorytext = new JComboBox(valcategory);
        categorytext.setBounds(350, 130, 300, 30);
        add(categorytext);

        JLabel Income = new JLabel("Income ");
        Income.setBounds(50, 180, 150, 30);
        Income.setFont(new Font("calibri", Font.PLAIN, 30));
        Income.setForeground(Color.BLACK);
        add(Income);

        String valincome[] = { "NULL", "<1,50,000", "<2,50,000", "<5,00,000", ">5,00,000" };
        incometext = new JComboBox(valincome);
        incometext.setBounds(350, 180, 300, 30);
        add(incometext);

        JLabel education = new JLabel("Education");
        education.setBounds(50, 230, 150, 30);
        education.setFont(new Font("calibri", Font.PLAIN, 30));
        education.setForeground(Color.BLACK);
        add(education);

        String valeducation[] = { "Non-graduation", "graduation", "Post-Graduation", "Doctrate", "Other" };
        educationtext = new JComboBox(valeducation);
        educationtext.setBounds(350, 240, 300, 30);
        add(educationtext);

        JLabel qualification = new JLabel("Qualification");
        qualification.setBounds(50, 260, 200, 30);
        qualification.setFont(new Font("calibri", Font.PLAIN, 30));
        qualification.setForeground(Color.BLACK);
        add(qualification);

        JLabel occupation = new JLabel("Occupation :");
        occupation.setBounds(50, 330, 200, 30);
        occupation.setFont(new Font("calibri", Font.PLAIN, 30));
        occupation.setForeground(Color.BLACK);
        add(occupation);

        String valoccupation[] = { "Salarieed", "Self Employee", "Bussinessman", "Student", "Retired", "Other" };
        occupationtext = new JComboBox(valoccupation);
        occupationtext.setBounds(350, 330, 300, 30);
        add(occupationtext);

        JLabel panno = new JLabel("PAN No :");
        panno.setBounds(50, 380, 150, 30);
        panno.setFont(new Font("calibri", Font.PLAIN, 30));
        panno.setForeground(Color.BLACK);
        add(panno);

        pantext = new JTextField();
        pantext.setBounds(350, 380, 300, 30);
        add(pantext);

        JLabel adharno = new JLabel("Aadhar no :");
        adharno.setBounds(50, 430, 150, 30);
        adharno.setFont(new Font("calibri", Font.PLAIN, 30));
        adharno.setForeground(Color.BLACK);
        add(adharno);

        adhartext = new JTextField();
        adhartext.setBounds(350, 430, 300, 30);
        add(adhartext);

        JLabel seniorcitizen = new JLabel("Senior Citizen :");
        seniorcitizen.setBounds(50, 480, 200, 30);
        seniorcitizen.setFont(new Font("calibri", Font.PLAIN, 30));
        seniorcitizen.setForeground(Color.BLACK);
        add(seniorcitizen);

        yes = new JRadioButton("Yes");
        yes.setBounds(350, 480, 100, 30);
        yes.setFont(new Font("calibri", Font.BOLD, 22));
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(470, 480, 100, 30);
        no.setFont(new Font("calibri", Font.BOLD, 22));
        add(no);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(yes);
        genderGroup.add(no);

        JLabel eaccount = new JLabel("Existing Acc :");
        eaccount.setBounds(50, 530, 150, 30);
        eaccount.setFont(new Font("calibri", Font.PLAIN, 30));
        eaccount.setForeground(Color.BLACK);
        add(eaccount);

        ayes = new JRadioButton("Yes");
        ayes.setBounds(350, 530, 100, 30);
        ayes.setFont(new Font("calibri", Font.BOLD, 22));
        add(ayes);

        ano = new JRadioButton("No");
        ano.setBounds(470, 530, 100, 30);
        ano.setFont(new Font("calibri", Font.BOLD, 22));
        add(ano);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(ayes);
        accountgroup.add(ano);

        next = new JButton("Next");
        next.setBounds(550, 580, 150, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.BLUE);
        next.setFont(new Font("calibri", Font.BOLD, 24));
        next.addActionListener(this);
        add(next);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(840, 680);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String)relegiontext.getSelectedItem();
        String category = (String)categorytext.getSelectedItem();
        String income = (String)incometext.getSelectedItem();
        String education = (String)educationtext.getSelectedItem();
        String occupation = (String)occupationtext.getSelectedItem();
        String panno = pantext.getText();
        String aadharno = adhartext.getText();
        String seniorci = null;
        if (yes.isSelected()) {
            seniorci = "Yes";
        } else if (no.isSelected()) {
            seniorci = "No";
        }
        String Eaccount = null;
        if (ayes.isSelected()) {
            Eaccount = "Yes";
        } else if (ano.isSelected()) {
            Eaccount = "No";
        }
        // System.out.println(formno);
        // System.out.println(religion);
        // System.out.println(category);
        // System.out.println(income);
        // System.out.println(education);
        // System.out.println(occupation);
        // System.out.println(panno);
        // System.out.println(seniorci);
        // System.out.println(Eaccount);
        // System.out.println(aadharno);

        try {
            if(religion.equals("") ||category.equals("") || income.equals("")||
            education.equals("") || occupation.equals("") || panno.equals("") || 
            aadharno.equals("") )
            {
            JOptionPane.showMessageDialog(null,"These all  Details is Required");
            return;
            }
            else{
                database d = new database();
                String query = "insert into additionalDetails values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+panno+"','"+seniorci+"','"+Eaccount+"','"+aadharno+"')";
                d.s.executeUpdate(query);
                setVisible(false);
                new Sinupthree(formno).setVisible(true);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new Sinuptwo("");
    }


}
