<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page import="java.sql.*"%> 
<%@ page import="java.util.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="PYS.connection.*" %>
<!DOCTYPE html>
<html>
  <head>
  <style>
 h1 {
  font-family: Cambria;
        color: #9ACD32; 
       }
</style>
<meta charset="ISO-8859-1">
<title>BOOKING FORM</title>
</head>

<style>
    p {
      font-family: Arial;
      color: #B2D2A4;
      }
</style>

<style>
  .container {
  display: flex;
  align-items: center;
}

</style>
  <body style="background-color:#FFFFFF;">
     <form class="form" action="addBookingController" method="post">
     <fieldset>
     <h1>BOOKING FORM</h1>
      	 <%
      		LocalDate date = java.time.LocalDate.now();
         	System.out.println(date);
         %>
    
       <label>CUSTOMER INFO</label>
      <div class="flex">
      <% int custid = (Integer) session.getAttribute("custid"); %>
      <input name="custid" type="hidden" value="<%=custid%>" required>
      <input name="staffid" type="hidden" value="8">
      
      
      <label>
            <input name="custname" type="text" class="input" size=25  value="<c:out value="${c.custname}"/>" readonly>
        </label>
    
      </div><br>
      
      <label>PHONE NUMBER</label> <br>
        <label>
           <input required="" name="custphone" type="text" class="input" id="phone" value="<c:out value="${c.custphone}"/>">
        </label> <br></br>
    
      <label>EMAIL</label><br>
        <label>
            <input required="" name="cust_email" type="text" class="input" id="email" value="<c:out value="${c.cust_email}"/>">
        </label> <br></br>
        
        <label>ADDRESS</label><br>
        <div class="flex">
            <label>
                <input required="" name="custaddress" type="text" class="input" size=25 value="<c:out value="${c.custaddress}"/>">
              </label> <br></br>
              
              
              <label>
                  <input required="" name="custcity" type="text" class="input" size=25 placeholder="CITY" value="<c:out value="${c.custcity}"/>">
              </label>
              
              <label>
                  <input required="" name="custpostcode" type="text" class="input" size=25 placeholder="POSTCODE" value="<c:out value="${c.custpostcode}"/>">
              </label> <br></br>
            
      
              <label>
                  <input required="" name="custstate" type="text" class="input" size=10 placeholder="STATE" value="<c:out value="${c.custstate}"/>">
              </label>

              <label>
                <input required="" name="custcountry" type="text" class="input" size=25 placeholder="COUNTRY" value="<c:out value="${c.custcountry}"/>">
            </label> <br></br>
        </div>
        
        
<!--         Data below will be retrieved from the package table -->

    <label for="packageid">PACKAGES: </label>
    <select id="packageid" name="packageid" required>
    <option value="">Select Package</option>
         <%
        Connection con=null;
		Statement st=null;
		ResultSet rs = null;
		try{
			con=dBConnection.getConnection();
			st = con.createStatement();
			String query="Select * from package";
			rs = st.executeQuery(query);
			 while (rs.next()) {
	                String packageid = rs.getString("packageid");
	                String packagename = rs.getString("packagename");
	                String optionValue = packageid + " - " + packagename;
	                %>
	                <option value="<%= packageid %>"><%= optionValue %></option>
	                <%
	            }
		} catch(Exception e) {
			
		}
        %>
    </select>
    
        <br><br><label>PACKAGE DATE</label>
    <select id="packagedate" name="packagedate" required>
    <option value="">Select Date</option>
         <%
		try{
			con=dBConnection.getConnection();
			st = con.createStatement();
			String query="Select * from package";
			rs = st.executeQuery(query);
			 while (rs.next()) {
				 Date p_startdate = rs.getDate("p_startdate");
				 Date p_enddate = rs.getDate("p_enddate");
		            String packagename = rs.getString("packagename");
		            String optionValue = p_startdate.toString() + " - " + p_enddate.toString() + " - " + packagename;
		            %>
		            <option value="<%= p_startdate %>"><%= optionValue %></option>
		            <%
	            }
		} catch(Exception e) {
			
		}
        %>
     </select>
<!--         <div class="flex"> -->
<!--         <label> -->
<!--             <input required="" name="startDate" type="date" class="input" placeholder="START DATE"> -->
<!--           </label> -->
        
<!--           <label> -->
<!--             <input required="" name="endDate" type="date" class="input" placeholder="END DATE"> -->
<!--           </label> -->
        
<!--         </div><br></br> -->
        
<!--         Data below will be written inside of the table booking -->
        <div class="flex">
    <br><label>TOTAL OF PEOPLE(MAX 6 PERSON/FAMILY) : </label>
         <select name="qtypeople" id="qtypeople" required>
          <option value=1>1</option>
          <option value=2>2</option>
          <option value=3>3</option>
          <option value=4>4</option>
          <option value=5>5</option>
          <option value=6>6</option>
    </select><br>
        
       <br> <label>BOOKING DATE</label>
        <label>
          <input type="date" name="booking_date" value="<%=date%>" readonly>
        </label>
  
      <button class="submit" type="submit">BOOK NOW</button>
      <button class="reset" type="reset">RESET</button>
      </fieldset>
    </form>
  </body>
</html>