<%-- 
    Document   : resetpassword
    Created on : Apr. 20, 2022, 11:28:40 a.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <p>Please enter your email address to reset your password</p>
        <form action="resetpassword" method="post">
            <label for="email">Email address</label>
            <input type="email" name="email" id="email" required>
            <button type="submit">Reset</button>
        </form>
        <p>${message}</p>
    </body>
</html>
