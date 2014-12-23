package include;
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//2014
//
//connectionmanageria käytetään siihen, että tehdään yhteys tietokantaan.
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionManager {
	public Connection doConnection() {
		Connection con = null;

		// KIRJAUTUMISTIEDOT
		// Peterin Tunneli
		String username = "a1303399";
		String password = "meSEUk52v";
		String url = "jdbc:mariadb://localhost/a1303399";
		
		
	
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
			e.printStackTrace();
		}
	}

}
