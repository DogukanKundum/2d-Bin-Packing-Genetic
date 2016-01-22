package binpacking;

import java.util.Random;

public class iterasyon {

	public int[][] kopyalama(int[][] kutuBilgisi, int cesit) {
		
		int [][]temp = new int[cesit][4];
		int o = 0;
		
		while(o < cesit)
		{
				temp[o][0] = kutuBilgisi[o][0];
				temp[o][1] = kutuBilgisi[o][1];
				temp[o][2] = kutuBilgisi[o][2];
				temp[o][3] = kutuBilgisi[o][3];
				o++;
		}
		
		return temp;
	}

	public int[][] kromOlustur(int[][] temp,int[][] kutuBilgisi,
			int top_kutu, int populasyon, int cesit) {
		
		Random random = new Random();
		
		int [][] kromozom;
		int [][] a_diz = new int [populasyon][top_kutu];
		kromozom = a_diz;
		int deger, aa = 0,bb = 0;
		int rand ;
		int j = 0;
		
		///////////////İLK 24 POPULASYONUN OLUŞTURULMASI///////////////
		
		temp = kopyalama(kutuBilgisi, cesit); //POPULASYONUN GEÇİCİYE KOPYALANMASI

		for (int i = 0; i < populasyon; i++) // KROMOZOM İNDEKS
		{
			j = 0;
			
			while ( j < top_kutu) // KROMOZOM İÇERİĞİNİN OLUSTURULMASI
			{
				rand = random.nextInt(cesit);
				
					if(temp[rand][3] != 0)
					{
						if (temp[rand][0] == temp[rand][1]) // KARE KONTROLÜ
						{
							deger = temp[rand][3];
					
						if(deger != 0)
						{
							deger--;
							temp[rand][3] = deger;
							kromozom[i][j] = rand;
							j++;
						}
						else
						{
							rand = random.nextInt(cesit);
						}
					}
					else // DİKDÖRTGEN İÇİN İNCELENEN YER
					{
						if(rand % 2 == 0) // ÇİFT OLDUĞU DURUM
						{                 //çift ise bir sonraki kutu indisine bakılır
							
							if(temp[rand][0] == temp[rand+1][1]) // DİKDÖRTGEN KONTROLÜ
							{							
								aa = temp[rand][3];
								aa--;
								temp[rand][3] = aa;
								
								bb = temp[rand+1][3];
								bb--;
								temp[rand+1][3] = bb;
								
								kromozom[i][j] = rand;
								
								j++;
							}
						
						}
						else  // TEK ŞARTI
						{
							if(temp[rand][0] == temp[rand-1][1]) 
							{								
								aa = temp[rand][3];
								aa--;
								temp[rand][3] = aa;
								
								bb = temp[rand-1][3];
								bb--;
								temp[rand-1][3] = bb;
								
								kromozom[i][j] = rand;
								j++;
							}
						}
					
					}
				}
					else
					{
						rand = random.nextInt(cesit);
					}
				}
			
			temp = kopyalama(kutuBilgisi, cesit); // KOPYALAMA İŞLEMİ 
			
			}
		return kromozom;
	}
	
	
	/////////////////// 8 ADET POPULASYON ÜRETİMİ ///////////////////
	

	public int[][] kromOlustur8(int[][] temp, int[][] kutuBilgisi, 
			int top_kutu, int pop, int cesit) {
		
		
		Random random = new Random();
		int populasyon = pop-16;
		
		int [][] kromozom;
		int [][] a_diz = new int [populasyon][top_kutu];
		kromozom = a_diz;
		int deger, aa = 0,bb = 0;
		int rand ;
		int j = 0;
		
		temp = kopyalama(kutuBilgisi, cesit);

		for (int i = 0; i < populasyon; i++) // kromozom indeks
		{
			j = 0;
			
			while ( j < top_kutu) // kromozom içerik oluşturma
			{
				rand = random.nextInt(cesit);
				
					if(temp[rand][3] != 0)
					{
						if (temp[rand][0] == temp[rand][1]) // kare kontrol
						{
							deger = temp[rand][3];
					
						if(deger != 0)
						{
							deger--;
							temp[rand][3] = deger;
							kromozom[i][j] = rand;
							j++;
						}
						else
						{
							rand = random.nextInt(cesit);
						}
					}
					else // dikdörtgen için incelenen yer
					{
						if(rand % 2 == 0) // çift olduğu durum
						{
							if(temp[rand][0] == temp[rand+1][1]) // dikdörtgen şartı
							{							
								aa = temp[rand][3];
								aa--;
								temp[rand][3] = aa;
								
								bb = temp[rand+1][3];
								bb--;
								temp[rand+1][3] = bb;
								
								kromozom[i][j] = rand;
								
								j++;
							}
						
						}
						else  // tek şartı
						{
							if(temp[rand][0] == temp[rand-1][1]) 
							{								
								aa = temp[rand][3];
								aa--;
								temp[rand][3] = aa;
								
								bb = temp[rand-1][3];
								bb--;
								temp[rand-1][3] = bb;
								
								kromozom[i][j] = rand;
								j++;
							}
						}
					
					}
				}
					else
					{
						rand = random.nextInt(cesit);
					}
				}
			
			temp = kopyalama(kutuBilgisi, cesit);
			
			}
		return kromozom;
	}
}
