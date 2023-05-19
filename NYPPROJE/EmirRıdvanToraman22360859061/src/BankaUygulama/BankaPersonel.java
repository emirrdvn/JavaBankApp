package BankaUygulama;
import java.util.ArrayList;
import java.util.Random;

public class BankaPersonel extends Kisi {
	private int PersonelID;
	ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
    static ArrayList<BankaPersonel> personeller = new ArrayList<BankaPersonel>();
	public BankaPersonel() {
		
	}
	public BankaPersonel(int tckimlikno ,String ad,String soyad,String email,int telefonnumarasi) {
		super(ad,soyad,email,telefonnumarasi);
		super.setTcKimlikNo(tckimlikno);
		Random rand = new Random(); 
        int randomPersonelID = rand.nextInt(5000);
        for(BankaPersonel Personel : personeller) {
            while (Personel.getPersonelID() == randomPersonelID) {
                randomPersonelID = rand.nextInt(5000);
            }
        }
        this.PersonelID = randomPersonelID;
        personeller.add(this);
	}
	
	public void musteriEkle(Musteri Musteri) {
        musteriler.add(Musteri);
    }

    public int getPersonelID() { 
        return this.PersonelID;
    }

    public ArrayList<Musteri> getMusteriler() {
		return musteriler;
	}

    public ArrayList<BankaPersonel> getPersoneller() {
		return personeller;
	}
    
    @Override
    public String toString() {
        return "Personel ID: " +this.getPersonelID() +"\t"+ super.toString();
    }
}