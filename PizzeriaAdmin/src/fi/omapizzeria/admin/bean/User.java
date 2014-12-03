package fi.omapizzeria.admin.bean;
public class User {
private int id;
private String Etunimi;
private String Sukunimi;

private String katuosoite;
private String postinumero;
private String postitoimipaikka;
private String puhelinnumero;

private String email;
private String password;
private boolean valid;
public User(){
	id = 0;
	Etunimi ="";
	Sukunimi="";
	katuosoite="";
	postinumero="";
	postitoimipaikka="";
	puhelinnumero="";
	email="";
	password="";
	valid=false;
	
}
public User(int id, String etunimi, String sukunimi, String email,
		String password) {
	super();
	this.id = id;
	Etunimi = etunimi;
	Sukunimi = sukunimi;
	
	this.password = password;
	this.email = email;
	valid=true;
}
public int getId() {
	return id;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public void setId(int id) {
	this.id = id;
}
public String getEtunimi() {
	return Etunimi;
}
public void setEtunimi(String etunimi) {
	Etunimi = etunimi;
}
public String getSukunimi() {
	return Sukunimi;
}
public void setSukunimi(String sukunimi) {
	Sukunimi = sukunimi;
}


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isValid(){
	return valid;
}
public void setValid(boolean newValid){
	valid = newValid;
}
}
