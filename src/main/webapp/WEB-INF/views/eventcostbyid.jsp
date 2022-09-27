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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<style>
    /*th {*/
    /*    color: rgb(255, 255, 255);*/
    /*    border: 1px solid rgb(219, 219, 219);*/
    /*    font-weight: normal;*/
    /*    background-color: rgb(124, 124, 125);*/
    /*}*/
    /*table {*/
    /*    border-collapse: collapse;*/
    /*}*/
    /*td {*/
    /*    color: rgb(77, 77, 79);*/
    /*    border: 1px solid rgb(219, 219, 219);*/
    /*    background-color: rgb(231, 231, 231);*/
    /*}*/
    /*td, th {*/
    /*    padding: 15px 20px;*/
    /*}*/
</style>
<body>
<h3>Lista wydatków event</h3>
<table class="table table-striped ">
    <tr>
        <th scope="col">Cost</th>
        <th scope="col">User</th>
        <th scope="col">Event</th>
        <th scope="col">Descriptions</th>
        <th scope="col">Action</th>
        <%--        <th>AllCost</th>--%>

    </tr>
    <c:forEach items="${allexpense}" var="e">
        <tr>
            <td><c:out value="${e.cost}"/></td>
            <td><c:out value="${e.user}"/></td>
            <td><c:out value="${e.event}"/></td>
            <td><c:out value="${e.description}"/></td>


            <td><a href="<c:url value="/expense/delete/${e.id}"/>"
                   onclick="return confirm('Are you sure you want to delete expense \'${e.description}\'?')">Delete</a>
                <br><a href="<c:url value="/expense/edit/${e.id}"/>">Edit</a></td>
        </tr>
    </c:forEach>

    <a href="<c:url value="/expense/add"/>">Add Expenses</a><br>
    <a href="<c:url value="/userform/list"/>">List User</a><br>
    <a href="<c:url value="/event/list"/>">ListEvent</a><br>
</table>
<br>

<table class="table table-striped ">
    <tr>
        <th scope="col">name</th>
        <th scope="col">cost</th>
        <th scope="col">subCost</th>


    </tr>
    <c:forEach items="${allusercost}" var="e">
        <tr>
            <td><c:out value="${e.key}"/></td>
            <td><c:out value="${e.value}"/></td>
            <td><c:out value="${e.value-summary.avg}"/></td>

        </tr>
    </c:forEach>


</table>
<br>

${summary.sumAmount} / ${summary.sumUser} =${summary.avg}<br>

<table class="table table-striped ">
    <tr>
        <th scope="col">nazwa wydarzenia</th>
        <th scope="col">id wydarzenia</th>


    </tr>
    <c:forEach items="${allEventByIdMap}" var="e">
        <tr>
            <td><c:out value="${e.key}"/></td>
            <td><c:out value="${e.value}"/></td>


        </tr>
    </c:forEach>


</table>
<br>

<table class="table table-striped ">
    <tr>
        <th scope="col">do oddania</th>
        <th scope="col">oddajacy</th>
    </tr>
    <c:forEach items="${Bild}" var="e">
        <tr>
            <td><c:out value="${e.key.userName}"/> <c:out value="${e.key.cost}"/></td>
            <td>
                <c:forEach items="${e.value}" var="o">
                    <c:out value="${o.userName}"/> <c:out value="${o.cost}"/><br>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
