package fi.omapizzeria.customer.controller;

import include.ConnectionManager;
import include.Hash;

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
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Customer/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			System.out.println("salasana=" + salasana);

			

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
						.executeQuery("INSERT INTO Kayttaja (etunimi, sukunimi, katuosoite, postinumero, postitoimipaikka, email, puhelinnro, salasana, level) VALUE ('"
								+ etunimi
								+ "','"
								+ sukunimi
								+ "','"
								+ katuosoite
								+ "','"
								+ postinumero
								+ "','"
								+ postitoimipaikka
								+ "','"
								+ email
								+ "','"
								+ puhelinnumero
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
				System.out.println("Lisättiin käyttäjä onnistuneesti! e-mail: "+email+" level:" +level);
				connection.closeConnection(con);
				// request.getRequestDispatcher("list?added=true").forward(request,
				// response);
				response.sendRedirect("index.jsp"); // MITEN LISÄTÄ
			}
		}
		else {
			request.setAttribute("error", "Salasanat eivät vastaa toisiaan."); // salasanat ei vastaa
		    request.getRequestDispatcher("index.jsp").forward(request, response); // Forward to same page so that you can display error.
		    JOptionPane.showMessageDialog(null, "Salasanat eivät vastaa toisiaan."); //näytetään alert-laatikko jossa virhe selitetään
		}

		// REDIRECT???????
	}

}
