package fi.omapizzeria.customer.controller;

import java.io.IOException;
import include.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Customer/palaute")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//2014
//
//Tämä servlet lisää palautteet jotka on tehty asiakaspuolen palaute-sivulla. Palautteille on oma tietokantansa.
public class PalauteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public PalauteServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("palaute.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String nimi = request.getParameter("nimi");
		String email = request.getParameter("email");
		String otsikko = request.getParameter("otsikko");
		String palaute = request.getParameter("palaute");

		ConnectionManager connection = new ConnectionManager();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} // Statement olion luonti

		try {
			resultSet = statement
					.executeQuery("INSERT INTO Palaute (nimi, email, otsikko, palaute) VALUES ('"
							+ nimi
							+ "','"
							+ email
							+ "','"
							+ otsikko
							+ "','"
							+ palaute + "')");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			connection.closeConnection(con);
			response.sendRedirect("palaute?added=true");
		}

	}

}
