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
    <title>Event</title>
</head>
<style>
    th {
        color: rgb(255, 255, 255);
        border: 1px solid rgb(219, 219, 219);
        font-weight: normal;
        background-color: rgb(124, 124, 125);
    }

    table {
        border-collapse: collapse;
    }

    td {
        color: rgb(77, 77, 79);
        border: 1px solid rgb(219, 219, 219);
        background-color: rgb(231, 231, 231);
    }

    td, th {
        padding: 15px 20px;
    }
</style>
<body>
<h3>Lista wydarzeń</h3>
<table>
    <tr>
        <th>Nazwa Wydarzenia</th>
        <th>Data</th>
        <th>Users</th>
        <th>Action</th>

    </tr>
    <c:forEach items="${event}" var="e">
        <tr>
            <td><c:out value="${e.name}"/></td>
            <td><c:out value="${e.date}"/></td>
            <td><c:out value="${e.users}"/></td>

            <td><a href="<c:url value="/event/delete/${e.id}"/>"
                   onclick="return confirm('Are you sure you want to delete event \'${e.name}\'?')">Delete</a>
                <br><a href="<c:url value="/event/edit/${e.id}"/>">Edit</a>
                <br><a href="<c:url value="/expense/eventcost/${e.id}"/>">View</a>
                </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value="/event/add"/>">Add Event</a><br>
<a href="<c:url value="/userform/list"/>">List User</a><br>
<a href="<c:url value="/expense/list"/>">List Expenses</a><br>

</body>
</html>
