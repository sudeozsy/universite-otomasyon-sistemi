// Sude Özsoy 22100011074
package odev1;

public class Ders {
	private int bolNo,dersID,dersKredi;
	private String dersAd;
	static int syc = 10;
	
	public Ders(int bolNo, int dersKredi, String dersAd) {
		super();
		this.bolNo = bolNo;
		this.dersKredi = dersKredi;
		this.dersAd = dersAd;
		this.dersID = syc++;
	}
	
	public int getDersID() {
		return dersID;
	}

	public int getDersKredi() {
		return dersKredi;
	}

	public String getDersAd() {
		return dersAd;
	}
}
