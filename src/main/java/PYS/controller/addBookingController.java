package PYS.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import PYS.bean.booking;
import PYS.dao.bookingDAO;
import PYS.dao.custDAO;

/**
 * Servlet implementation class addBookingController
 */
public class addBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private custDAO dao;
    private bookingDAO bookingdao;
    
	public addBookingController() {
        super();
        dao = new custDAO();
        bookingdao = new bookingDAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session = request.getSession();
    	    int custid = (Integer) session.getAttribute("custid");
    	    System.out.print("CUST ID: "+custid);
    	    request.setAttribute("c", custDAO.getCustByCustId(custid));
	        RequestDispatcher view = request.getRequestDispatcher("addBookingCustomer.jsp");
	        view.forward(request, response);
    	    
    	    
//    	    if (custidObj != null) {
//    	        int custid = custidObj.intValue();
//    	        // Use the custid as needed
//    	        request.setAttribute("c", custDAO.getCustByCustId(custid));
//    	        RequestDispatcher view = request.getRequestDispatcher("addBooking.jsp");
//    	        view.forward(request, response);
//    	    } else {
//    	        // Handle the case when custid is not found in the session
//    	    }
    	
//     int custid = Integer.parseInt(request.getParameter("custid"));
//      request.setAttribute("c",BookingDAO.getCustByCustid(custid));
//      RequestDispatcher view = request.getRequestDispatcher("addBooking.jsp");
 //     view.forward(request, response);
    }
	
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
		
		
		b.setBooking_date(date);
		b.setBooking_status(request.getParameter("booking_status"));
		b.setPackageid(request.getParameter("packageid"));
		b.setQtypeople(Integer.parseInt(request.getParameter("qtypeople")));
		b.setStaffid(Integer.parseInt(request.getParameter("staffid")));
		b.setCustid(Integer.parseInt(request.getParameter("custid")));
		
		bookingdao.addBooking(b,request,response);
		HttpSession session = request.getSession();
		int bookingId = (int) session.getAttribute("bookingId");
		request.getRequestDispatcher("payment.jsp").forward(request, response);
	}
    	
}
