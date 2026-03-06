<html>

<head>
All Employee Details
</head>
<body>
<table>
<th>
<tr>
<td>Name</td>
<td>Email</td>
<td>Salary</td>
<td>Admin</td>
<td>Password</td>

</tr>
</th>
<c:forEach var = "emp" items = "${msg}"> 
	<tr>
	<td> ${emp.name}</td>
	<td>${emp.email }</td>
	<td>${emp.salary}</td>
	<td>${emp.role }</td>
	<td>${emp.password }</td>
	
	
	<tr/>
</c:forEach>


</table>
</body>
</html>