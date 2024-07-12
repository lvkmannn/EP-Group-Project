<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta charset="UTF-8">
<title>Update Staff</title>
<link href="css/updateBooking.css" rel="stylesheet">
</head>
<body>
<form class="form" action="updateBookingController" method="post">
        <p class="title">TASK MANAGEMENT</p>


         <label>
            <input required="" name="booking_id" type="text" class="input" value="<c:out value="${b.booking_id}"/>" readonly>
            <span>Booking ID</span>
        </label>
        
        <label>
            <input required="" name="booking_date" type="text" class="input" value="<c:out value="${b.booking_date}"/>" readonly>
            <span>Booking Date</span>
        </label>
        
        <label>
            <input required="" name="booking_status" type="text" class="input" value="<c:out value="${b.booking_status}"/>">
            <span>Booking Status</span>
        </label>
        
        <label>
            <input required="" name="packageid" type="text" class="input" value="<c:out value="${b.packageid}"/>" readonly>
            <span>Package ID</span>
        </label>
        
        <label>
            <input required="" name="qtypeople" type="text" class="input" value="<c:out value="${b.qtypeople}"/>" readonly>
            <span>Quantity</span>
        </label>
        
        <label class="input" for="staffid">Assign Staff: </label>
    <select id="staffid" name="staffid" required>
    <option value="">Select Staff</option>
         <%
        Connection con=null;
		Statement st=null;
		ResultSet rs = null;
		try{
			con=dBConnection.getConnection();
			st = con.createStatement();
			String query="Select * from staff";
			rs = st.executeQuery(query);
			 while (rs.next()) {
	                int staffid = rs.getInt("staffid");
	                String staffname = rs.getString("staffname");
	                String optionValue = staffid + " - " + staffname;
	                %>
	                <option value="<%= staffid %>"><%= optionValue %></option>
	                <%
	            }
		} catch(Exception e) {
			
		}
        %>
    </select>
        
        
<!--         <label> -->
<%--             <input required="" name="staffid" type="text" class="input" value="<c:out value="${b.staffid}"/>"> --%>
<!--             <span>Staff ID</span> -->
<!--         </label> -->
        
        <input type="hidden" name="custid" value="<c:out value="${b.custid}"/>"/><br>
        
       
        <button class="submit">Submit</button>
        <button class="reset">Reset</button>
      </form>
</body>
</html>