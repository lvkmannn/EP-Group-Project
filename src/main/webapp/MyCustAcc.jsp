<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="java.sql.*"%> 
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.LocalDateTime"%>>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="PYS.connection.*" %>
<!DOCTYPE html>
<html>
<head>
  <title>Account Information</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
  <style>
    * {
      box-sizing: border-box;
    }
    
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
      background-color: #f9f9f9;
    }
    
    h1 {
      text-align: center;
      color: #333;
      margin-bottom: 20px;
    }
    
    .form-container {
      max-width: 500px;
      margin: 0 auto;
      background-color: #ffffff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      transform: scale(1);
      opacity: 1;
      transition: transform 0.3s ease, opacity 0.3s ease;
    }
    
    .form-container label {
      display: block;
      margin-bottom: 10px;
      font-weight: bold;
      color: #555;
    }
    
    .form-container input[type="text"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 14px;
      transition: border-color 0.3s ease;
    }
    
    .form-container input[type="hidden"] {
      display: none;
    }
    
    .form-container .flex {
      display: flex;
      margin-bottom: 15px;
    }
    
    .form-container .flex label {
      flex: 1;
    }
    
    .form-container .button-container {
      text-align: center;
      margin-top: 20px;
    }
    
    .form-container .button-container button {
      background-color: #4caf50;
      color: #fff;
      border: none;
      padding: 10px 20px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 16px;
      border-radius: 4px;
      cursor: pointer;
      transition: background-color 0.3s ease, transform 0.3s ease;
    }
    
    .form-container .button-container button:hover {
      background-color: #45a049;
      transform: translateY(-2px);
    }
    
    .form-container .button-container button:focus {
      outline: none;
      box-shadow: 0 0 0 3px rgba(69, 160, 73, 0.4);
    }
    
    .form-container.fade-out {
      transform: scale(0.95);
      opacity: 0;
    }
    
    .form-container.fade-out input[type="text"] {
      border-color: #ddd;
    }
    
    .form-container.fade-out .button-container button {
      transform: translateY(2px);
    }
    
    @media screen and (max-width: 480px) {
      .form-container {
        padding: 10px;
      }
      
      .form-container input[type="text"] {
        font-size: 12px;
      }
    }
  </style>
  <script>
    function redirectToUpdatePage(custid) {
      window.location.href = 'updateCustController?custid=' + custid;
    }
    function redirectToindexPage() {
        window.location.href = 'Index.jsp'
      }
  </script>
</head>
<body>
  <div class="form-container">
    <h1>Account Information</h1>
  
    <label>CUSTOMER INFO</label>
    <div class="flex">
      <% int custid = (Integer) session.getAttribute("custid"); %>
      <input name="custid" type="hidden" value="<%=custid%>" readonly required>
      <input name="staffid" type="hidden" value="8" readonly>
    
      <label>
        <input name="custname" type="text" value="<c:out value="${c.custname}"/>" readonly>
      </label>
    </div>
  
    <label>PHONE NUMBER</label>
    <label>
      <input required="" name="custphone" type="text" id="phone" value="<c:out value="${c.custphone}"/>" readonly>
    </label>
  
    <label>EMAIL</label>
    <label>
      <input required="" name="cust_email" type="text" id="email" value="<c:out value="${c.cust_email}"/>" readonly>
    </label>
  
    <label>ADDRESS</label>
    <div class="flex">
      <label>
        <input required="" name="custaddress" type="text" value="<c:out value="${c.custaddress}"/>" readonly>
      </label>
    
      <label>
        <input required="" name="custcity" type="text" placeholder="CITY" value="<c:out value="${c.custcity}"/>" readonly>
      </label>
    
      <label>
        <input required="" name="custpostcode" type="text" placeholder="POSTCODE" value="<c:out value="${c.custpostcode}"/>" readonly>
      </label>
    </div>
    
    <div class="flex">
      <label>
        <input required="" name="custstate" type="text" placeholder="STATE" value="<c:out value="${c.custstate}"/>" readonly>
      </label>

      <label>
        <input required="" name="custcountry" type="text" placeholder="COUNTRY" value="<c:out value="${c.custcountry}"/>" readonly>
      </label>
    </div>
     
    <div class="button-container">
    <button type="button" onclick="redirectToindexPage()">Back</button>
      <button type="button" onclick="redirectToUpdatePage('<%=custid%>')">Update</button>
    </div>
  </div>
</body>
</html>
