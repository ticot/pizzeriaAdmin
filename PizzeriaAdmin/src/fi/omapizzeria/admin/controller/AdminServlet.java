package fi.omapizzeria.admin.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fi.omapizzeria.admin.bean.*;
import fi.omapizzeria.admin.dao.TilausDao;
import fi.omapizzeria.admin.dao.TuoteDao;
@WebServlet("/index")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//   2014
//   
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Lyhyesti: kun admin-sivun etusivulle saavutaan, käydään hakemassa
		// neljään listaan tuotteet, tilattavat tuotteet, palautteet ja sisältö

		TuoteDao pDao = new TuoteDao(); // Alustetaan tuotedao
		TilausDao tDao = new TilausDao(); // Alustetaan TilausDao
		List<Tuote> pList = null; // alustetaan tuotelista(kaikki tuotteet)
		List<Palaute> palauteList = null; // alustetaan palautelista
		List<Tuote> pTilattavissa = null; // alustetaan tilattavien tuotteiden
											// lista
		List<Sisalto> pSisaltoList = null; // alusteaan sisältölista
		List<Tilaus> tilausList = null;

		try {
			pTilattavissa = pDao.haeKaikkiTuotteetTilattavissa(); // haetaan
																	// tilattavat
																	// tuotteet
																	// listaan
		} catch (SQLException e1) {
			System.out
					.println("Tilattavissa olevien tuotteiden haku epäonnistui");
			e1.printStackTrace();
		}

		try {
			palauteList = pDao.haeKaikkiPalautteetRajattu(); // haetaan kaikki
																// palautteet
																// listaan
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			pList = pDao.haeKaikkiTuotteet(); // haetaan kaikki tuotteet listaan
			pSisaltoList = pDao.haeTuoteSisalto();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			tilausList = tDao.haeKaikkiTilaukset();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("tilaukset", tilausList);
		int yhteensa = pTilattavissa.size(); // määritellään requestille
												// listojen nimet
		request.setAttribute("pizzat", pList);
		request.setAttribute("pizzatSisalto", pSisaltoList);
		request.setAttribute("pizzatTilattavissa", pTilattavissa);
		request.setAttribute("palautteet", palauteList);
		request.setAttribute("yht", yhteensa);

		request.getRequestDispatcher("index.jsp").forward(request, response); // lähetetään
																				// uudelleen
																				// määritelty
																				// requesti
																				// takaisin
																				// index.jsp
																				// (admin
																				// sivu)

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
