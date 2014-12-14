package fi.omapizzeria.admin.bean;

public class Tilaus {
	
	private int tilaus_id;
	private int kayttaja_id;
	private int tuote_id;
	private Ostoskori ostoskori;
	private String maksutapa;
	private String toimitustapa;
	private String tilaus_pvm;
	private String toimitus_pvm;
	private String katuosoite, postinumero, postitoimipaikka, puhelinnumero;
	private int status;
	private double yhteensa;
	
	public Tilaus() {
		super();
	}

	

	public Tilaus(int tilaus_id, int kayttaja_id, int tuote_id,
			String maksutapa, String toimitustapa, String tilaus_pvm,
			String toimitus_pvm, String katuosoite, String postinumero,
			String postitoimipaikka, String puhelinnumero, int status,
			double yhteensa) {
		super();
		this.tilaus_id = tilaus_id;
		this.kayttaja_id = kayttaja_id;
		this.tuote_id = tuote_id;
		this.maksutapa = maksutapa;
		this.toimitustapa = toimitustapa;
		this.tilaus_pvm = tilaus_pvm;
		this.toimitus_pvm = toimitus_pvm;
		this.katuosoite = katuosoite;
		this.postinumero = postinumero;
		this.postitoimipaikka = postitoimipaikka;
		this.puhelinnumero = puhelinnumero;
		this.status = status;
		this.yhteensa = yhteensa;
	}

	

	public String getKatuosoite() {
		return katuosoite;
	}



	public void setKatuosoite(String katuosoite) {
		this.katuosoite = katuosoite;
	}



	public String getPostinumero() {
		return postinumero;
	}



	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}



	public String getPostitoimipaikka() {
		return postitoimipaikka;
	}



	public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
	}



	public String getPuhelinnumero() {
		return puhelinnumero;
	}



	public void setPuhelinnumero(String puhelinnumero) {
		this.puhelinnumero = puhelinnumero;
	}



	public int getTuote_id() {
		return tuote_id;
	}

	public void setTuote_id(int tuote_id) {
		this.tuote_id = tuote_id;
	}

	public int getTilaus_id() {
		return tilaus_id;
	}
	public void setTilaus_id(int tilaus_id) {
		this.tilaus_id = tilaus_id;
	}
	public int getKayttaja_id() {
		return kayttaja_id;
	}
	public void setKayttaja_id(int kayttaja_id) {
		this.kayttaja_id = kayttaja_id;
	}
	public String getMaksutapa() {
		return maksutapa;
	}
	public void setMaksutapa(String maksutapa) {
		this.maksutapa = maksutapa;
	}
	public String getToimitustapa() {
		return toimitustapa;
	}
	public void setToimitustapa(String toimitustapa) {
		this.toimitustapa = toimitustapa;
	}
	public String getTilaus_pvm() {
		return tilaus_pvm;
	}
	public void setTilaus_pvm(String tilaus_pvm) {
		this.tilaus_pvm = tilaus_pvm;
	}
	public String getToimitus_pvm() {
		return toimitus_pvm;
	}
	public void setToimitus_pvm(String toimitus_pvm) {
		this.toimitus_pvm = toimitus_pvm;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getYhteensa() {
		return yhteensa;
	}
	public void setYhteensa(double yhteensa) {
		this.yhteensa = yhteensa;
	}

	@Override
	public String toString() {
		return "Tilaus [tilaus_id=" + tilaus_id + ", kayttaja_id="
				+ kayttaja_id + ", tuote_id=" + tuote_id + ", maksutapa="
				+ maksutapa + ", toimitustapa=" + toimitustapa
				+ ", tilaus_pvm=" + tilaus_pvm + ", toimitus_pvm="
				+ toimitus_pvm + ", status=" + status + ", yhteensa="
				+ yhteensa + "]";
	}
	
//	CREATE TABLE Tilaus
//	(tilaus_id INTEGER (10)NOT NULL 
//
//	AUTO_INCREMENT
//	,kayttaja_id INTEGER (10) NOT NULL
//	,maksutapa VARCHAR (100) NOT NULL
//	,toimitustapa VARCHAR (100) NOT NULL
//	,tilaus_paivamaara TIMESTAMP NOT NULL DEFAULT 
//
//	CURRENT_TIMESTAMP
//	,toimitus_paivamaara TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
//	,status INTEGER (10) NOT NULL
//	,yhteensa DECIMAL(5,2) NOT NULL
//	,PRIMARY KEY (tilaus_id)
//	,FOREIGN KEY (kayttaja_id) REFERENCES 
//
//	Kayttaja (kayttaja_id)
//	)ENGINE=InnoDB;
	

}
