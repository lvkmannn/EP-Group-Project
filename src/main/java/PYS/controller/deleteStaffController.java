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
 * Servlet implementation class deleteStaffController
 */
public class deleteStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private staffDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteStaffController() {
        super();
        dao=new staffDAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int staffid = Integer.parseInt(request.getParameter("staffid"));
		dao.deleteStaff(staffid);
		request.setAttribute("staffs", staffDAO.getAllStaff());
		RequestDispatcher view = request.getRequestDispatcher("StaffManagement.jsp");
		view.forward(request, response);
	}

}
