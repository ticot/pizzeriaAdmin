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
//Tuotteen oma beani. Ihan vain perus luokka jossa yksityiset muuttujat.
public class Tuote {
	private int id;
	private String nimi;
	private double hinta;
	private boolean tilattavissa;
	private String sisalto;
	

	public Tuote(){
		id = 0;
		nimi = "";
		hinta = 0;
		tilattavissa = true;
	}
	public Tuote(int id, String nimi, double hinta, boolean tilattavissa, String sisalto) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.tilattavissa = tilattavissa;
		this.setSisalto(sisalto);
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
	
	public String getSisalto() {
		return sisalto;
	}
	public void setSisalto(String sisalto) {
		this.sisalto = sisalto;
	}
	@Override
	public String toString() {
		return "Tuote [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta
				+ ", tilattavissa=" + tilattavissa + ", sisalto=" + sisalto
				+ "]";
	}
	
}


