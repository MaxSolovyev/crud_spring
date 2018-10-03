<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: maximus
  Date: 20.08.2018
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login form</title>
  <%--<link rel="stylesheet" href="css/style.css">--%>
</head>
<body>

<p>
  <security:authorize access="isAuthenticated()">
    Welcome to the main page, <security:authentication property="principal.username" />
  </security:authorize>
  <security:authorize access="! isAuthenticated()">
    Welcome to the main page. You are not logged in!
  </security:authorize>
</p>

<div class="controls">
  <a href="<c:url value="/logout" />">Logout</a>
  <%--<form action="/logout" method="POST">--%>
    <%--<input value="Logout" type="submit">--%>
  <%--</form>--%>
</div>

</body>
</html>