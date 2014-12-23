package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.Palaute;
import fi.omapizzeria.admin.dao.TuoteDao;


@WebServlet("/palaute")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//2014
//
public class PalauteServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public PalauteServletAdmin() {
		super();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// kun tullaan palaute.jsp sivulle niin tarkistetaan et onko käyttäjä
		// tullut tänne etusivulta klikkaamalla jotain palautetta siitä keskeltä
		// löytyvästä laatikosta
		String highlight = request.getParameter("id");

		TuoteDao pDao = new TuoteDao();
		List<Palaute> palauteList = null;

		try {
			palauteList = pDao.haeKaikkiPalautteet();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int yhteensa = palauteList.size();

		request.setAttribute("yht", yhteensa);
		request.setAttribute("highlight", highlight); // jos etusivulla oli
														// klikattu tiettyä
														// palautetta niin sen
														// klikatun palautteen
														// id otetaa taltee
		request.setAttribute("palautteet", palauteList);
		request.getRequestDispatcher("palaute.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
