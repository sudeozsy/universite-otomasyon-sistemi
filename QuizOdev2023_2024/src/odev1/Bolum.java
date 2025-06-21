// Sude Özsoy 22100011074
package odev1;

public class Bolum {
	private int bolNo;
	private String bolAd;
	public Ogrenci ogrenciler[];
	public Ders dersler[];
	
	public Bolum(int bolNo, String bolAd) {
		super();
		this.bolNo = bolNo;
		this.bolAd = bolAd;
	}
	
	public int getBolNo() {
		return bolNo;
	}

	public String getBolAd() {
		return bolAd;
	}
}
