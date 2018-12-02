
package Controller;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class logindao2 {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(logindao2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean validate(String na,String pa){
      boolean status = false;
      String url = "jdbc:mysql://localhost/prajwaljaswal?useSSL=false&allowMultiQueries=true";
      try{
          Connection con = DriverManager.getConnection(url,"root", "Pprajwal68&");
          PreparedStatement ps = con.prepareStatement("select * from jaswal2 where email=? and password=?");
                  ps.setString(1, na);
                  ps.setString(2, pa);
                  ResultSet rs = ps.executeQuery();
                  status = rs.next();
      }
      catch(Exception e){
          System.out.println(e);
      }
      return status;
    }
}