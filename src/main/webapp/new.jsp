<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <form class="form-horizontal" action='/admin/register' method="POST">

    <fieldset>

        <div class="control-group">
            <!-- Name -->
            <label class="control-label" for="name">name</label>
            <div class="controls">
                <input type="text" id="name" name="name" value="${user.name}" placeholder="" class="input-xlarge">
            </div>
        </div>

        <div class="control-group">
            <!-- Login -->
            <label class="control-label"  for="login">login</label>
            <div class="controls">
                <input type="text" id="login" name="login" value="${user.login}" placeholder="" class="input-xlarge">
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="password">password</label>
            <div class="controls">
                <input type="password" id="password" name="password" value="${user.password}" placeholder="" class="input-xlarge">
            </div>
        </div>

        <div class="control-group">
            <!-- Password-->
            <label class="control-label" for="role">role</label>
            <div class="controls">
                <input type="text" id="role" name="role" value="" placeholder="" class="input-xlarge">
            </div>
        </div>

        <div class="control-group">
            <!-- Button -->
            <div class="controls">
                <button type="submit" class="btn btn-success">
                    add User
                </button>
            </div>
        </div>
    </fieldset>
</form>

</body>
</html>