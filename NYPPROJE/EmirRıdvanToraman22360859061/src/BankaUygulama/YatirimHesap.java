package BankaUygulama;

public class YatirimHesap extends BankaHesap{
	private String hesapBilgisi;
	private double yatirimBakiye;
	private String yatirimTuru;
	private float kur;
	
	public YatirimHesap(){}
	public YatirimHesap(String hesapBilgisi, double yatirimBakiye, String yatirimTuru, float kur) {
		super(BankaHesap.ibanolustur(), yatirimBakiye, hesapBilgisi);
        super.setHesapBilgisi(hesapBilgisi);
        this.hesapBilgisi = hesapBilgisi;
        this.yatirimBakiye = yatirimBakiye;
        this.yatirimTuru = yatirimTuru;
        this.kur = kur;
	}
	public double paraEkle(double yatirimBakiye,float kur) {
		System.out.println("Eski bakiyeniz: " + super.getToplamBakiye());
        super.setToplamBakiye(super.getToplamBakiye() + (kur * yatirimBakiye));
        System.out.println("Yeni bakiyeniz: " + super.getToplamBakiye());
        return super.getToplamBakiye();
	}
	public double paraBoz(int yatirimBakiye,float kur) {
		System.out.println("Eski bakiyeniz: " + super.getToplamBakiye());
        super.setToplamBakiye(super.getToplamBakiye() - (kur * yatirimBakiye));
        System.out.println("Yeni bakiyeniz: " + super.getToplamBakiye());

        return super.getToplamBakiye();
	}
	
	@Override
    public String toString() {
        return super.toString() +"\nHesap Türü: " + this.hesapBilgisi +"\nYatırım Türü: " + this.yatirimTuru +"\nKur: " + this.kur+"\nYatirim Bakiye: "+this.yatirimBakiye;
    }
}
