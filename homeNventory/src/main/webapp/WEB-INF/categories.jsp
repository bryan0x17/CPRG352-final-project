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
        <h1 class="text-center">Category Management</h1>
            <h4 class="text-center">Add new category</h4>
                <form action="admin" method="POST">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <td>
                                    <input type="text" name="name">
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
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
                    <thead>
                        <tr>
                            <th>Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
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
            <p class="text-center alert alert-success">${message}</p>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
