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
//Hash-luokkaan voidaan tuoda käyttäjän syöttämät salasanat ja ne käännetään tiivisteeksi.
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	public String getHash(String pwd){ //otetaa vastaan salasana string
		try{
	MessageDigest md = MessageDigest.getInstance("SHA1"); //muutetaan string tiivisteeksi, siitä tulee iso integer bigint
	md.update(pwd.getBytes());		
	BigInteger bint = new BigInteger(1, md.digest());
	pwd = bint.toString();		//bigint stringiksi takaisin
		}catch(NoSuchAlgorithmException e){
		e.printStackTrace();	
		}
		return pwd;
	}
}
