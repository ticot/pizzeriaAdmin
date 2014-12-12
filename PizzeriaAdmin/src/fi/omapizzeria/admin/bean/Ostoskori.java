package fi.omapizzeria.admin.bean;

import java.util.Date;

public class Ostoskori {
	private int tuote_id;
	private int kayttaja_id;
	private int lkm;
	private boolean glu;
	private boolean lakt;

	private Date toimitusaika;
	private String fantasia;
	private String extra;
	private double hinta;

	public Ostoskori(){
		
	}
	public Ostoskori(int tuote_id, int kayttaja_id, int lkm, boolean glu,
			boolean lakt, Date toimitusaika,
			String fantasia, String extra, double hinta) {
		super();
		this.tuote_id = tuote_id;
		this.kayttaja_id = kayttaja_id;
		this.lkm = lkm;
		this.glu = glu;
		this.lakt = lakt;
		this.toimitusaika = toimitusaika;
		this.fantasia = fantasia;
		this.extra = extra;
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

	public int getLkm() {
		return lkm;
	}

	public void setLkm(int lkm) {
		this.lkm = lkm;
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

	public Date getToimitusaika() {
		return toimitusaika;
	}

	public void setToimitusaika(Date toimitusaika) {
		this.toimitusaika = toimitusaika;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	@Override
	public String toString() {
		return "Ostoskori [tuote_id=" + tuote_id + ", kayttaja_id="
				+ kayttaja_id + ", lkm=" + lkm + ", glu=" + glu + ", lakt="
				+ lakt + ", toimitusaika="
				+ toimitusaika + ", fantasia=" + fantasia + ", extra=" + extra
				+ ", hinta=" + hinta + "]";
	}

}
