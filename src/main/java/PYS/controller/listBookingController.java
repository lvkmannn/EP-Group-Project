package PYS.controller;

import java.io.IOException;

import PYS.dao.bookingDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listBookingController
 */
public class listBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookingDAO dao;
    /**
     * Default constructor. 
     */
    public listBookingController() {
    	super();
    	setDao(new bookingDAO());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("bookings", bookingDAO.getAllBooking());
		RequestDispatcher view = request.getRequestDispatcher("listBooking.jsp");
		view.forward(request, response);
	}
	
	private void setDao(bookingDAO dao) {
		this.dao=dao;
	}
	
	public bookingDAO getDao() {
		return dao;
	}
}
