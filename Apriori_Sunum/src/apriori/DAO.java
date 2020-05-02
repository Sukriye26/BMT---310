package apriori;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	private static DAO instance = null;

	private DAO() {

	}

	public static DAO getInstance() {
		if (instance == null)
			instance = new DAO();
		return instance;
	}
	public boolean kayitOl(String kadý, String sifre) {

		Connection con =AprioriConnection.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "Insert Into musterýler(kad,sifre) VALUES(?,?)";

			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				preparedStatement.setString(1, kadý);
				preparedStatement.setString(2, sifre);
				

				preparedStatement.executeUpdate();
				return true;

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			// con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
			return false;
	}
	
	public Musteri girisYap(String kad, String parola) {

		Connection con = AprioriConnection.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "Select*From musterýler where kad=? and sifre=?"; // veritabanýnda girilen kimlik ve
																					// parola var mý?
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
				preparedStatement.setString(1, kad);
				preparedStatement.setString(2, parola);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					// veritabanýndaki tablo üzerinde gezilir.

					String isim = rs.getString("KAD");
					String sifre = rs.getString("SIFRE"); // müþterinin bilgileri alýnýr
					int ID = rs.getInt("ID");

					Musteri musteri = new Musteri(isim,sifre,ID);

					return musteri; 

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<String> urunBul(int musteri_id,String urun) {
		ArrayList<String> urunler=new ArrayList<String>();
		Connection con = AprioriConnection.getInstance().getCon();

		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "SELECT URUN2  From APRIORI Where ID=" + musteri_id +"and URUN1='"+urun+"'";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);

				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					String urun2 = rs.getString("URUN2");
					urunler.add(urun2);
					
				}
				
				return urunler;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
   public int IDbul(String kad , String parola) {
	   Connection con = AprioriConnection.getInstance().getCon();
       int ID = 0;
		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "Select id,kad,sifre From musteriler where kad=? and sifre=?"; // veritabanýnda girilen kimlik ve
																					// parola var mý?
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
				preparedStatement.setString(1, kad);
				preparedStatement.setString(2, parola);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					// veritabanýndaki tablo üzerinde gezilir.

					String isim = rs.getString("kad");
					String sifre = rs.getString("sifre"); // müþterinin bilgileri alýnýr
					ID = rs.getInt("id");
                    Musteri musteri=new Musteri(isim,sifre,ID);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ID;   
   }
   public ArrayList<String> urunOner() {

		Connection con = AprioriConnection.getInstance().getCon();
        ArrayList <String> urunler =new ArrayList();
		try {

			PreparedStatement preparedStatement = null;

			String sorgu = "SELECT URUNLER FROM SAYI WHERE ROWNUM <=5";
			try {
				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
				
				ResultSet rs = preparedStatement.executeQuery();
				
				while(rs.next()) {
					
					String urun = rs.getString("URUNLER");
					urunler.add(urun);
				
					
					
				}
				return urunler;
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
   
   public Musteri idbul(int id){
	   Connection con = AprioriConnection.getInstance().getCon();
	          
	          Musteri musteri=null;
	   		try {

	   			PreparedStatement preparedStatement = null;

	   			String sorgu = "Select id From APRIORI where id=( "
	   						+ "Select id From musteriler where id="+ id +")"; // veritabanýnda girilen kimlik ve
	   																					// parola var mý?
	   			try {
	   				preparedStatement = (PreparedStatement) con.prepareStatement(sorgu);
	     				
	   				ResultSet rs = preparedStatement.executeQuery();

	   				while (rs.next()) {

	   					// veritabanýndaki tablo üzerinde gezilir.

	   					 // müþterinin bilgileri alýnýr
	   					int ID = rs.getInt("id");
	   					System.out.println("************"+ID);
	   					musteri=new Musteri(ID); 
	   				}
	   				
	   				
	   				return musteri;
	   			} catch (SQLException ex) {
	   				ex.printStackTrace();
	   				
	   			}
	   		} catch (Exception e) {
	   			e.printStackTrace();
	   		}
	   		return null;   
	   		}
	  
   
}
