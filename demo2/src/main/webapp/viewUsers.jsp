<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.chainsys.demo2.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<h2>User Details</h2>
<form action="searchUser" method="get">
    Search by Name: <input type="text" name="name" required>
    <input type="submit" value="Search">
</form>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>MobileNo</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Actions</th>
    </tr>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        for (User user : users) {
    %>
        <tr>
            <td><%=user.getUserName() %></td>
            <td><%= user.getAge() %></td>
            <td><%= user.getMobileNo() %></td>
            <td><%= user.getGender() %></td>
            <td><%= user.getAddress() %></td>
            <td>
                <form action="deleteUser" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= user.getId() %>">
                    <input type="submit" value="Delete">
                </form>
                <form action="showUpdateForm" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="<%= user.getId() %>">
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    <%
        }
    %>
</table>
</body>
</html>
