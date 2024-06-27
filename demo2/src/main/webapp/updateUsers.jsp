<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.demo2.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
<h2>Update User</h2>
<%
    User user = (User) request.getAttribute("user");
%>
<form action="updateUser" method="post">
<input type="hidden" name="id" value="<%= user.getId() %>">

    Name: <input type="text" name="name" value="<%= user.getUserName() %>" required><br>
    Age: <input type="number" name="age" value="<%= user.getAge() %>" required><br>
    MobileNo: <input type="text" name="mobileNo" value="<%= user.getMobileNo() %>" readonly><br>
    Gender: <input type="text" name="gender" value="<%= user.getGender() %>" required><br>
    Address: <input type="text" name="address" value="<%= user.getAddress() %>" required><br>
    <input type="submit" value="Update">
</form>
</body>
</html>
