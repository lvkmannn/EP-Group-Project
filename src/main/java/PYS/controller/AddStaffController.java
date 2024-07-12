package PYS.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import PYS.bean.staff;
import PYS.dao.staffDAO;

/**
 * Servlet implementation class AddStaffController
 */
public class AddStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private staffDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStaffController() {
        super();
        dao = new staffDAO();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		staff staff=new staff();
		
		staff.setStaffname(request.getParameter("staffname"));
		staff.setStaffphone(request.getParameter("staffphone"));
		staff.setStaff_email(request.getParameter("staff_email"));
		staff.setStaffaddress(request.getParameter("staffaddress"));
		staff.setStaffcity(request.getParameter("staffcity"));
		staff.setStaffpostcode(Integer.parseInt(request.getParameter("staffpostcode")));
		staff.setStaffstate(request.getParameter("staffstate"));
		staff.setStaffcountry(request.getParameter("staffcountry"));
		staff.setStaffsalary(Double.parseDouble(request.getParameter("staffsalary")));
		staff.setStaff_username(request.getParameter("staff_username"));
		staff.setStaff_password(request.getParameter("staff_password"));
		staff.setManagerid(Integer.parseInt(request.getParameter("managerid")));
		
		dao.addStaff(staff);
		
		request.setAttribute("staffs", staffDAO.getAllStaff());
		RequestDispatcher view = request.getRequestDispatcher("StaffManagement.jsp");
		view.forward(request, response);
	}

}
