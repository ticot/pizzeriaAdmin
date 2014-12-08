package fi.omapizzeria.admin.controller;

import include.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import fi.omapizzeria.admin.bean.Tuote;
import fi.omapizzeria.admin.dao.TuoteDao;

/**
 * Servlet implementation class MuokkaaPizzanSisalto
 */
@WebServlet("/muokkaasisalto")
public class MuokkaaPizzanSisalto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuokkaaPizzanSisalto() {
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
		TuoteDao pDao = new TuoteDao();
		String tuote_id = request.getParameter("id");
		

		String pnimi = request.getParameter("nimi");
		String phintas = request.getParameter("hinta");

		double phinta = Double.parseDouble(phintas);
		String tilattavissa = request.getParameter("tilattavissa");
		System.out.println("Tilattavissa: " + tilattavissa);
		if(tilattavissa == null){
			tilattavissa = "0";
			System.out.println(tilattavissa);
		}
		if(tilattavissa != null){
			tilattavissa = "1";
			System.out.println(tilattavissa);
		}
		
		
		int osia = 0;
		String osa1w = request.getParameter("osa1w");
		String osa2w = request.getParameter("osa2w");
		String osa3w = request.getParameter("osa3w");
		String osa4w = request.getParameter("osa4w");
		String osa1 = request.getParameter("selectpicker1");
		String osa2 = request.getParameter("selectpicker2");
		String osa3 = request.getParameter("selectpicker3");
		String osa4 = request.getParameter("selectpicker4");
		
		
		
		

	
		System.out.println("Tuote id on !!!! " +tuote_id);

		ConnectionManager connection = new ConnectionManager();

		List<Tuote> lista = new ArrayList<Tuote>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Statement olion luonti

		System.out.println("osa1w: " +osa1w + "\nosa1:" +osa1);
		try {
			
			resultSet = statement
					.executeQuery("UPDATE Tuote SET nimi='"+pnimi +"', hinta='"+phinta +"', tilattavissa="+ tilattavissa +" WHERE tuote_id ='"+ tuote_id +"'");

			resultSet = statement
					.executeQuery("UPDATE Tuotteen_sisalto SET sisalto_id='"+osa1+"' WHERE tuote_id='"+ tuote_id +"' AND sisalto_id='"+ osa1w +"'");
			
			resultSet = statement
					.executeQuery("UPDATE Tuotteen_sisalto SET sisalto_id='"+osa2+"' WHERE tuote_id='"+ tuote_id +"' AND sisalto_id='"+ osa2w +"'");
			
			resultSet = statement
					.executeQuery("UPDATE Tuotteen_sisalto SET sisalto_id='"+osa3+"' WHERE tuote_id='"+ tuote_id +"' AND sisalto_id='"+ osa3w +"'");
			
			resultSet = statement
					.executeQuery("UPDATE Tuotteen_sisalto SET sisalto_id='"+osa4+"' WHERE tuote_id='"+ tuote_id +"' AND sisalto_id='"+ osa4w +"'");
		
			response.sendRedirect("list?edit=true");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("list?error=edit"); // MITEN LISÄTÄ
		}

		finally {
			connection.closeConnection(con);
			// request.getRequestDispatcher("list?added=true").forward(request,
			// response);
			
		}
	}
}