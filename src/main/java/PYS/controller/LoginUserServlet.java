package PYS.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import PYS.bean.customer;
import PYS.dao.staffDAO;

/**
 * Servlet implementation class LoginUserServlet
 */
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custusername = request.getParameter("custusername");
		String custpassword = request.getParameter("custpassword");
//		System.out.print("IN userServlet, name: "+custusername);
		
		customer login = new customer(); //creating object for LoginBean class(contain setter,getter)
		login.setCust_username(custusername);
		login.setCust_password(custpassword);
		
		staffDAO loginDao = new staffDAO();//creating object for LoginDao. This class contains main logic of the application
		int userValidate = loginDao.authenticateUser(login);//calling authenticateUser function
//		System.out.print("(After)IN userServlet, name: "+login.getCust_username());
		
		//if(userValidate.equals("SUCCESS")) //if function returns success string then user will be rooted to HomePage
		if(userValidate > 0)
		{ 
			//httpsession
			HttpSession session = request.getSession(); //create session
			session.setAttribute("custusername", custusername); //(label,variable) variable=data that being sent
			session.setAttribute("custid", userValidate);
			request.setAttribute("custid", userValidate);
			request.setAttribute("custusername", custusername);///with setAttribute() can define a "key" and value pair so that you can get it in future using getAttribute("key")
			request.getRequestDispatcher("/Index.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page
		} else {
			request.setAttribute("errMessage", userValidate); //if authenticateUser() function returns other than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
			request.getRequestDispatcher("invalidCust.jsp").forward(request, response);//forwarding the request
		}
	}
}
