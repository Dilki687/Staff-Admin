<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update profile</title>

<link rel="stylesheet" href="styles/updateStaff.css">
<script src="js/updateStaff.js"></script>

</head>
<body>

<header>
    <h1>Staff Management System</h1>
</header>

<%
	String empID = request.getParameter("empID");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String post = request.getParameter("post");
	String phoneNumber = request.getParameter("phoneNumber");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
%>

<div class="container">
    <h2>Edit Staff Members</h2>
    <form action="updateStaff" method="post" onsubmit="return validateForm()">
    	<div class="form-group">
            <label for="empID">Employee ID:</label>
            <input type="text" id="empID" name="empID" required value="<%= empID%>" readonly>
        </div>
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required value="<%= username%>">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required value="<%= password%>">
        </div>
        <div class="form-group">
            <label for="post">Post:</label>
            <input type="text" id="post" name="post" required value="<%= post%>">
        </div>
        <div class="form-group">
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required value="<%= phoneNumber%>">
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <select id="gender" name="gender" required>
                <option value="male" <%= gender%>>Male</option>
                <option value="female" <%= gender%>>Female</option>
                <option value="other" <%= gender%>>Other</option>
            </select>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required value="<%= email%>">
        </div>
        <div class="form-group">
            <input type="submit" class="btn" value="Update member details">
        </div>
    </form>
</div>

<footer>
    <p>&copy; 2024 Staff Management System. All rights reserved.</p>
</footer>

</body>
</html>