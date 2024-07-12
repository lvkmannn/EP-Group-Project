package PYS.controller;

import java.io.IOException;

import PYS.bean.staff;
import PYS.dao.staffDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginStaffServlet
 */
public class LoginStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		staff login = new staff(); //creating object for LoginBean class(contain setter,getter)
		login.setStaff_username(username);//setting the username and password through the loginBean object
		login.setStaff_password(password);
		
		staffDAO loginDao = new staffDAO();//creating object for LoginDao. This class contains main logic of the application
		int userValidate = loginDao.authenticateStaff(login);//calling authenticateUser function
		
		if (userValidate > 0) {
		    HttpSession session = request.getSession();
		    session.setAttribute("staffid", userValidate);
		    request.setAttribute("staffid", userValidate);
		    
		    Integer staffid = (Integer) session.getAttribute("staffid");
		    staffDAO checkManager = new staffDAO();
		    int managerid = checkManager.checkManagerID(staffid); // Retrieve the managerid from the DAO

		    request.setAttribute("username", username);
		    session.setAttribute("username", username);
		    session.setAttribute("managerid", managerid);
		    request.setAttribute("managerid", managerid); // Set the managerid as a request attribute
		    request.getRequestDispatcher("/StaffMenu.jsp").forward(request, response);
		} else {
			request.setAttribute("errMessage", userValidate); //if authenticateUser() funtion returns other than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
			request.getRequestDispatcher("invalidStaff.jsp").forward(request, response);//forwarding the request
		}
	}
}
