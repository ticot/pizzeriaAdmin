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

public class TuoteDao {

	public List<Tuote> haeKaikkiTuotteet() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		List<Tuote> lista = new ArrayList<Tuote>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		resultSet = statement.executeQuery("SELECT * FROM Tuote"); // Result
																	// setin
																	// luonti
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

				Tuote p = new Tuote(id, nimi, hinta);
				lista.add(p);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			connection.closeConnection(con);
		}
		System.out.println(lista);
		return lista;
	}

}