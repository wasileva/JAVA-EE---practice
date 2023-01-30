
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
    </head>
    <body>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Department</th>
                <th>Salary</th>
            </tr>
            <c:forEach var="emp" items="${allEmpl}">
                
                <c:url var="updateButton" value = "/updateInfo">
                    <c:param name="empId" value="${emp.id}" />
                </c:url>
                <c:url var="deleteButton" value = "/deleteEmployee">
                    <c:param name="empId" value="${emp.id}" />
                </c:url>
                <tr>
                    <td>${emp.name}</td>
                    <td>${emp.surname}</td>
                    <td>${emp.department}</td>
                    <td>${emp.salary}</td>
                    <td>
                        <input type = "button" value="Update" 
                               onclick="window.location.href='${updateButton}'"/>
                    </td>
                    <td>
                        <input type = "button" value="Delete" 
                               onclick="window.location.href='${deleteButton}'"/>
                    </td>
                </tr>    
            </c:forEach>  
            
        </table>
        <br><br>
        
        <input type="button" value="Add" onclick="window.location.href = 'addNewEmployee' " />
        
    </body>
</html>
