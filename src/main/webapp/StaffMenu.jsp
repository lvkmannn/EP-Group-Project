<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Home</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
    }
    
    .container {
      max-width: 800px;
      margin: 0 auto;
    }
    
    .header {
      text-align: center;
      margin-bottom: 30px;
    }
    
    .welcome-message {
      font-size: 24px;
      font-weight: bold;
      margin-bottom: 20px;
    }
    
    .link-container {
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
    }
    
    .link-container a {
      display: block;
      width: 200px;
      height: 120px;
      margin: 10px;
      padding: 10px;
      background-color: #f0f0f0;
      border-radius: 4px;
      text-decoration: none;
      text-align: center;
      line-height: 100px;
      font-size: 18px;
      color: #333;
      transition: background-color 0.3s ease;
    }
    
    .link-container a:hover {
      background-color: #e0e0e0;
    }
    
    @media screen and (max-width: 600px) {
      .link-container a {
        width: 100%;
        height: 80px;
        line-height: 60px;
        font-size: 16px;
      }
    }
  </style>
</head>
<body>
  <div class="container">
    <div class="header">
      <h1>TRAVELOG</h1>
      <% Integer managerId = (Integer) session.getAttribute("managerid"); %>
      <% String username = (String) session.getAttribute("username");%>
      <p class="welcome-message">Hello, <%= username %></p>
      <form action="LogoutController" method="GET">
        <button type="submit" class="btn btn-primary">Logout</button>
      </form>
    </div>
    
    <div class="link-container">
      <a href="addStaff.jsp">Add Staff</a>
      <a href="listStaffController">List Staff</a>
      <a href="listCustController">List Customer</a>
      <a href="listBookingController">List Booking</a>
      <a href="reportController">Sales Report</a>
      <a href="Index.jsp">Travelog Page</a>
      <a href=listPackageController>List Package</a>
    </div>
  </div>
</body>
</html>
