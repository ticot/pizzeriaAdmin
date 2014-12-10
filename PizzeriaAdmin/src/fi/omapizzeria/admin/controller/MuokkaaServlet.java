package fi.omapizzeria.admin.controller;

import fi.omapizzeria.admin.dao.TuoteDao;
import fi.omapizzeria.admin.dao.UserDao;
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

/**
 * Servlet implementation class MuokkaaServlet
 */
@WebServlet("/muokkaa")
public class MuokkaaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MuokkaaServlet() {
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
		TuoteDao tDao = new TuoteDao();
		// Jos käyttäjä painaa list.jsp löytyvästä tuotelistauksesta jonkun
		// tuotteen vierestä nappulaa "tilattavissa", mennään tänne, ja
		// tilattavuus muutetaan.
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		System.out.println(id);
		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
//			ConnectionManager connection = new ConnectionManager();
//			Connection con = connection.doConnection();
//
//			Statement statement = null;
//			ResultSet resultSet = null;
//
//			try {
//				statement = con.createStatement();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} // Statement olion luonti

			if (action.equals("0")) {
				boolean piilotettu = tDao.piilotaTuote(id);
				if(piilotettu){
					System.out.println("Poistettu pizza id:" + id);
					response.sendRedirect("list?muokattu=true");
				}
				else{
					System.out.println("Ei toiminut, tuotetta ei piilotettu.");
				}
//				try {
//					resultSet = statement
//							.executeQuery("UPDATE Tuote SET tilattavissa=0 WHERE tuote_id='"
//									+ id + "'");
//				} catch (SQLException e) {
//					System.out.println("Ei");
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} finally {
//					System.out.println("Poistettu pizza id:" + id);
//					response.sendRedirect("list?muokattu=true");
//					connection.closeConnection(con);
//				}

			} else if (action.equals("1")) {
				boolean palautettu = tDao.palautaTuote(id);
				if(palautettu){
					System.out.println("Palautettu pizza id:" + id);
					response.sendRedirect("list?muokattu=true");
				}
				else{
					System.out.println("Ei toiminut, tuotetta ei palautettu.");
					response.sendRedirect("list?muokattu=false");
				}
//				try {
//					resultSet = statement
//							.executeQuery("UPDATE Tuote SET tilattavissa=1 WHERE tuote_id='"
//									+ id + "'");
//				} catch (SQLException e) {
//					System.out.println("Ei");
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} finally {
//					System.out.println("Poistettu pizza id:" + id);
//					response.sendRedirect("list?muokattu=true");
//					connection.closeConnection(con);
//				}
			}
		}
	}

}
