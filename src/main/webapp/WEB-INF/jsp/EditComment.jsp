<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Edit Comment</h2>

<form action="${pageContext.request.contextPath}/comments/edit/${comment.id}" method="post">
    <textarea name="text" rows="4" cols="50">${comment.text}</textarea>
    <br/>
    <input type="submit" value="Save" />
</form>

