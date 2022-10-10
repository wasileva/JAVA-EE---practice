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
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        int number1 = Integer.parseInt(request.getParameter("num1"));
        if (number1 > 0){
            chain.doFilter(request, response);
        } else {
            out.println("<h1>The number_1 MUST be positive</h1>");
         
        }
    }

    @Override
    public void destroy() {
        System.out.println(""); 
    }
    
}
