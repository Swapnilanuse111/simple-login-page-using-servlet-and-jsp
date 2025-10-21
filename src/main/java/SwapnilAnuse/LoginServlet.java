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

        String username = request.getParameter("textName"); // ✅ fixed name
        String password = request.getParameter("textpwd");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SwapRam", "root", "Swapnil@1706");

            PreparedStatement ps = con.prepareStatement(
                    "SELECT uname FROM login WHERE uname=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // ✅ Login successful
                RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
                rd.forward(request, response);
            } else {
                // ❌ Invalid login – show styled message
                out.println("<html><head><title>Login Failed</title>");
                out.println("<style>");
                out.println("body { font-family: Arial; background: linear-gradient(135deg, #ff7675, #d63031); color: white; text-align: center; padding-top: 100px; }");
                out.println(".box { background: rgba(255,255,255,0.1); padding: 40px; border-radius: 15px; display: inline-block; }");
                out.println("a { color: #ffeaa7; font-weight: bold; text-decoration: none; }");
                out.println("a:hover { text-decoration: underline; }");
                out.println("</style></head><body>");
                out.println("<div class='box'>");
                out.println("<h2>❌ Invalid Username or Password</h2>");
                out.println("<p>Please <a href='login.jsp'>try again</a>.</p>");
                out.println("</div>");
                out.println("</body></html>");
            }

            con.close();

        } catch (ClassNotFoundException e) {
            out.println("<h3 style='color:red;'>⚠ JDBC Driver not found!</h3>");
            e.printStackTrace();
        } catch (SQLException e) {
            out.println("<h3 style='color:red;'>⚠ Database Error: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
    }
}
