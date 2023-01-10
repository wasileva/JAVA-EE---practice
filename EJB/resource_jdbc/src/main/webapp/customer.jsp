<%-- 
    Document   : customer.jsp
    Created on : 06.01.2023, 20:52:27
    Author     : crimd
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.customer.ee9.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EE9</title>
    </head>
    <body>
        <h1>Customer</h1>
        <%
            Customer c = (Customer)request.getAttribute("CUSTOMER");
            out.print(c.getCustomerName() + " " + c.getCustomerPhone());
        %>
        <h2>All Customers:</h2>
        <%
            List<Customer> allCustomers = (ArrayList<Customer>) request.getAttribute("ALL_CUSTOMERS");
            for(Customer cust : allCustomers){
                out.print(cust.getCustomerName() + " " + cust.getCustomerPhone());
             %>
             <br>
             <%
            }
        %>
    </body>
</html>
