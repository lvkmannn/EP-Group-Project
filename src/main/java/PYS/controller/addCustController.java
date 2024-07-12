package PYS.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import PYS.bean.customer;
import PYS.dao.custDAO;

/**
 * Servlet implementation class addCustController
 */
public class addCustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private custDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCustController() {
        super();
        dao = new custDAO();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		customer cust = new customer();
		cust.setCustname(request.getParameter("custname"));
		cust.setCustphone(request.getParameter("custphone"));
		cust.setCust_email(request.getParameter("custemail"));
		cust.setCustaddress(request.getParameter("custaddress"));
		cust.setCustcity(request.getParameter("custcity"));
		cust.setCustpostcode(Integer.parseInt(request.getParameter("custpostcode")));
		cust.setCuststate(request.getParameter("custstate"));
		cust.setCustcountry(request.getParameter("custcountry"));
		cust.setCust_username(request.getParameter("custusername"));
		cust.setCust_password(request.getParameter("custpassword"));
		
		dao.addCust(cust);
		
		System.out.println("addCustController passed");
		request.getRequestDispatcher("/Login.html").forward(request, response);

	}

}
