package fi.omapizzeria.admin.bean;
//████████╗██╗ ██████╗ ██████╗ ██╗     ██╗ ██████╗██╗ ██████╗ ██╗   ██╗███████╗
//╚══██╔══╝██║██╔════╝██╔═══██╗██║     ██║██╔════╝██║██╔═══██╗██║   ██║██╔════╝
//	 ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║███████╗
//   ██║   ██║██║     ██║   ██║██║     ██║██║     ██║██║   ██║██║   ██║╚════██║
//   ██║   ██║╚██████╗╚██████╔╝███████╗██║╚██████╗██║╚██████╔╝╚██████╔╝███████║
//   ╚═╝   ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝╚═╝ ╚═════╝  ╚═════╝ ╚══════╝
//Antti Eloranta, Heini Haatanen, Tanja Partanen, Péter Takács, Samu Tapanen
//2014
//
//palautteen beani. Olion konstruktori ja yksityiset muuttujat.
public class Palaute {
	
	private int id;
	private String nimi;
	private String email;
	private String otsikko;
	private String sisalto;
	private boolean luettu;
	public Palaute() {
		super();
	}
	public Palaute(int id, String nimi, String email, String otsikko,
			String sisalto, boolean luettu) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.email = email;
		this.otsikko = otsikko;
		this.sisalto = sisalto;
		this.luettu = luettu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtsikko() {
		return otsikko;
	}
	public void setOtsikko(String otsikko) {
		this.otsikko = otsikko;
	}
	public String getSisalto() {
		return sisalto;
	}
	public void setSisalto(String sisalto) {
		this.sisalto = sisalto;
	}
	public boolean isLuettu() {
		return luettu;
	}
	public void setLuettu(boolean luettu) {
		this.luettu = luettu;
	}
	@Override
	public String toString() {
		return "Palaute [id=" + id + ", nimi=" + nimi + ", email=" + email
				+ ", otsikko=" + otsikko + ", sisalto=" + sisalto + ", luettu="
				+ luettu + "]";
	}

	
}
