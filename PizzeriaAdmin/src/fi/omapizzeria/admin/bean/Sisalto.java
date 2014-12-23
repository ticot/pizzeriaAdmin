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
//Sisallon oma beani. Olio konstruktoreilla ja muuttujilla.
public class Sisalto {
	private int tuote_id;
	private String nimi;

	public Sisalto(int tuote_id, String nimi) {
		super();
		this.tuote_id = tuote_id;
		this.nimi = nimi;
	}

	public int getTuote_id() {
		return tuote_id;
	}

	public void setTuote_id(int tuote_id) {
		this.tuote_id = tuote_id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "Sisalto [tuote_id=" + tuote_id + ", nimi=" + nimi + "]";
	}
}
