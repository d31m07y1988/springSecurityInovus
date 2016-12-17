<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="elements/headers.jsp"/>
    <title>Страница регистрации</title>
</head>
<body>
<div class="container">
    <div style="width: 400px;">
        <form:form modelAttribute="user" method="POST" enctype="utf8">
            <h2 class="form-signin-heading">Регистрация пользователя:</h2>
            <form:input type="text" class="form-control" path="login" placeholder="Login"/>
            <form:errors path="login" element="div" />

            <form:input type="password" class="form-control" path="password" placeholder="Password"/>
            <form:errors path="password" element="div" />

            <form:input type="password" class="form-control" path="matchingPassword" placeholder="Confirm password"/>
            <form:errors element="div" />

            <button type="submit" class="btn btn-primary btn-md btn-block">Зарегистрироваться</button>
        </form:form>
    </div>
    <jsp:include page="elements/footer.jsp"/>
</div>
</body>
</html>
