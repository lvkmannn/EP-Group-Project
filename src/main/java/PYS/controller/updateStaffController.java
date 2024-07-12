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
 * Servlet implementation class updateStaffController
 */
public class updateStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private staffDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStaffController() {
        super();
        dao = new staffDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int staffid = Integer.parseInt(request.getParameter("staffid"));
    	request.setAttribute("s",staffDAO.getStaffByStaffId(staffid));
    	RequestDispatcher view = request.getRequestDispatcher("updateStaff.jsp");
    	view.forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		staff s = new staff();
		
		s.setStaffid(Integer.parseInt(request.getParameter("staffid")));
		s.setStaffname(request.getParameter("staffname"));
		s.setStaffphone(request.getParameter("staffphone"));
		s.setStaff_email(request.getParameter("staff_email"));
		s.setStaffaddress(request.getParameter("staffaddress"));
		s.setStaffcity(request.getParameter("staffcity"));
		s.setStaffpostcode(Integer.parseInt(request.getParameter("staffpostcode")));
		s.setStaffstate(request.getParameter("staffstate"));
		s.setStaffcountry(request.getParameter("staffcountry"));
		s.setStaffsalary(Double.parseDouble(request.getParameter("staffsalary")));
		//The reason set method below is commented because admin can't update staff's username and password
//		s.setStaff_username(request.getParameter("staff_username"));
//		s.setStaff_password(request.getParameter("staff_password"));
		s.setManagerid(Integer.parseInt(request.getParameter("managerid")));
	
		dao.updateStaff(s);
		
		request.setAttribute("staffs", staffDAO.getAllStaff());
		RequestDispatcher view = request.getRequestDispatcher("StaffManagement.jsp");
		view.forward(request, response);
	}

}
