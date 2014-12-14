package fi.omapizzeria.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import include.ConnectionManager;
import fi.omapizzeria.admin.bean.Palaute;
import fi.omapizzeria.admin.bean.Tuote;
import fi.omapizzeria.admin.bean.Sisalto;

public class TuoteDao {
	ConnectionManager connection = new ConnectionManager();
	Connection con = connection.doConnection();

	Statement statement = null;
	ResultSet resultSet = null;

	public List<Tuote> haeKaikkiTuotteet() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		List<Tuote> lista = new ArrayList<Tuote>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		// resultSet = statement.executeQuery("SELECT * FROM Tuote"); // Result
		// setin
		// luonti
		resultSet = statement
				.executeQuery("SELECT p.tuote_id, p.nimi, p.hinta, p.tilattavissa, GROUP_CONCAT(DISTINCT c.nimi ORDER BY c.nimi SEPARATOR ', ') AS Sisalto FROM Tuote p INNER JOIN Tuotteen_sisalto r ON p.tuote_id = r.tuote_id INNER JOIN Sisalto c ON r.sisalto_id = c.sisalto_id WHERE p.tuote_id = r.tuote_id AND r.sisalto_id = c.sisalto_id GROUP BY p.tuote_id ORDER BY p.tilattavissa DESC");

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
				.executeQuery("SELECT p.tuote_id, p.nimi, p.hinta, p.tilattavissa, GROUP_CONCAT(DISTINCT c.nimi ORDER BY c.nimi SEPARATOR ', ') AS Sisalto FROM Tuote p INNER JOIN Tuotteen_sisalto r ON p.tuote_id = r.tuote_id INNER JOIN Sisalto c ON r.sisalto_id = c.sisalto_id WHERE p.tuote_id = r.tuote_id AND r.sisalto_id = c.sisalto_id AND p.tilattavissa = 1 GROUP BY p.tuote_id ORDER BY p.nimi");
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

		resultSet = statement.executeQuery("SELECT * FROM Sisalto");

		try {
			while (resultSet.next()) { // Iteroidaan läpi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				int id = resultSet.getInt("sisalto_id");
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

	public List<Sisalto> haeTuoteSisaltoPakolliset() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		List<Sisalto> lista = new ArrayList<Sisalto>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		resultSet = statement.executeQuery("SELECT * FROM Sisalto");

		try {
			while (resultSet.next()) { // Iteroidaan läpi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */
				if (resultSet.getInt("sisalto_id") != 1) {
					int id = resultSet.getInt("sisalto_id");
					String nimi = resultSet.getString("nimi");

					Sisalto p = new Sisalto(id, nimi);
					lista.add(p);
				}

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

	public List<Palaute> haeKaikkiPalautteet() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		List<Palaute> palautelista = new ArrayList<Palaute>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement();

		resultSet = statement
				.executeQuery("SELECT * FROM Palaute ORDER BY palaute_id DESC");

		try {
			while (resultSet.next()) { // Iteroidaan läpi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				int id = resultSet.getInt("palaute_id");
				String nimi = resultSet.getString("nimi");
				String email = resultSet.getString("email");
				String otsikko = resultSet.getString("otsikko");
				String sisalto = resultSet.getString("palaute");
				boolean luettu = resultSet.getBoolean("luettu");
				// boolean luettu = false;

				Palaute palaute = new Palaute(id, nimi, email, otsikko,
						sisalto, luettu);
				palautelista.add(palaute);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			connection.closeConnection(con);
		}
		return palautelista;
	}

	public List<Palaute> haeKaikkiPalautteetRajattu() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		List<Palaute> palautelista = new ArrayList<Palaute>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement();

		resultSet = statement
				.executeQuery("SELECT * FROM Palaute ORDER BY palaute_id DESC LIMIT 5");

		try {
			while (resultSet.next()) { // Iteroidaan läpi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				int id = resultSet.getInt("palaute_id");
				String nimi = resultSet.getString("nimi");
				String email = resultSet.getString("email");
				String otsikko = resultSet.getString("otsikko");
				String sisalto = resultSet.getString("palaute");
				boolean luettu = resultSet.getBoolean("luettu");
				// boolean luettu = false;

				// Tuote p = new Tuote(id, nimi, hinta, tilattavissa, sisalto);
				Palaute palaute = new Palaute(id, nimi, email, otsikko,
						sisalto, luettu);
				palautelista.add(palaute);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			connection.closeConnection(con);
		}
		return palautelista;
	}

	public boolean piilotaTuote(String id) {
		boolean piilotettu = false;
		ConnectionManager connection = new ConnectionManager();
		Connection con = connection.doConnection();

		Statement statement = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Statement olion luonti
		try {
			resultSet = statement
					.executeQuery("UPDATE Tuote SET tilattavissa=0 WHERE tuote_id='"
							+ id + "'");
			piilotettu = true;

		} catch (SQLException e) {
			System.out.println("Ei");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Poistettu pizza id:" + id);
			connection.closeConnection(con);
			// response.sendRedirect("list?muokattu=true");

		}
		return piilotettu;
	}

	public boolean palautaTuote(String id) {
		boolean palautettu = false;
		ConnectionManager connection = new ConnectionManager();
		Connection con = connection.doConnection();

		Statement statement = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Statement olion luonti
		try {
			resultSet = statement
					.executeQuery("UPDATE Tuote SET tilattavissa=1 WHERE tuote_id='"
							+ id + "'");
			palautettu = true;

		} catch (SQLException e) {
			System.out.println("Ei");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.closeConnection(con);
			// response.sendRedirect("list?muokattu=true");

		}
		return palautettu;
	}

	public boolean poistaSisalto(String id) {
		boolean poistettu = false;
		ConnectionManager connection = new ConnectionManager();
		Connection con = connection.doConnection();

		Statement statement = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Statement olion luonti

		try {
			resultSet = statement
					.executeQuery("DELETE FROM Sisalto WHERE sisalto_id='" + id
							+ "'");
			poistettu = true;
		} catch (SQLException e) {
			System.out.println("Ei");

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// System.out.println("Poistettu pizza id:"+id);
			connection.closeConnection(con);
		}
		return poistettu;
	}

	public boolean poistaTuote(String id) {
		boolean poistettu = false;
		ConnectionManager connection = new ConnectionManager();
		Connection con = connection.doConnection();

		Statement statement = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Statement olion luonti
			// Tää allaoleva tuotedaoo
		try {
			resultSet = statement
					.executeQuery("DELETE FROM Tuotteen_sisalto WHERE tuote_id='"
							+ id + "'");
		} catch (SQLException e) {
			System.out.println("Ei");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resultSet = statement
					.executeQuery("DELETE FROM Tuote WHERE tuote_id='" + id
							+ "'");
		} catch (SQLException e) {
			System.out.println("Ei");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			poistettu = true;
			// viedään käyttäjä takaisin list.jsp ja otetaan mukaan tieto
			// onnistuneesta poistosta
			connection.closeConnection(con);
		}
		return poistettu;
	}

	public boolean muokkaaSisalto(String osa1w, String osa1, String pnimi,
			double phinta, String tilattavissa, String tuote_id, String osa2,
			String osa2w, String osa3, String osa3w, String osa4, String osa4w) {
		boolean muokattu = false;
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
			// tää sinne tuotedaoo vissiii
		System.out.println("osa1w: " + osa1w + "\nosa1:" + osa1);
		try {

			resultSet = statement.executeQuery("UPDATE Tuote SET nimi='"
					+ pnimi + "', hinta='" + phinta + "', tilattavissa="
					+ tilattavissa + " WHERE tuote_id ='" + tuote_id + "'");

			resultSet = statement
					.executeQuery("UPDATE Tuotteen_sisalto SET sisalto_id='"
							+ osa1 + "' WHERE tuote_id='" + tuote_id
							+ "' AND sisalto_id='" + osa1w + "'");

			resultSet = statement
					.executeQuery("UPDATE Tuotteen_sisalto SET sisalto_id='"
							+ osa2 + "' WHERE tuote_id='" + tuote_id
							+ "' AND sisalto_id='" + osa2w + "'");

			resultSet = statement
					.executeQuery("UPDATE Tuotteen_sisalto SET sisalto_id='"
							+ osa3 + "' WHERE tuote_id='" + tuote_id
							+ "' AND sisalto_id='" + osa3w + "'");

			resultSet = statement
					.executeQuery("UPDATE Tuotteen_sisalto SET sisalto_id='"
							+ osa4 + "' WHERE tuote_id='" + tuote_id
							+ "' AND sisalto_id='" + osa4w + "'");

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		finally {
			muokattu=true;
			connection.closeConnection(con);
			// request.getRequestDispatcher("list?added=true").forward(request,
			// response);

		}
		return muokattu;
	}
	
	public boolean lisaaTuote(int tuote_id, String pnimi, double phinta, String tilattavissa, String osa1, String osa2, String osa3, String osa4 ){
		boolean lisatty=false;
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
		//varsinkin nää vissii daoo
		try {
			resultSet = statement
					.executeQuery("INSERT INTO Tuote(nimi, hinta, tilattavissa) VALUE ('"
							+ pnimi
							+ "', '"
							+ phinta
							+ "', '"
							+ tilattavissa
							+ "')");

			resultSet = statement
					.executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
							+ osa1 + "','" + tuote_id + "')");
			resultSet = statement
					.executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
							+ osa2 + "','" + tuote_id + "')");
			resultSet = statement
					.executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
							+ osa3 + "','" + tuote_id + "')");
			resultSet = statement
					.executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
							+ osa4 + "','" + tuote_id + "')");
					//tuotteen lisäyksen jälkeen mennään taikaisin list.jsp ja viedään tieto että lisäys onnistui
			lisatty=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

		finally {
			connection.closeConnection(con);
		
			// request.getRequestDispatcher("list?added=true").forward(request,
			// response);

		}
		return lisatty;
	}
}