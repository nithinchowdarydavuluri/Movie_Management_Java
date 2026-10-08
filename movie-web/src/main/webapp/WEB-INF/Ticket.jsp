<%@ page import="java.util.List" %>
<%@ page import="org.example.Model.BookingDetails" %>
<!DOCTYPE html> <html lang="en">
<head> <meta charset="UTF-8">
<title>All Bookings</title>
<style> body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 30px; } h1 { text-align: center; margin-bottom: 30px; } .container { width: 95%; margin: auto; } table { width: 100%; border-collapse: collapse; background-color: white; } th, td { padding: 12px; border: 1px solid #ddd; text-align: center; } th { background-color: #333; color: white; } tr:nth-child(even) { background-color: #f9f9f9; } .status { font-weight: bold; } .empty { text-align: center; padding: 30px; background-color: white; }
</style>
</head>
<body>
<div class="container">
<h1>All Movie Bookings</h1>
<% List<BookingDetails> bookings = (List<BookingDetails>) request.getAttribute("bookings"); %>
<% if (bookings != null && !bookings.isEmpty()) { %>
<table>
<thead>
<tr>
<th>Ticket ID</th>
<th>Movie Name</th>
<th>Genre</th>
<th>Price</th>
<th>Customer</th>
<th>Category</th>
<th>Status</th> </tr>
 </thead>
  <tbody>
  <% for (BookingDetails booking : bookings) { %>
  <tr>
  <td><%= booking.getMovieId() %></td>
  <td><%= booking.getMovieName() %></td>
  <td><%= booking.getGenre() %></td>
  <td>₹<%= booking.getPrice() %></td>
  <td><%= booking.getCustomerName() %></td>
  <td><%= booking.getCategory() %></td>
  <td class="status">
   <%= booking.getStatus() %>
   </td>
   <td>
   <% if (!"CONFIRMED".equals(booking.getStatus())) { %>
   <a href="${pageContext.request.contextPath}/payNow?ticketId=<%= booking.getMovieId() %>&&price=<%= booking.getPrice() %>&CustomerId=<%= booking.getCustomerId() %>"
       class="pay-btn">
       Pay Now
   </a>
   <% } %>
   </td>
   </tr>
   <% } %>
   </tbody>
   </table>
   <% } else { %>
   <div class="empty"> <h3>No bookings found.</h3> </div> <% } %> </div> </body> </html>