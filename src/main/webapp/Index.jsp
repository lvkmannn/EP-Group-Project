<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/MainStyle.css">
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TRAVELOG</title>
</head>
<style>
	ul li a -button{
	margin-left: 500px;
}
</style>
 <script>
        // Function to navigate to the specified URL
        function navigateTo(url) {
            window.location.href = url;
        }
    </script>
<body>
<!--we need to check was the data(login) was entered -->
	<%
// 		//to prevent back button, make sure the page is 
// 		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");//response.setHeader(label, instruction)
// 		if(session.getAttribute("custusername")==null)
// 		{
// 			response.sendRedirect("HomePage.jsp");
// 		}
// 		if(session.getAttribute("username")==null)
// 		{
// 			response.sendRedirect("Index.jsp");
// 		}
		
		String name = (String) session.getAttribute("custusername");
		Integer custid = (Integer) session.getAttribute("custid");
	%>
  <!--For the Header-->
  <header>
      <a href="#" class="header-brand">TRAVELOG</a>
      <nav>
        <ul>
          <li><a href="Index.jsp">Home</a></li>
          <li><a href="addBookingController">Booking</a></li>
          <li><a href="listOneCustController">Account</a></li>
          <li><a href="#" id="login">Hello, <%= name %></a></li>
          <li><a href="LogoutController" class="logout">logout</a></li>
          
<%--           <li><a href="Login.html" id="">Hello, <%= name %></a></li> --%>
        </ul>
        <!--<a href="project.html" class="header-proj">Sign In</a>-->
      </nav>
           
  </header>

  <!--For MAIN Content-->
  <main>
     <section class="index-banner">
       <div class="vertical-center">
         <h2>EXPLORE NEW HORIZON<br>WITH UNFORGETTABLE EXPERIENCES</h2>
         <h1>Travel with TRAVELOG</h1>
       </div>
     </section>
     <div class=wrapper>
     <section>
	     		<!-- CONTENT -->
	     		<div class=content1>
	     			<p>DESTINATION<p>
	     			<button class="bookbtn" onclick="navigateTo('ViewPackages.jsp')">
	    <span class="icon">
	  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="24" fill="currentColor" class="bi bi-airplane-fill" viewBox="0 0 16 16">
	  <path d="M6.428 1.151C6.708.591 7.213 0 8 0s1.292.592 1.572 1.151C9.861 1.73 10 2.431 10 3v3.691l5.17 2.585a1.5 1.5 0 0 1 .83 1.342V12a.5.5 0 0 1-.582.493l-5.507-.918-.375 2.253 1.318 1.318A.5.5 0 0 1 10.5 16h-5a.5.5 0 0 1-.354-.854l1.319-1.318-.376-2.253-5.507.918A.5.5 0 0 1 0 12v-1.382a1.5 1.5 0 0 1 .83-1.342L6 6.691V3c0-.568.14-1.271.428-1.849Z"></path>
	</svg>
	    </span>
	    <span class="text">Book Now</span>
	</button>
	     		</div>
	     </section>
	     <section>
	     
	     	<div class="content2">
	     	<p>WHY CHOOSE TRAVELOG</p>
	     	Travelog is your ideal travel companion for an unforgettable trip, encompassing Flight Ticket, Baggage Fee, Airport Tax, Accommodation, and Transport. With a wide range of handpicked flight options and transparent baggage fees, booking your journey is hassle-free and cost-effective. You can travel with peace of mind, knowing that airport taxes are included in your booking, eliminating last-minute surprises.
	
	     	</div>
	     </section>
  </div>
     
  </main>
	<div class="wrapper">
  <!--For the Footer-->
	  <footer>
	    <ul class="footer-links-main">
	      <li><a href="#">Home</a></li>
	      <li><a href="#">Booking</a></li>
	      <li><a href="listOneCustController">Account</a></li>
	      <li><a href="#">Contact</a></li>
	    </ul>
	    <ul class="footer-links-project">
	      <li><p></p></li>
	      <li><a href="#"></a></li>
	      <li><a href="#"></a></li>
	      <li><a href="#"></a></li>
	      <li><a href="#"></a></li>
	    </ul>
	    <div class="footer-sm"> <!--sm = social media-->
	      <a href="#">
	        <img src="media/facebook.png" alt="facebook icon">
	      </a>
	      <a href="https://youtube.com/@Man-nv2rn">
	        <img src="media/youtube.png" alt="youtube icon">
	      </a>
	      <a href="#">
	        <img src="media/tiktok.png" alt="tiktok icon">
	      </a>
	    </div>
  	</footer>
  	<div class="footer-copyright">
    <p>&copy; 2023 TRAVELOG. All rights reserved.</p>
  </div>
   </div>
<!--    <form action="LogoutController" > -->
<%--       			Hello!! <%= name %><br> --%>
<%--       			id : <%= custid %><br> --%>
<!-- 				<input type="submit" value="Logout"> -->
<!--       		</form> -->
</body>
</html>