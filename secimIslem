package binpacking;

public class secimIslem {

	public int[] Secim(int [][]islem, int pop) 
	{
		
		/*
		 * RULET SEÇİMİ
		 * 
		 * Uygunluk değerlerinin yüzdelik kısma göre belirlenmesi
		 * 
		 *  ve içerisinden rastgele seçilmesi
		 * 
		 */
		
		
		int toplam_uygunluk = 0;
		int a = 0;
		int deger;
		int dongu = 0;
		int b = 0;
		
		for (int i = 0; i < pop; i++) 
		{
			toplam_uygunluk += islem[i][1]; 
		}
		
		for (int i = 0; i < pop; i++) 
		{
			deger = (islem[i][1] * 100) / toplam_uygunluk;
			dongu += deger; 
			while (a < dongu) 
			{
				a++;
			}
			b++;	
		}
		int [] rulet = new int [dongu];
		a = 0;
		b = 0;
		dongu = 0;
		for (int i = 0; i < pop; i++) 
		{
			deger = (islem[i][1] * 100) / toplam_uygunluk;
			dongu += deger; 
			while (a < dongu) 
			{
				rulet[a] = islem[b][0];
				a++;
			}
			b++;	
		}
		
		return rulet;
				
	}

}
