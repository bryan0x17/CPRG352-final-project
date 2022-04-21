<%-- 
    Document   : categories
    Created on : Apr. 18, 2022, 2:01:31 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
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
                        <li>
                            <a href="admin?users" class="nav-link text-white">Manage Users</a>
                        </li>
                        <li>
                            <a href="admin?categories" class="nav-link text-white">Manage Categories</a>
                        </li>
                        <li>
                            <a href="account" class="nav-link text-white">Account</a>
                        </li>
                        <li>
                            <a href="login" class="nav-link text-white">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="container">
            <h1 class="text-center">Category Management</h1>
            <p class="text-center alert">${message}</p>
            <h4 class="text-center">Add new category</h4>
            <form action="admin" method="POST">
                <table class="table">
                    <tbody>
                        <tr>
                            <td>Name</td>
                            <td>
                                <input type="text" name="name">
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary btn-sm" name="action" value="addcategory">Add</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>

            <h4 class="text-center">Categories</h4>
            <form action="admin" method="POST" >
                <table class="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="category" items="${categories}">
                            <tr>
                                <td>${category.categoryName}</td>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm" name="action"  value="editcategory?${category.categoryId}">Edit</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>

            <h4 class="text-center">Edit category</h4>
            <form action="admin" method="POST">
                <table class="table">
                    <tbody>
                        <tr>
                            <td>Name</td>
                            <td>
                                <input type="hidden" name="id" value="${category.categoryId}">
                                <input type="text" name="name" value="${category.categoryName}">
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary btn-sm" name="action" value="updatecategory">Save</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>

        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
