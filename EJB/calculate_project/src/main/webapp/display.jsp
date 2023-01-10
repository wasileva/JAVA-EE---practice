
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String fNumber = (String)request.getParameter("firstNumber");
            String sNumber = (String)request.getParameter("secondNumber");
            String operand = (String)request.getParameter("operand");
            double result = (double)request.getAttribute("result");
          
            out.println("<h1>" +fNumber + " " + operand + " " + sNumber + " = " + result + "</h1>");
        %>    
        
        <%--
        Использование JSP expression
        --%>
        <%=fNumber%> <%=operand%> <%=sNumber%> = <%=result%>
       
    </body>
</html>
