<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%> 
<%@ page import="PYS.connection.dBConnection"%> 
<%@ page import="PYS.bean.packages"%>
<%@ page import=" java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/addStaff.css" rel="stylesheet">
</head>
<body>
  <form class="form" action="addPackageController" method="post">
        <p class="title">Add Package </p>

        
        <label>
            <input required="" name="packageid" type="text" class="input">
            <span>Package ID</span>
        </label>
        
    
        <label>
          <input required="" name="packagename" type="text" class="input">
          <span>Package Name</span>
        </label>
        
        <label>
          <input required="" name="p_destination" type="text" class="input">
          <span>Package Destination</span>
        </label> 
        
        <div class="flex">
            <label>
                <input required="" name="p_startdate" type="date" class="input">
                <span>Start Date</span>
              </label> 
      
              <label>
                  <input required="" name="p_enddate" type="date" class="input" >
                  <span>End Date</span>
              </label>
        </div>

       

        <label>
            <input required="" name="packageprice" type="text" class="input">
            <span>Package Price</span>
        </label> 

        <label>
            <input required="" name="packagedesc" type="text" class="input">
            <span>Package Description</span>
        </label>

        <button class="submit" onclick="addSuccess()">Submit</button>
        <button class="reset" type="reset">Reset</button>
        <button class="backbtn" onclick="home()">Back</button>
        <div> 
    </div>
    <script>
    
    function home(){
      location.href = 'listPackageController'
    }
    
    
    function addSuccess(){
    	alert("Successfully Add New Package");
    }
    </script>
      </form>
</body>
</html>