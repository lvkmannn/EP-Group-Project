package PYS.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import PYS.dao.staffDAO;

/**
 * Servlet implementation class listStaffController
 */
public class listStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private staffDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listStaffController() {
        super();
        setDao(new staffDAO());
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("staffs", staffDAO.getAllStaff());
		RequestDispatcher view = request.getRequestDispatcher("StaffManagement.jsp");
		view.forward(request, response);
		
	}
	
	private void setDao(staffDAO dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}
	
	public staffDAO getDao() {
		return dao;
	}

}
