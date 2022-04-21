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
        <div class="text-center container"> 
            <main class="form-signin">
                <form action="login" method="POST">
                    <h1>Welcome to Home nVentory</h1>
                    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                    <div class="form-floating">
                        <label for="email">Email address</label>
                        <input type="email" class="form-control" name="email" id="email" required placeholder="name@example.com">
                    </div>
                    <div class="form-floating">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" id="password" required placeholder="Password">
                    </div>
                    <button class="btn btn-primary w-50" type="submit">Sign in</button>
                </form>
                <a href="register" class="btn btn-secondary w-50">Sign up</a>
                <p class="text-center alert">${message}</p>
            </main>
            <a href="resetpassword">Forgot password?</a>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
