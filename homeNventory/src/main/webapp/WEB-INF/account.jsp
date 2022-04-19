<%-- 
    Document   : manageaccount
    Created on : Apr. 14, 2022, 3:35:35 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
            <input type="email" name="email" id="email" value="${email}" required>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password" required>
            <label for="newpassword">New password</label>
            <input type="password" name="newpassword" id="newpassword">
            <p>Please enter your current password to make any changes to your information</p>
            <p>If you deactivate your account, you will be logged out and your account will be disabled. You will not be able to log back in unless an administrator reactivates your account.</p>
            <button type="submit">Update</button>
            <button type="submit" formaction="account?deactivate=true">Deactivate</button>
        </form>
        <p>${message}</p>
        <a href="home">Home</a>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
