package PYS.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import PYS.bean.booking;
import PYS.dao.bookingDAO;

/**
 * Servlet implementation class updateBookingController
 */
public class updateBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookingDAO dao;
	
    public updateBookingController() {
    	super();
    	dao = new bookingDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int booking_id=Integer.parseInt(request.getParameter("booking_id"));
		request.setAttribute("b", bookingDAO.getBookingByBooking_id(booking_id));
		RequestDispatcher view = request.getRequestDispatcher("taskManagement.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		booking b = new booking();
		String pattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		
		Date date = null;
		try {
			date = dateFormat.parse(request.getParameter("booking_date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b.setBooking_id(Integer.parseInt(request.getParameter("booking_id")));
		b.setBooking_date(date);
		b.setBooking_status(request.getParameter("booking_status"));
		b.setPackageid(request.getParameter("packageid"));
		b.setQtypeople(Integer.parseInt(request.getParameter("qtypeople")));
		b.setStaffid(Integer.parseInt(request.getParameter("staffid")));
		b.setCustid(Integer.parseInt(request.getParameter("custid")));
	
		
		dao.updateBooking(b);
		
		request.setAttribute("bookings", bookingDAO.getAllBooking());
		RequestDispatcher view = request.getRequestDispatcher("listBooking.jsp");
		view.forward(request, response);
	}

}
