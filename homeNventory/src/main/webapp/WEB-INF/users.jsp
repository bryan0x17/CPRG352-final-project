<%-- 
    Document   : users
    Created on : Apr. 18, 2022, 12:50:28 p.m.
    Author     : Bryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        <h1 class="text-center">User Management</h1>
            <h4 class="text-center">Add new user</h4>
                <form action="admin" method="POST">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Email</th>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Password</th>
                                <th>Role</th>
                                <th>Active</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <input type="email" name="email">
                                </td>
                                <td>
                                    <input type="text" name="firstname">
                                </td>
                                <td>
                                    <input type="text" name="lastname">
                                </td>
                                <td>
                                    <input type="password" name="password">
                                </td>
                                <td>
                                    <select name="role">
                                        <option value="">Please select a role</option>
                                        <c:forEach var="role" items="${roles}">
                                            <option value="${role.roleId}">${role.roleName}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>
                                    <input type="checkbox" name="active">
                                </td>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm" name="action" value="adduser">Add</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            
            <h4 class="text-center">Users</h4>
            <form action="admin" method="POST" >
                <table class="table">
                    <thead>
                        <tr>
                            <th>Email</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Active</th>
                            <th>Role</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.email}</td>
                                <td>${user.firstName}</td>
                                <td>${user.lastName}</td>
                                <td>${user.active ? "Y" : "N"}</td>
                                <td>${user.role.roleName}</td>
                                <td>
                                    <button type="submit" class="btn btn-primary btn-sm" name="action"  value="edituser?${user.email}">Edit</button>
                                    <button type="submit" class="btn btn-danger btn-sm" name="action" value="deleteuser?${user.email}">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </form>
            
            <h4 class="text-center">Edit user</h4>
            <form action="admin" method="POST">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Email</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Password</th>
                            <th>Role</th>
                            <th>Active</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <input type="hidden" name="oldemail" value="${user.email}">
                                <input type="email" name="email" value="${user.email}" required>
                            </td>
                            <td>
                                <input type="text" name="firstname" value="${user.firstName}" required>
                            </td>
                            <td>
                                <input type="text" name="lastname" value="${user.lastName}" required>
                            </td>
                            <td>
                                <input type="password" name="password" value="${user.password}" required>
                            </td>
                            <td>
                                <select name="role">
                                    <option value="${user.role.roleId}">${user.role.roleName}</option>
                                    <c:forEach var="role" items="${roles}">
                                        <option value="${role.roleId}">${role.roleName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <input type="checkbox" name="active">
                            </td>
                            <td>
                                <button type="submit" class="btn btn-primary btn-sm" name="action" value="updateuser">Save</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
            <p class="text-center alert alert-success">${message}</p>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
