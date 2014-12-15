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
import fi.omapizzeria.admin.dao.TilausDao;
import fi.omapizzeria.admin.dao.TuoteDao;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/list")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ControllerServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * List<Pizza> lista = new ArrayList<Pizza>(); lista.add(new Pizza(1,
		 * "Margarita", 7.90)); lista.add(new Pizza(2, "Frutti di Mare", 9.90));
		 * response.setContentType("text/html");
		 * 
		 * java.io.PrintWriter wout = response.getWriter();
		 * 
		 * 
		 * 
		 * request.setAttribute("piz", lista);
		 * 
		 * //ohjataan pyynt� jsp-sivulle, joka hoitaa tulostuksen muotoilun
		 * request.getRequestDispatcher("list.jsp").forward(request, response);
		 * 
		 * String aloitusaika; Date now = new Date(); SimpleDateFormat ft = new
		 * SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss");
		 * 
		 * aloitusaika =
		 * (String)request.getSession().getAttribute("aloitusaika");
		 * 
		 * request.getSession().setAttribute("aloitusaika", ft.format(now));
		 */
		// ControllerServletiss� tehd��n sama juttu kuin AdminServletiss�,
		// paitsi t�ll� kertaa tiedot l�hetet��n list.jsp sivulle
		
		TuoteDao pDao = new TuoteDao();
		
		List<Tuote> pList = null;
		List<Palaute> palauteList = null;
		List<Tuote> pTilattavissa = null;
		List<Sisalto> pSisaltoList = null;
	

		try {
			pTilattavissa = pDao.haeKaikkiTuotteetTilattavissa();
		} catch (SQLException e1) {
			System.out
					.println("Tilattavissa olevien tuotteiden haku ep�onnistui");
			e1.printStackTrace();
		}

		try {
			palauteList = pDao.haeKaikkiPalautteet();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			pList = pDao.haeKaikkiTuotteet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			pSisaltoList = pDao.haeTuoteSisalto();
			System.out.println(pSisaltoList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		// request.getRequestDispatcher("dummy.jsp").forward(request, response);
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
	 * System.out.println("OLLAAN FUNKAN SIS�LL�"); String id =
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
		//t�m�n sivun dopostissa listataan tuotteet. Kun k�ytt�j� painaa list.jsp sivulla "lis�� tuote" ja t�ytt�� lomakkeen onnistuneesti, l�hetet��n lomakkeen tiedot t�h�n funktioon
		
		TuoteDao pDao = new TuoteDao();
		int tuote_id = 0;
		try {
			tuote_id = pDao.haeUusinID();
			if (tuote_id == 0) {
				tuote_id = 1;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//T�st� alasp�in pit�is tehd� oma funktio tuotedaoon.
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
		
//		ConnectionManager connection = new ConnectionManager();
//
//		List<Tuote> lista = new ArrayList<Tuote>();
//
//		Connection con = connection.doConnection();
//
//		Statement statement = null;
//		ResultSet resultSet = null;
//
//		try {
//			statement = con.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // Statement olion luonti
//		//varsinkin n�� vissii daoo
//		try {
//			resultSet = statement
//					.executeQuery("INSERT INTO Tuote(nimi, hinta, tilattavissa) VALUE ('"
//							+ pnimi
//							+ "', '"
//							+ phintas
//							+ "', '"
//							+ tilattavissa
//							+ "')");
//
//			resultSet = statement
//					.executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
//							+ osa1 + "','" + tuote_id + "')");
//			resultSet = statement
//					.executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
//							+ osa2 + "','" + tuote_id + "')");
//			resultSet = statement
//					.executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
//							+ osa3 + "','" + tuote_id + "')");
//			resultSet = statement
//					.executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
//							+ osa4 + "','" + tuote_id + "')");
//			response.sendRedirect("list?added=true");		//tuotteen lis�yksen j�lkeen menn��n taikaisin list.jsp ja vied��n tieto ett� lis�ys onnistui
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			response.sendRedirect("list?error=lisays"); // MITEN LIS�T�
//		}
//
//		finally {
//			connection.closeConnection(con);
//			// request.getRequestDispatcher("list?added=true").forward(request,
//			// response);
//
//		}

		// REDIRECT???????

	}

}
