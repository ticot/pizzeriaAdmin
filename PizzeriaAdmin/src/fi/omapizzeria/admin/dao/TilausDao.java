package fi.omapizzeria.admin.dao;

import fi.omapizzeria.admin.bean.Palaute;
import fi.omapizzeria.admin.bean.Tuote;
import include.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.*;

public class TilausDao {
	ConnectionManager connection = new ConnectionManager();
	Connection con = connection.doConnection();

	Statement statement = null;
	ResultSet resultSet = null;

	public List<Tilaus> haeKaikkiTilaukset() throws SQLException {

		List<Tilaus> tilausLista = new ArrayList<Tilaus>();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement();

		resultSet = statement
				.executeQuery("SELECT Tilaus.tilaus_id, Tilaus.kayttaja_id, Tilaus.maksutapa, Tilaus.toimitustapa ,		Tilaus.katuosoite, Tilaus.postinumero, Tilaus.postitoimipaikka, Tilaus.puhelinnumero, Tilaus.yhteensa, Tilaus.tilaus_pvm, Tilaus.status,GROUP_CONCAT(DISTINCT Tuote.nimi ORDER BY Tuote.nimi SEPARATOR ', ') AS Tuotteet FROM Tilaus INNER JOIN Tilauksen_tuote ON Tilaus.tilaus_id = Tilauksen_tuote.tilaus_id INNER JOIN Tuote ON Tilauksen_tuote.tuote_id = Tuote.tuote_id GROUP BY tilaus_id ORDER BY Tilauksen_tuote.tuote_id ASC;");

		try {
			while (resultSet.next()) { // Iteroidaan l‰pi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				int tilaus_id = resultSet.getInt("tilaus_id");
				int kayttaja_id = resultSet.getInt("kayttaja_id");
				String maksutapa = resultSet.getString("maksutapa");
				String toimitustapa = resultSet.getString("toimitustapa");
				String katuosoite = resultSet.getString("katuosoite");
				String postinumero = resultSet.getString("postinumero");
				String postitoimipaikka = resultSet.getString("postitoimipaikka");
				String puhelinnumero = resultSet.getString("puhelinnumero");
				double yhteensa = resultSet.getDouble("yhteensa");
				String tilaus_pvm = resultSet.getString("tilaus_pvm");
				int status = resultSet.getInt("status");
				String tuotteet = resultSet.getString("tuotteet");
				
				
				// boolean luettu = false;

				
				Tilaus tilaus = new Tilaus(tilaus_id, kayttaja_id, tuotteet, maksutapa, toimitustapa, tilaus_pvm, null, katuosoite, postinumero, postitoimipaikka, puhelinnumero, status, yhteensa);
				tilausLista.add(tilaus);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			connection.closeConnection(con);
		}
		return tilausLista;
	}

	public boolean lisaaTilaus(Tilaus tilaus, List<Ostoskori> ostoslista)
			throws SQLException {
		boolean lisatty = false;

		// List<Tuote> lista = new ArrayList<Tuote>();

		// Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		} // Statement olion luonti
			// varsinkin n‰‰ vissii daoo
		try {
			resultSet = statement // luodaan uus tilaus
					.executeQuery("INSERT INTO Tilaus(kayttaja_id, maksutapa, toimitustapa, katuosoite, postinumero, postitoimipaikka, puhelinnumero, status, yhteensa)"
							+ " VALUES ('"
							+ tilaus.getKayttaja_id()
							+ "', '"
							+ tilaus.getMaksutapa()
							+ "', '"
							+ tilaus.getToimitustapa()
							+ "', '"
							+ tilaus.getKatuosoite()
							+ "', '"
							+ tilaus.getPostinumero()
							+ "', '"
							+ tilaus.getPostitoimipaikka()
							+ "', '"
							+ tilaus.getPuhelinnumero() + "', 1, '" // kun
																	// tilaus
																	// tehd‰‰n
																	// ekan
																	// kerran
																	// nii
																	// merkit‰‰n
																	// 1 -
																	// kesken
																	// (2=toimitettu,
																	// 3=peruttu)
							+ tilaus.getYhteensa() + "')");

			for (int i = 0; i < ostoslista.size(); i++) {
				// System.out.println(ostoslista.get(i));

				resultSet = statement //
						.executeQuery("INSERT INTO Tilauksen_tuote (tilaus_id, tuote_id, gluteeniton, laktoositon)"
								+ "VALUES ('"
								+ haeUusinTilausID()
								+ "', '"
								+ ostoslista.get(i).getTuote_id()
								+ "', '"
								+ ostoslista.get(i).isGlu()
								+ "', '"
								+ ostoslista.get(i).isLakt() + "')");

			}

			// resultSet = statement
			// .executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
			// + osa2 + "','" + tuote_id + "')");
			// resultSet = statement
			// .executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
			// + osa3 + "','" + tuote_id + "')");
			// resultSet = statement
			// .executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
			// + osa4 + "','" + tuote_id + "')");
			// tuotteen lis‰yksen j‰lkeen menn‰‰n taikaisin list.jsp ja vied‰‰n
			// tieto ett‰ lis‰ys onnistui
			lisatty = true;
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

	public int haeUusinTilausID() throws SQLException {

		int tilaus_id = 0;

		statement = con.createStatement(); // Statement olion luonti

		// TƒTƒ EI ENƒƒ KƒYTETƒƒ !!=?!?!!=?!=!=!=!=

		resultSet = statement
				.executeQuery("SELECT tilaus_id FROM Tilaus ORDER BY tilaus_id DESC LIMIT 1;");

		try {
			while (resultSet.next()) { // Iteroidaan l‰pi

				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				tilaus_id = resultSet.getInt("tilaus_id");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			// connection.closeConnection(con);
		}

		return tilaus_id;
	}

}
