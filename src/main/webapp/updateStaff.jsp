<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%> 
<%@ page import="PYS.connection.dBConnection"%> 
<%@ page import="PYS.bean.staff"%>
<%@ page import=" java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Staff</title>
<link href="css/addStaff.css" rel="stylesheet">
</head>
<body>
	<form class="form" action="updateStaffController" method="post">
        <p class="title">Staff Update </p>

        <input type="hidden" name="staffid" value="<c:out value="${s.staffid}"/>"/><br>
        <label>
            <input required="" name="staffname" type="text" class="input" value="<c:out value="${s.staffname}"/>">
            <span>Staff Name</span>
        </label>
        
        <div class="flex">
            <label>
                <input required="" name="staffphone" type="text" class="input" id="phonenum" value="<c:out value="${s.staffphone}"/>">
                <span>Phone Number</span>
            </label>
    
            <label>
                <input required="" name="staff_email" type="text" class="input" id="email" value="<c:out value="${s.staff_email}"/>">
                <span>Email</span>
            </label> 
        </div>
    
        <label>
          <input required="" name="staffaddress" type="text" class="input" value="<c:out value="${s.staffaddress}"/>">
          <span>Address</span>
        </label> 
        
        <div class="flex">
            <label>
                <input required="" name="staffcity" type="text" class="input" value="<c:out value="${s.staffcity}"/>">
                <span>City</span>
              </label> 
      
              <label>
                  <input required="" name="staffpostcode" type="text" class="input" value="<c:out value="${s.staffpostcode}"/>">
                  <span>Postcode</span>
              </label>

              <label>
                <input required="" name="staffstate" type="text" class="input" value="<c:out value="${s.staffstate}"/>">
                <span>State</span>
            </label> 
        </div>

       

        <label>
            <input required="" name="staffcountry" type="text" class="input" value="<c:out value="${s.staffcountry}"/>">
            <span>Staff Country</span>
        </label> 

        <label>
            <input required="" name="staffsalary" type="text" class="input" value="<c:out value="${s.staffsalary}"/>">
            <span>Staff Salary</span>
        </label>
        
        <label>
        <select id="managerid" name="managerid" required>
        <option value="0">Select Admin</option>
        <%
        Connection con=null;
		Statement st=null;
		ResultSet rs = null;
		try{
			con=dBConnection.getConnection();
			st = con.createStatement();
			String query="Select * from staff where managerid is NULL";
			rs = st.executeQuery(query);
			while(rs.next()){
				%>
				<option value="<%=rs.getString("staffid")%>"><%= rs.getString("staffname") %></option>
				<%
			}
		} catch(Exception e) {
			
		}
        %>
    </select>
    <span>Manager ID(just leave at Select Admin if no manager)</span>
        
         </label>

<!--         <label> -->
<%--             <input required="" name="staff_username" type="text" class="input" value="<c:out value="${s.staff_username}"/>"> --%>
<!--             <span>Staff Username</span> -->
<!--         </label> -->

<!--         <label> -->
<%--             <input required="" name="staff_password" type="password" class="input" value="<c:out value="${s.staff_password}"/>"> --%>
<!--             <span>Password</span> -->
<!--         </label> -->

        <button class="submit">Submit</button>
        <button class="reset" type="reset">Reset</button>
      </form>
</body>
</html>