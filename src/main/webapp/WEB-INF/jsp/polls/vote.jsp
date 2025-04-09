<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Vote</title>
</head>
<body>
    <h2>${poll.question}</h2>

    <c:if test="${param.success == 'voted'}">
        <p style="color:green;">✅ Thank you for voting!</p>
    </c:if>
    <c:if test="${param.error == 'already_voted'}">
        <p style="color:red;">⚠️ You have already voted in this poll.</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/polls/${poll.id}/vote" method="post">
        <c:forEach var="option" items="${poll.options}">
            <input type="radio" name="selectedOptionId" value="${option.id}" required/>
            ${option.text}<br/>
        </c:forEach>
        <br/>
        <input type="submit" value="Submit Vote"/>
    </form>
</body>
</html>