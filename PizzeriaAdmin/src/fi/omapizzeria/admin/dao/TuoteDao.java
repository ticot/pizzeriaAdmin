package fi.omapizzeria.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import include.ConnectionManager;
import fi.omapizzeria.admin.bean.Tuote;
import fi.omapizzeria.admin.bean.Sisalto;

public class TuoteDao {

	public List<Tuote> haeKaikkiTuotteet() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		List<Tuote> lista = new ArrayList<Tuote>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		//resultSet = statement.executeQuery("SELECT * FROM Tuote"); // Result
																	// setin
																	// luonti
		resultSet = statement
				.executeQuery("SELECT p.tuote_id, p.nimi, p.hinta, p.tilattavissa, GROUP_CONCAT(DISTINCT c.sisalto ORDER BY c.sisalto SEPARATOR ', ') AS Sisalto FROM Tuote p INNER JOIN Tuotteen_sisalto r ON p.tuote_id = r.tuote_id INNER JOIN Sisalto c ON r.sisalto_id = c.sisalto_id WHERE p.tuote_id = r.tuote_id AND r.sisalto_id = c.sisalto_id GROUP BY p.tuote_id ORDER BY p.nimi");
		
		try {
			while (resultSet.next()) { // Iteroidaan läpi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				int id = resultSet.getInt("tuote_id");
				String nimi = resultSet.getString("nimi");
				double hinta = resultSet.getDouble("hinta");
				boolean tilattavissa = resultSet.getBoolean("tilattavissa");
				String sisalto = resultSet.getString("sisalto");

				Tuote p = new Tuote(id, nimi, hinta, tilattavissa, sisalto);
				lista.add(p);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			connection.closeConnection(con);
		}
		return lista;
	}

	public List<Tuote> haeKaikkiTuotteetTilattavissa() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		List<Tuote> lista = new ArrayList<Tuote>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		resultSet = statement
				.executeQuery("SELECT p.tuote_id, p.nimi, p.hinta, p.tilattavissa, GROUP_CONCAT(DISTINCT c.sisalto ORDER BY c.sisalto SEPARATOR ', ') AS Sisalto FROM Tuote p INNER JOIN Tuotteen_sisalto r ON p.tuote_id = r.tuote_id INNER JOIN Sisalto c ON r.sisalto_id = c.sisalto_id WHERE p.tuote_id = r.tuote_id AND r.sisalto_id = c.sisalto_id AND p.tilattavissa = 1 GROUP BY p.tuote_id ORDER BY p.nimi");
		try {
			while (resultSet.next()) { // Iteroidaan läpi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				int id = resultSet.getInt("tuote_id");
				String nimi = resultSet.getString("nimi");
				double hinta = resultSet.getDouble("hinta");
				boolean tilattavissa = resultSet.getBoolean("tilattavissa");
				String sisalto = resultSet.getString("sisalto");

				Tuote p = new Tuote(id, nimi, hinta, tilattavissa, sisalto);
				lista.add(p);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			connection.closeConnection(con);
		}

		return lista;
	}

	public List<Sisalto> haeTuoteSisalto() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		List<Sisalto> lista = new ArrayList<Sisalto>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		
		// TÄTÄ EI ENÄÄ KÄYTETÄÄ !!=?!?!!=?!=!=!=!=
		resultSet = statement
				.executeQuery("SELECT * FROM Sisalto");

		try {
			while (resultSet.next()) { // Iteroidaan läpi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */
				
				int id  = resultSet.getInt("sisalto_id");
				String nimi = resultSet.getString("nimi");

				Sisalto p = new Sisalto(id, nimi);
				lista.add(p);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			connection.closeConnection(con);
		}
		return lista;
	}
	public int haeUusinID() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		int tuote_id = 0;
		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		
		// TÄTÄ EI ENÄÄ KÄYTETÄÄ !!=?!?!!=?!=!=!=!=
		resultSet = statement
				.executeQuery("SELECT tuote_id FROM Tuote ORDER BY tuote_id DESC LIMIT 1;");

		try {
			while (resultSet.next()) { // Iteroidaan läpi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				tuote_id = resultSet.getInt("tuote_id");


			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			connection.closeConnection(con);
		}
		System.out.println(tuote_id);
		return tuote_id + 1;
	}

}