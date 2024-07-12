<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/CustFormStyle.css">
</head>
<body>
    <form action="addCustController" method="post" onsubmit="return validateForm()">
        Name: <input type="text" name="custname" required><br><br>
        Phone Number: <input type="text" name="custphone" required><br><br>
        Email : <input type="text" name="custemail" id="custemail" required><br><br>
        Address : <input type="text" name="custaddress" required><br><br>
        City : <input type="text" name="custcity" required><br><br>
        Postcode : <input type="text" name="custpostcode" required><br><br>
        State : <input type="text" name="custstate" required><br><br>
        Country : <input type="text" name="custcountry" required><br><br>
        Username : <input type="text" name="custusername" required><br><br>
        Password : <input type="password" name="custpassword" required><br><br>

        <button class="submit" onclick="addCust()">Submit</button>
        <button class="reset" type="reset">Reset</button>
    </form>
<script>
function validateForm() {
    var emailInput = document.getElementById("custemail");
    var emailValue = emailInput.value.trim();
    
    if (emailValue === "" || emailValue.indexOf("@") === -1) {
        alert("Please enter a valid email address.");
        emailInput.focus();
        return false;
    }

    return true;
}

function addCust(){
	alert("You are now a member!");
}
    </script>
    
  </body>
</html>
