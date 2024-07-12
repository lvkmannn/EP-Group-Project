package PYS.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import PYS.bean.customer;
import PYS.dao.custDAO;

/**
 * Servlet implementation class updateCustController
 */
public class updateCustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private custDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCustController() {
        super();
        dao = new custDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int custid = Integer.parseInt(request.getParameter("custid"));
    	request.setAttribute("c",custDAO.getCustByCustId(custid));
    	RequestDispatcher view = request.getRequestDispatcher("updateCust.jsp");
    	view.forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customer c = new customer();
		
		c.setCustid(Integer.parseInt(request.getParameter("custid")));
		c.setCustname(request.getParameter("custname"));
		c.setCustphone(request.getParameter("custphone"));
		c.setCust_email(request.getParameter("cust_email"));
		c.setCustaddress(request.getParameter("custaddress"));
		c.setCustcity(request.getParameter("custcity"));
		c.setCustpostcode(Integer.parseInt(request.getParameter("custpostcode")));
		c.setCuststate(request.getParameter("custstate"));
		c.setCustcountry(request.getParameter("custcountry"));
		
		dao.updateCust(c);
		HttpSession session = request.getSession();
		int custid = (Integer) session.getAttribute("custid");
		request.setAttribute("c", custDAO.getCustByCustId(custid));
		 RequestDispatcher view = request.getRequestDispatcher("MyCustAcc.jsp");
		 view.forward(request, response);
	}

}
