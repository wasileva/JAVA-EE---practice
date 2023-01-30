<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add customer</title>
    </head>
    <body>
    <form:form action="saveEmployee" modelAttribute="employee">
        
        <form:hidden path="id"/>
        
        Name <form:input path="name" /><br><br>
        Surname <form:input path="surname" /><br><br>
        Department <form:input path="department" /><br><br>
        Salary <form:input path="salary" /><br><br>
        <input type="submit" value = "Submit"/>
    </form:form>    
    </body>
</html>
