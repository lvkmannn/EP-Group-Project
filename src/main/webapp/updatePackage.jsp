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
<title>Update Package</title>
<link href="css/addStaff.css" rel="stylesheet">
</head>
<body>
	<form class="form" action="updatePackageController" method="post">
        <p class="title">Package Update </p>

		<label>
            <input required="" name="packageid" type="text" class="input" value="<c:out value="${p.packageid}"/>">
            <span>Package ID</span>
        </label>

        <label>
            <input required="" name="packagename" type="text" class="input" value="<c:out value="${p.packagename}"/>">
            <span>Package Name</span>
        </label>
       
    
        <label>
          <input required="" name="p_destination" type="text" class="input" value="<c:out value="${p.p_destination}"/>">
          <span>Package Destination</span>
        </label> 
        
        <div class="flex">
            <label>
                <input required="" name="p_startdate" type="date" class="input" value="<c:out value="${p.p_startdate}"/>">
                <span>Start Date</span>
              </label> 
      
              <label>
                  <input required="" name="p_enddate" type="date" class="input" value="<c:out value="${p.p_enddate}"/>">
                  <span>End Date</span>
              </label>
        </div>

       

        <label>
            <input required="" name="packageprice" type="text" class="input" value="<c:out value="${p.packageprice}"/>">
            <span>Package Price</span>
        </label> 

        
         </label>

        <label>
            <input required="" name="packagedesc" type="text" class="input" value="<c:out value="${p.packagedesc}"/>">
            <span>Package Description</span>
        </label>

        
		 <!-- Add a back button -->
       
        <button class="submit" onclick="updatePackage()">Submit</button>
        <button class="reset" type="reset">Reset</button>
      </form>
</body>
<script>
function updatePackage() { 
    // Check if all required fields are filled 
    var allFieldsFilled = true; 
    var inputElements = document.getElementsByTagName("input"); 
    for (var i = 0; i < inputElements.length; i++) { 
        if (inputElements[i].hasAttribute("required") && inputElements[i].value === "") { 
            allFieldsFilled = false; 
            break; 
        } 
    } 

    // Display the alert based on the form validation 
    if (allFieldsFilled) { 
        alert("Package Successfully Updated"); 
    } else { 
        alert("Please fill out all required fields"); 
    } 
}
</script>
</html>