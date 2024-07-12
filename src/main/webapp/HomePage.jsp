<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        /* Set the body to full height */
        body, html {
            height: 100%;
            margin: 0;
        }

        /* Set the video to fill the entire screen */
        .bg {
            position: fixed;
            right: 0;
            bottom: 0;
            width: 100%;
            height: auto;
        }

        /* Create a box in front of the background */
        .content-box {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 400px;
            height: 200px;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            background-color: rgba(255, 255, 255, 0.5);
        }

        /* Style the buttons */
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            background-color: black;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        /* Change button background color on hover */
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <img class="bg" alt="" src="media/vHP.gif">

    <!-- Add the video element -->
    <video></video>

    <!-- Insert content in the box -->
    <div class="content-box">
        <h1>WELCOME TO TRAVELOG</h1>
        <div>
           <!-- <button class="btn" onclick="navigateTo('page1.html')">STAFF</button> -->
           	<button class="btn" onclick="navigateTo('StaffLogin.html')">STAFF</button>
            <!-- <button class="btn" onclick="navigateTo('Index.jsp')">GUEST</button> -->
            <button class="btn" onclick="navigateTo('Login.html')">LOGIN</button>
            <p>Don't have an account? <a href="addCust.jsp" class="a2">Sign up!</a></p>
            <!-- <button class="btn" onclick="navigateTo('Login.html')">MEMBER</button> -->
        </div>
    </div>

    <script>
        // Function to navigate to the specified URL
        function navigateTo(url) {
            window.location.href = url;
        }
    </script>
</body>
</html>
