package binpacking;

import java.text.DecimalFormat;
import java.util.Random;

public class genetikIslem {
	
	double mutasyon_orani = 0.1;
	double caprazlama_orani = 0.5;
	int nokta_x;
	int nokta_y;
	int nx; 
	int ny;
	Random random = new Random();

	public int[][] genetikCaprazlama(int[] rulet_secim, int[][] kromozom)
	{
		int parent1_d;
		int parent2_d;
		int uzunluk_kromozom = kromozom[0].length;
		int[] tmp;
		int [][] tum_parent = new int[rulet_secim.length][uzunluk_kromozom];
		int gecici;
		double c_orani,sonuc;
		DecimalFormat islem = new DecimalFormat("0.0");
		
		int item = 0;
		String a,b;
		
		
		/////////////////// ÇAPRAZLAMA İŞLEMİ ///////////////////////
		/*
		 * RULET İÇERİSİNDE YER ALAN RASTGELE KUTULARIN
		 * AYNI OLUP OLMADIĞININ KONTOLÜNÜN YAPILDIĞI VE
		 * ÇAPRAZLANDIĞI YER
		 */
		
		for (int i = 0; i < rulet_secim.length; i = i + 2) {
			
			parent1_d = rulet_secim[i];
			parent2_d = rulet_secim[i+1];
			
			for (int j = 0; j < uzunluk_kromozom; j++) 
			{
				tum_parent[i][j]   = kromozom[parent1_d][j];
				tum_parent[i+1][j] = kromozom[parent2_d][j];
			}
		}
		
		///////////////////////////////////////////////////////////////
		
		/*
		 * 
		 * ÇAPRAZLAMA SIRASINDA ORAN MİKTARI KADAR KUTU ÜZERİNDE ÇAPRAZLAMA
		 * YAPMAMIZA YARDIMCI OLAN VE DE RASTGELE SEÇİLEN ARALIĞIN FARKININ
		 * NEGATİF OLMASININ ÖNLENDİĞİ YER
		 *  
		 */
		
		while(item == 0)
		{
			nokta_x = random.nextInt(uzunluk_kromozom);
			nokta_y = random.nextInt(uzunluk_kromozom);
			
	         if (nokta_x > nokta_y){    
	        	 gecici = nokta_x;
	             nokta_x = nokta_y;
	             nokta_y = gecici;
	         } 
	         if(uzunluk_kromozom %2 == 0) c_orani = (double)(nokta_y-nokta_x)*10 / uzunluk_kromozom;
	         else c_orani = (double)(nokta_y-nokta_x)*9 / uzunluk_kromozom;
	         sonuc = c_orani / 10;
	         a = islem.format(sonuc);
	         b = islem.format(caprazlama_orani);
	         
	         if( (a.equals(b)))
	        	 item = 1;
	         
		}  
		tmp = new int[nokta_y-nokta_x];
		int param = 0;
		
		for (int i = 0; i < kromozom.length-8; i = i+2)        // 16 ADET KROMOZOM ÇAPRAZLAMA
	    {
			param = 0;
	        for (int k = nokta_x; k < nokta_y; k++) 
	        {
	        			 tmp[param] = tum_parent[i][k];
	        			 tum_parent[i][k] = tum_parent[i+1][k];
	        			 tum_parent[i+1][k] = tmp[param];
	        			 param++;
	        }
	    }
		
		return tum_parent;            //ÖNCEKİ NESİLİN ÜZERİNE YAZILDI
	         
	}	
                  ///////////   MUTASYON  ////////////////
	
	public int[][] genetikMutasyon(int[][] mutasyon) 
	{
		int kontrol = 0;
		
		while(kontrol == 0){
			
			nx= random.nextInt(mutasyon[0].length);
			ny= random.nextInt(mutasyon[0].length);
			if(nx != ny)kontrol = 1;                 //RASTGELE SEÇİLEN DEĞERLERİN AYNI OLMAMASI
			
		}
	
		int gecici;
		
		 if (nx > ny){
        	 gecici = nx;
        	 nx = ny;
        	 ny = gecici;
         } 
		int[] tmp = new int[ny-nx];
		int param;
		
		
		for (int i = 0; i < mutasyon.length; i++) //İNVERSİON MUTASYON İŞLEMİ
		{
			param = 0;
			
			for (int k = nx; k < ny; k++) 
			{
				tmp[param] = mutasyon[i][k];
				param++;
			}
			
			for (int j = param-1; j >= 0; j--) {
				mutasyon[i][j] = tmp[j];
				}			
		}
		return mutasyon;
	}
}


