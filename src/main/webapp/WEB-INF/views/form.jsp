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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

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
