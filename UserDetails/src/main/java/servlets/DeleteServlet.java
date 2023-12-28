package servlets;


import java.io.IOException;
import java.io.PrintWriter;

import dao.UsersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userId = request.getParameter("id");
        int id = Integer.parseInt(userId);
        PrintWriter out = response.getWriter();
        int status = UsersDAO.delete(id);
        if (status > 0) {
            out.println("<p>User Deleted Successfully</p>");
        } else {
            out.println("<p>Unable to delete user</p>");
        }
        out.close();
    }
}






















//import dao.UsersDAO;
//        import jakarta.servlet.ServletException;
//        import jakarta.servlet.annotation.WebServlet;
//        import jakarta.servlet.http.HttpServlet;
//        import jakarta.servlet.http.HttpServletRequest;
//        import jakarta.servlet.http.HttpServletResponse;
//
//
//        import java.io.IOException;
//        import java.io.PrintWriter;
//
//@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
//public class DeleteServlet extends HttpServlet {
//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setContentType("text/html");
//        String userId=request.getParameter("id");
//        int id=Integer.parseInt(userId);
//        PrintWriter out=response.getWriter();
//        int status= UsersDAO.delete(id);
//        if(status>0){
//            out.println("<p>User Deleted Successfully</p>");
//        }else{
//            out.println("<p>Unable to delete user</p>");
//        }
//        out.close();
//    }
//}