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

/**
 * Servlet implementation class TilausServlet
 */
@WebServlet(name = "TilausServletAdmin", urlPatterns = { "/tilaukset" })
public class TilausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TilausServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TilausDao tDao = new TilausDao();   //Alustetaan TilausDao
		List<Tilaus> tilausList = null;
		
		try {
			tilausList = tDao.haeKaikkiTilaukset();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("tilaukset", tilausList);
		
		request.getRequestDispatcher("tilaukset.jsp").forward(request, response);	//l‰hetet‰‰n uudelleen m‰‰ritelty requesti takaisin etusivulle (admin sivu)
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
