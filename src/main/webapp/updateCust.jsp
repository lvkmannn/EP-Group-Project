<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%> 
<%@ page import="PYS.connection.dBConnection"%> 
<%@ page import="PYS.bean.customer"%>
<%@ page import=" java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer</title>
<link href="css/addStaff.css" rel="stylesheet">
</head>
<body>
  <form class="form" action="updateCustController" method="post">
        <p class="title">Customer Update </p>

        <input type="hidden" name="custid" value="<c:out value="${c.custid}"/>"/><br>
        <label>
            <input required="" name="custname" type="text" class="input" value="<c:out value="${c.custname}"/>">
            <span>Customer Name</span>
        </label>
        
        <div class="flex">
            <label>
                <input required="" name="custphone" type="text" class="input" id="phonenum" value="<c:out value="${c.custphone}"/>">
                <span>Phone Number</span>
            </label>
    
            <label>
                <input required="" name="cust_email" type="text" class="input" id="email" value="<c:out value="${c.cust_email}"/>">
                <span>Email</span>
            </label> 
        </div>
    
        <label>
          <input required="" name="custaddress" type="text" class="input" value="<c:out value="${c.custaddress}"/>">
          <span>Address</span>
        </label> 
        
        <div class="flex">
            <label>
                <input required="" name="custcity" type="text" class="input" value="<c:out value="${c.custcity}"/>">
                <span>City</span>
              </label> 
      
              <label>
                  <input required="" name="custpostcode" type="text" class="input" value="<c:out value="${c.custpostcode}"/>">
                  <span>Postcode</span>
              </label>

              <label>
                <input required="" name="custstate" type="text" class="input" value="<c:out value="${c.custstate}"/>">
                <span>State</span>
            </label> 
        </div>

       

        <label>
            <input required="" name="custcountry" type="text" class="input" value="<c:out value="${c.custcountry}"/>">
            <span>Customer Country</span>
        </label> 

        
         </label>

        <label>
            <input required="" name="cust_username" type="text" class="input" value="<c:out value="${c.cust_username}"/>">
            <span>Username</span>
        </label>

        <label>
            <input required="" name="cust_password" id="myInput" type="password" class="input" value="<c:out value="${c.cust_password}"/>" >
            <span>Password</span>
            <input type="checkbox" onclick="myFunction()">Show Password
        </label>
		 <!-- Add a back button -->
       
        <button class="submit">Submit</button>
        <button class="reset" type="reset">Reset</button>
      </form>
</body>
<script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
</html>