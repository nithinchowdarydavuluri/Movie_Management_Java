<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Movies</title>
</head>
<body>

<h2>Movie List</h2>

<table border="1">
    <tr>
        <th>Index</th>
        <th>Name</th>
        <th>Genre</th>
        <th>Price</th>
    </tr>

    <c:forEach items="${movielist}" var="movie" >
        <tr>
            <td>${movie.id}</td>
            <td>${movie.name}</td>
            <td>${movie.genre}</td>
            <td>${movie.price}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>