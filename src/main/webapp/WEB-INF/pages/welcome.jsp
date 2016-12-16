<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <jsp:include page="elements/headers.jsp"/>
</head>
<body>

<div class="container">

    <div class="jumbotron" style="margin-top: 20px;">
        <h1>Welcome</h1>

        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/sign-in" />" role="button">Войти</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <form:form class="navbar-form" action="logout" method="post">
                <p><c:out value="${greet}"/>, <sec:authentication property="principal.username"/></p>
                <p>
                    <input type="submit" class="btn btn-primary" value="Выйти">
                </p>
            </form:form>
        </sec:authorize>
    </div>

    <div class="footer">
        <p>© Kazan 2016</p>
    </div>

</div>

</body>
</html>
