<%-- 
    Document   : categories
    Created on : Apr. 18, 2022, 2:01:31 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1 class="text-center">Category Management</h1>
            <h4 class="text-center">Add new category</h4>
                <form action="admin" method="POST">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <td>
                                    <input type="email" name="email">
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm" name="action" value="adduser">Add</button>
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
                        <c:forEach var="categories" items="${categories}">
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
                    <thead>
                        <tr>
                            <th>Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type="email" name="email" readonly value="${user.email}">
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary btn-sm" name="action" value="updatecategory">Save</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <p class="text-center alert alert-success">${message}</p>
    </body>
</html>