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

/**
 * Servlet implementation class OstoskoriServlet
 */
@WebServlet("/Customer/ostoskori")
public class OstoskoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Ostoskori> ostoslista = new ArrayList<Ostoskori>();
	double hintayhteensa = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OstoskoriServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// request.getSession().invalidate();
		request.setAttribute("yht", hintayhteensa);
		request.getRequestDispatcher("shoppingcart.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String id = request.getParameter("id");

		if (action == null) {
			action = "0";
		}
		if (action.equals("1")) {//jos poistetaan
			// ostoslista.clear();
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
			// request.getSession().invalidate();
			request.getRequestDispatcher("shoppingcart.jsp").forward(request,
					response);
		}

		if (action.equals("0")) { //lisätään 
			
			 
			System.out.println("sisallla" + id);
//			for (Iterator<Ostoskori> iter = ostoslista.listIterator(); iter
//					.hasNext();) {
//				System.out.println(iter);
//				Ostoskori a = iter.next();
//				if (a.getTuote_id() == Integer.parseInt(id)) {
//					hintayhteensa += a.getHinta();
//					System.out.println("Löytyi: " + hintayhteensa);
//					request.setAttribute("yht", hintayhteensa);
//				}
//			
//
//			}

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
