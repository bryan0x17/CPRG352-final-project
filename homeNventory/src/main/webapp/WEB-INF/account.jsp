<%-- 
    Document   : manageaccount
    Created on : Apr. 14, 2022, 3:35:35 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Account</title>
    </head>
    <body>
        <div class="px-3 py-2 bg-dark text-white">
            <div class="container">
                <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                    <div class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">
                        Hello, ${firstname}
                    </div>
                    <ul class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
                        <li>
                            <a href="home" class="nav-link text-white">Home</a>
                        </li>
                        <c:if test="${admin}">
                            <li>
                                <a href="admin?users" class="nav-link text-white">Manage Users</a>
                            </li>
                            <li>
                                <a href="admin?categories" class="nav-link text-white">Manage Categories</a>
                            </li>
                        </c:if>
                        <li>
                            <a href="login" class="nav-link text-white">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">
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
                <button type="submit" class="btn-primary">Update</button>
                <button type="submit" formaction="account?deactivate=true" class="btn-danger">Deactivate</button>
            </form>
            <p>${message}</p>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
