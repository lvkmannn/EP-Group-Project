package PYS.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import PYS.bean.booking;
import PYS.bean.customer;
import PYS.bean.packages;

/**
 * Servlet implementation class invoiceController
 */
public class invoiceController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve data from the request attributes
        customer customerData = (customer) request.getAttribute("c");
        booking bookingData = (booking) request.getAttribute("b");
        packages packageData = (packages) request.getAttribute("p");

        // Calculate the total invoice amount
        double packagePrice = packageData.getPackageprice();
        int quantityOfPeople = bookingData.getQtypeople();
        double totalAmount = packagePrice * quantityOfPeople;

        // Store the attributes in the request to access them in the JSP
        request.setAttribute("customerName", customerData.getCustname());
        request.setAttribute("bookingId", bookingData.getBooking_id());
        request.setAttribute("packageName", packageData.getPackagename());
        request.setAttribute("quantityOfPeople", quantityOfPeople);
        request.setAttribute("packagePrice", packagePrice);
        request.setAttribute("totalAmount", totalAmount);

        // Forward the request to invoice.jsp to display the invoice
        request.getRequestDispatcher("invoice.jsp").forward(request, response);
    }
}
