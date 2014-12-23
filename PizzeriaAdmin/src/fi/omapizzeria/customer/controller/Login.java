package fi.omapizzeria.customer.controller;

import java.io.IOException;

import include.Hash;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import fi.omapizzeria.admin.dao.UserDao;
import fi.omapizzeria.admin.bean.UserBean;

@WebServlet("/Customer/login")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//2014
//
//Kun käyttäjä painaa "kirjaudu sisään" nappulaa täytettyään tiedot, käydään läpi tämä servletti. UserDaosta otetaan metodeja tähän.
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			UserBean user = new UserBean();
			user.setEmail(request.getParameter("email"));
			Hash h = new Hash();
			user.setSalasana(h.getHash(request.getParameter("salasana")));

			user = UserDao.login(user);	//katso UserDao

			if (user.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				
				
				if (user.getLevel() == 2) {		/* tarkistetaan onko käyttäjä kirjautunut sisään */
					response.sendRedirect("index.jsp");

				}
				else if (user.getLevel() == 1)
					
				response.sendRedirect("../index");
			
			} else {
				response.sendRedirect("index.jsp");
				JOptionPane.showMessageDialog(null,
						"Virheellinen email tai salasana!");
			}

		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
