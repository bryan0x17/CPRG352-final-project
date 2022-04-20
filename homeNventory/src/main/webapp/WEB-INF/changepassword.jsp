<%-- 
    Document   : changepassword
    Created on : Apr. 20, 2022, 4:01:05 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <h1>Change Password</h1>
        <p>Enter your email and your new password below.</p>
        <form action="resetpassword" method="POST">
            <input type="hidden" name="uuid" id="uuid" value="${uuid}">
            <label for="email">Email: </label>
            <input type="email" name="email" id="email" required>
            <label for="password">New password: </label>
            <input type="password" name="password" id="password" required>
            <button type="submit">Change Password</button>
        </form>
            <p>${message}</p>
            <a href="login">Login</a>
    </body>
</html>
