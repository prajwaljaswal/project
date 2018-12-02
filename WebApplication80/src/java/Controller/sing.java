 package Controller;
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class sing extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String f=request.getParameter("email");  
String l=request.getParameter("psw");  
String e=request.getParameter("mobile");


          
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost/prajwaljaswal?useSSL=false&allowMultiQueries=true","root","Pprajwal68&");  
  
PreparedStatement ps=con.prepareStatement("insert into jaswal2 values(?,?,?)");  
  
ps.setString(1,f);  
ps.setString(2,l);  
ps.setString(3,e);  


          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
RequestDispatcher rd = request.getRequestDispatcher("login.html");
          rd.forward(request,response);
      
          
}
catch (Exception e2) {
   RequestDispatcher rd = request.getRequestDispatcher("login.html");
          rd.forward(request,response);
    System.out.println(e2);
}  
    out.close();       
} 
}