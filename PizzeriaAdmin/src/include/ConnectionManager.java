package include;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionManager {
	public Connection doConnection() {
		Connection con = null;

		// KIRJAUTUMISTIEDOT
		/* Peterin Tunneli
		String username = "a1303399";
		String password = "meSEUk52v";
		String url = "jdbc:mariadb://localhost/a1303399";
		*/
		
		//Tanjan Tunneli
		String username = "a1303392";
		String password = "faMUNr33r";
		String url = "jdbc:mariadb://localhost/a1303392";
		

		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance(); // Ladataan
																	// ajurit

			con = DriverManager.getConnection(url, username, password); // Yhteyden
																		// muodostus

		} catch (Exception e) {
			System.out.println("Tietokanta yhteys epäonnistui");
			e.printStackTrace();
		}
		return con;
	}

	public void closeConnection(Connection con) {
		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
