<form action="/polls/create" method="post">
    <label>Question: <input type="text" name="question" /></label><br/><br/>

    <label>Options (one per line):</label><br/>
    <textarea name="options" rows="5" cols="40"></textarea><br/><br/>

    <input type="submit" value="Create Poll" />
</form>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Create a New Poll</h2>

<form action="/polls/create" method="post">
    <label>Question:</label><br/>
    <input type="text" name="question" required/><br/><br/>

    <label>Options:</label><br/>
    <input type="text" name="options" placeholder="Option 1" required/><br/>
    <input type="text" name="options" placeholder="Option 2" required/><br/>
    <input type="text" name="options" placeholder="Option 3 (optional)"/><br/>
    <input type="text" name="options" placeholder="Option 4 (optional)"/><br/><br/>

    <input type="submit" value="Create Poll"/>
</form>
