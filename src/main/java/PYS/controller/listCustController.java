package PYS.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import PYS.dao.custDAO;

/**
 * Servlet implementation class listCustController
 */
public class listCustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private custDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listCustController() {
        super();
        setDao(new custDAO());
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("customers", custDAO.getAllCust());
		RequestDispatcher view = request.getRequestDispatcher("listCust.jsp");
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