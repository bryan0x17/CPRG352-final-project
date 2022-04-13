<%-- 
    Document   : login
    Created on : Apr. 8, 2022, 12:03:51 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home nVentory</title>
    </head>
    <body>
        <h1>Welcome to Home nVentory</h1>
        <form action="login" method="POST">
            <label for="email">Email address: </label>
            <input type="email" name="email" id="email" required>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password" required>
            <button type="submit">Login</button>
        </form>
        <a href="resetPassword">Forgot password?</a>
        <p>${message}</p>
        <p>New user? <a href="register">Sign up here</a>.</p>
    </body>
</html>
