<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: marek--%>
<%--  Date: 04.10.2022--%>
<%--  Time: 21:15--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Login</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<img src="IMG-2773.png" width="400" height="200" alt="kwiatki">--%>
<%--&lt;%&ndash;<img alt="govno" src="<%=request.getContextPath() + "/home/marek/Desktop/Workspace/Fotki/IMG-2773.png"%>" style="width: 400px; height: 300px;">&ndash;%&gt;--%>
<%--<form  method="post">--%>
<%--  <h1 >Login to eventShareMoney</h1>--%>
<%--  <div class="table table-striped ">--%>
<%--    <input type="text" class="form-control" id="name" name="name" placeholder="name">--%>
<%--  </div>--%>
<%--  <div class="table table-striped ">--%>
<%--    <input type="password" class="form-control" id="password" name="password" placeholder="password">--%>
<%--  </div>--%>
<%--  <button class="btn btn-color rounded-0" type="submit">Sign in</button>--%>
<%--</form>--%>

<%--</body>--%>
<%--</html>--%>


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
  <title>Login</title>
  <style >
    .errors{
      color:red;
    }
  </style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>
<body>
<h3>Login to eventShareMoney</h3>

<form:form method="post" action="/" modelAttribute="admin">


  name: <form:input path="login"/><form:errors path="login" cssClass="errors" /><br>
  password: <form:password path="password" /><form:errors path="password" cssClass="errors" /><br>
  <form:hidden path="id" />
<%--      <form:errors path="*" />--%>
  <button type="submit">Save</button>
</form:form>


</body>
</html>
