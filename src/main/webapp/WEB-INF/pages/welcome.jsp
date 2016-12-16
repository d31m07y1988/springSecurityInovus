<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Hello everyone!

<c:if test="${not empty users}">
    <c:out value="${users}"/>
</c:if>


</body>
</html>
