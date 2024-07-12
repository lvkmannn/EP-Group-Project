package PYS.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import PYS.dao.bookingDAO;

/**
 * Servlet implementation class deleteBookingController
 */
public class deleteBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookingDAO dao;
    /**
     * Default constructor. 
     */
    public deleteBookingController() {
        super();
        dao=new bookingDAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int booking_id = Integer.parseInt(request.getParameter("booking_id"));
		dao.deleteBooking(booking_id);
		request.setAttribute("bookings", bookingDAO.getAllBooking());
		RequestDispatcher view = request.getRequestDispatcher("listBooking.jsp");
		view.forward(request, response);
	}

}
