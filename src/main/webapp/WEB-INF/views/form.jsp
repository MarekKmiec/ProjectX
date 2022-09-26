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
    <title>User form</title>

</head>
<body>
<h3>Dodawanie użytkownika</h3>
<form:form method="post" action="/userform/add" modelAttribute="user">
    name: <form:input path="name"/><br>
    Balance: <form:input path="balance" /><br>
    phoneNumber: <form:input path="phoneNumber" /><br>
    <form:hidden path="id" />
    <%--    <form:errors path="*" />--%>
    <button type="submit">Save</button>
</form:form>


</body>
</html>
