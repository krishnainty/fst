<%@page %>

 <%@ page language="java" import="com.m4.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Course course = (Course)request.getAttribute("course");

out.println("Hello "+course.getName());

out.println("id : " + course.getId());

out.println("Domain : "+ course.getDomain());

%>
</body>
</html>