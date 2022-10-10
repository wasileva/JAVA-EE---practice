package com.demo.servlets_project;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
        urlPatterns = "/add", 
        initParams={
        @WebInitParam(name = "firstName", value = "Olga") 
})
public class AddServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Student> students = Arrays.asList(new Student(56, "Mia"), new Student(56, "Kira"));
        
        req.setAttribute("students", students);
        getServletContext().getRequestDispatcher("/add.jsp").forward(req, resp);
                
        int number1 = Integer.parseInt(req.getParameter("num1"));
        int number2 = Integer.parseInt(req.getParameter("num2"));
        int sum = number1 + number2;
           
        PrintWriter writer = resp.getWriter();
        writer.println("Sum of " + number1 + " and " + number2 + " = " + sum);
        writer.println(getInitParameter("firstName"));
        writer.close();
        
        
        
       /* 
        getServletContext().getRequestDispatcher("/sqr").forward(req, resp);
      
        //-----
        req.setAttribute("sum", sum);
        req.getRequestDispatcher("/sqr").forward(req, resp);
       
        //-----1 way to send data via url
        resp.sendRedirect("sqr?sum="+sum);
        //-----2 way to send data via session
        HttpSession session = req.getSession();
        session.setAttribute("sum", sum);
       */
        //-----3 way to send data via coockie
        Cookie coockie = new Cookie("sum", Integer.toString(sum));
        resp.addCookie(coockie);
        resp.sendRedirect("sqr");

    }
    
}
