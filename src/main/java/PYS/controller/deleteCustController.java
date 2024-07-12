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
 * Servlet implementation class deleteCustController
 */
public class deleteCustController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private custDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCustController() {
        super();
        dao=new custDAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int custid = Integer.parseInt(request.getParameter("custid"));
		dao.deleteCust(custid);
		request.setAttribute("customers", custDAO.getAllCust());
		RequestDispatcher view = request.getRequestDispatcher("listCust.jsp");
		view.forward(request, response);
	}

}
