package servlets;

import dao.Users;
import dao.UsersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteUser", value = "/DeleteUser")
//@WebServlet(urlPatterns = "/DeleteUser", name = "DeleteServlet", loadOnStartup = 1)
public class DeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("id");
        int id=Integer.parseInt(userId);

        UsersDAO.delete(id);
    }
}