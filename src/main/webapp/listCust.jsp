<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.box {
    border: 2px solid black;
    padding: 15px;
    margin-bottom: 25px;
 }
.box-header {
    font-size: 24px;
    font-weight: bold;
    margin-bottom: 10px;
    text-align:center;
    }


table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}


</style>
<body>
    <!--For MAIN Content-->
    <div class="box">
        <h1 class="box-header">CUSTOMER</h1>

    </div>
      <table style="width:100%">
        <thead>
            <tr>
                <th>CUSTOMER ID</th>
                <th>CUSTOMER NAME</th>
                <th>CUSTOMER PHONE</th>
                <th>CUSTOMER EMAIL</th>
                <th>CUSTOMER ADDRESS</th>
                <th>CUSTOMER CITY</th>
                <th>CUSTOMER POSTCODE</th>
                <th>CUSTOMER STATE</th>
                <th>CUSTOMER COUNTRY</th>
<!--                  <th colspan="2">Action</th>  -->
            </tr>
        </thead>
    <c:forEach items="${customers}" var="c" varStatus="customers">
    <tr>
          <td><c:out value="${c.custid}"/></td>
            <td><c:out value="${c.custname}"/></td>
            <td><c:out value="${c.custphone}"/></td> 
            <td><c:out value="${c.cust_email}"/></td>
            <td><c:out value="${c.custaddress}"/></td>
            <td><c:out value="${c.custcity}"/></td> 
            <td><c:out value="${c.custpostcode}"/></td> 
            <td><c:out value="${c.custstate}"/></td> 
            <td><c:out value="${c.custcountry}"/></td> 
<%--       <td><button class="btn btn-update" id="<c:out value="${c.custid}"/>" onclick="updateCustJsp(this.id)">Update</button></td> --%>
<%--     <td><button class="btn btn-danger" id="<c:out value="${c.custid}"/>" onclick="confirmation(this.id)">Delete</button></td>              --%>
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
    
//     function updateCustJsp(custid){
//       location.href = 'updateCustController?custid=' + custid;
//   }
    
//    function confirmation(custid){
//       console.log(custid);
//       var r = confirm("Are you sure you want to delete?");
      
//       if (r == true){
//         location.href = 'deleteCustController?custid=' + custid;
//         alert("Customer successfully deleted");      
//       } else {          
//           return false;  
//       }
//   }
  </script>
</body>
</html>