package fi.omapizzeria.admin.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fi.omapizzeria.admin.dao.TuoteDao;


@WebServlet("/muokkaasisalto")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//   2014
//   
public class MuokkaaPizzanSisalto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MuokkaaPizzanSisalto() {
		super();
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Jos käyttäjä klikkaa tuotesivulla tietyn tuotteen oikealta puolelta
		// löytyvää "muokkaa"-nappia, aukeaa lomake johon täytetään tuotteen
		// uudet tiedot, jonka jälkeen ne uudet tiedot lähetetään tänne.

		TuoteDao pDao = new TuoteDao();
		String tuote_id = request.getParameter("id");

		String pnimi = request.getParameter("nimi");
		String phintas = request.getParameter("hinta");

		double phinta = Double.parseDouble(phintas);
		String tilattavissa = request.getParameter("tilattavissa");
		System.out.println("Tilattavissa: " + tilattavissa);
		if (tilattavissa == null) {
			tilattavissa = "0";
			System.out.println("Lol " + tilattavissa);
		} else {
			tilattavissa = "1";
			System.out.println("lol2 " + tilattavissa);
		}

		int osia = 0;
		String osa1w = request.getParameter("osa1w");				
		String osa2w = request.getParameter("osa2w");				
		String osa3w = request.getParameter("osa3w");
		String osa4w = request.getParameter("osa4w");
		String osa1 = request.getParameter("selectpicker1");
		String osa2 = request.getParameter("selectpicker2");
		String osa3 = request.getParameter("selectpicker3");
		String osa4 = request.getParameter("selectpicker4");
		
		System.out.println("Tuote id on !!!! " + tuote_id);
		boolean muokattu = pDao.muokkaaSisalto(osa1w, osa1, pnimi, phinta, tilattavissa, tuote_id, osa2, osa2w, osa3, osa3w, osa4, osa4w);
		if (muokattu){
			response.sendRedirect("list?edit=true");
		}
		else{
			response.sendRedirect("list?error=edit");
		}

	}
}