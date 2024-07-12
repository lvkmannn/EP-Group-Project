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
<title>Insert title here</title>
<link href="css/addStaff.css" rel="stylesheet">
</head>
<body>
  <form class="form" action="AddStaffController" method="post">
        <p class="title">Staff Registration </p>

        
        <label>
            <input required="" name="staffname" type="text" class="input">
            <span>Staff Name</span>
        </label>
        
        <div class="flex">
            <label>
                <input required="" name="staffphone" type="text" class="input" id="phonenum">
                <span>Phone Number</span>
            </label>
    
            <label>
                <input required="" name="staff_email" type="text" class="input" id="email">
                <span>Email</span>
            </label> 
        </div>
    
        <label>
          <input required="" name="staffaddress" type="text" class="input">
          <span>Address</span>
        </label> 
        
        <div class="flex">
            <label>
                <input required="" name="staffcity" type="text" class="input">
                <span>City</span>
              </label> 
      
              <label>
                  <input required="" name="staffpostcode" type="text" class="input">
                  <span>Postcode</span>
              </label>

              <label>
                <input required="" name="staffstate" type="text" class="input">
                <span>State</span>
            </label> 
        </div>

       

        <label>
            <input required="" name="staffcountry" type="text" class="input">
            <span>Staff Country</span>
        </label> 

        <label>
            <input required="" name="staffsalary" type="text" class="input">
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
				int staffid = rs.getInt("staffid");
	             String staffname = rs.getString("staffname");
	             String optionValue = staffid + " - " + staffname;
				%>
				<option value="<%=rs.getString("staffid")%>"><%= optionValue %></option>
				<%
			}
		} catch(Exception e) {
			
		}
        %>
    </select>
    <span>Manager ID(just leave at Select Admin if no manager)</span>
</label>

        <label>
            <input required="" name="staff_username" type="text" class="input">
            <span>Staff Username</span>
        </label>

        <label>
            <input required="" name="staff_password" type="password" class="input">
            <span>Password</span>
        </label>

        <button class="submit" onclick="addSuccess()">Submit</button>
        <button class="reset" type="reset">Reset</button>
        <div> 
      <td><button class="btn btn-addStaff" onclick="home()">BACK</button></td>
    </div>
    <script>
    
    function home(){
      location.href = 'StaffMenu.jsp'
    }
    
    function addSuccess(){
    	alert("Successfully Add New Staff");
    }
    </script>
      </form>
</body>
</html>