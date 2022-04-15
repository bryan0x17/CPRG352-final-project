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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
        <h1>Dashboard</h1>
        <a href="account">Account</a>
        <a href="login">Logout</a>
        <h2>Inventory</h2>
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
                            <button type="submit" class="btn btn-primary btn-sm" name="action" value="update">Save</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
