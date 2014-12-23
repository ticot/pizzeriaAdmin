package fi.omapizzeria.customer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.Tuote;
import fi.omapizzeria.admin.dao.TuoteDao;

@WebServlet("/Customer/pizzat")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//2014
//
//Tämä servletti käsittelee tietoja jotka lähetetään käyttäjälle kun hän menee asiakas-puolen "pizzat"-sivulle. Yksinkertaisuudessaan tuotteet listataan sivulle.
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControllerServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TuoteDao pDao = new TuoteDao();
		List<Tuote> pList = null;

		try {
			pList = pDao.haeKaikkiTuotteetTilattavissa();	//haetaan tietokannasta kaikki tuotteet (pizzat)

		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		int yhteensa = pList.size();		
		request.setAttribute("pizzat", pList);		
		request.setAttribute("yht", yhteensa);	

		request.getRequestDispatcher("pizzat.jsp").forward(request, response);//lähetetään kaikki pizzat pizzat.jsp sivulle.	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
