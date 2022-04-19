<%-- 
    Document   : register
    Created on : Apr. 14, 2022, 9:56:04 a.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
        <p>${message}</p>
        <p>Already have an account? <a href="login">Log in</a></p>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
