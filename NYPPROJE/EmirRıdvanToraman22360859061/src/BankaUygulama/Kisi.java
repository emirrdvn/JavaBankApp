package BankaUygulama;



public class Kisi{
	private int tckimlikno;
	private String ad;
	private String soyad;
	private String email;	
	private int telefonnumarasi;
	
	public Kisi(){}
	public Kisi(String ad,String soyad,String email,int telefonnumarasi) {
        this.ad = ad;
        this.soyad = soyad;
        this.telefonnumarasi = telefonnumarasi;
        this.email = email;
	}
	
	//Getter ve Setter Metodların Yazılması
		public int getTcKimlikNo() 
		{
			return tckimlikno;
		}

		public void setTcKimlikNo(int tckimlikno) 
		{
			this.tckimlikno =tckimlikno;
		}

		public String getSoyad() 
		{
			return soyad;
		}


		public String getEmail() 
		{
			return email;
		}

		public void setEmail(String email) 
		{
			this.email = email;
		}

		public int getTelefonNumarasi() 
		{
			return telefonnumarasi;
		}

		public void setTelefonNumarasi(int telefonnumarasi) 
		{
			this.telefonnumarasi = telefonnumarasi;
		}

		
		
		//toString metodunun eklenmesi
		@Override
		public String toString() 
			{
			return " Ad=" + ad + ",\n Soyad=" + soyad + ", \nEmail=" + email 
					+ ",\n Telefon Numarasi=" + telefonnumarasi+ "\n";
		}      
}