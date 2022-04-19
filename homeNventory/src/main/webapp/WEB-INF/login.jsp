<%-- 
    Document   : login
    Created on : Apr. 8, 2022, 12:03:51 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
