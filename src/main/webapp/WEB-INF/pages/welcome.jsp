<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <jsp:include page="elements/headers.jsp"/>
    <title>Spring security</title>
</head>
<body>

<div class="container">

    <div class="jumbotron" style="margin-top: 20px;">
        <h2>Welcome</h2>

        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/sign-in" />" role="button">Войти</a></p>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <form:form class="navbar-form" action="logout" method="post">
                <p><c:out value="${greet}"/>, <c:out value="${userName}"/>!</p>
                <p>
                    <button class="btn btn-primary" type="submit">Выйти</button>
                </p>
            </form:form>
        </sec:authorize>
    </div>

    <jsp:include page="elements/footer.jsp"/>

</div>

</body>
</html>
