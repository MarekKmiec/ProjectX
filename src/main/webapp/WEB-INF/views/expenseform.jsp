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