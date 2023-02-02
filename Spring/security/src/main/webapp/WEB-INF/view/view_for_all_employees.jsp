<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Information for all empolyees</h3>
        <br><br>
        <sec:authorize access="hasRole('HR')"> 
            <input type ="button" value="Salary" onclick="window.location.href = 'hr_info'"/>
            Only for HR staff  
        </sec:authorize> 
        <br><br>
   
        <sec:authorize access="hasRole('MANAGER')"> 
            <input type ="button" value="Performance" onclick="window.location.href = 'manager_info'"/>
            Only for Manager staff
         </sec:authorize> 
    </body>
</html>
