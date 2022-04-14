<%-- 
    Document   : manageaccount
    Created on : Apr. 14, 2022, 3:35:35 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Account</title>
    </head>
    <body>
        <h1>Manage Account</h1>
        <form action="account" method="POST">
            <label for="fistname">First name: </label>
            <input type="text" name="firstname" id="firstname" value="${firstName}" required>
            <label for="lastname">Last name: </label>
            <input type="text" name="lastname" id="lastname" value="${lastName}" required>
            <label for="email">Email address: </label>
            <input type="email" name="email" id="email" value="${email}" required readonly>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password" required>
            <p>Please enter your current password to make any changes to your information</p>
            <p>If you wish to change your email address, you must contact an administrator</p>
            <p>If you deactivate your account, you will be logged out and your account will be disabled. You will not be able to log back in unless an administrator reactivates your account.</p>
            <button type="submit">Update</button>
            <button type="submit" formaction="account?deactivate=true">Deactivate</button>
        </form>
        <p>${message}</p>
        <a href="home">Home</a>
    </body>
</html>
