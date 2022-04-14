<%-- 
    Document   : register
    Created on : Apr. 14, 2022, 9:56:04 a.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <h1>Create Account</h1>
        <form action="register" method="post">
            <label for="fistname">First name: </label>
            <input type="text" name="firstname" id="firstname" required>
            <label for="lastname">Last name: </label>
            <input type="text" name="lastname" id="lastname" required>
            <label for="email">Email address: </label>
            <input type="email" name="email" id="email" required>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password" required>
            <button type="submit">Register</button>
        </form>
        <p>Already have an account? <a href="login">Log in</a></p>
    </body>
</html>
