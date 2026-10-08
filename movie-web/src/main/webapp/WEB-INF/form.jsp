<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>

<h1>Add Movie</h1>

<form action="${pageContext.request.contextPath}/movie" method="POST">

    <label for="name">Movie Name:</label>
    <input type="text" id="name" name="name" required>

    <br><br>

    <label for="genre">Genre:</label>
    <input type="text" id="genre" name="genre" required>

    <br><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required>

    <br><br>

    <label for="database">Select Database:</label>

    <select id="database" name="database" required>
        <option value="">-- Select Database --</option>
        <option value="mysql">MySQL</option>
        <option value="postgresql">PostgreSQL</option>
    </select>

    <br><br>

    <button type="submit" id="submit">Add Movie</button>

</form>

</body>
</html>