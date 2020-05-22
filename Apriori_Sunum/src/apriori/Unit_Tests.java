package apriori;

import apriori.DAO;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Unit_Tests {
	DAO islemler = new DAO();
	AprioriConnection con= new AprioriConnection();
	ArrayList<String> musteri = new ArrayList<String>();
	ArrayList<String> yeni = new ArrayList<String>();
	
	
	@Test
	public void connectionTest() {
		con.getCon();
	}
	
	@Test
	public void girisTest() {
		Musteri musteri =islemler.getInstance().girisYap("þükriye", "1965");
	}
	@Test
	public void kayitOlTest() {
		assertEquals(true,DAO.getInstance().kayitOl("1", "1"));
	}
	@Test
	public void yeniKayit_IDTest() {
		
		assertEquals(9,DAO.getInstance().IDbul("1", "1"));
	}
	@Test
	public void urun_bulTest() {
		musteri.add("LOVE BUILDING BLOCK WORD");
		assertEquals(musteri,DAO.getInstance().urunBul(1, "HOME BUILDING BLOCK WORD"));
	}
	
	@Test
	public void urun_onerTest() {
		yeni.add("TOY TIDY SPACEBOY  ");
		yeni.add("SUKI  SHOULDER BAG");
		yeni.add("ANTIQUE GLASS DRESSING TABLE POT");
		yeni.add("SET/20 STRAWBERRY PAPER NAPKINS ");
		yeni.add("SET 3 PAPER VINTAGE CHICK PAPER EGG");
		assertEquals(yeni, DAO.getInstance().urunOner());
		
	}
}
