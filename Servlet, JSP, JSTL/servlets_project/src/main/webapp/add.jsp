<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" errorPage="errorHandle.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="test.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="lightblue">
       <%
        int number1 = Integer.parseInt(request.getParameter("num1"));
        int number2 = Integer.parseInt(request.getParameter("num2"));
        int sum = number1 + number2;
        int devide = number1/number2;
        
        out.println("<br> Sum of " + number1 + " and " + number2 + " = " + sum + "<br>");
               
        String url = "jdbc:mysql://localhost:3306/girrafe";
        String username = "root";
        String password = "root";
        String sql = "SELECT * FROM employee WHERE emp_id = 104";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement statement = con.createStatement();
        ResultSet set = statement.executeQuery(sql);
        set.next();
        
       %>
       
       <br> <br>
       
       <c:forEach items="${students}" var="st">
           ${st.name}<br>
       </c:forEach>
       
       <br> <br>
       <%=set.getString(2)%>
       <%=set.getString(3)%>
       <%=set.getString(4)%>
       
       
    </body>
</html>
