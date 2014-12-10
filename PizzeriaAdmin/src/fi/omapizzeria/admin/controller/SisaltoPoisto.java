package fi.omapizzeria.admin.controller;

import include.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fi.omapizzeria.admin.dao.*;
/**
 * Servlet implementation class poistaServlet
 */
@WebServlet("/sisaltopoisto")
public class SisaltoPoisto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SisaltoPoisto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Käyttäjä klikaa sisältösivulla ainesosalistasta löytyvän ainesosan
		// vierestä ruksia, tullaan tänne, mukana tieto poistettavan ainesosan
		// id:stä
		TuoteDao tDao = new TuoteDao();
		String id = request.getParameter("id");

		if (request.getParameter("id") != null
				&& !request.getParameter("id").equals("")) {
			boolean poistettu = tDao.poistaSisalto(id);
			if (poistettu){
				response.sendRedirect("sisalto?poistettu=true");
			}
			else{
				response.sendRedirect("sisalto?error=aineosa_jo_olemassa");
			}
		}
	}

}
