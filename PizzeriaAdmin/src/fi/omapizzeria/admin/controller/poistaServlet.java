package fi.omapizzeria.admin.controller;

import fi.omapizzeria.admin.dao.TuoteDao;
import include.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class poistaServlet
 */
@WebServlet("/poista")
public class poistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public poistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Jos k‰ytt‰j‰ poistaa tuotteen list.jsp sivulla niin tullaan t‰nne. Mukana tulee tieto sen tuotteen id:st‰ mik‰ pit‰‰ poistaa.
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
//			ConnectionManager connection = new ConnectionManager();
//			Connection con = connection.doConnection();
//
//			Statement statement = null;
//			ResultSet resultSet = null;
//
//			try {
//				statement = con.createStatement();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} // Statement olion luonti
//			//T‰‰ allaoleva tuotedaoo
//			try {
//				resultSet = statement
//						.executeQuery("DELETE FROM Tuotteen_sisalto WHERE tuote_id='" + id +"'");
//			} catch (SQLException e) {
//				System.out.println("Ei");
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				resultSet = statement
//						.executeQuery("DELETE FROM Tuote WHERE tuote_id='" + id +"'");
//			} catch (SQLException e) {
//				System.out.println("Ei");
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//				System.out.println("Poistettu pizza id:"+id);
//				response.sendRedirect("list?poistettu=true"); //vied‰‰n k‰ytt‰j‰ takaisin list.jsp ja otetaan mukaan tieto onnistuneesta poistosta
//				connection.closeConnection(con);
//			}
		}
	}

}
