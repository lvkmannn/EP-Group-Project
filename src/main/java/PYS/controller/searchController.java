package PYS.controller;

import java.io.IOException;

import PYS.dao.staffDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchController
 */
public class searchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action = "create",forward="";
	private static String LIST = "StaffManagement.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		if(action.equalsIgnoreCase("search")) {
	          
	          forward=LIST;
	          String staffname = request.getParameter("staffname");
	          request.setAttribute("staffs", staffDAO.getStaffSearch(staffname));
	          RequestDispatcher view = request.getRequestDispatcher(forward);
	          view.forward(request, response);
	        }
		
	}

}
