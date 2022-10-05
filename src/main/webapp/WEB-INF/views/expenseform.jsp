<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 21.09.2022
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Event form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>
<body>
<h3>Dodanie wydatku</h3>
<form:form method="post" action="/expense/add" modelAttribute="expense">
  cost: <form:input path="cost"/><br>
  description: <form:input path="description" /><br>
<%--  allCost: <form:input path="allCost" /><br>--%>
  <%--    user:<form:input path="users"/><br>--%>
  User: <form:select path="user" items="${users}" itemLabel="name"  itemValue="id" /><br>
  Event: <form:select path="event" items="${events}" itemLabel="name"  itemValue="id" /><br>
  <form:hidden path="id" />
  <%--    <form:errors path="*" />--%>
  <button type="submit">Save</button>
</form:form>

</body>
</html>