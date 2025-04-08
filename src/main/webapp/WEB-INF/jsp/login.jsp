<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form method="post" action="/login">
        Username: <input type="text" name="username"/><br/>
        Password: <input type="password" name="password"/><br/>
        Remember Me: <input type="checkbox" name="remember-me"/><br/>

        <!-- CSRF token -->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <input type="submit" value="Log In"/>
    </form>

    <c:if test="${param.error != null}">
        <p style="color: red">Invalid username or password.</p>
    </c:if>

    <c:if test="${param.logout != null}">
        <p style="color: green">You have been logged out.</p>
    </c:if>
</body>
</html>