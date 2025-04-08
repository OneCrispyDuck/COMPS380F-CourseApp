<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>${poll.question}</h2>

<ul>
    <c:forEach var="option" items="${poll.options}">
        <li>${option.text}</li>
    </c:forEach>
</ul>