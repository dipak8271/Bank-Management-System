import java.sql.*;

public class database {
    Connection c;
    Statement s;
    public database(){
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","merimaa");
            s = c.createStatement();
        
        } catch (Exception e) {
            System.out.println("");

        }
    }
    
}