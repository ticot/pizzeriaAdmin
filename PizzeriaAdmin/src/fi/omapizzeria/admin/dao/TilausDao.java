package fi.omapizzeria.admin.dao;

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

		List<Tilaus> lista = new ArrayList<Tilaus>();

		return lista;
	}

	public boolean lisaaTilaus(Tilaus tilaus) throws SQLException {
		boolean lisatty = false;

		// List<Tuote> lista = new ArrayList<Tuote>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = con.createStatement();
		} catch (SQLException e) {

			e.printStackTrace();
		} // Statement olion luonti
			// varsinkin nää vissii daoo
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
																	// tehdään
																	// ekan
																	// kerran
																	// nii
																	// merkitään
																	// 1 -
																	// kesken
																	// (2=toimitettu,
																	// 3=peruttu)
							+ tilaus.getYhteensa() + "')");

			resultSet = statement //
					.executeQuery("INSERT INTO Tilauksen_tuote (tilaus_id, tuote_id, gluteeniton, laktoositon)"
							+ "VALUES ('"
							+ haeUusinTilausID()
							+ "', '"
							
							+ "', '"
							+ "')");
			// resultSet = statement
			// .executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
			// + osa2 + "','" + tuote_id + "')");
			// resultSet = statement
			// .executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
			// + osa3 + "','" + tuote_id + "')");
			// resultSet = statement
			// .executeQuery("INSERT INTO Tuotteen_sisalto (sisalto_id, tuote_id) VALUE ('"
			// + osa4 + "','" + tuote_id + "')");
			// tuotteen lisäyksen jälkeen mennään taikaisin list.jsp ja viedään
			// tieto että lisäys onnistui
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

		// TÄTÄ EI ENÄÄ KÄYTETÄÄ !!=?!?!!=?!=!=!=!=

		resultSet = statement
				.executeQuery("SELECT tilaus_id FROM Tilaus ORDER BY tilaus_id DESC LIMIT 1;");

		try {
			while (resultSet.next()) { // Iteroidaan läpi

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
			connection.closeConnection(con);
		}

		return tilaus_id;
	}

}
