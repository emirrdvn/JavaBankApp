package BankaUygulama;



public class Krediler {
	private int krediID;
	private double krediMiktari;
	private double taksitMiktari;
	
	
	public Krediler() {
		
	}
	public Krediler(int krediID, double krediMiktari) {
		this.krediID=krediID;
		this.krediMiktari=krediMiktari;
		this.taksitMiktari=(krediMiktari/6);
		
		
	}
	public void kampanya(double limit) {
		 if((krediMiktari > limit*6) || (limit < 10000)) {
	            System.out.println("Yıllık kazancınızın yarısından fazla kredi çekilemez.");
		 }
		 
	}
	
	public int getID() {
        return krediID;
    }
	
	public double getTaksit() {
        return taksitMiktari;
    }
	
	public void setKredi(double kalankredi) {
         this.krediMiktari=kalankredi;
    }
	
	public double getKredi() {
        return krediMiktari;
    }
	
	
	
	public String toString() {
		return "Kredi ID: "+krediID+"\n"+"Kredi Miktari: "+krediMiktari+"\n"+"Taksit Miktari :"+ taksitMiktari +"\n";
	}

}