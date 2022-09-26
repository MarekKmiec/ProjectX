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
<h3>Dodawanie wydarzenia</h3>
<form:form method="post" action="/event/add" modelAttribute="event">
    name: <form:input path="name"/><br>
    data: <form:input path="date" /><br>
<%--    user:<form:input path="users"/><br>--%>
    User: <form:checkboxes path="users" items="${users}" itemLabel="name"  itemValue="id" multiple="true"/><br>
        <form:hidden path="id" />
    <%--    <form:errors path="*" />--%>
    <button type="submit">Save</button>
</form:form>


</body>
</html>
