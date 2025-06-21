/*// Sude Özsoy 22100011074
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
//Sude Özsoy 22100011074
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
//Sude Özsoy 22100011074
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
//Sude Özsoy 22100011074
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
//Sude Özsoy 22100011074
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
//Sude Özsoy 22100011074
package odev1;

import java.util.Scanner;

public class AnaSayfa {

	public static void main(String[] args) {
		int topbol,topls=0,topyl = 0,topders,bolNo,ogrSinif,dersKredi;
		String bolAd,ogrAd,ogrSoyad,dersAd;
		Scanner r = new Scanner(System.in);
		
		System.out.print("Kac tane bolum var: ");
		topbol = r.nextInt();
		
		Bolum[] bolum = new Bolum[topbol];
		for(int i=0;i<topbol;i++)
		{
			System.out.print("\n"+(i+1)+". bolum numarasi: ");
			bolNo = r.nextInt();
			System.out.print((i+1)+". bolum adi: ");
			r.nextLine();      //line i tek basina kullaninca almiyor bu yüzden buraya da ekledim cozum olarak.
			bolAd = r.nextLine();
			
			bolum[i] = new Bolum(bolNo,bolAd);
			System.out.print("\n"+(i+1)+". bolumde kac adet lisans ogrencisi var: ");
			topls = r.nextInt();
			System.out.print((i+1)+". bolumde kac adet yuksek lisans ogrencisi var: ");
			topyl = r.nextInt();
			System.out.print((i+1)+". bolumde kac adet ders var: ");
			topders = r.nextInt();
			
			bolum[i].ogrenciler = new Ogrenci[topls+topyl];
			for(int j=0;j<topls;j++)
			{
				System.out.print("\n"+(j+1)+". lisans ogrencisi ad: ");
				r.nextLine();
				ogrAd = r.nextLine();
				System.out.print((j+1)+". lisans ogrencisi soyad: ");
				ogrSoyad = r.next();
				System.out.print((j+1)+". lisans ogrencisi sinif: ");
				ogrSinif = r.nextInt();
				
				bolum[i].ogrenciler[j] = new LisansOgrencisi(bolNo,ogrAd,ogrSoyad,ogrSinif);
			}
		
			for(int j=topls;j<topyl+topls;j++)
			{
				System.out.print("\n"+(j-topls+1)+". yuksek lisans ogrencisi ad: ");
				r.nextLine();
				ogrAd = r.nextLine();
				System.out.print((j-topls+1)+". yuksek lisans ogrencisi soyad: ");
				ogrSoyad = r.next();
				
				bolum[i].ogrenciler[j] = new YLOgrencisi(bolNo,ogrAd,ogrSoyad);
			}
			
			bolum[i].dersler = new Ders[topders];
			for(int j=0;j<topders;j++)
			{
				System.out.print("\n"+(j+1)+". ders ad: ");
				r.nextLine();
				dersAd = r.nextLine();
				System.out.print((j+1)+". ders kredi: ");
				dersKredi = r.nextInt();
				
				bolum[i].dersler[j] = new Ders(bolNo,dersKredi,dersAd);
			}
		}
		menu(bolum);
	}
	public static void menu(Bolum[] bolum)
	{
		int secim;
		Scanner r = new Scanner(System.in);
		System.out.print("\n1- Tüm Bolumlerin Bilgilerini Listele\r\n"
				+ "2- Lisans Ogrencilerini Listele\r\n"
				+ "3- Yuksek Lisans Ogrencilerini Listele\r\n"
				+ "4- Dersleri Listele\r\n"
				+ "5- Arama Yap\r\n"
				+ "6- Cıkıs\r\n"
				+ "\t Secin:");
		secim = r.nextInt();
		
		switch(secim)
		{
		case 1:
			bolumListele(bolum);
			menu(bolum);
			break;
		case 2:
			lisansListele(bolum);
			menu(bolum);
			break;
		case 3:
			YLListele(bolum);
			menu(bolum);
			break;
		case 4:
			dersListele(bolum);
			menu(bolum);
			break;
		case 5:
			aramaYap(bolum);
			menu(bolum);
			break;
		case 6:
			System.exit(0);
		default:
			System.out.println("Yanlis secim,tekrar dogru secim yapin.");
			menu(bolum);
		}
	}
	public static void bolumListele(Bolum[] bolum)
	{
		for(int i=0;i<bolum.length;i++)
		{
			System.out.println("Bolum No: "+bolum[i].getBolNo()+"  Bolum Ad:"+bolum[i].getBolAd());
			System.out.println("Lisans Ogrencileri:");
			for(int j=0;j<bolum[i].ogrenciler.length;j++)
			{
				if(bolum[i].ogrenciler[j] instanceof LisansOgrencisi)
				{
					LisansOgrencisi lisans = (LisansOgrencisi) bolum[i].ogrenciler[j];
					System.out.println("\t"+(j+1)+". ogrenci: "+lisans.getOgrID()+" "+lisans.getOgrAd()+" "+lisans.getOgrSoyad()+" "+lisans.getOgrSinif());
				}
			}
			System.out.println("Yuksek Lisans Ogrencileri:");
			int a=0;
			for(int j=0;j<bolum[i].ogrenciler.length;j++)
			{
				if(bolum[i].ogrenciler[j] instanceof YLOgrencisi)
				{
					YLOgrencisi Ylisans = (YLOgrencisi) bolum[i].ogrenciler[j];
					System.out.println("\t"+(++a)+". ogrenci: "+Ylisans.getOgrID()+" "+Ylisans.getOgrAd()+" "+Ylisans.getOgrSoyad());
				}
			}
			System.out.println("Dersler:");
			for(int j=0;j<bolum[i].dersler.length;j++)
			{
				System.out.println("\t"+(j+1)+". Ders: "+bolum[i].dersler[j].getDersID()+" "+bolum[i].dersler[j].getDersAd()+" "+bolum[i].dersler[j].getDersKredi());
			}
		}
	}
	public static void lisansListele(Bolum[] bolum)
	{
		int kontrol;    //baktigi sinif sayisinda sinif varsa eğer bir kere basligini yazdirmak icin yoksa hic yazmaz.
		System.out.println("Tum Lisans Bolumlerindeki Ogrenciler:");
		for(int k=1;k<=6;k++)   //6. sinifa kadar tüm sinif seviyelerine göre siniflari dolasir.
		{
			kontrol = 0;
			for(int i=0;i<bolum.length;i++)
			{
				for(int j=0;j<bolum[i].ogrenciler.length;j++)
				{
					if(bolum[i].ogrenciler[j] instanceof LisansOgrencisi)
					{
						LisansOgrencisi lisans = (LisansOgrencisi) bolum[i].ogrenciler[j];
						if(k == lisans.getOgrSinif())
						{
							if(kontrol == 0)
								System.out.println("\t"+k+". Sinif Ogrenciler:");
							System.out.println("\t\t"+lisans.getOgrID()+" "+lisans.getOgrAd()+" "+lisans.getOgrSoyad());
							kontrol=1;
						}
					}
				}
			}
		}
		
	}
	public static void YLListele(Bolum[] bolum)
	{
		System.out.println("Tum Bolumlerdeki Yuksek Lisans Ogrencileri");
		for(int i=0;i<bolum.length;i++)
		{
			for(int j=0;j<bolum[i].ogrenciler.length;j++)
			{
				if(bolum[i].ogrenciler[j] instanceof YLOgrencisi)
				{
					YLOgrencisi ylisans = (YLOgrencisi) bolum[i].ogrenciler[j];
					System.out.println("\t"+ylisans.getOgrID()+" "+ylisans.getOgrAd()+" "+ylisans.getOgrSoyad());
				}
			}
		}
	}
	public static void dersListele(Bolum[] bolum)
	{
		int kontrol;   //baktigi kredi sayisinda ders varsa eğer bir kere "kredili dersler" basligini yazdirmak icin yoksa hic yazmaz.
		System.out.println("Tüm Bölümlerdeki Dersler:");
		for(int k=1 ; k<=10;k++)    // 10 krediye kadar tüm kredilere göre siniflari dolasir.
		{
			kontrol=0;
			for(int i=0;i<bolum.length;i++)
			{
				for(int j=0;j<bolum[i].dersler.length;j++)
				{
					if(k == bolum[i].dersler[j].getDersKredi())
					{
						if(kontrol == 0)
							System.out.println("\t"+k+" Kredili Dersler:");
						System.out.println("\t\t"+bolum[i].dersler[j].getDersID()+" "+bolum[i].dersler[j].getDersAd());
						kontrol = 1;
					}
				}
			}
		}
	}
	public static void aramaYap(Bolum[] bolum)
	{
		String kelime;
		int kontrol = 0;        //ogrenci veya ders bulunup bulunmadıgını kontrol eder.
		Scanner r = new Scanner(System.in);
		System.out.print("Arancak kelime: ");
		kelime = r.next();
		
		System.out.println("Ogrenciler:");
		for(int i=0;i<bolum.length;i++)
		{
			for(int j=0;j<bolum[i].ogrenciler.length;j++)
			{
				if(bolum[i].ogrenciler[j] instanceof LisansOgrencisi)
				{
					LisansOgrencisi lisans = (LisansOgrencisi) bolum[i].ogrenciler[j];    
					if(kelime.equals(lisans.getOgrAd()) || kelime.equals(lisans.getOgrSoyad()))
					{
						System.out.print("\t"+lisans.getOgrID()+" "+lisans.getOgrAd()+" "+lisans.getOgrSoyad()+" "+lisans.getOgrSinif());
						System.out.println(" "+lisans.getDurum()+" "+bolum[i].getBolAd());
						kontrol = 1;
					}
				}
				if(bolum[i].ogrenciler[j] instanceof YLOgrencisi)
				{
					YLOgrencisi ylisans = (YLOgrencisi) bolum[i].ogrenciler[j];
					if(kelime.equals(ylisans.getOgrAd()) || kelime.equals(ylisans.getOgrSoyad()))
					{
						System.out.print("\t"+ylisans.getOgrID()+" "+ylisans.getOgrAd()+" "+ylisans.getOgrSoyad());
						System.out.println(" "+ylisans.getDurum()+" "+bolum[i].getBolAd());
						kontrol=1;
					}
				}
			}
		}
		if(kontrol==0)
		{
			System.out.println("\tBu isimde veya soyadda ogrenci bulunamadi.");
		}
		kontrol = 0;
		System.out.println("Dersler:");
		for(int i=0;i<bolum.length;i++)
		{
			for(int j=0;j<bolum[i].dersler.length;j++)
			{
				if(kelime.equals(bolum[i].dersler[j].getDersAd()))
				{
					System.out.print("\t"+bolum[i].dersler[j].getDersID()+" "+bolum[i].dersler[j].getDersAd()+" "+bolum[i].dersler[j].getDersKredi());
					System.out.println(" "+bolum[i].getBolAd());
					kontrol = 1;
				}
			}
		}
		if(kontrol==0)
		{
			System.out.println("\tBu isimde ders bulunamadi.");
		}
	}
}*/
