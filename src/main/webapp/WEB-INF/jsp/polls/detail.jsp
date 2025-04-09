<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Poll Details</title>
</head>
<body>

<h2>${poll.question}</h2>

<ul>
    <c:forEach var="option" items="${poll.options}">
        <li>
            ${option.text}
            <c:if test="${not empty option.votes}">
                - ${fn:length(option.votes)} votes
            </c:if>
        </li>
    </c:forEach>
</ul>

<br/>
<a href="${pageContext.request.contextPath}/polls/${poll.id}/vote">Vote in this Poll</a>

<hr>

<h3>Comments</h3>

<ul>
    <c:forEach var="comment" items="${comments}">
        <li>
            <strong>${comment.author.username}:</strong> ${comment.text}
            <c:if test="${comment.author.username == pageContext.request.userPrincipal.name}">
                <!-- Mostrar enlaces de edición solo si el autor es el usuario actual -->
                <a href="${pageContext.request.contextPath}/comments/edit/${comment.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/comments/delete/${comment.id}">Delete</a>
            </c:if>
        </li>
    </c:forEach>
</ul>

<!-- Mostrar formulario de comentario solo si el usuario ha iniciado sesión -->
<c:if test="${pageContext.request.userPrincipal != null}">
    <form action="${pageContext.request.contextPath}/comments/add" method="post">
        <textarea name="text" rows="3" cols="60" placeholder="Add your comment..."></textarea><br/>
        <input type="hidden" name="pollId" value="${poll.id}" />
        <input type="submit" value="Add Comment" />
    </form>
</c:if>

</body>
</html>