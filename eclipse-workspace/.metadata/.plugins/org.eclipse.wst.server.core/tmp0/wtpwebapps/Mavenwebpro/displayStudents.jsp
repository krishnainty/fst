<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.csed.Mavenwebpro.Student1" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Students</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>List of Students</h2>

    <table>
        <thead>
            <tr>
                <th>Roll Number</th>
                <th>Name</th>
                <th>Branch</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Student1> students = (List<Student1>) request.getAttribute("students");
                if (students != null && !students.isEmpty()) {
                    for (Student1 student : students) {
            %>
            <tr>
                <td><%= student.getRno() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getBrn() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="3">No students found</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>