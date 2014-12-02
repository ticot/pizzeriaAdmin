package fi.omapizzeria.admin.bean;

public class UserBean {
	private String salasana;
	private String etunimi;
	private String sukunimi;
	private String katuosoite;
	private String postinumero;
	private String postitoimipaikka;
	private String puhelinnumero;
	private String email;
	private int level;
	public boolean valid;
	
	

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}

	
}