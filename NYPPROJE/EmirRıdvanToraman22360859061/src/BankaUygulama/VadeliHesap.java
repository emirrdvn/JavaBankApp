package BankaUygulama;

public class VadeliHesap extends BankaHesap{
	String hesapBilgisi;
	double vadeliBakiye;
	float faizOrani;
	public VadeliHesap() {
		
	}
	public VadeliHesap(String hesapBilgisi, double vadeliBakiye) {
		super(BankaHesap.ibanolustur(), vadeliBakiye, hesapBilgisi);
		super.setHesapBilgisi(hesapBilgisi);
		super.setHesapTuru("Vadeli Hesap");
		this.hesapBilgisi = hesapBilgisi;
		if(hesapBilgisi=="Maaş") {
			this.vadeliBakiye = vadeliBakiye;
	        this.faizOrani = (float)0.2;}
		else {
			this.vadeliBakiye = vadeliBakiye;
			this.faizOrani = (float)0.1;}}



@Override
public String toString() {
    return super.toString()+"\nHesap Turu: " + "Vadeli Hesap" +"\nVadeli Bakiye: " + this.vadeliBakiye;
}
}