package PYS.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import PYS.bean.packages;
import PYS.dao.packageDAO;
import PYS.dao.staffDAO;

/**
 * Servlet implementation class addPackageController
 */
public class addPackageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private packageDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPackageController() {
        super();
        dao = new packageDAO();
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		packages p = new packages();
		String pattern = "yyyy-MM-dd";
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		
		Date p_startdate = null;
		Date p_enddate = null;
		try {
			p_startdate = dateFormat.parse(request.getParameter("p_startdate"));
			p_enddate = dateFormat.parse(request.getParameter("p_enddate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p.setPackageid(request.getParameter("packageid"));
		p.setPackagename(request.getParameter("packagename"));
		p.setP_destination(request.getParameter("p_destination"));
		p.setP_startdate(p_startdate);
		p.setP_enddate(p_enddate);
		p.setPackageprice(Double.parseDouble(request.getParameter("packageprice")));
		p.setPackagedesc(request.getParameter("packagedesc"));
		
		dao.addPackage(p);
		
		request.setAttribute("packages", packageDAO.getAllPackages());
		RequestDispatcher view = request.getRequestDispatcher("listPackage.jsp");
		view.forward(request, response);
	}

}
