<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/ViewPackagesCSS.css">
<title>Travel Agency</title>
</head>
<script>
Array.from(document.getElementsByTagName('input')).forEach((e,i)=>{
	e.addEventListener('keyup', (el)=>{
		if(e.value.length > 0){
			document.getElementsByClassName('bi-caret-down-fill')[i].style.transform = "rotate(180deg)";
			
		} else {
			document.getElementsByClassName('bi-caret-down-fill')[i].style.transform = "rotate(0deg)";
		}
	})
})
</script>
<body>
<!--we need to check was the data(login) was entered -->
	<%
		//to prevent back button, make sure the page is 
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");//response.setHeader(label, instruction)
		if(session.getAttribute("custusername")==null)
		{
			response.sendRedirect("HomePage.jsp");
		}
		
		String name = (String) session.getAttribute("custusername");
	%>
  <!--For the Header-->
  <header>
      <a href="#" class="header-brand">TRAVELOG</a>
      <nav>
        <ul>
          <li><a href="Index.jsp">Home</a></li>
          <li><a href="addBookingController">Booking</a></li>
          <li><a href="listOneCustController">Account</a></li>
<%--           <li><a href="#" id="login">Hello, <%= name %></a></li> --%>
<!--           <li><a href="LogoutController" class="logout">logout</a></li> -->
        </ul>
        <!--<a href="project.html" class="header-proj">Sign In</a>-->
      </nav>
           
  </header>
<main>
     <nav>
       <h4>Travel Tours with Travelog</h4>
       <ul>
          <li><a href="LogoutController">LOGOUT</a></li>
       </ul>
     </nav>
     <div class="content">
      <div class="cont_bx">
         <h1>The right destination for you and your family</h1>
         <p>"Embark on Adventure, Create Memories."</p>
         <button>Get Started</button>
       </div>
       <div class="trip_bx">
            <div class="search_bx">
                <div class="card">
                   <h4>Travel Beyond Boundaries<i class=""></i></h4>
                   <input type="hidden" placeholder="Enter your destination">
                </div>
                <div class="card">
                   <h4><i class=""></i></h4>
                   <input type="hidden">
                </div>
                <div class="card">
                   <h4><i class=""></i></h4>
                   <input type="hidden" placeholder="How many people?">
                </div>
                <input type="hidden" value="Search">
          </div>
          <div class="travel_bx">
              <h4>Countries to travel</h4>
              <div class="cards">
                 <div class="card">
                    <h3>Japan <img src="media/ViewPackages/japanFlag.png" alt=""></h3>
                    <img src="media/ViewPackages/tokyo.jpg" alt="">
                    <div class="btn_city">
                         <a href="addBookingController" class="btn">Book Now</a>
                         <h5>Cruise to Japan</h5>
                      
                    </div>
                 </div>
                 <div class="card">
                    <h3>Paris <img src="media/ViewPackages/franceFlag.png" alt=""></h3>
                    <img src="media/ViewPackages/DisneylandParis.jpg" alt="">
                    <div class="btn_city">
                         <a href="addBookingController" class="btn">Book Now</a>
                         <h5>Paris Day Trip</h5>
                    </div>
               </div>
               <div class="card">
                    <h3>Switzerland <img src="media/ViewPackages/switzerlandFlag.jpg" alt=""></h3>
                    <img src="media/ViewPackages/Switzerland.jpg" alt="">
                    <div class="btn_city">
                         <a href="addBookingController" class="btn">Book Now</a>
                         <h5>Best Skiing</h5>
                    </div>
                 </div>
                 
              </div>   
            </div>     
         </div>
       </div>
     
    </main>
    <div class="offers">
        <h1>Best tour Package offers for you</h1>
        <p>Choose your destination</p> 
        <div class="cards">
            <div class="card">
              <h3>Cruise to Japan</h3>
              <div class="img_text">
                <img src="media/ViewPackages/JapanCruise.jpg" alt="">
                <h4>Included: Air ticket, Hotel, Breakfast, Tours, Airport Transfer</h4>
              </div>
              <div class="cont_bx">
                 <div class="price">
                   <div class="heart_chat">
                     <i class="bi bi-heart-fill"><span>8.2K</span></i>
                     <i class="bi bi-chat-fill"><span>4.1K</span></i>
                    </div>
                    <div class="info_price">
                       <a href=""></a>
                       <h4>RM8000</h4>
                     </div>
                 </div>
                 <div class="days">5 Days <br> Trip</div>
              </div>
            </div> 
               <div class="card">
              <h3>Disneyland</h3>
              <div class="img_text">
                <img src="media/ViewPackages/disneyTrip.jpg" alt="">
                <h4>Included: Air ticket, Hotel, Breakfast, Tours, Airport Transfer</h4>
              </div>
              <div class="cont_bx">
                 <div class="price">
                   <div class="heart_chat">
                     <i class="bi bi-heart-fill"><span>10.9K</span></i>
                     <i class="bi bi-chat-fill"><span>7.4K</span></i>
                   </div>
                     <div class="info_price">
                       <a href=""></a>
                       <h4>RM7500</h4>
                     </div>
                 </div>
                 <div class="days">4 Days <br>Trip</div>  
               </div>
            </div>
            <div class="card">
              <h3>Best Skiing</h3>
              <div class="img_text">
                <img src="media/ViewPackages/Ski.jpg" alt="">
                <h4>Included: Air ticket, Hotel, Breakfast, Tours, Airport Transfer</h4>
              </div>
              <div class="cont_bx">
                 <div class="price">
                   <div class="heart_chat">
                     <i class="bi bi-heart-fill"><span>25K</span></i>
                     <i class="bi bi-chat-fill"><span>9.7K</span></i>
                   </div>
                     <div class="info_price">
                       <a href=""></a>
                       <h4>RM8500</h4>
                     </div>
                 </div>
                 <div class="days">5 Days<br> Trip</div>  
               </div>
            </div>
        </div>
    </div>
    <div class="footer-copyright" style="text-align:center;">
    <p>&copy; 2023 TRAVELOG. All rights reserved.</p>
  </div>
</body>
</html>