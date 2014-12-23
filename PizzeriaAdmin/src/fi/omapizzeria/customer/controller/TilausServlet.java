package fi.omapizzeria.customer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.Ostoskori;
import fi.omapizzeria.admin.bean.Tilaus;
import fi.omapizzeria.admin.dao.TilausDao;


@WebServlet("/Customer/order")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//2014
//
//Kun käyttäjä varmistaa tilauksensa, mennään tähän servlettiin tekemään uusi tilaus ja lisätään se tietokantaan.
public class TilausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TilausServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.getRequestDispatcher("Order.jsp").forward(request,
				response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//kun käyttäjä varmistaa tilauksen, tehdään uusi tilaus ja lisätään sinne tarvittavat tiedot toimitusta varten.
		String toimitustapa = request.getParameter("toimitustapa");
		String maksutapa = request.getParameter("maksutapa");
		String osoite = request.getParameter("Osoite");
		String postinumero = request.getParameter("Postinro");
		String postitoimipaikka = request.getParameter("Postitoimipaikka");
		String puhelinnumero = request.getParameter("Puhelinnro");
		String kayttaja_id = request.getParameter("kayttaja_id");
		System.out.println(toimitustapa);
		System.out.println(maksutapa);
		boolean lisatty=false;
		TilausDao tilausDao = new TilausDao(); //tilausdaosta tarvittavat metodit tilauksen lisäystä varten.
		System.out.println(kayttaja_id);
		int tilaus_id = 0;
		try {
			tilaus_id = tilausDao.haeUusinTilausID();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		double yhteensa = (double) request.getSession().getAttribute("yht");
		System.out.println("yht "+yhteensa);
		Tilaus tilaus = new Tilaus();	//tilaus-olion luonti ja tiedot
		tilaus.setTilaus_id(tilaus_id);
		tilaus.setKayttaja_id(Integer.parseInt(kayttaja_id));
		tilaus.setYhteensa(yhteensa);
		tilaus.setMaksutapa(maksutapa);
		tilaus.setToimitustapa(toimitustapa);
		tilaus.setPuhelinnumero(puhelinnumero);
		tilaus.setKatuosoite(osoite);
		tilaus.setPostinumero(postinumero);
		tilaus.setPostitoimipaikka(postitoimipaikka);
		List<Ostoskori> ostoslista = (List<Ostoskori>) request.getSession().getAttribute("ostosKoriLista");
		System.out.println("Tilaus_id: " + tilaus_id);
		try {
			lisatty = tilausDao.lisaaTilaus(tilaus, ostoslista);		//katso tilausdaosta miten lisäys tapahtuu
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (lisatty){
			System.out.println("Uusi Tilaus taulun rivi lisätty");
			request.getSession().invalidate();
			ostoslista.clear();
		}
		else{
			System.out.println("Uuden rivin lisääminen ei onnistunut tauluun Tilaus");
		}
		request.getRequestDispatcher("Order.jsp?ordered=true").forward(request,
				response);
	}

}
