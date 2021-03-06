<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<%--<%--%>
    <%--String firstname = request.getParameter("firstName");--%>
<%--%>--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User menu</title>
    <%--<link rel="stylesheet" href="css/styleAdmin.css">--%>
</head>
<body>

<p>
    <security:authorize access="isAuthenticated()">
    Welcome, <security:authentication property="principal.username" />
    </security:authorize>
</p>

<div class="controls">
    <p>
        <a href="<c:url value="/logout" />">Logout</a>
    </p>
</div>

<div class="controls">
    <form action='/admin/register'>
        <button type="submit">Add</button>
    </form>
</div>

<div class="container">
    <div class="row">

        <div class="col-md-10">
            <br><br>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thread>
                        <tr class="active">
                            <th>id</th>
                            <th>name</th>
                            <th>login</th>
                            <th>password</th>
                            <th>role</th>
                            <th>control</th>
                        </tr>
                    </thread>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.login}</td>
                            <td>${user.password}</td>
                            <td>
                                <c:forEach items="${user.roles}" var="item">
                                    ${item.name}<br>
                                </c:forEach>
                            </td>
                            <td align="center">
                                <div class="btn-group">
                                    <a href="/admin/edit?id=${user.id}"><button type="button" class="btn btn-primary">Edit</button></a>
                                    <a href="/admin/delete?id=${user.id}"><button type="button" class="btn btn-primary">Delete</button></a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


</body>
</html>