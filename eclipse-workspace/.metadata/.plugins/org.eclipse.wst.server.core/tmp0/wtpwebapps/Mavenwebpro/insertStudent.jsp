<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            margin: 20px auto;
            width: 300px;
        }
        label, input {
            display: block;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Insert Student Details</h2>
    <form action="insertstudent" method="post">
        <label for="rno">Roll Number:</label>
        <input type="text" id="rno" name="rno" required>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="brn">Branch:</label>
        <input type="text" id="brn" name="brn" required>

        <input type="submit" value="Insert Student">
    </form>
</body>
</html>