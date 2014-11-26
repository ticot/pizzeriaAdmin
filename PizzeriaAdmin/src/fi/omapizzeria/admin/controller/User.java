package fi.omapizzeria.admin.controller;

import include.ConnectionManager;
import include.Hash;

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
import javax.swing.JOptionPane;

import fi.omapizzeria.admin.bean.Tuote;
import fi.omapizzeria.admin.dao.TuoteDao;

/**
 * Servlet implementation class User
 */
@WebServlet("/user")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TuoteDao pDao = new TuoteDao();

		String email = request.getParameter("email");
		// String salasana = request.getParameter("salasana");
		Hash h = new Hash();
		String salasana = h.getHash(request.getParameter("salasana"));
		String salasana2 = h.getHash(request.getParameter("salasana2"));
		if (salasana2.equals(salasana)) {
			System.out.println("salasana=" + salasana);

			String level = request.getParameter("level");

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
						.executeQuery("INSERT INTO Kayttaja (email, salasana, level) VALUE ('"
								+ email
								+ "','"
								+ salasana
								+ "','"
								+ level
								+ "')");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				connection.closeConnection(con);
				// request.getRequestDispatcher("list?added=true").forward(request,
				// response);
				response.sendRedirect("user?added=true"); // MITEN LISÄTÄ
			}
		}
		else {
			request.setAttribute("error", "Salasanat eivät vastaa toisiaan."); // salasanat ei vastaa
		    request.getRequestDispatcher("/user.jsp").forward(request, response); // Forward to same page so that you can display error.
		    JOptionPane.showMessageDialog(null, "Salasanat eivät vastaa toisiaan."); //näytetään alert-laatikko jossa virhe selitetään
		}

		// REDIRECT???????

	}

}
