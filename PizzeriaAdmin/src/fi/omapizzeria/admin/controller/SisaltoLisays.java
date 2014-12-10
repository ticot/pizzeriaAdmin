package fi.omapizzeria.admin.controller;

import include.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.Palaute;
import fi.omapizzeria.admin.bean.Sisalto;
import fi.omapizzeria.admin.bean.Tuote;
import fi.omapizzeria.admin.dao.TuoteDao;

/**
 * Servlet implementation class SisaltoLisays
 */
@WebServlet("/sisalto")
public class SisaltoLisays extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SisaltoLisays() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// kun sis‰ltˆ-sivulle tullaan, haetaan t‰‰lt‰ lista niist‰ ainesosista
		// jotka ovat tallessa
		TuoteDao pDao = new TuoteDao();
		List<Sisalto> pSisaltoList = null;

		try {
			pSisaltoList = pDao.haeTuoteSisaltoPakolliset();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("pizzatSisalto", pSisaltoList);

		request.getRequestDispatcher("sisalto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// k‰ytt‰j‰ painaa "lis‰‰ ainesosa" kirjoitettuaan ainesosan nimen
		// kentt‰‰n, tullaan t‰nne ja lis‰t‰‰n ainesosa tietokantaan
		String uusi_sisalto = request.getParameter("sisalto");

		ConnectionManager connection = new ConnectionManager();

		List<Tuote> lista = new ArrayList<Tuote>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Statement olion luonti

		try {
			resultSet = statement
					.executeQuery("INSERT INTO Sisalto(nimi, sisalto) VALUE ('"
							+ uusi_sisalto + "','" + uusi_sisalto + "')");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			connection.closeConnection(con);
			// request.getRequestDispatcher("list?added=true").forward(request,
			// response);
			response.sendRedirect("sisalto?added=true"); // menn‰‰n takas sis‰ltˆsivulle ja vied‰‰n tieto onnistuneesta lis‰yksest‰
		}

		// REDIRECT???????

	}

}
