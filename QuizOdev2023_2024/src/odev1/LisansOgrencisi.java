// Sude Özsoy 22100011074
package odev1;

public class LisansOgrencisi extends Ogrenci{
	private int ogrID,ogrSinif;
	private String durum;
	static int syc = 20;
	
	public LisansOgrencisi(int bolNo, String ogrAd, String ogrSoyad, int ogrSinif) {
		super(bolNo, ogrAd, ogrSoyad);
		this.ogrSinif = ogrSinif;
		this.durum = "Lisans";
		this.ogrID = syc++;
	}

	public int getOgrID() {
		return ogrID;
	}

	public int getOgrSinif() {
		return ogrSinif;
	}

	public String getDurum() {
		return durum;
	}
}
