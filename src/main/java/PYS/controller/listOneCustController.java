package PYS.controller;

import java.io.IOException;

import PYS.dao.custDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class listOneCustController
 */
public class listOneCustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private custDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listOneCustController() {
        super();
        setDao(new custDAO());
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int custid = (Integer) session.getAttribute("custid");
		request.setAttribute("c", custDAO.getCustByCustId(custid));
		RequestDispatcher view = request.getRequestDispatcher("MyCustAcc.jsp");
		view.forward(request, response);
		
	}
	
	private void setDao(custDAO dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}
	
	public custDAO getDao() {
		return dao;
	}

}
