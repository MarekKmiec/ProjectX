<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 21.09.2022
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<style>
    /*th {*/
    /*  color: rgb(255, 255, 255);*/
    /*  border: 1px solid rgb(219, 219, 219);*/
    /*  font-weight: normal;*/
    /*  background-color: rgb(124, 124, 125);*/
    /*}*/
    /*table {*/
    /*  border-collapse: collapse;*/
    /*}*/
    /*td {*/
    /*  color: rgb(77, 77, 79);*/
    /*  border: 1px solid rgb(219, 219, 219);*/
    /*  background-color: rgb(231, 231, 231);*/
    /*}*/
    /*td, th {*/
    /*  padding: 15px 20px;*/
    /*}*/
</style>
<body>
<h3>Lista użytkowników</h3>
<table class="table table-striped ">
    <tr>
        <th>User name</th>
<%--        <th>Balance</th>--%>
        <th>phoneNumber</th>
        <th>action</th>

    </tr>
    <c:forEach items="${user}" var="u">
        <tr>
            <td><c:out value="${u.name}"/></td>
<%--            <td><c:out value="${u.balance}"/></td>--%>
            <td><c:out value="${u.phoneNumber}"/></td>

            <td><a href="<c:url value="/userform/delete/${u.id}"/>"
                   onclick="return confirm('Are you sure you want to delete user \'${u.name}\'?')">Delete</a>
                <br><a href="<c:url value="/userform/edit/${u.id}"/>">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/userform/add"/>">Add User</a><br>
<a href="<c:url value="/expense/list"/>">List Expenses</a><br>
<a href="<c:url value="/event/list"/>">ListEvent</a><br>
</body>
</html>
