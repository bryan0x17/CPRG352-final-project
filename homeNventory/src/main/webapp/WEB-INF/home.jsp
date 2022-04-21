<%-- 
    Document   : home
    Created on : Apr. 13, 2022, 4:42:05 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body class="bg-light">
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
            <h2 class="text-center">Inventory</h2>
            <p>${message}</p>
            <h4 class="text-center">Add new item</h4>
            <form action="home" method="POST">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Category</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type="text" name="name">
                            </td>
                            <td>
                                <input type="number" name="price">
                            </td>
                            <td>
                                <select name="category">
                                    <option value="">Please select a category</option>
                                    <c:forEach var="category" items="${categories}">
                                        <option value="${category.categoryId}">${category.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary btn-sm" name="action" value="add">Add</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>

            <h4 class="text-center">Items</h4>
            <form action="home" method="POST" >
                <table class="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Category</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${items}">
                            <tr>
                                <td>${item.itemName}</td>
                                <td>${item.price}</td>
                                <td>${item.category.categoryName}</td>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm" name="action"  value="edit?${item.itemId}">Edit</button>
                                    <button type="submit" class="btn btn-danger btn-sm" name="action" value="delete?${item.itemId}">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>

            <h4 class="text-center">Edit item</h4>
            <form action="home" method="POST">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Category</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type="hidden" name="id" value="${item.itemId}">
                                <input type="text" name="name" value="${item.itemName}">
                            </td>
                            <td>
                                <input type="number" name="price" value="${item.price}">
                            </td>
                            <td>
                                <select name="category">
                                    <option value="${item.category.categoryId}">${item.category.categoryName}</option>
                                    <c:forEach var="category" items="${categories}">
                                        <option value="${category.categoryId}">${category.categoryName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary btn-sm" name="action" value="update">Save</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
