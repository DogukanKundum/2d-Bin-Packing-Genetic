package binpacking;

import java.util.Random;

public class kromozom {
	/*
	 * POPULASYON,KUTU SAYISI, KROMOZOM ve 8-KROMOZOM
	 * GLOBAL TANIMLANDI 
	 */
	
	int populasyon = 24;
	int top_kutu;
	int cesit;
	int uz_krom;
	int [][] kromozom;
	int [][] kutuBilgisi;
	int [][] kromozom8;
	int jenerasyon = 1000;
	
	Random random = new Random();

	kromozom(int[][] kutuBilgisi, int cesit, int top_kutu, int uz_krom)
	{
		this.kutuBilgisi = kutuBilgisi;   // KUTU BİLGİSİ DİZİSİ
		this.top_kutu = top_kutu;  		//   kare_sayi + dikdortgen_sayi
		this.cesit = cesit;  			// FARKLI KUTU SAYISI
		this.uz_krom = uz_krom;
	}
	
	public void kromozomOlustur()
	{
		//////////////////////////////////////////////////////////
		int [] rulet;
		int [] rulet_secim = new int [16];
		int [][] a_diz = new int [populasyon][top_kutu];
		int [][] b_diz = new int [populasyon-16][top_kutu];
		
		kromozom = a_diz;
		kromozom8 = b_diz;
		int jen_say = 0;
		int [][] temp = new int[cesit][4];
		int [][] caprazlama = new int[populasyon-16][top_kutu];
		int [][] mutasyon = new int[populasyon-16][top_kutu];
		double [][] fitness_deger = new double [populasyon][2];
		int[][] uygunlukDizisi = new int [populasyon][2];
		
		iterasyon iter_kromozom = new iterasyon();
		genetikIslem gen = new genetikIslem();
		uygunluk fitness = new uygunluk();
		
		///////////////////////BASLANGIÇ KROMOZOM OLUSTURMA///////////////////
		
		temp = iter_kromozom.kopyalama(kutuBilgisi, cesit);
		
		kromozom = iter_kromozom.kromOlustur(temp,kutuBilgisi,top_kutu,populasyon,cesit);
		
		while(jen_say < jenerasyon) // DURDURMA ŞARTI
		{
		
		kromozom8 = iter_kromozom.kromOlustur8(temp,kutuBilgisi,top_kutu,populasyon,cesit);
		
		///////////////////////KROMOZOM OLUŞTURULDU////////////////////////////

		///////////////////////UYGUNLUK DEĞERİ HESAPLAMA///////////////////////
		fitness_deger = fitness.hesapla(kromozom, kutuBilgisi,jen_say);
		
		for (int i=0; i< populasyon; ++i){
			for (int k = 0; k < 2; k++) {
				uygunlukDizisi[i][k] = (int) fitness_deger[i][k];
			}
		}
		
		fitness.selectionSort(uygunlukDizisi,jen_say,kromozom);  // UYGUNLUK DEĞERLERİNE GÖRE SIRALAMA FONKSİYONU
		
		
		int uzunluk = uygunlukDizisi.length;
		
		//////////////////////// RULET SEÇİMİ ////////////////////////
		secimIslem islem = new secimIslem();
		
		rulet = islem.Secim(uygunlukDizisi,populasyon); // SEÇİM FONKSİYONU
		
		int secim, secim2;
		int rulet_indis_i = 0;
		int rulet_uzunluk = rulet.length;
		
			while(rulet_indis_i < uzunluk - 8) 
			{
				secim = random.nextInt(rulet_uzunluk);
				secim2 = random.nextInt(rulet_uzunluk);
			
				if(secim != secim2)   // SEÇİMLERİN FARKLILIK KONTROLÜ
				{
					rulet_secim[rulet_indis_i] = rulet[secim];
					rulet_secim[rulet_indis_i+1] = rulet[secim2];
					rulet_indis_i += 2;  
				}		
			}
			/////////////////ÇAPRAZLAMA////////////////////
			
			caprazlama = gen.genetikCaprazlama(rulet_secim, kromozom);
			
			/////////////////MUTASYON///////////////////	
			
			mutasyon = gen.genetikMutasyon(caprazlama);
			
			////////////////İTERASYON ADIMLARI////////////////////
			
			for (int i = 0; i < uzunluk - 8; i++) {
				for (int k = 0; k < top_kutu; k++) {
					kromozom[i][k] = mutasyon[i][k];
				}
			}
			int indis8 = 0;
			for (int x = uzunluk - 8; x < uzunluk ; x++) {
				for (int k = 0; k < top_kutu; k++) {
					kromozom[x][k] = kromozom8[indis8][k];
				}
				indis8++;
			}
			////////////////////////////////////////////////////
		jen_say++;
		
		try {
		    Thread.sleep(30);                 
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		}
	}
}
