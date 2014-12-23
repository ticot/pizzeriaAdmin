package fi.omapizzeria.admin.controller;

import fi.omapizzeria.admin.dao.TuoteDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/muokkaa")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
// 	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
// Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
// 2014
// 
public class MuokkaaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public MuokkaaServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TuoteDao tDao = new TuoteDao();
		// Jos käyttäjä painaa list.jsp löytyvästä tuotelistauksesta jonkun
		// tuotteen vierestä nappulaa "tilattavissa", mennään tänne, ja
		// tilattavuus muutetaan.
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		System.out.println(id);
		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			if (action.equals("0")) {
				boolean piilotettu = tDao.piilotaTuote(id);
				if(piilotettu){
					System.out.println("Poistettu pizza id:" + id);
					response.sendRedirect("list?muokattu=true");
				}
				else{
					System.out.println("Ei toiminut, tuotetta ei piilotettu.");
				}
			} else if (action.equals("1")) {
				boolean palautettu = tDao.palautaTuote(id);
				if(palautettu){
					System.out.println("Palautettu pizza id:" + id);
					response.sendRedirect("list?muokattu=true");
				}
				else{
					System.out.println("Ei toiminut, tuotetta ei palautettu.");
					response.sendRedirect("list?muokattu=false");
				}

			}
		}
	}

}
