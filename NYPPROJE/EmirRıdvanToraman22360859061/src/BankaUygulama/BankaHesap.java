package BankaUygulama;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class BankaHesap{
	private long iban;
	private Date hesapAcilisTarih;
	private double toplamBakiye;
	private String hesapBilgisi;
	//private double islemMiktar;
	private String hesapTuru;
	
	private static ArrayList<BankaHesap> hesaplar = new ArrayList<BankaHesap>();
    private static ArrayList<KrediKarti> krediKartlari = new ArrayList<KrediKarti>();
    private static ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
    private static ArrayList<Krediler> krediler = new ArrayList<Krediler>();
    
    
    public static long ibanolustur() {
    	long smallest = 1000_0000_0000_0000L;
	    long biggest =  9999_9999_9999_9999L;
	    // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
	    long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
	    return random;
    }
	
	public BankaHesap() {
		
	}
	public BankaHesap(long iban, double toplamBakiye, String hesapBilgisi) {
		this.iban = iban;
        this.toplamBakiye = toplamBakiye;
        this.hesapBilgisi = hesapBilgisi;
        this.hesapAcilisTarih = new Date();
	}
	public void hesapGoruntuleme(long iban) {
		for(BankaHesap hesap:BankaHesap.getHesaplar()) {
			if(hesap.getIban()== iban) {
				System.out.println(" ");
				hesap.toString();
			}
			
		}
	}
	
	public Date getHesapAcilisTarih() {
        return hesapAcilisTarih;
    }
	
	public static ArrayList<KrediKarti> getKrediKartlari() {
        return krediKartlari;
    }
	public static ArrayList<BankaHesap> getHesaplar() {
        return hesaplar;
    }

    public static ArrayList<Musteri> getMusteriler() {
        return musteriler;
    }
    
    public static ArrayList<Krediler> getKrediler() {
        return krediler;
    }

    public long getIban() {
        return iban;
    }


    public double getToplamBakiye() {
        return toplamBakiye;
    }

    public void setToplamBakiye(double toplamBakiye) {
        this.toplamBakiye = toplamBakiye;
    }

    public String getHesapBilgisi() {
        return hesapBilgisi;
    }
    
    public void setHesapBilgisi(String hesapBilgisi) {
        this.hesapBilgisi = hesapBilgisi;
    }

    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }
    
    @Override
    public String toString() {
        return getMusteriler().toString() +"IBAN: " + this.iban +
                "\nHesap Acilis Tarihi: " + this.hesapAcilisTarih +"\nToplam Bakiye: " + this.toplamBakiye + "\nHesap Bilgisi: " + this.hesapBilgisi;
    }
}