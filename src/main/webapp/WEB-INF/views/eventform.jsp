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
<form:form method="post" action="/event/add" modelAttribute="events">
    name: <form:input path="name"/><br>
    data: <form:input path="date" /><br>
<%--    user:<form:input path="users"/><br>--%>
<%--    User: <form:select path="users" items="${user}" itemLabel="name"  itemValue="id" multiple="true"/><br>--%>
        <form:hidden path="id" />
    <%--    <form:errors path="*" />--%>
    <button type="submit">Save</button>
</form:form>

</body>
</html>
