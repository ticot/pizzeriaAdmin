package fi.omapizzeria.admin.bean;


public class Tuote {
	private int id;
	private String nimi;
	private double hinta;
	private boolean tilattavissa;
	

	public Tuote(){
		id = 0;
		nimi = "";
		hinta = 0;
		tilattavissa = false;
	}
	public Tuote(int id, String nimi, double hinta) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.tilattavissa = tilattavissa;
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
	public double getHinta() {
		return hinta;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public boolean isTilattavissa() {
		return tilattavissa;
	}
	public void setTilattavissa(boolean tilattavissa) {
		this.tilattavissa = tilattavissa;
	}
	
	@Override
	public String toString() {
		return "Tuote [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta
				+ ", tilattavissa=" + tilattavissa + "]";
	}
}


