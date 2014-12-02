package fi.omapizzeria.admin.dao;
import java.sql.*;
import java.util.*;



import fi.omapizzeria.admin.bean.*;
import include.ConnectionManager;
public class UserDao {
	public List<User> getUsers() throws SQLException {
		
		ConnectionManager connection = new ConnectionManager();

		List<User> lista = new ArrayList<User>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		resultSet = statement.executeQuery("SELECT * FROM Kayttaja"); // Result
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

				int id = resultSet.getInt("id");
				String etunimi = resultSet.getString("etunimi");
				String sukunimi = resultSet.getString("etunimi");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				User u = new User(id, etunimi, sukunimi, email, password);
				lista.add(u);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// SULJETAAN YHTEYS
			connection.closeConnection(con);
		}
		System.out.println(lista);
		return lista;
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