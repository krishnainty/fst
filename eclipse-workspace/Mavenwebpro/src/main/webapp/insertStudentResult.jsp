<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Student Result</title>
</head>
<body>
    <h2><%= request.getAttribute("message") %></h2>
    <a href="insertStudent.jsp">Insert another student</a> | <a href="retrievestudents">View all students</a>
</body>
</html>