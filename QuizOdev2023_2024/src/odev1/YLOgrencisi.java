// Sude Özsoy 22100011074
package odev1;

public class YLOgrencisi extends Ogrenci{
	private int ogrID;
	private String durum;
	static int syc = 50;
	
	public YLOgrencisi(int bolNo, String ogrAd, String ogrSoyad) {
		super(bolNo, ogrAd, ogrSoyad);
		this.durum = "Yuksek Lisans";
		this.ogrID = syc++;
	}
	
	public String getDurum() {
		return durum;
	}

	public int getOgrID() {
		return ogrID;
	}

}
