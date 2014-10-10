package fi.omapizzeria.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		List<Pizza> lista = new ArrayList<Pizza>();
		lista.add(new Pizza(1, "Margarita", 7.90));
		lista.add(new Pizza(2, "Frutti di Mare", 9.90));
		response.setContentType("text/html");
		
		java.io.PrintWriter wout = response.getWriter();
		
		 
		request.setAttribute("piz", lista);
		
		//ohjataan pyyntö jsp-sivulle, joka hoitaa tulostuksen muotoilun
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		String aloitusaika;
		Date now = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss");
	  
	    aloitusaika = (String)request.getSession().getAttribute("aloitusaika");

	    request.getSession().setAttribute("aloitusaika", ft.format(now));

		 */
		TuoteDao pDao = new TuoteDao();
		List<Tuote> pList = null;
		try {
			pList = pDao.haeKaikkiTuotteet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("pizzat", pList);

		request.getRequestDispatcher("list.jsp").forward(request, response);
	    
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		//paketoidaan requestin parametrit yhteen olioon
				String pnimi = request.getParameter("nimi");
				String phintas = request.getParameter("hinta");
				double phinta = Double.parseDouble(phintas);
				Pizza p = new Pizza(3,pnimi,phinta);
				
				//tallennetaan luotu olio requestin atribuutiksi
				request.setAttribute("pizza", p);
				
				//ohjataan pyyntö jsp-sivulle, joka hoitaa tulostuksen muotoilun
				request.getRequestDispatcher("list.jsp").forward(request, response);
				
				//tarvitaan kirjoituskone, jolla voidaan kirjoittaa tekstiä webbiselaimelle takaisin päin
				//PrintWriter wout = response.getWriter();

				//palautetaan selaimelle sivu, jossa lukee syötetty nimi
				System.out.println("Nimi: " + pnimi + "\nHinta: " + phinta);
				response.sendRedirect("controller?added=true");
				*/
		
		
	}

}
