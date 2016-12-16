<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="elements/headers.jsp"/>
    <title>Страница входа</title>
</head>
<body>

<div class="container" style="width: 400px;">
    <form:form action="spring_security_check" method="post">
        <h2 class="form-signin-heading">Введите учетные данные</h2>
        <input type="text" class="form-control" name="username" placeholder="Login">
        <input type="password" class="form-control" name="password" placeholder="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form:form>
</div>

</body>
</html>
