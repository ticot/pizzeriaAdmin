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
import fi.omapizzeria.admin.bean.UserBean;
import fi.omapizzeria.admin.dao.TuoteDao;
import fi.omapizzeria.admin.dao.UserDao;

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

		// Kun k‰ytt‰j‰ saapuu user.jsp sivulle, haetaan kaikki olemassa olevat
		// k‰ytt‰j‰t tietokannasta

		UserDao uDao = new UserDao();
		List<UserBean> uList = null;

		try {
			uList = uDao.getUsers();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int yhteensa = uList.size();
		request.setAttribute("users", uList);
		request.setAttribute("yht", yhteensa);

		request.getRequestDispatcher("user.jsp").forward(request, response); // t‰‰
																				// rivi
																				// l‰hett‰‰
																				// selaimen
																				// user.jsp
																				// sivulle,
																				// mukanaan
																				// lista
																				// k‰ytt‰jist‰
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// jos k‰ytt‰j‰ painaa "poista" tai "lis‰‰ k‰ytt‰j‰" nappulaa t‰ll‰
		// sivulla, menn‰‰n t‰h‰n funktioon
		String action = request.getParameter("button");
		String id = request.getParameter("id");

		System.out.println("toiminto oli" + action + " ja id " + id);
		if (action.equals("register")) { // jos painettu nappula oli
											// "lis‰‰ k‰ytt‰j‰" k‰yd‰‰n t‰m‰
											// funktio l‰pi
			String email = request.getParameter("email");
			String etunimi = request.getParameter("etunimi");
			String sukunimi = request.getParameter("sukunimi");
			// String salasana = request.getParameter("salasana");
			Hash h = new Hash();
			String salasana = h.getHash(request.getParameter("salasana"));
			String salasana2 = h.getHash(request.getParameter("salasana2"));
			if (salasana2.equals(salasana)) {
				System.out.println("salasana=" + salasana);

				String level = request.getParameter("level");

				ConnectionManager connection = new ConnectionManager();

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
							.executeQuery("INSERT INTO Kayttaja (etunimi, sukunimi, email, salasana, level) VALUE ('"
									+ etunimi
									+ "','"
									+ sukunimi
									+ "','"
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
					response.sendRedirect("user?added=true");
				}
			} else {
				request.setAttribute("error",
						"Salasanat eiv‰t vastaa toisiaan."); // salasanat ei
																// vastaa
				request.getRequestDispatcher("/user?added=false").forward(
						request, response); // Forward to same page so that you
											// can display error.
				JOptionPane.showMessageDialog(null,
						"Salasanat eiv‰t vastaa toisiaan."); // n‰ytet‰‰n
																// alert-laatikko
																// jossa virhe
																// selitet‰‰n
			}

		}
		if (action.equals("remove")) { // Jos sivulla painettiin "poista"
										// nappulaa k‰ytt‰j‰listauksessa

			if (request.getParameter("id") != null
					&& !request.getParameter("id").equals("")) {
				ConnectionManager connection = new ConnectionManager();
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
							.executeQuery("DELETE FROM Kayttaja WHERE kayttaja_id='"
									+ id + "'");
					System.out.println("K‰ytt‰j‰n poistaminen onnistui!");
					response.sendRedirect("user?removed=true");
				} catch (SQLException e) {
					System.out.println("Poistaminen ei onnistunut");
					response.sendRedirect("user?removed=false");
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					connection.closeConnection(con);
				}
			}

		}
	}

}
