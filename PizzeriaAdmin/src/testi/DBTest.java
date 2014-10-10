package testi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		Connection con = null;

		// KIRJAUTUMISTIEDOT
		String username = "a1303399";
		String password = "meSEUk52v";
		String url = "jdbc:mariadb://localhost/a1303399";

		
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance(); // Ladataan
																	// ajurit

			con = DriverManager.getConnection(url, username, password); // Yhteyden
																		// muodostus
			
			statement = con.createStatement(); // Statement olion luonti
			
			resultSet = statement.executeQuery("SELECT * FROM Pizzat"); // Result
																		// setin
																		// luonti

			while (resultSet.next()) { // Iteroidaan läpi

				int id = resultSet.getInt("id");
				String nimi = resultSet.getString("nimi");
				double hinta = resultSet.getDouble("hinta");
				System.out.println("ID : " + id + "\nNimi: " + nimi
						+ "\nHinta: " + hinta);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
