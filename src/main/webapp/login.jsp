<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<div class="container">
    <div>
        <c:if test="${not empty sessionScope.msg}" >
            <span style="color: red"><c:out value="${sessionScope.msg}"/></span>
            <c:remove var="msg" scope="session" />
        </c:if>
    </div>

    <div class="row" style="margin-top:20px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form class="auth-form" action='<spring:url value="/loginAction"/>' method="POST">
                <fieldset>
                    <h2>Please log in</h2>
                    <hr class="colorgraph">
                    <div class="form-group">
                        <input type="text" name="username" id="username" class="form-control input-lg"
                               placeholder="Login">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" id="password" class="form-control input-lg"
                               placeholder="Password">
                    </div>
                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Log In">
                        </div>
                    </div>
                </fieldset>
            </form>

            <%--<form action='<spring:url value="/loginAction"/>' method="post">--%>
            <%--<table>--%>
            <%--<tr>--%>
            <%--<td>Username</td>--%>
            <%--<td><input type="text" name="username"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>Password</td>--%>
            <%--<td><input type="password" name="password"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><button type="submit">Login</button></td>--%>
            <%--</tr>--%>
            <%--</table>--%>
            <%--</form>--%>


        </div>
    </div>

</div>

</body>
</html>