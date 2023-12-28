package servlets;
import dao.Users;
import dao.UsersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        out.println("<h1>Update User</h1>");

        String userId=request.getParameter("id");
        int id=Integer.parseInt(userId);

        Users e=UsersDAO.getUserDetailsById(id);

        out.print("<form action='UpdateServlet2' method='post'>");
        out.print("<table border=1>");
        out.print("<tr><td>User Id:</td><td><input type='text' name='id' value='"+e.getId()+"'/></td></tr>");
        out.print("<tr><td>First Name:</td><td><input type='text' name='firstName' value='"+e.getFirstName()+"'/></td></tr>");
        out.print("<tr><td>Last Name:</td><td><input type='text' name='lastName' value='"+e.getLastName()+"'/></td></tr>");
        out.print("<tr><td>City:</td><td><input type='text' name='city' value='"+e.getCity()+"'/></td></tr>");
        out.print("<tr><td>Age</td><td><input type='text' name='age' value='"+e.getAge()+"'/></td></tr>");
        out.print("<tr><td><input type='submit' value='Edit & Save '/></td></tr>");
        out.print("</table>");
        out.print("</form>");

        out.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}