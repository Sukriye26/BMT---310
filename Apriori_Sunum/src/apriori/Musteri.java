package apriori;

public class Musteri {

public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
String isim;
 String sifre;
 int ID;
public Musteri(String isim, String sifre, int iD) {
	super();
	this.isim = isim;
	this.sifre = sifre;
	ID = iD;
}
 public Musteri(int id) {
	 
	 super();
	 this.ID=id;
	 
 }
}
