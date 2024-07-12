<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script>
function handleButtonClick() {
    var staffname = document.getElementById("staffname").value;
    if (staffname.trim() !== "") {
        location.href = 'searchController?action=search&staffname=' + encodeURIComponent(staffname);
    } else {
        // Handle empty search query (optional)
        alert("Please enter a search query.");
    }
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
<!--           <li><a href="LogoutController" id="login" style="padding-left:500px">LOG OUT</a></li> -->
        </ul>
        <!--<a href="project.html" class="header-proj">Sign In</a>-->
      </nav>
           
  </header>
  <!--For MAIN Content-->
	<main>
	<div class="wrapper">
		<div class="box">
        <h1 class="box-header">STAFF MANAGEMENT</h1>
	<div class="search_box">
        <input type="text" placeholder="Search staff by name" id="staffname" >
         <button type="button" onclick="handleButtonClick()">
        Search<i class="fa-sharp fa-solid fa-magnifying-glass"></i>
       </button>
      </div>
    </div>
	    <table style="width:100%">
        <thead>
            <tr>
                <th>STAFF ID</th>
                <th>STAFF NAME</th>
                <th>STAFF PHONE</th>
                <th>STAFF EMAIL</th>
                <th>STAFF ADDRESS</th>
                <th>STAFF CITY</th>
                <th>STAFF POSTCODE</th>
                <th>STAFF STATE</th>
                <th>STAFF COUNTRY</th>
                <th>STAFF SALARY</th>
                <th>MANAGER ID(0=NO MANAGER)</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>  
		<c:forEach items="${staffs}" var="s" varStatus="staffs">
		<tr>
        	<td><c:out value="${s.staffid}"/></td>
            <td><c:out value="${s.staffname}"/></td>
            <td><c:out value="${s.staffphone}"/></td> 
            <td><c:out value="${s.staff_email}"/></td>
            <td><c:out value="${s.staffaddress}"/></td>
            <td><c:out value="${s.staffcity}"/></td> 
            <td><c:out value="${s.staffpostcode}"/></td> 
            <td><c:out value="${s.staffstate}"/></td> 
            <td><c:out value="${s.staffcountry}"/></td> 
            <td><c:out value="${s.staffsalary}"/></td> 
            <td><c:out value="${s.managerid}"/></td>
			<td><button class="btn btn-update" id="<c:out value="${s.staffid}"/>" onclick="updateStaffJsp(this.id)">Update</button></td>
			<td><button class="btn btn-danger" id="<c:out value="${s.staffid}"/>" onclick="confirmation(this.id)">Delete</button></td>            
        </tr>
        </c:forEach>
    </table>
    <div> 
    	<td><button class="btn btn-addStaff" onclick="home()">BACK</button></td>
    	<td><button class="btn btn-addStaff" onclick="addStaffJsp()">ADD STAFF</button></td>
    	<button onclick="taskmanagement()" class="btn-primary">TASK MANAGEMENT</button>
    </div>
    <script>
    
    function home(){
      location.href = 'StaffMenu.jsp'
    }
    </script>
    <script>
    function taskmanagement(){
    	location.href='listBookingController'
    }
    function addStaffJsp(){
    	location.href='addStaff.jsp'
    }
    
   function updateStaffJsp(staffid){
	   location.href = 'updateStaffController?staffid=' + staffid;
   }
    
    function confirmation(staffid){
    	console.log(staffid);
    	var r = confirm("Are you sure you want to delete?");
    	
    	if (r == true){
    		location.href = 'deleteStaffController?staffid=' + staffid;
    		alert("Staff successfully deleted");      
      } else {          
          return false;  
      }
  }
  </script>
	</div>
  </main>
  <div class="wrapper">
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
    <div class="footer-copyright">
    <p>&copy; 2023 TRAVELOG. All rights reserved.</p>
  </div>
   </div>
</body>
</html>