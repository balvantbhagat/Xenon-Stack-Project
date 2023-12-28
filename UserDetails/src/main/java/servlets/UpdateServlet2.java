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

@WebServlet(name = "UpdateServlet2", value = "/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String userId=request.getParameter("id");
        int id=Integer.parseInt(userId);
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter(("lastName"));
        String city=request.getParameter("city");
        String userAge=request.getParameter("age");
        int age=Integer.parseInt(userAge);

        Users users=new Users();
        users.setId(id);
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setCity(city);
        users.setAge(age);

        int status= UsersDAO.update(users);
        if(status>0){
            out.println("<p>User Details saved successfully</p>");
        }else{
            out.println("<p>Unable to save user details</p>");
        }
        out.close();
    }
}