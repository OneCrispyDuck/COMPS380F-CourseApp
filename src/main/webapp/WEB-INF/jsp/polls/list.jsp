<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Available Polls</h2>

<c:forEach var="poll" items="${polls}">
    <div>
        <h3><a href="/polls/${poll.id}">${poll.question}</a></h3>
        <p>Created on: ${poll.createdAt}</p>
    </div>
</c:forEach>
