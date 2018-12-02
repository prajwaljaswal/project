package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login3 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String n = request.getParameter("name");
        String p = request.getParameter("pass");
        if (logindao2.validate(n, p)) {
            RequestDispatcher rd = request.getRequestDispatcher("form.html");
            rd.forward(request, response);
        } else {
           
            RequestDispatcher rd = request.getRequestDispatcher("online.html");
            rd.include(request, response);
        }
        out.close();
    }
}
