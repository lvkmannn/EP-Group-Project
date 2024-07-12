<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html lang="en">
<head>
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
        <h1 class="box-header">BOOKING MANAGEMENT</h1>

    </div>
	    <table style="width:100%">
        <thead>
            <tr>
                <th>BOOKING ID</th>
                <th>BOOKING DATE</th>
                <th>BOOKING STATUS</th>
                <th>PACKAGE ID</th>
                <th>QTYPEOPLE</th>
                <th>STAFF ID</th>
                <th>CUSTOMER ID</th>
                <th colspan="1">Action</th>
            </tr>
        </thead>
		<c:forEach items="${bookings}" var="b" varStatus="bookings">
		<tr>
        	<td><c:out value="${b.booking_id}"/></td>
            <td><c:out value="${b.booking_date}"/></td>
            <td><c:out value="${b.booking_status}"/></td> 
            <td><c:out value="${b.packageid}"/></td>
            <td><c:out value="${b.qtypeople}"/></td>
            <td><c:out value="${b.staffid}"/></td> 
            <td><c:out value="${b.custid}"/></td>
            <td><button class="btn btn-taskmanagement" id="<c:out value="${b.booking_id}"/>" onclick="taskManagementJsp(this.id)">TASK MANAGEMENT</button></td>
            
        </tr>
        </c:forEach>
    </table>
     <div> 
      <td><button class="btn btn-addStaff" onclick="home()">BACK</button></td>
    </div>
    <script>
    
    function home(){
      location.href = 'StaffMenu.jsp'
    }
    </script>
    <script>
    
//     function addStaffJsp(){
//     	location.href='addStaff.jsp'
//     }
    
   function taskManagementJsp(booking_id){
	   location.href = 'updateBookingController?booking_id=' + booking_id;
   }
    
//     function confirmation(staffid){
//     	console.log(staffid);
//     	var r = confirm("Are you sure you want to delete?");
    	
//     	if (r == true){
//     		location.href = 'deleteStaffController?staffid=' + staffid;
//     		alert("Staff successfully deleted");      
//       } else {          
//           return false;  
//       }
//   }
   </script>
	</div>
  </main>
  <div class="wrapper" style="background-color: transparent;">
  <!--For the Footer-->
<!--     <footer> -->
<!--       <ul class="footer-links-main"> -->
<!--         <li><a href="#">Home</a></li> -->
<!--         <li><a href="#">Booking</a></li> -->
<!--         <li><a href="#">About us</a></li> -->
<!--         <li><a href="#">Contact</a></li> -->
<!--       </ul> -->
<!--       <ul class="footer-links-project"> -->
<!--         <li><p>OUR LOCATION</p></li> -->
<!--         <li><a href="#"></a></li> -->
<!--         <li><a href="#"></a></li> -->
<!--         <li><a href="#"></a></li> -->
<!--         <li><a href="#"></a></li> -->
<!--       </ul> -->
<!--       <div class="footer-sm"> sm = social media -->
<!--         <a href="#"> -->
<!--           <img src="media/facebook.png" alt="facebook icon"> -->
<!--         </a> -->
<!--         <a href="https://youtube.com/@Man-nv2rn"> -->
<!--           <img src="media/youtube.png" alt="youtube icon"> -->
<!--         </a> -->
<!--         <a href="#"> -->
<!--           <img src="media/tiktok.png" alt="tiktok icon"> -->
<!--         </a> -->
<!--       </div> -->
<!--     </footer> -->
     <div class="footer-copyright" style="background-color: transparent;">
    <p>&copy; 2023 TRAVELOG. All rights reserved.</p>
  </div>
   </div>
</body>
</html>
