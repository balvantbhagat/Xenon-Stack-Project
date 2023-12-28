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

@WebServlet(name = "UserById", value = "/UserById")
public class UserById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId=request.getParameter("id");
        int id=Integer.parseInt(userId);
        PrintWriter out=response.getWriter();
        Users users= UsersDAO.getUserDetailsById(id);
        out.print("<table border=1> ");
        out.println("<tr><td>Id</td><td>First Name</td><td>Last Name</td><td>City</td><td>Age</td></tr>");
        out.println("<tr><td>"+users.getId()+"</td><td>"+users.getFirstName()+"</td><td>"+users.getLastName()
        +"</td><td>"+users.getCity()+"</td><td>"+users.getAge()+"</td></tr>");
        out.print("</table>");
    }


}