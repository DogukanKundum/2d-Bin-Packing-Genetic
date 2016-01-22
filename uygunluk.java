package binpacking;

import java.util.Random;

public class uygunluk {


	public double[][] hesapla(int[][] kromozom, int[][] i_kromozom,int jen_say) 
	{ 
		
		int a = kromozom.length;
		int b = kromozom[0].length;
		int deger;
		double islem , degisken;
		int en_top;
		
		Random random = new Random();
		
		////////////// UYGUNLUK DEĞERİ HESAPLAMA ////////////
		
		double[][] uygunluk = new double [a][2];
		
		for (int i = 0; i < a; i++) 
		{
			en_top = 0;
			islem = random.nextInt(50) + 50;
			for (int j = 0; j < b; j++) 
			{
				
				deger = kromozom[i][j];
				en_top += i_kromozom[deger][0];	
				
			}
			degisken = (en_top * 0.01) * islem; //TOPLAM EN UZUNLUĞUNA GÖRE
			uygunluk[i][0] = i;
			uygunluk[i][1] = degisken;
		}
		if(jen_say == 0){
		for (int i = 0; i < a; i++) {
			
			System.out.print((i+1) + ".Kromozom : " );
			
			for (int j = 0; j < b; j++) {
				
				System.out.print(kromozom[i][j] + "  ");			
			}
			System.out.print("Uygunluk Değeri :" + uygunluk[i][1]);
			System.out.println();
		}
		}
		return uygunluk;
		
	}
	
	public void selectionSort(int [][] kromozom,int jen_say, int [][]yazdir)
	{
		
		//////////////// UYGUNLUK DEĞERLERİNİN SIRALANMASI //////////////
		
		int [] temp = new int[2];
		
		for (int i = 0; i < kromozom.length; i++) 
		{
			for (int j = 0; j < kromozom.length; j++)
			{
				if(kromozom[i][1] > kromozom[j][1])
				{
					temp[0] = kromozom[i][0];
					temp[1] = kromozom[i][1];
							
					kromozom[i][0] = kromozom[j][0];
					kromozom[i][1] = kromozom[j][1];
					
					kromozom[j][0] = temp[0];
					kromozom[j][1] = temp[1];
				}
			}
		}
		
		//////// İTERASYONLARIN KROMOZOM /\ UYGUNLUK DEĞERLERİNİN ÇIKTISI ///////////
	    
		if(jen_say != 0){
			System.out.println("---------------------------------");
			System.out.println(" ");
			System.out.print((jen_say+1) + ".İterasyon Kromozom :");
			
			
			for(int i = 0; i < yazdir[0].length; i++ )
			System.out.print(( yazdir[23][i]) + " ");
			
			System.out.println(" ,Uygunluk Değeri :" + kromozom[23][1]);
		}
	    
	}

}
