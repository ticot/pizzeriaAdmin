package fi.omapizzeria.admin.controller;
import include.Hash;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fi.omapizzeria.admin.bean.UserBean;
import fi.omapizzeria.admin.dao.UserDao;


@WebServlet("/user")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//   2014
//   
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public User() {
		super();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Kun käyttäjä saapuu user.jsp sivulle, haetaan kaikki olemassa olevat
		// käyttäjät tietokannasta

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

		request.getRequestDispatcher("user.jsp").forward(request, response); // tää
																				// rivi
																				// lähettää
																				// selaimen
																				// user.jsp
																				// sivulle,
																				// mukanaan
																				// lista
																				// käyttäjistä
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// jos käyttäjä painaa "poista" tai "lisää käyttäjä" nappulaa tällä
		// sivulla, mennään tähän funktioon
		String action = request.getParameter("button");
		String id = request.getParameter("id");
		UserDao uDao = new UserDao();
		if (action.equals("register")) { // jos painettu nappula oli
											// "lisää käyttäjä" käydään tämä
											// funktio läpi
			
			
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
										// nappulaa käyttäjälistauksessa
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
