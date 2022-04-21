<%-- 
    Document   : resetpassword
    Created on : Apr. 20, 2022, 11:28:40 a.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <div class="container text-center">
            <h1>Reset Password</h1>
            <p>Please enter your email address to reset your password</p>
            <form action="resetpassword" method="post">
                <label for="email">Email address</label>
                <input type="email" name="email" id="email" required>
                <button type="submit" class="btn-primary" type="submit">Reset</button>
            </form>
            <p class="text-center alert">${message}</p>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
