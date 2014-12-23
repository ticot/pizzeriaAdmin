package fi.omapizzeria.admin.controller;

import fi.omapizzeria.admin.dao.TuoteDao;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/poista")
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//2014
//
public class poistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public poistaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Jos käyttäjä poistaa tuotteen list.jsp sivulla niin tullaan tänne. Mukana tulee tieto sen tuotteen id:stä mikä pitää poistaa.
		String id = request.getParameter("id");
		TuoteDao tDao = new TuoteDao();
		if(request.getParameter("id") !=null && !request.getParameter("id").equals("") ){
			boolean poistettu = tDao.poistaTuote(id);
			if (poistettu){
				System.out.println("Poistettu pizza id:"+id);
				response.sendRedirect("list?poistettu=true");
			}
			else{
				response.sendRedirect("list");
			}
		}
	}

}
