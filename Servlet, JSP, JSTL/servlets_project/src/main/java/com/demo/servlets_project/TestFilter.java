package com.demo.servlets_project;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



@WebFilter("/add")
public class TestFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
        PrintWriter out = response.getWriter();
        int number2 = Integer.parseInt(request.getParameter("num2"));
        if (number2 > 5){
            chain.doFilter(request, response);
        } else {
            out.println("<h1>The number_2 MUST be more than 5</h1>");
         
        }
    }

    @Override
    public void destroy() {
        System.out.println(""); 
    }
    
}
