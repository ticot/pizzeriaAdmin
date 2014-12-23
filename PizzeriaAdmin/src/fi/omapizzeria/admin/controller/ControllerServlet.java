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
import fi.omapizzeria.admin.dao.TuoteDao;


@WebServlet("/list")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//   2014
//   
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerServlet() {

	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ControllerServletissä tehdään sama juttu kuin AdminServletissä,
		// paitsi tällä kertaa tiedot lähetetään list.jsp sivulle
		//tällä sivulla käytetyt metodit löytyvät src.fi.omapizzeria.admin.dao.TuoteDao.java
		
		TuoteDao pDao = new TuoteDao();
		
		List<Tuote> pList = null;
		List<Palaute> palauteList = null;
		List<Tuote> pTilattavissa = null;
		List<Sisalto> pSisaltoList = null;
	

		try {
			pTilattavissa = pDao.haeKaikkiTuotteetTilattavissa();
		} catch (SQLException e1) {
			System.out
					.println("Tilattavissa olevien tuotteiden haku epäonnistui");
			e1.printStackTrace();
		}

		try {
			palauteList = pDao.haeKaikkiPalautteet();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			pList = pDao.haeKaikkiTuotteet();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			pSisaltoList = pDao.haeTuoteSisalto();
			System.out.println(pSisaltoList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	

		int yhteensa = pList.size();
		int yhteensaTil = pTilattavissa.size();
		request.setAttribute("pizzat", pList);
		request.setAttribute("pizzatSisalto", pSisaltoList);
		request.setAttribute("pizzatTilattavissa", pTilattavissa);
		request.setAttribute("palautteet", palauteList);
		request.setAttribute("yht", yhteensa);
		request.setAttribute("yhtTil", yhteensaTil);

		request.getRequestDispatcher("list.jsp").forward(request, response);


	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//tämän sivun dopostissa listataan tuotteet. Kun käyttäjä painaa list.jsp sivulla 
		//"lisää tuote" ja täyttää lomakkeen onnistuneesti, lähetetään lomakkeen tiedot tähän funktioon
		TuoteDao pDao = new TuoteDao();
		int tuote_id = 0;
		try {
			tuote_id = pDao.haeUusinID();
			if (tuote_id == 0) {
				tuote_id = 1;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String pnimi = request.getParameter("nimi");
		String phintas = request.getParameter("hinta");

		double phinta = Double.parseDouble(phintas);
		String tilattavissa = request.getParameter("tilattavissa");
		if (tilattavissa == null) {
			tilattavissa = "0";
		}
		int osia = 0;
		String osa1 = request.getParameter("selectpicker1");
		String osa2 = request.getParameter("selectpicker2");
		String osa3 = request.getParameter("selectpicker3");
		String osa4 = request.getParameter("selectpicker4");

		System.out.println("Nimi: " + pnimi + "\nHinta: " + phinta
				+ "Tilattavissa:" + tilattavissa + " Osa1: " + osa1);
		System.out.println("Tuote id on !!!! " + tuote_id);
		boolean lisatty = pDao.lisaaTuote(tuote_id, pnimi, phinta, tilattavissa, osa1, osa2, osa3, osa4);
		if (lisatty){
			response.sendRedirect("list?added=true");
		}
		else{
			response.sendRedirect("list?error=lisays");
		}
	}

}
