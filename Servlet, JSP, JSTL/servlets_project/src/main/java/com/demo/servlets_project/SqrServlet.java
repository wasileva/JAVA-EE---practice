package com.demo.servlets_project;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sqr")
public class SqrServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printer = resp.getWriter();
    //    HttpSession session = req.getSession();
    //    int k = (int) session.getAttribute("sum");
        
        
      //  int k = Integer.parseInt(req.getParameter("k"));
      
        int k = 0;
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies){
            if (c.getName().equals("sum")){
                k = Integer.parseInt(c.getValue());
            }
        }
        
        int sq = k * k;
        printer.write("<br>Square =  " + sq);
    }
    
    
}
