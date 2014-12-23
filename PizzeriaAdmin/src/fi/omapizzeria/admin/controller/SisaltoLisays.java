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
import fi.omapizzeria.admin.bean.Sisalto;
import fi.omapizzeria.admin.bean.Tuote;
import fi.omapizzeria.admin.dao.TuoteDao;


@WebServlet("/sisalto")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//   2014
//   
public class SisaltoLisays extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SisaltoLisays() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// kun sisältö-sivulle tullaan, haetaan täältä lista niistä ainesosista
		// jotka ovat tallessa
		TuoteDao pDao = new TuoteDao();
		List<Sisalto> pSisaltoList = null;

		try {
			pSisaltoList = pDao.haeTuoteSisaltoPakolliset();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("pizzatSisalto", pSisaltoList);

		request.getRequestDispatcher("sisalto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// käyttäjä painaa "lisää ainesosa" kirjoitettuaan ainesosan nimen
		// kenttään, tullaan tänne ja lisätään ainesosa tietokantaan
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
			response.sendRedirect("sisalto?added=true"); // mennään takas sisältösivulle ja viedään tieto onnistuneesta lisäyksestä
		}

		// REDIRECT???????

	}

}
