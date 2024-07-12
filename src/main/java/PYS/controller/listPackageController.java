package PYS.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import PYS.dao.packageDAO;

/**
 * Servlet implementation class listPackageController
 */
public class listPackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private packageDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listPackageController() {
        super();
        setDao(new packageDAO());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("packages", packageDAO.getAllPackages());
		RequestDispatcher view=request.getRequestDispatcher("listPackage.jsp");
		view.forward(request, response);
	}

	private void setDao(packageDAO dao) {
		this.dao=dao;
	}

	public packageDAO getDao() {
		return dao;
	}
}
