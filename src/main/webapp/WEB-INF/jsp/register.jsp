<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <form method="post" action="/register">
        Username: <input type="text" name="username"/><br/>
        Password: <input type="password" name="password"/><br/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Register"/>
    </form>

    <c:if test="${param.success != null}">
        <p style="color: green">Account created successfully. Please <a href="/login">login</a>.</p>
    </c:if>

    <c:if test="${param.error != null}">
        <p style="color: red">Registration failed. Username may already exist.</p>
    </c:if>
</body>
</html>