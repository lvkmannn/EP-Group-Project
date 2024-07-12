<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Invoice</title>
</head>
<body>
    <h2>Invoice Details:</h2>
    <p><strong>Customer Name:</strong> <%= request.getAttribute("customerName") %></p>
    <p><strong>Booking ID:</strong> <%= request.getAttribute("bookingId") %></p>
    <p><strong>Package Name:</strong> <%= request.getAttribute("packageName") %></p>
    <p><strong>Quantity of People:</strong> <%= request.getAttribute("quantityOfPeople") %></p>
    <p><strong>Package Price per Person:</strong> RM <%= request.getAttribute("packagePrice") %></p>
    <p><strong>Total Amount:</strong> RM <%= request.getAttribute("totalAmount") %></p>
    <!-- ...other invoice details... -->
</body>
</html>
    