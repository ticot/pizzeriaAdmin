package fi.omapizzeria.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import include.ConnectionManager;
import fi.omapizzeria.admin.bean.Pizza;

public class PizzaDao {

	public List<Pizza> haeKaikkiTuotteet() throws SQLException {
		ConnectionManager connection = new ConnectionManager();

		List<Pizza> lista = new ArrayList<Pizza>();

		Connection con = connection.doConnection();

		Statement statement = null;
		ResultSet resultSet = null;

		statement = con.createStatement(); // Statement olion luonti

		resultSet = statement.executeQuery("SELECT * FROM Pizzat"); // Result
																	// setin
																	// luonti
		try {
			while (resultSet.next()) { // Iteroidaan l�pi
				/*
				 * int id = resultSet.getInt("id"); String nimi =
				 * resultSet.getString("nimi"); double hinta =
				 * resultSet.getDouble("hinta"); System.out.println("ID : " + id
				 * + "\nNimi: " + nimi + "\nHinta: " + hinta);
				 */

				int id = resultSet.getInt("id");
				String nimi = resultSet.getString("nimi");
				double hinta = resultSet.getDouble("hinta");

				Pizza p = new Pizza(id, nimi, hinta);
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