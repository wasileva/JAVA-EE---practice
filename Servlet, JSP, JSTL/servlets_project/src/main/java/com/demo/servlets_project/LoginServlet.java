package com.demo.servlets_project;

import com.demo.dao.LoginDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String username = req.getParameter("uname");
        String password = req.getParameter("pass");  
        try {
            if (LoginDao.check(username, password)){
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                resp.sendRedirect("welcome.jsp");
            } else {
                resp.sendRedirect("index.html");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
