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
		UserDao uDao = new UserDao();
		if (action.equals("register")) { // jos painettu nappula oli
											// "lis‰‰ k‰ytt‰j‰" k‰yd‰‰n t‰m‰
											// funktio l‰pi
			
			
			String email = request.getParameter("email");
			String etunimi = request.getParameter("etunimi");
			String sukunimi = request.getParameter("sukunimi");
			String katuosoite = request.getParameter("katuosoite");
			String postinumero = request.getParameter("postinumero");
			String postitoimipaikka = request.getParameter("postitoimipaikka");
			String puhelinnumero = request.getParameter("puhelinnumero");
			int level = Integer.parseInt(request.getParameter("level"));
			Hash h = new Hash();
			String salasana = h.getHash(request.getParameter("salasana"));

			// String salasana = request.getParameter("salasana");
			
			
			String salasana2 = h.getHash(request.getParameter("salasana2"));
			if (salasana2.equals(salasana)) {
				boolean added=uDao.addUser(etunimi, sukunimi, katuosoite, postinumero, postitoimipaikka, puhelinnumero, email, level, salasana);
				System.out.println("salasana=" + salasana);
				if (added){
					response.sendRedirect("user?added=true");
				}
				else {
					response.sendRedirect("user?added=false");
				}
			}
		}
		if (action.equals("remove")) { // Jos sivulla painettiin "poista"
										// nappulaa k‰ytt‰j‰listauksessa
			boolean removed = uDao.removeUser(Integer.parseInt(id));
			if (removed){
				response.sendRedirect("user?removed=true");
			}
			else{
				response.sendRedirect("user?removed=false");
			}
			

		}
	}

}
