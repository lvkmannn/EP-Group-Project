package PYS.controller;

import java.io.IOException;

import PYS.dao.bookingDAO;
import PYS.dao.custDAO;
import PYS.dao.packageDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class rcontroller
 */
public class rcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int bookingId = (int) session.getAttribute("bookingId");
		int custid = (int) session.getAttribute("custid");

		request.setAttribute("c", custDAO.getCustByCustId(custid));
		request.setAttribute("b", bookingDAO.getBookingByBooking_id(bookingId));
		request.setAttribute("d", bookingDAO.getBookingByBookingid(bookingId, request, response));
		// Access the packageid from the session
		String packageId = (String) session.getAttribute("packageid");
		request.setAttribute("p", packageDAO.getPackageByPackageid(packageId)); // Use the actual variable packageId, not "packageId"

		
		RequestDispatcher view = request.getRequestDispatcher("invoiceController");
        view.forward(request, response);
		
	}

}
