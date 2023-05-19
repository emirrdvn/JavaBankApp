package BankaUygulama;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Musteri extends Kisi{
	Scanner sc= new Scanner(System.in);
	Scanner sc2= new Scanner(System.in);
	public int musteriNumarasi;
	private ArrayList<BankaHesap> hesaplar;
	private static ArrayList<KrediKarti> KrediKartlari;
	public Musteri() {}
	public Musteri(int tckimlikno ,String ad,String soyad,String email,int telefonnumarasi) {
		super(ad, soyad, email, telefonnumarasi);
        super.setTcKimlikNo(tckimlikno);
		KrediKartlari=new ArrayList<KrediKarti>();
		hesaplar=new ArrayList<BankaHesap>();
		Random rand = new Random();
		musteriNumarasi= rand.nextInt(2500);
		
		
		for(BankaPersonel personel : BankaPersonel.personeller) {   
            for(Musteri musteri : personel.musteriler) {    
                while (musteri.getMusteriNo() == musteriNumarasi) {
                	musteriNumarasi= rand.nextInt(2500);
                }
            }
        }	
	}
	
	public void hesapEkle() {
		System.out.println("Maas hesabi icin 1,\nNormal Hesap icin 2");
		int hangisi = sc.nextInt();
		System.out.println("\n1:VadeliHesap\n2:VadesizHesap\n3:YatirimHesap");
		int hesapTuru = sc2.nextInt();
		
		switch(hangisi) {
		case 1:
			if(hesapTuru==1) {
				System.out.println("Vadeli hesap icin baslangic bakiyesi giriniz");
				double bakiye= sc.nextDouble();
				/*System.out.println("Vadeli hesap için faiz orani giriniz");
				float faiz= sc.nextFloat();*/
				VadeliHesap yeniVadeli= new VadeliHesap("Maaş",bakiye);
				
				hesaplar.add(yeniVadeli);
			}
			else if(hesapTuru==2) {
				System.out.println("Vadesiz hesap icin baslangic bakiyesi giriniz");
				double bakiye= sc.nextDouble();
				VadesizHesap yeniVadesiz= new VadesizHesap("Maaş",bakiye);
				hesaplar.add(yeniVadesiz);
			}
			else if(hesapTuru==3){
				System.out.println("Yatirim hesap icin baslangic bakiyesi giriniz");
				double bakiye= sc.nextDouble();
				System.out.println("Yatirim sebebini giriniz");
				String sebep=sc.nextLine();
				System.out.println("Yatirim hesabi icin kur orani giriniz");
				float kur=sc.nextFloat();
				YatirimHesap yeniYatirim=new YatirimHesap("Maaş",bakiye,sebep,kur);
				hesaplar.add(yeniYatirim);
			}
			break;
		case 2:
			if(hesapTuru==1) {
				System.out.println("Vadeli hesap icin baslangic bakiyesi giriniz");
				double bakiye= sc.nextDouble();
				/*System.out.println("Vadeli hesap için faiz orani giriniz");
				float faiz= sc.nextFloat();*/
				VadeliHesap yeniVadeli= new VadeliHesap("Normal",bakiye);
				hesaplar.add(yeniVadeli);
			}
			else if(hesapTuru==2) {
				//System.out.println("Vadesiz hesap için başlangıç bakiyesi giriniz");
				double bakiye= sc.nextDouble();
				VadesizHesap yeniVadesiz= new VadesizHesap("Normal",bakiye);
				hesaplar.add(yeniVadesiz);
			}
			else if(hesapTuru==3){
				System.out.println("Yatirim hesap icin baslangic bakiyesi giriniz");
				double bakiye= sc.nextDouble();
				System.out.println("Yatirim sebebini giriniz");
				String sebep=sc.nextLine();
				System.out.println("Yatirim hesabi icin kur orani giriniz");
				float kur=sc.nextFloat();
				YatirimHesap yeniYatirim=new YatirimHesap("Normal",bakiye,sebep,kur);
				hesaplar.add(yeniYatirim);
			}
			break;
		}
		
		
		
	}
	
	
	
	public void hesapSil() {
		for(BankaHesap hesap : this.hesaplar) {
            hesap.toString();
        }
        System.out.println("Silmek istediginiz hesabin IBAN'ini giriniz:");
        Scanner getInput = new Scanner(System.in);
        long silinecekIBAN = getInput.nextLong();
        getInput.close();
        for(BankaHesap hesap : this.hesaplar ) {
            if(hesap.getIban() == silinecekIBAN) {
                if(hesap.getToplamBakiye() > 0) {
                    System.out.println("Lutfen oncelikle hesaptaki bakiyeyi baska hesaba aktariniz.");
                }
                else {
                    try {
                        hesaplar.remove(hesap);
                        System.out.println("Hesap basariyla silindi.");
                        break;
                    }
                    catch(Exception hata) {
                        System.out.println("Hesap silinirken bir hata olustu.");
                        System.out.println("Hata: " + hata.getMessage());
                    }
                }
            }
            else {
                System.out.println("Hesap bulunamadi.");
            }
        }
	}

    public int getMusteriNo() {
        return musteriNumarasi;
    }

    public ArrayList<BankaHesap> getMusteriHesaplari() {
        return hesaplar;
    }

    public ArrayList<KrediKarti> getMusteriKrediKartlari() {
        return KrediKartlari;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}