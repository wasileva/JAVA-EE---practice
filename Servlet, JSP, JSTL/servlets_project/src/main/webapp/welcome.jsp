
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0
            response.setHeader("Expires", "0"); // Proxies
            
            if (session.getAttribute("username") == null) {
                response.sendRedirect("index.html");
            }
        %>   
        
        <form action="add" method="get">
            First number:  <input type="text" name="num1"><br>
            Second number: <input type="text" name="num2"><br>
            <input type="submit" value="Submit">
        </form>
        <br>
        <form action="jstl.jsp">
            <label>Practice for JSTL</label>
            <input type="submit" value="JSTL">
        </form>
        <br>
        <form action="upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file" multiple>
            <input type = "submit">
        </form>
        <br>
        <form action="logout" method="post">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
