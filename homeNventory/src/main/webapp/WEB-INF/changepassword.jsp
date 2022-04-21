<%-- 
    Document   : changepassword
    Created on : Apr. 20, 2022, 4:01:05 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <div class="container text-center">
        <h1>Change Password</h1>
        <p>Enter your email and your new password below.</p>
        <form action="resetpassword" method="POST">
            <input type="hidden" name="uuid" id="uuid" value="${uuid}">
            <label for="email">Email: </label>
            <input type="email" name="email" id="email" required>
            <label for="password">New password: </label>
            <input type="password" name="password" id="password" required>
            <button type="submit" class="btn-primary">Change Password</button>
        </form>
        <a href="login">Login</a>
        <p class="text-center alert">${message}</p>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
