package fi.omapizzeria.admin.controller;

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
@WebServlet("/sisaltopoisto")
public class SisaltoPoisto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SisaltoPoisto() {
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
		String id = request.getParameter("id");
		
		if(request.getParameter("id") !=null && !request.getParameter("id").equals("") ){
			ConnectionManager connection = new ConnectionManager();
			Connection con = connection.doConnection();

			Statement statement = null;
			ResultSet resultSet = null;

			try {
				statement = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Statement olion luonti

			try {
				resultSet = statement
						.executeQuery("DELETE FROM Sisalto WHERE sisalto_id='" + id +"'");
				response.sendRedirect("sisalto?poistettu=true");
			} catch (SQLException e) {
				System.out.println("Ei");
				response.sendRedirect("sisalto?error=aineosa_jo_olemassa");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				//System.out.println("Poistettu pizza id:"+id);
				connection.closeConnection(con);
			}
		}
	}

}
