<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Book A Movie</title>
</head>
<body>
<h1>Book A Movie</h1>
<form action="${pageContext.request.contextPath}/bookAmovie" method="POST">
    <label for="movie">Choose a movie:</label>

    <select name="movie" id="movie">
      <option value="" disabled selected hidden>Select an option...</option>
      <c:forEach items="${movielist}" var="movie" >
             <option value=${movie.id}>${movie.name}</option>
      </c:forEach>

    </select>

    <br><br>
    <label for="customer">Customer:</label>
     <select name="customer" id="customer">
          <option value="" disabled selected hidden>Select an option...</option>
          <c:forEach items="${customerlist}" var="cus" >
                 <option value=${cus.id}>${cus.name}</option>
          </c:forEach>
      </select>

     <label for="category">Ticket Category:</label> <select id="category" name="category"> <option value="1">REGULAR</option> <option value="2">PREMIUM</option> <option value="3">VIP</option> <option value="4">RECLINER</option> </select>


    <button type="submit" id="submit">Book a movie</button>
</form>
</body>
</html>