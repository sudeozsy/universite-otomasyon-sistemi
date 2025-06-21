// Sude Özsoy 22100011074
package odev1;

public class Ogrenci {
	private int bolNo;
	private String ogrAd,ogrSoyad;
	
	public Ogrenci(int bolNo, String ogrAd, String ogrSoyad) {
		super();
		this.bolNo = bolNo;
		this.ogrAd = ogrAd;
		this.ogrSoyad = ogrSoyad;
	}

	public String getOgrAd() {
		return ogrAd;
	}

	public String getOgrSoyad() {
		return ogrSoyad;
	}
	

}
