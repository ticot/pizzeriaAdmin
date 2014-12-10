package fi.omapizzeria.admin.controller;

import include.ConnectionManager;

import java.awt.image.TileObserver;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import fi.omapizzeria.admin.bean.*;
import fi.omapizzeria.admin.dao.TuoteDao;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/index")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AdminServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//Lyhyesti: kun admin-sivun etusivulle saavutaan, käydään hakemassa neljään listaan tuotteet, tilattavat tuotteet, palautteet ja sisältö
		
		TuoteDao pDao = new TuoteDao();		//Alustetaan tuotedao
		List<Tuote> pList = null;			//alustetaan tuotelista(kaikki tuotteet)
		List<Palaute> palauteList = null;	//alustetaan palautelista
		List<Tuote> pTilattavissa = null;	//alustetaan tilattavien tuotteiden lista
		List<Sisalto> pSisaltoList = null;	//alusteaan sisältölista

		try {
			pTilattavissa = pDao.haeKaikkiTuotteetTilattavissa();	//haetaan tilattavat tuotteet listaan
		} catch (SQLException e1) {
			System.out
					.println("Tilattavissa olevien tuotteiden haku epäonnistui");
			e1.printStackTrace();
		}

		try {
			palauteList = pDao.haeKaikkiPalautteetRajattu();		//haetaan kaikki palautteet listaan
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			pList = pDao.haeKaikkiTuotteet();						//haetaan kaikki tuotteet listaan
			pSisaltoList = pDao.haeTuoteSisalto();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int yhteensa = pTilattavissa.size();						//määritellään requestille listojen nimet
		request.setAttribute("pizzat", pList);
		request.setAttribute("pizzatSisalto", pSisaltoList);
		request.setAttribute("pizzatTilattavissa", pTilattavissa);
		request.setAttribute("palautteet", palauteList);
		request.setAttribute("yht", yhteensa);

	
		request.getRequestDispatcher("index.jsp").forward(request, response);	//lähetetään uudelleen määritelty requesti takaisin etusivulle (admin sivu)
		//request.getRequestDispatcher("dummy.jsp").forward(request, response);
		// request.getRequestDispatcher("PETER_TEST_INGORE.jsp").forward(request,
		// response); // IGNORE

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/*
	 * public void poistaTuote(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * System.out.println("OLLAAN FUNKAN SISÄLLÄ"); String id =
	 * request.getParameter("action");
	 * 
	 * if(request.getParameter("action") !=null &&
	 * !request.getParameter("action").equals("") ){ ConnectionManager
	 * connection = new ConnectionManager(); Connection con =
	 * connection.doConnection();
	 * 
	 * Statement statement = null; ResultSet resultSet = null;
	 * 
	 * try { statement = con.createStatement(); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } // Statement olion
	 * luonti
	 * 
	 * try { resultSet = statement .executeQuery("DELETE FROM Tuote WHERE id='"
	 * + id +"'"); } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } finally { System.out.println(id);
	 * connection.closeConnection(con); } } }
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		

		// REDIRECT???????

	}

}
