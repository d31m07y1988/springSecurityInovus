<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="elements/headers.jsp"/>
    <title>Страница входа</title>
</head>
<body>
<div class="container">
    <div style="width: 400px;">
        <form:form action="spring_security_check" method="post">
            <h2 class="form-signin-heading">Введите учетные данные</h2>
            <input type="text" class="form-control" name="login" placeholder="Login">
            <input type="password" class="form-control" name="password" placeholder="Password">
            <button type="submit" class="btn btn-primary btn-md btn-block">Войти</button>
        </form:form>
        <a class="btn btn-primary btn-md btn-block" href="/sign-up">Регистрация</a>
    </div>
    <jsp:include page="elements/footer.jsp"/>
</div>
</body>
</html>
