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
    <title>Expense</title>
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
<h3>Lista wydatków</h3>
<table>
    <tr>
        <th>Cost</th>
        <th>User</th>
        <th>Event</th>
        <th>Descriptions</th>
<%--        <th>AllCost</th>--%>

    </tr>
    <c:forEach items="${expense}" var="e">
        <tr>
            <td><c:out value="${e.cost}"/></td>
            <td><c:out value="${e.user}"/></td>
            <td><c:out value="${e.event}"/></td>
            <td><c:out value="${e.description}"/></td>
<%--            <td><c:out value="${e.allCost}"/></td>--%>
                <%--      <td><c:out value="${e.users}"/></td>--%>

            <td><a href="<c:url value="/expense/delete/${e.id}"/>"
                   onclick="return confirm('Are you sure you want to delete expense \'${e.description}\'?')">Delete</a>
                <br><a href="<c:url value="/expense/edit/${e.id}"/>">Edit</a></td>
        </tr>
    </c:forEach>


</table>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>All cost</th>--%>

<%--    </tr>--%>
<%--    <c:forEach items="${expense}" var="e">--%>
<%--        <tr>--%>
<%--            <td><c:out value="${e.allCost}"/></td>--%>

<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<a href="<c:url value="/expense/add"/>">Add Expenses</a><br>
<a href="<c:url value="/userform/list"/>">List User</a><br>
<a href="<c:url value="/event/list"/>">ListEvent</a><br>
</body>
</html>
