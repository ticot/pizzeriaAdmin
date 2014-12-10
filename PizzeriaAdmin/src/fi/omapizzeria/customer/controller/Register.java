package fi.omapizzeria.customer.controller;

import include.Hash;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import fi.omapizzeria.admin.dao.*;


@WebServlet("/Customer/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDao uDao = new UserDao();
		// TODO Auto-generated method stub
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String katuosoite = request.getParameter("katuosoite");
		String postinumero = request.getParameter("postinumero");
		String postitoimipaikka = request.getParameter("postitoimipaikka");
		String email = request.getParameter("email");
		String puhelinnumero = request.getParameter("puhelinnumero");

		// String salasana = request.getParameter("salasana");
		Hash h = new Hash();
		String salasana = h.getHash(request.getParameter("salasana"));
		String salasana2 = h.getHash(request.getParameter("salasana2"));
		int level = 2;
		if (salasana2.equals(salasana)) {
			boolean added = uDao.addUser(etunimi, sukunimi, katuosoite,
					postinumero, postitoimipaikka, puhelinnumero, email, level,
					salasana);
			if (added) {
				response.sendRedirect("index.jsp");
				JOptionPane.showMessageDialog(null,
						"Käyttäjä lisättiin onnistuneesti.");
			} else {
				request.setAttribute("error",
						"Salasanat eivät vastaa toisiaan."); // salasanat ei
																// vastaa
				request.getRequestDispatcher("index.jsp").forward(request,
						response); // Forward to same page so that you can
									// display error.
				JOptionPane
						.showMessageDialog(null,
								"Rekisteröitymisessä tapahtui virhe, kokeile myöhemmin uudestaan."); // näytetään
																										// alert-laatikko
																										// jossa
																										// virhe
																										// selitetään

			}
		} else {
			request.setAttribute("error", "Salasanat eivät vastaa toisiaan."); // salasanat
																				// ei
																				// vastaa
			request.getRequestDispatcher("index.jsp")
					.forward(request, response); 
			JOptionPane.showMessageDialog(null,
					"Salasanat eivät vastaa toisiaan."); // näytetään
															// alert-laatikko
															// jossa virhe
															// selitetään
		}

	
	}

}
