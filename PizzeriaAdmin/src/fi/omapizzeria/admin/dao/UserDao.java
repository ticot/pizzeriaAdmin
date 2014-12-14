package fi.omapizzeria.admin.dao;
import java.sql.*;
import java.util.*;

import fi.omapizzeria.admin.bean.UserBean;
import include.ConnectionManager;
public class UserDao {
	public List<UserBean> getUsers() throws SQLException {
		
		ConnectionManager connection = new ConnectionManager();

		List<UserBean> uList = new ArrayList<UserBean>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		resultSet = statement.executeQuery("select * from Kayttaja"); // Result
																	// setin
																	// luonti
		try {
			
			while (resultSet.next()) { // Iteroidaan l‰pi
				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				int id = resultSet.getInt("kayttaja_id");
				int level = resultSet.getInt("level");
				String etunimi = resultSet.getString("etunimi");
				String sukunimi = resultSet.getString("sukunimi");
				String katuosoite = resultSet.getString("katuosoite");
				String postinumero = resultSet.getString("postinumero");
				String postitoimipaikka = resultSet.getString("postitoimipaikka");
				String puhelinnumero = resultSet.getString("puhelinnro");
				
				
				String email = resultSet.getString("email");
				
				UserBean u = new UserBean(etunimi, sukunimi, katuosoite, postinumero, postitoimipaikka, puhelinnumero, email, level, id);
				
				uList.add(u);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// SULJETAAN YHTEYS
			connection.closeConnection(con);
		}
		System.out.println(uList);
		return uList;
	}
	@SuppressWarnings("finally")
	public boolean addUser(String etunimi, String sukunimi, String katuosoite, String postinumero, String postitoimipaikka, String puhelinnumero, String email, int level, String salasana){
	boolean added=false;
	
	ConnectionManager connection = new ConnectionManager();
	Connection con = connection.doConnection();
	Statement statement = null;
	ResultSet resultSet = null;
	try {
		statement = con.createStatement();
	} catch (SQLException e){
		e.printStackTrace();
	}
	try {
		resultSet = statement
				.executeQuery("INSERT INTO Kayttaja (etunimi, sukunimi, katuosoite, postinumero, postitoimipaikka, email, puhelinnro, salasana, level) VALUE ('"
						+ etunimi
						+ "','"
						+ sukunimi
						+ "','"
						+ katuosoite
						+ "','"
						+ postinumero
						+ "','"
						+ postitoimipaikka
						+ "','"
						+ email
						+ "','"
						+ puhelinnumero
						+ "','"
						+ salasana
						+ "','"
						+ level
						+ "')");
added=true;
	} catch (SQLException e) {
		e.printStackTrace();
	}

	finally {
		connection.closeConnection(con);

		// request.getRequestDispatcher("list?added=true").forward(request,
		// response);
		return added;
	}
	
	}
	@SuppressWarnings("finally")
	public boolean removeUser(int id){
		boolean removed=false;
		ConnectionManager connection = new ConnectionManager();
		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		} // Statement olion luonti

		try {
			resultSet = statement
					.executeQuery("DELETE FROM Kayttaja WHERE kayttaja_id='"
							+ id + "'");
			removed = true;
		} catch (SQLException e) {
			removed = false;
			e.printStackTrace();
		} finally {
			connection.closeConnection(con);
			return removed;
		}
	}
	public static UserBean login(UserBean bean){
		ConnectionManager connection = new ConnectionManager();
		Statement stmt = null; 
		ResultSet rs = null;	 
		Connection con = null;
		String email = bean.getEmail();
		String salasana = bean.getSalasana();
		
		String searchQuery = "select * from Kayttaja"
				+ " where email ='"
				+email
				+"' AND salasana='"
				+salasana
				+"';";
		
		//debug
		System.out.println("email="+email);
		System.out.println("pass="+salasana);
		System.out.println("haku= "+searchQuery);
		
		try
		{
			//yhdistet‰‰
			con = connection.doConnection();
			System.out.println("connection natsas");
			stmt=con.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
		
			if(!more)
			{
				System.out.println("Kirjautuminen ei onnistunut!");
				bean.setValid(false);
			}
			else if(more)
			{
				
				String etunimi = rs.getString("etunimi");
				String sukunimi = rs.getString("sukunimi");
				String katuosoite = rs.getString("katuosoite");
				String postinumero = rs.getString("postinumero");
				String postitoimipaikka = rs.getString("postitoimipaikka");
				String puhelinnumero = rs.getString("puhelinnro");
				int level = rs.getInt("level");
				int id = rs.getInt("kayttaja_id");

				bean.setId(id);
				bean.setEtunimi(etunimi);
				bean.setSukunimi(sukunimi);
				bean.setKatuosoite(katuosoite);
				bean.setPostinumero(postinumero);
				bean.setPostitoimipaikka(postitoimipaikka);
				bean.setPuhelinnumero(puhelinnumero);
				bean.setLevel(level);
				
				
				bean.setValid(true);
			}
		}
		catch (Exception ex)
		{
			System.out.println("Exception has occurred! " + ex);
		}
		finally
		{
			if (rs != null){
				try{
					rs.close();
					System.out.println("resultset suljettu");
				} catch (Exception e){}
				rs=null;
			}
			
			if (stmt != null){
				try{
					stmt.close();
				}catch (Exception e){}
				stmt=null;
			}
			
			if(con != null){
				try{
					con.close();
				}catch (Exception e){}
				con = null;
			}
	}
		return bean;
}
}