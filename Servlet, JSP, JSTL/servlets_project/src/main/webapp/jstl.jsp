
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" 
                           url="jdbc:mysql://localhost:3306/girrafe"
                           user="root"
                           password="root"/>
        <sql:query var="rs" dataSource="${db}">SELECT * FROM branch LIMIT 3</sql:query>
        
        <c:forEach items="${rs.rows}" var="branch">
            <br> <c:out value="${branch.branch_name}"/> | <c:out value="${branch.mgr_start_date}"/> 
        </c:forEach>
            
        <c:set var="str" value="Olga Vasileva"/>
        <br>Length: ${fn:length(str)}
        <c:forEach items="${fn:split(str, ' ')}" var="word">
            <br> ${word}
        </c:forEach>
            
        <c:if test="${fn:contains(str, 'Vasileva')}">
            <br>Yes, your last name is Vasileva   
        </c:if>   
            
        <br>index of 'V': ${fn:indexOf(str, 'V')}   
        <br> Low Case: ${fn:toLowerCase(str)}
        <br> Upper Case: ${fn:toUpperCase(str)}
    </body>
</html>
