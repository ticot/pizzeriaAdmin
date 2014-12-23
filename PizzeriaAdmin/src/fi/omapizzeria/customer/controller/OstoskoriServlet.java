package fi.omapizzeria.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.Ostoskori;
import fi.omapizzeria.admin.bean.Tuote;


@WebServlet("/Customer/ostoskori")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//2014
//
//OstoskoriServlet käsittelee ostoskorin sisältöä. Lisäys ja poistometodit löytyy.
public class OstoskoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Ostoskori> ostoslista = new ArrayList<Ostoskori>();
	double hintayhteensa = 0;

	public OstoskoriServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("yht", hintayhteensa);
		request.setAttribute("tyht", ostoslista.size());
		request.getRequestDispatcher("shoppingcart.jsp").forward(request,
				response);

	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");	
		//ostoskorisivulla voi jokaisen ostoskorin tuotteen vieressä klikata "poista" 
		//ja pizzat-sivulla voi jokaisen tuotteen kohdalla painaa "lisää ostkoskoriin". 
		//Noh, sitä tässä vertaillaan.
		String id = request.getParameter("id");

		if (action == null) {
			action = "0";
		}
		if (action.equals("1")) {//jos poistetaan
			for (Iterator<Ostoskori> iter = ostoslista.listIterator(); iter
					.hasNext();) {
				Ostoskori a = iter.next();
				if (a.getTuote_id() == Integer.parseInt(id)) {

					hintayhteensa -= a.getHinta();
					request.setAttribute("yht", hintayhteensa);
					iter.remove();

					break;
				}

			}
			request.getRequestDispatcher("shoppingcart.jsp").forward(request,
					response);
		}

		if (action.equals("0")) { //lisätään 
			
			 
			System.out.println("sisallla" + id);


			String tuote_nimi = request.getParameter("nimi");
			String glu = request.getParameter("glutein-free");
			String lakt = request.getParameter("lactose-free");
			Ostoskori ostoskori = new Ostoskori();
			String hintas = request.getParameter("hinta");

			double hinta = Double.parseDouble(hintas);
			boolean glub = Boolean.valueOf(glu);
			boolean laktb = Boolean.valueOf(lakt);

			ostoskori.setTuote_id(Integer.parseInt(id));
			ostoskori.setGlu(glub);
			ostoskori.setLakt(laktb);
			ostoskori.setHinta(hinta);
			ostoskori.setTuote_nimi(tuote_nimi);
			ostoslista.add(ostoskori);
			hintayhteensa = 0.0;
			  for(int i = 0; i <ostoslista.size(); i++){ 
			  hintayhteensa = hintayhteensa + ostoslista.get(i).getHinta();
			  request.setAttribute("yht", hintayhteensa); }
			  System.out.println(hintayhteensa);
			request.getSession().setAttribute("ostosKoriLista", ostoslista);
			request.getSession().setAttribute("yht", hintayhteensa);
			response.sendRedirect("pizzat?added=true");
		}

	}

}
