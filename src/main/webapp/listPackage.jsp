<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html lang="en">
<head>
<style>
.btn {
  border: none;
  color: white;
  padding: 7px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
/*   font-size: 16px; */
/*   margin: 4px 2px; */
  cursor: pointer;
}
.btn-updatepackage{
	background-color: #4CAF50;
}
.btn-deletepackage{
	background-color: #f44336;
}
.btn-home{
	background-color: #008CBA;
}
.btn-addPackage{
	color:black;
	background-color: #baae00;
}
</style>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TRAVELOG</title>
</head>
  <!--For MAIN Content-->
    
 <script>
        // Function to navigate to the specified URL
        function navigateTo(url) {
            window.location.href = url;
        }
    </script>

  <!--For the Header-->
  <header>
      <a href="portfolio.html" class="header-brand">TRAVELOG</a>
      <nav>
        <ul>
<!--           <li><a href="portfolio.html">Home</a></li> -->
<!--           <li><a href="listCust.jsp">Customer</a></li> -->
<!--           <li><a href="contact.html">About Us</a></li> -->
<!--           <li><a href="#">Contact</a></li> -->
<!--           <li><a href="#" id="login">LOG IN</a></li> -->
        </ul>
        <!--<a href="project.html" class="header-proj">Sign In</a>-->
      </nav>
           
  </header>
  <!--For MAIN Content-->
	<main>
	<div class="wrapper">
		<div class="box">
        <h1 class="box-header">PACKAGE MANAGEMENT</h1>

    </div>
	    <table style="width:100%">
        <thead>
            <tr>
                <th>PACKAGE ID</th>
                <th>PACKAGE NAME</th>
                <th>DESTINATION</th>
                <th>START DATE</th>
                <th>END DATE</th>
                <th>PRICE</th>
                <th>DESCRIPTION</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
		<c:forEach items="${packages}" var="p" varStatus="packages">
		<tr>
        	<td><c:out value="${p.packageid}"/></td>
            <td><c:out value="${p.packagename}"/></td>
            <td><c:out value="${p.p_destination}"/></td> 
            <td><c:out value="${p.p_startdate}"/></td>
            <td><c:out value="${p.p_enddate}"/></td>
            <td><c:out value="${p.packageprice}"/></td> 
            <td><c:out value="${p.packagedesc}"/></td>
            <td><button class="btn btn-updatepackage" id="<c:out value="${p.packageid}"/>" onclick="updatepackageJsp(this.id)">UPDATE</button></td>
            <td><button class="btn btn-deletepackage" id="<c:out value="${p.packageid}"/>" onclick="confirmation(this.id)">DELETE</button></td>
        </tr>
        </c:forEach>
    </table>
     <div> 
      <td><button class="btn btn-home" onclick="home()">BACK</button></td>
      <td><button class="btn btn-addPackage" onclick="addPackage()">ADD PACKAGE</button></td>
    </div>
    <script>
    
    function home(){
      location.href = 'StaffMenu.jsp'
    }
    
    function addPackage(){
        location.href = 'addPackage.jsp'
      }
    </script>
    <script>
    
    
   function updatepackageJsp(packageid){
	   location.href = 'updatePackageController?packageid=' + packageid;
   }
	
   function confirmation(packageid){
   	console.log(packageid);
   	var r = confirm("Are you sure you want to delete?");
   	
   	if (r == true){
   		location.href = 'deletePackageController?packageid=' + packageid;
   		alert("Package successfully deleted");      
     } else {          
         return false;  
     }
 }
   </script>
	</div>
  </main>
  <div class="wrapper" style="background-color: transparent;">

     <div class="footer-copyright" style="background-color: transparent;">
    <p>&copy; 2023 TRAVELOG. All rights reserved.</p>
  </div>
   </div>
</body>
</html>