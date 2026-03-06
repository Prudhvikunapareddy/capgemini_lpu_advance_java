<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: lightgray;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>

<body>

<h2>Employee List</h2>

<table>
    <tr>
        <th>Email</th>
        <th>Name</th>
        <th>Password</th>
        <th>Role</th>
        <th>Salary</th>
    </tr>

    <c:forEach var="emp" items="${msg}">
        <tr>
            <td>${emp.email}</td>
            <td>${emp.name}</td>
            <td>${emp.password}</td>
            <td>${emp.role}</td>
            <td>${emp.salary}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>