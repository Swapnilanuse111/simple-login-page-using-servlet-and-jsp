package SwapnilAnuse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
    
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         
    	response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SwapRam","root","Swapnil@1706");
            String username = request.getParameter("txtName");
            String password = request.getParameter("txtpwd");
            PreparedStatement ps = con.prepareStatement("select uname from login where uname=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) 
            {
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } 
            else 
            {
            	out.println("<font color='red' size='10'>LOGIN FAILED!!!</font><br>"); 
            	out.println("<font color='red' size='10'>Plz Try Agian</font><br>");
            
            }
            con.close();
            } 
         catch(ClassNotFoundException e) 
         {
        	 out.println("<font color='green'>Driver not found!</font>");
            e.printStackTrace();
         } catch(SQLException e) {
            out.println("<font color='red'>Database error: " + e.getMessage() + "</font>");
            e.printStackTrace();
        }
    }
}