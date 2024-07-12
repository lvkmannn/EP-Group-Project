<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Invoice</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background: linear-gradient(to bottom, #f0f0f0, #e0e0e0);
        }

        .invoice-details {
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
            background-color: #fff;
        }

        h2 {
            color: #007bff;
            margin-bottom: 20px;
        }

        p {
            margin: 5px 0;
        }

        strong {
            font-weight: bold;
        }

        .total-amount {
            font-size: 18px;
            margin-top: 30px;
        }
       .logout-btn {
            background-color: #dc3545;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }
        .print-btn {
            background-color: #28a745;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }
        .home-btn {
            background-color: #2876a7;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="invoice-details">
        <h2>Invoice Details:</h2>
        <p><strong>Customer Name:</strong> <span id="customerName"></span></p>
        <p><strong>Booking ID:</strong> <span id="bookingId"></span></p>
        <p><strong>Package Name:</strong> <span id="packageName"></span></p>
        <p><strong>Quantity of People:</strong> <span id="quantityOfPeople"></span></p>
        <p><strong>Package Price per Person:</strong> RM <span id="packagePrice"></span></p>
        <p class="total-amount"><strong>Total Amount:</strong> RM <span id="totalAmount"></span></p>
        <!-- ...other invoice details... -->

		<button class="home-btn" onclick="backToIndex()">Home</button>
        <button class="logout-btn" onclick="logout()">Logout</button>
        <button class="print-btn" onclick="printInvoice()">Print</button>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.3.1/jspdf.umd.min.js"></script>
    <script>
        // This section sets the dynamic data from Java/JSP to JavaScript variables.
        var customerName = '<%= request.getAttribute("customerName") %>';
        var bookingId = '<%= request.getAttribute("bookingId") %>';
        var packageName = '<%= request.getAttribute("packageName") %>';
        var quantityOfPeople = '<%= request.getAttribute("quantityOfPeople") %>';
        var packagePrice = '<%= request.getAttribute("packagePrice") %>';
        var totalAmount = '<%= request.getAttribute("totalAmount") %>';

        // Set the values inside the corresponding <span> elements.
        document.getElementById("customerName").innerText = customerName;
        document.getElementById("bookingId").innerText = bookingId;
        document.getElementById("packageName").innerText = packageName;
        document.getElementById("quantityOfPeople").innerText = quantityOfPeople;
        document.getElementById("packagePrice").innerText = packagePrice;
        document.getElementById("totalAmount").innerText = totalAmount;

        // The rest of your JavaScript functions (logout, printInvoice, saveToPDF) remain unchanged.
        function logout() {
            // Redirect to the LogoutController servlet.
            window.location.href = "LogoutController"; // Replace with the correct URL.
        }

        function printInvoice() {
            window.print();
        }
        
        function backToIndex(){
        	window.location.href="Index.jsp"
        }

    </script>
</body>
</html>