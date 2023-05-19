package BankaUygulama;

public class VadesizHesap extends BankaHesap{
	String hesapBilgisi;
	private double vadesizBakiye;
	
	public VadesizHesap() {}
	public VadesizHesap(String hesapBilgisi, double vadesizBakiye) {
		super(BankaHesap.ibanolustur(), vadesizBakiye, hesapBilgisi);
		super.setHesapBilgisi(hesapBilgisi);
        this.hesapBilgisi = hesapBilgisi;
        this.vadesizBakiye = vadesizBakiye;
	}
	
	public void paraTransfer( long iban, int islemMiktar) {
		if(islemMiktar > vadesizBakiye) {
            System.out.println("Yetersiz bakiye.");
        }
        else {
            for(BankaHesap bankaHesap : BankaHesap.getHesaplar()) {
            	if(bankaHesap.getIban() == iban) {
	            	if(bankaHesap.getHesapBilgisi()==hesapBilgisi) {
	                    this.vadesizBakiye -= islemMiktar;
	                    bankaHesap.setToplamBakiye(bankaHesap.getToplamBakiye()+ islemMiktar);
	                    }
	            	else {
	            		this.vadesizBakiye -=8;
	                    this.vadesizBakiye -= islemMiktar;
	                    bankaHesap.setToplamBakiye(bankaHesap.getToplamBakiye()+ islemMiktar);
	                    
            	
	                    }
	            	}
            	}
            }
        
	}
	
	public double krediKartiBorcOdeme(double vadesizBakiye, KrediKarti Borc) {
		if(vadesizBakiye > Borc.getGuncelBorc()) {
            vadesizBakiye -= Borc.getGuncelBorc();
            Borc.setGuncelBorc(0);
            return Borc.getGuncelBorc();
        }
        else {
            Borc.setGuncelBorc(Borc.getGuncelBorc() - vadesizBakiye);
            vadesizBakiye = 0;
            return Borc.getGuncelBorc();
        }
	}
	
	public void krediOdeme(int krediID, KrediKarti krediKarti) {
		for(Krediler kredi : KrediKarti.getKrediler()) {
			if(kredi.getID()==krediID) {
				if(vadesizBakiye > kredi.getTaksit()) {
		            kredi.setKredi(vadesizBakiye -= kredi.getTaksit());
		            System.out.println("Kalan kredi miktari: "+ kredi.getKredi()) ;
		        }
				else {
					System.out.println("Yetersiz bakiye!!!");
				}
			}
			else {
				System.out.println("Kredi yok!!!");
			}
		}
		
	}
	
	@Override
    public String toString() {
        return super.toString()+"\nHesap Turu: " + "Vadesiz Hesap" +"\nVadesiz Bakiye: " + this.vadesizBakiye;
    }
}