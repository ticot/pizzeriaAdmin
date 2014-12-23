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
//Ostoskorin beani. Olion konstruktori ja muuttujat.

public class Ostoskori {
	private int tuote_id;
	private int kayttaja_id;
	private String tuote_nimi;
	private boolean glu;
	private boolean lakt;
	private double hinta;

	public Ostoskori() {

	}

	public Ostoskori(int tuote_id, int kayttaja_id, boolean glu, boolean lakt,
			double hinta) {
		super();
		this.tuote_id = tuote_id;
		this.kayttaja_id = kayttaja_id;
		this.glu = glu;
		this.lakt = lakt;
		this.hinta = hinta;
	}

	public int getTuote_id() {
		return tuote_id;
	}

	public void setTuote_id(int tuote_id) {
		this.tuote_id = tuote_id;
	}

	public int getKayttaja_id() {
		return kayttaja_id;
	}

	public void setKayttaja_id(int kayttaja_id) {
		this.kayttaja_id = kayttaja_id;
	}

	public boolean isGlu() {
		return glu;
	}

	public void setGlu(boolean glu) {
		this.glu = glu;
	}

	public boolean isLakt() {
		return lakt;
	}

	public void setLakt(boolean lakt) {
		this.lakt = lakt;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public String getTuote_nimi() {
		return tuote_nimi;
	}

	public void setTuote_nimi(String tuote_nimi) {
		this.tuote_nimi = tuote_nimi;
	}

	@Override
	public String toString() {
		return "Ostoskori tuote_id=" + tuote_id + ", kayttaja_id="
				+ kayttaja_id + ", tuote_nimi=" + tuote_nimi + ", glu=" + glu
				+ ", lakt=" + lakt + ", hinta=" + hinta;
	}

}
