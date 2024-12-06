<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff member login</title>

<link rel="stylesheet" href="styles/adminLogin.css">
    
</head>
<body>

 <div class="login-container">
        <h2>Staff Member Login</h2>
        <form action="log" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Sign In">
        </form>
    </div>

</body>
</html>