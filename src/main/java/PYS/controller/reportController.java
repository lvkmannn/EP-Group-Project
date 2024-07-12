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
 * Servlet implementation class reportController
 */
public class reportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public reportController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("spmChart", bookingDAO.getReportSPM());
		request.setAttribute("cpmChart", bookingDAO.getReportCustPM());
		request.setAttribute("custPerPackageChart", bookingDAO.getReportCustPerPackage());

		
        RequestDispatcher view = request.getRequestDispatcher("index-chart.jsp");
        view.forward(request, response);
        
	}


}
