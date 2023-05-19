package BankaUygulama;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KrediKarti{
	Random rand = new Random();
	private int kartNumarasi;
	double guncelBorc;
	double limit = kullanilabilirLimit(kartNumarasi,guncelBorc);
	private static ArrayList<Krediler> krediler = new ArrayList<Krediler>();
	
	
	public KrediKarti() {
		
	}
	public KrediKarti(double limit ,double guncelBorc,Musteri musteri) {
		this.kartNumarasi=kartolustur();
		this.limit = limit;
		this.guncelBorc = guncelBorc;
		BankaHesap.getKrediKartlari().add(this);
		musteri.getMusteriKrediKartlari().add(this);
		System.out.println("Kredi Kart Numarasi: "+ kartNumarasi);
	}
	
	
	/*public void krediKartiEkle(KrediKarti krediKarti,Musteri musteri) {
		for(KrediKarti krediKarti : BankaHesap.getKrediKartlari()) {
            if(krediKarti.getKartNo() == kartNumarasi) {
            	BankaHesap.getKrediKartlari().add(krediKarti);
            	}
            }
	}*/
	
	public void krediEkle(int kacincikredi,int krediMiktari) {
		Krediler kredi = new Krediler(kacincikredi ,krediMiktari);
		this.getKrediler().add(kredi);
	}
	
	public void krediKartiSil(int kartNumarasi,Musteri musteri) {
		for(KrediKarti krediKarti : BankaHesap.getKrediKartlari()) {
            if(krediKarti.getKartNo() == kartNumarasi) {
                if(krediKarti.guncelBorc > 0) {
                    System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
                    return;
                } else {
                    BankaHesap.getKrediKartlari().remove(krediKarti);
                    musteri.getMusteriKrediKartlari().remove(krediKarti);
                    System.out.println("Kredi kartı silindi.");
                    break;
                }
            }
        }
	}
	
	public double kullanilabilirLimit(int kartNumarasi, double guncelBorc) {
		for(KrediKarti krediKarti : BankaHesap.getKrediKartlari()) {
            if(krediKarti.getKartNo() == kartNumarasi) {
                return krediKarti.limit - krediKarti.guncelBorc;
            }
        }
        return 0;
	}
	
	
	public static int kartolustur() {
    	int smallest = 1000_0000;
	    int biggest =  9999_9999;
	    // return a long between smallest and biggest (+1 to include biggest as well with the upper bound)
	    int random = ThreadLocalRandom.current().nextInt(smallest, biggest+1);
	    return (int)random;
    }
	
	
	public double getGuncelBorc() {
        return guncelBorc;
    }

    public void setGuncelBorc(double guncelBorc) {
        this.guncelBorc = guncelBorc;
    }
    
	public double getLimit() {
        return limit;
    }
    public int getKartNo() {
        return kartNumarasi;
    }
    public static ArrayList<Krediler> getKrediler() {
        return krediler;
    }
    @Override
    public String toString() {
        return "Kart No: " + this.kartNumarasi + "\nLimit: " + this.limit +"\nGuncel Borc: " + this.guncelBorc +"\nKullanilabilir Limit: " + (this.limit - this.guncelBorc);
    }
}