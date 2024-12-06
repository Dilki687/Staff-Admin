<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit staff members</title>

<link rel="stylesheet" href="styles/editStaff.css">
<script src="js/editStaff.js"></script>

</head>
<body>
<header>
    <h1>Staff Management System</h1>
</header>

<div class="container">
    <h2>Add Staff Members</h2>
    <form action="insert" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" pattern="[A-Za-z\s]+" title="Username should contain only letters." required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="post">Post:</label>
            <input type="text" id="post" name="post" pattern="[A-Za-z\s]+" title="Post should contain only letters." required>
        </div>
        <div class="form-group">
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" pattern="\d{10}" title="Phone Number should contain exactly 10 digits." required>
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <select id="gender" name="gender" required>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <input type="submit" class="btn" value="Add Staff Member">
        </div>
    </form>
</div>
<br>
<form action="disStaff" method="post">
    <button type="submit" name="submit" class="btn">Display</button>
</form>
<br>
<div class="table-section">
    <table>
        <thead>
            <tr class="row1">
                <th scope="col">Employee ID</th>
                <th scope="col">Username</th>
                <th scope="col">Password</th>
                <th scope="col">Post</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Gender</th>
                <th scope="col">Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="staff" items="${staffDetails}">
                <c:set var="empID" value="${staff.empID}"/>
                <c:set var="username" value="${staff.username}"/>
                <c:set var="password" value="${staff.password}"/>
                <c:set var="post" value="${staff.post}"/>
                <c:set var="phoneNumber" value="${staff.phoneNumber}"/>
                <c:set var="gender" value="${staff.gender}"/>
                <c:set var="email" value="${staff.email}"/>
                <tr class="rows">
                    <td>${staff.empID}</td>
                    <td>${staff.username}</td>
                    <td>${staff.password}</td>
                    <td>${staff.post}</td>
                    <td>${staff.phoneNumber}</td>
                    <td>${staff.gender}</td>
                    <td>${staff.email}</td>
                    <td>
                        <c:url value="updateStaff.jsp" var="staffUpdate">
                            <c:param name="empID" value="${empID}"/>
                            <c:param name="username" value="${username}"/>
                            <c:param name="password" value="${password}"/>
                            <c:param name="post" value="${post}"/>
                            <c:param name="phoneNumber" value="${phoneNumber}"/>
                            <c:param name="gender" value="${gender}"/>
                            <c:param name="email" value="${email}"/>
                        </c:url>
                        <a href="${staffUpdate}">
                            <input type="button" name="update" value="Update">
                        </a>
                        <c:url value="deleteStaff.jsp" var="staffdelete">
                            <c:param name="empID" value="${empID}" />
                            <c:param name="username" value="${username}" />
                            <c:param name="password" value="${password}" />
                            <c:param name="post" value="${post}" />
                            <c:param name="phoneNumber" value="${phoneNumber}" />
                            <c:param name="gender" value="${gender}" />
                            <c:param name="email" value="${email}" />
                        </c:url>
                        <a href="${staffdelete}">
                            <input type="button" name="delete" value="Delete">
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<footer>
    <p>&copy; 2024 Staff Management System. All rights reserved.</p>
</footer>

</body>
</html>
