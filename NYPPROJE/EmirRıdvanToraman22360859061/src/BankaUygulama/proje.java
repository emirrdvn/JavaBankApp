package BankaUygulama;

public class proje{
public static void main (String[] args) {
		
	    Musteri Emir= new Musteri(33727,"Emir","Toraman","toramanemir41@gmail.com",896555);
	    Musteri Kerem= new Musteri(55687,"Kerem","Yilmaz","keremyilmaz@gmail.com",687555);
	    KrediKarti krediKarti1=new KrediKarti(10700,500,Emir);
	    KrediKarti krediKarti2=new KrediKarti(4800,800,Emir);
							/*Limit, Güncel borç ve kime ait olduğu*/
	     for(KrediKarti krediKartlari : BankaHesap.getKrediKartlari()) {
	    	if(krediKartlari.getGuncelBorc()<5000) {
	    		System.out.println(krediKartlari.toString());
	    	}
	    }
						
	    /*System.out.println(Emir.getMusteriKrediKartlari());
	    System.out.println(krediKarti1.getKrediler().toString());	
	    System.out.println(Kerem.getMusteriKrediKartlari());
	    System.out.println(krediKarti2.getKrediler().toString());*/
	    
	   
	    
	    //krediKarti1.krediEkle(1,1200);
	    //krediKarti1.krediEkle(1,6000);
	    /*Kaçıncı kredi,kredi miktari*/
	   /* Emir.hesapEkle();
	    Kerem.hesapEkle();
	    Kerem.hesapEkle();
	    System.out.println(Emir.getMusteriHesaplari().toString());
		System.out.println(Kerem.getMusteriHesaplari().toString());*/
		
	    
	    
	    
		
	    //System.out.println("Musteri Numarasi :"+Emir.getMusteriNo());
	    //System.out.println("Musteri Numarasi :"+Kerem.getMusteriNo());
	    
		/*Emir.hesapSil();
		
		System.out.println(Kerem.getMusteriHesaplari().toString());
		System.out.println(Emir.getMusteriHesaplari().toString());*/
		
		
		
	}
}



























