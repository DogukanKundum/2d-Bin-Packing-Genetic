package binpacking;

import java.util.Scanner;

public class main {
	public static void main(String arg[])
	{	
		int kare_sayi, dikdortgen_sayi, cesit = 0;
		int en, boy , say, kapasite;
		int top = 0,krom;
		Scanner scanner = new Scanner(System.in);
		System.out.println("2D Bin Packing Uygulaması");
		System.out.println("--------------------------");
		System.out.println("Konteyner Belirleyiniz! ");
		System.out.println("1. 100x100 ");
		System.out.print("2. 50x50 \nSeçim:");
		int konteyner_secim = scanner.nextInt();
		
		if(konteyner_secim == 1)
		{
			kapasite = 10000;
		}
		else if(konteyner_secim == 2)
		{
			kapasite = 2500;
		}
		else
		{
			kapasite = -1;
		}
		System.out.println("---------------------------------------------------------- ");
		System.out.println("KARE kutu çeşidini giriniz :  (Kare Kutu Yoksa 0 giriniz): ");
		System.out.print("Adet :"); kare_sayi = scanner.nextInt();
		System.out.println("DİKDÖRTGEN kutu çeşidini  giriniz : (Dikdörtgen Kutu Yoksa 0 giriniz): ");
		System.out.print("Adet :"); dikdortgen_sayi = scanner.nextInt();
		System.out.println("---------------------------------------------------------- ");
		
		krom = kare_sayi + dikdortgen_sayi; // KUTU ÇEŞİDİ SAYISI 
		dikdortgen_sayi = dikdortgen_sayi*2;
		cesit = kare_sayi + dikdortgen_sayi; // DİKDÖRTGENİN ORYANTASYONU VE KARE SAYILARI TOPLAMI
		
		
		int [][]dizi = new int [cesit][4];
		int a = 0 , b = 0 ,c = 0;
		
		if(kare_sayi == 0)   // GİRİLEN KARE KUTULARIN ADEDİNİN SIFIR KONTROLÜ
		{
			while(a < cesit ){
			
				System.out.println((c+1)+".Dikdörtgen Kutu En/Boy giriniz : ");
				System.out.print("En :"); en = scanner.nextInt();
				System.out.print("Boy :"); boy = scanner.nextInt();
				System.out.print(en + "," + boy + " kutusundan kaç tane : "); say = scanner.nextInt();
				System.out.println("---------------------------------------------------------- ");
				top = top + say;  // TOPLAM KUTU SAYISI
				
				
				/*
				 * EN | BOY | ALAN | KUTU SAYISI |
				 * |..|.....|......|............ |	
				 */
				dizi[a][0]=en;				
				dizi[a][1]=boy;
				dizi[a][2]=en*boy;
				dizi[a][3]=say;               
				
				dizi[a+1][0]=boy;
				dizi[a+1][1]=en;
				dizi[a+1][2]=en*boy;
				dizi[a+1][3]=say;
				
				a = a + 2;
				c++;				
			}	
		}
		else if(dikdortgen_sayi == 0)  // GİRİLEN DİKDÖRTGEN KUTULARIN ADEDİNİN SIFIR KONTROLÜ
		{
			while(b < cesit )
			{
			
				System.out.println((b+1)+".Kare Kutu En/Boy giriniz : ");
				System.out.print("En/Boy :"); en = scanner.nextInt();
				System.out.print(en+","+en+" kutusundan kaç tane : "); say = scanner.nextInt();
				System.out.println("---------------------------------------------------------- ");
				top = top + say;
				
				dizi[b][0]=en;
				dizi[b][1]=en;
				dizi[b][2]=en*en;
				dizi[b][3]=say;
				
				b = b + 1;
			}
		}
		else
		{
			a = 0;
			b = 0;
			while(a < dikdortgen_sayi ){
				
				System.out.println((c+1)+".Dikdörtgen Kutu En/Boy giriniz : ");
				System.out.print("En :"); en = scanner.nextInt();
				System.out.print("Boy :"); boy = scanner.nextInt();
				System.out.print(en+","+boy+" kutusundan kaç tane : "); say = scanner.nextInt();
				
				top = top + say;
				
				dizi[a][0]=en;
				dizi[a][1]=boy;
				dizi[a][2]=en*boy;
				dizi[a][3]=say;
				
				dizi[a+1][0]=boy;
				dizi[a+1][1]=en;
				dizi[a+1][2]=en*boy;
				dizi[a+1][3]=say;
				
				a = a + 2;
				c++;
			}
			a = a-2;
			
			while(b < kare_sayi )
			{
				System.out.println((b+1)+".Kare Kutu En/Boy giriniz : ");
				System.out.print("En/Boy :"); en = scanner.nextInt();
				System.out.print(en+","+en+" kutusundan kaç tane : "); say = scanner.nextInt();
				
				top = top + say;				
				
				dizi[a+2][0]=en;
				dizi[a+2][1]=en;
				dizi[a+2][2]=en*en;
				dizi[a+2][3]=say;
				a++;
				b++;
			}
		}
		int parametre = 0;
		
		
		// KUTUNUN ALAN KONTROLÜNÜN KONTEYNER'E GÖRE YAPILMASI
		
		for (int i = 0; i < cesit; i++) 
		{
			
			if (dizi[i][2] > kapasite) 
			{
				dizi[i][3] = 0;
				parametre = 1;
				
			}
			
			if(dizi[i][0] > Math.sqrt(kapasite) || dizi[i][1] > Math.sqrt(kapasite))
			{
				dizi[i][3] = 0;
				parametre = 1;
			}
			
		}
		////////////////////////////////////////////////////////
		int toplam = 0;
		for (int i = 0; i < cesit; i++) 
		{
			toplam += dizi[i][3];
		}
		
		int j = 0;
		
		System.out.println("-------------------   KUTU BİLGİSİ   --------------------- ");
		System.out.println("---------------: | E | B | A |");
		for (int i = 0; i < cesit; i++) 
		{
				System.out.println((i+1) + ". Kutu Bilgisi: | " + dizi[i][j]+ " | " + dizi[i][j+1] + " | " + dizi[i][j+2]+ " |");
			
		}
		System.out.println("---------------------------------------------------------- ");
		
		if(parametre == 1)  // ALAN KONTROLÜ YAPILAN KUTULARIN GÖNDERİLMESİ
		{  
			System.out.println("Girilen kutulardan bazıları konteynerin kapasitesini aştı! \nO kutular iptal edilerek hesaplandı! ");
			kromozom kromozom = new kromozom(dizi,cesit,toplam,krom);
			kromozom.kromozomOlustur();
			
		}
		else // TÜM KUTUNUN ALANLARININ KONTEYNERDEN KÜÇÜK OLMASI
		{
			kromozom kromozom = new kromozom(dizi,cesit,top,krom);
			kromozom.kromozomOlustur();
		}
	}
}
