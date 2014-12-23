package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.omapizzeria.admin.bean.Tilaus;
import fi.omapizzeria.admin.dao.TilausDao;


@WebServlet(name = "TilausServletAdmin", urlPatterns = { "/tilaukset" })
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//   Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//   2014
//   
public class TilausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TilausServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TilausDao tDao = new TilausDao();   //Alustetaan TilausDao
		List<Tilaus> tilausList = null;
		
		try {
			tilausList = tDao.haeKaikkiTilaukset();	//haeataan tilaukset ja laitetaan ne listaan.
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("tilaukset", tilausList);
		
		request.getRequestDispatcher("tilaukset.jsp").forward(request, response);	//lähetetään uudelleen määritelty requesti takaisin etusivulle (admin sivu)
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
