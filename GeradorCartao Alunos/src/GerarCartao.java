import javax.imageio.ImageIO;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;



import java.awt.Color;
import java.awt.image.BufferedImage;


public class GerarCartao{
	
	 static BufferedImage image = null;
	 static BufferedImage imageTemp = null;
	 static BufferedImage imageAluno = null;
	 private static Map<Character, Character> MAP_NORM;
	 static int flagB=0;
	 static int tamanhoMatricula=0;
	static MostrarLista mostrarLista;
	static String escola = "";
	 /**
	  * @wbp.parser.entryPoint
	  */
	 public static void main(String args[])
	 {
		 
		 /* passado para o construtor vazio gerarCarta()
		  * 
		  */
		 ObterModeloBranco();// obtem o image universal
		
		
		int sequencia[];
		sequencia = LerBaseGabarito("2EM_I_1_2019");
		GerarPadrao(image,sequencia);
		
		
		GerarImagemCartao(image, "2EM_I_1_2019");
		 
	 }
	 
	
	 
	public GerarCartao(String nome)
	 {
		 
		ObterModeloBranco();// obtem o image universal
		
		int sequencia[];
		sequencia = LerBaseGabarito(nome);
		GerarPadrao(image,sequencia);
		
		
		GerarImagemCartao(image, nome); 
	 }
	
	
	 public GerarCartao() {
		// TODO Auto-generated constructor stub
	}



	/**
	  * @wbp.parser.entryPoint
	  */
	 
	public static void GerarPadrao(BufferedImage im,int sequencia[])
	{// funcao mor que gera os padroes e distribui pelas funcoes necessarias para gerar o cartao de resposta
		int x=0,y=0;
		flagB=0;
		int dx=200, dy=370;// deslocamento para calibrar a posicao na folha
		MontarCabecalho(); // gerar o cabacalho de acordo com as caracteristicas do arquivo cabecalho.txt
		ColocarCabecalho(image, x+dx, y);
		CriarLinhasVermelhas(image, x+dx,y+dy);// gera padrao de linhas vermelhas
		ExtraObrigatoria( image,0, dy);
		CriarMarcaObrigatoria(im,720,300);
		CriarMarcaObrigatoria(im, 1240,300);
		
		for (int i =1 ; i<= sequencia.length; i++)
		{
		int corBG=i%2 +1;	
		int MarcaObrigatoria = i%5;
		 if(i<=50)// enquanto numero de questoes for menor que 50
		 {
			 if(i==1)
				 GerarTopo(image,x+dx, y+dy-70);
			x=70+dx; // mapeamento CALIBRAVEL X
			y=(i-1)*70+dy;// mapeamento CALIBRAVEL Y
			GerarNumero(im,i, x, y,corBG);// escreve o numero da questao
			Switch(im, x+100,y, sequencia[i-1],corBG,dx,dy,i);// distribui para o tipo da questa
			ColocarImagemPadrao(image,"LinhaVertical", x, y);
			if(MarcaObrigatoria==0)
				CriarMarcaObrigatoria(im, x-70,y);
			
		 }
		 if( (i>50) &&(i<=100))
		 {
			 
			x=450+70*2+dx;
			y=70*(i-51)+dy;
			if(i==51)
				 GerarTopo(image,x-70, y-70);
			GerarNumero(im,i, x,y ,corBG);
			Switch(im, x+100,y, sequencia[i-1],corBG,dx,dy,i);
			ColocarImagemPadrao(image,"LinhaVertical", x, y);
			ColocarImagemPadrao(image,"LinhaVertical", x-70, y);
			if(MarcaObrigatoria==0)
				CriarMarcaObrigatoria(im, x-70,y);
		 } 
		 if((i>100) &&(i<=150))
		 {
			 
			x=450*2+70*3+dx;
			y=70*(i-101)+dy;
			if(i==101)
				 GerarTopo(image,x-70, y-70);
			GerarNumero(im,i,x, y,corBG);
			Switch(im, x+100,y, sequencia[i-1],corBG,dx,dy,i);
			ColocarImagemPadrao(image,"LinhaVertical", x, y);
			ColocarImagemPadrao(image,"LinhaVertical", x-70, y);
			if(MarcaObrigatoria==0)
				CriarMarcaObrigatoria(im, x-70,y);
		 }
		 
		 if((i>150) &&(i<=180))
		 {
			 
			x=450*3+70*4+dx ;
			y=70*(i-151)+dy + 70 *20;
			if(i==151)
				 GerarTopo(image,x-70, y-70);
			GerarNumero(im,i,x, y,corBG);
			Switch(im, x+100,y, sequencia[i-1],corBG,dx,dy,i);
			ColocarImagemPadrao(image,"LinhaVertical", x, y);
			ColocarImagemPadrao(image,"LinhaVertical", x-70, y);
			if(MarcaObrigatoria==0)
				CriarMarcaObrigatoria(im, x-70,y);
		 }
		 
		}
		x= 450*3+ 70*3 + dx +200;
		y= dy-70;
		GerarMatricula(image,x, y);
	}
	
	public static void Switch(BufferedImage im, int x,int  y,int questao, int corBG, int dx, int dy, int numero)
	{
		switch (questao)
		{
		case 1:
			GerarA(im,x,y,corBG);// tipo a
			break;
		case 2:
			GerarB(im,x,y,corBG,dx,dy, numero);// tipo b
			flagB++;
			break;
		case 3:
			GerarC(im,x,y,corBG); // tipo c
			break;
		case 4: 
			GerarCl(im,x,y,corBG);// tipo c'
			break;
		case 5: 
			GerarD(im,x,y,corBG,dx,dy, numero);// tipo d
			break;
		}
	}
	
	 public static void GerarA(BufferedImage im, int x,int  y, int corBG){
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_C",x+70*0, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_E",x+70*1, y);
	
	 }
	 public static void GerarB(BufferedImage im, int x,int  y, int corBG, int dx, int dy, int nq){
		 ColocarImagemPadrao(image,"PalavraBG_"+corBG+"TipoB",x+70*1, y);
		 
		 if( flagB <3)
		 {
		 x= 450*3+ 70*3 + dx +200;
		 y = 70*11 +dy + flagB*70*12 ;
		 
		 
		 ColocarImagemPadrao(image,"PalavraItem",x, y);
		 GerarNumero(im,nq,x+100, y,1);
		 CriarMarcaObrigatoria(im,x-90,y+70);
		 CriarMarcaObrigatoria(im,x-90,y+70*6);
		  for (int i =0; i < 10; i++)
				 for(int j =0 ; j<3;j++)
			 ColocarImagemPadrao(image,"Circulo"+i ,x+70*j, y+ 70*(i+1));
		  
		  ColocarImagemPadrao(image,"LinhaHorizontal210",x, y);
		  ColocarImagemPadrao(image,"LinhaVertical770",x, y);
			 ColocarImagemPadrao(image,"LinhaVertical770",x+ 70*3, y);
		 }
		 
		 if( flagB >=3)
		 {
		 x= 450*3+ 70*3 + dx +200 +70*6;
		 y = 70*11 +dy + (flagB-3)*70*12 ;
		 
		 
		 ColocarImagemPadrao(image,"PalavraItem",x, y);
		 GerarNumero(im,nq,x+100, y,1);
		 CriarMarcaObrigatoria(im,x-90,y+70);
		 CriarMarcaObrigatoria(im,x-90,y+70*6);
		 ColocarImagemPadrao(image,"LinhaVertical770",x-90-45+5, y);
		 ColocarImagemPadrao(image,"LinhaVertical770",x-90-45, y);
		 ColocarImagemPadrao(image,"LinhaVertical770",x-90-45-5, y);
		  for (int i =0; i < 10; i++)
				 for(int j =0 ; j<3;j++)
			 ColocarImagemPadrao(image,"Circulo"+i ,x+70*j, y+ 70*(i+1));
		  
		  ColocarImagemPadrao(image,"LinhaHorizontal210",x, y);
		  ColocarImagemPadrao(image,"LinhaVertical770",x, y);
			 ColocarImagemPadrao(image,"LinhaVertical770",x+ 70*3, y);
		 }
		 
	 }
	 public static void GerarC(BufferedImage im, int x,int  y, int corBG){
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_A",x+70*0, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_B",x+70*1, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_C",x+70*2, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_D",x+70*3, y);
		  
	 }
	 public static void GerarCl(BufferedImage im, int x,int  y, int corBG){
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_A",x+70*0, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_B",x+70*1, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_C",x+70*2, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_D",x+70*3, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_E",x+70*4, y);
		 
	 }
	 

	 public static void GerarD(BufferedImage im, int x,int  y, int corBG, int dx, int dy, int nq){
		 ColocarImagemPadrao(image,"PalavraBG_"+corBG+"TipoD",x+70*1+30, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_C",x+70*0, y);
		 ColocarImagemPadrao(image,"CirculoBG"+corBG+"_E",x+70*1, y);
	 }
	 
	 public static void GerarTopo(BufferedImage im, int x,int  y){
		 CriarMarcaObrigatoria(im, x, y);
		 ColocarImagemPadrao(image,"PalavraItem",x+80, y);
		 ColocarImagemPadrao(image,"PalavraResposta",x+170, y);
		 ColocarImagemPadrao(image,"LinhaHorizontal",x+70, y);
	 }
	 
	 public static void GerarMatricula(BufferedImage im, int x,int  y){
		 ColocarImagemPadrao(image,"PalavraMatricula",x, y-70);
		 
		 for(int i=0;i<tamanhoMatricula;i++)
		 ColocarImagemPadrao(image,"LinhaHorizontal70",x+i*70, y);
		 
		 for(int i=0;i<tamanhoMatricula;i++)
		 {
			 ColocarImagemPadrao(image,"LinhaVertical",x+(i+1)*70, y);
		 }
		
		 
		
		 
		 CriarMarcaObrigatoria(image,x-90,y+70);
		 CriarMarcaObrigatoria(image,x-90,y+70*6);
		  for (int i =0; i < 10; i++)
			 for(int j =0 ; j<tamanhoMatricula;j++)
		 ColocarImagemPadrao(image,"Circulo"+i ,x+70*j, y+ 70*(i+1));
		  
		  ColocarImagemPadrao(image,"LinhaVertical770",x+70*tamanhoMatricula, y);
			 ColocarImagemPadrao(image,"LinhaVertical770",x, y);
		 
	 
	 }
	 
	
	 
	 public static void CriarMarcaObrigatoria(BufferedImage im, int x,int  y) 
	    {
	    	// cria marcaObrigatorias tendo como referencia a ponta esquerda superior X,Y
	    	Color MarcaR = new Color(0,0,0);
	    	for(int i =0 ; i< 70; i++)
	    	{
	    		for(int j= 0; j< 70; j++)
	    		im.setRGB(x+i,y+j , MarcaR.getRGB());
	    	}
	    	
	    }
	 public static void CriarMarcaVermelhoEscuro(BufferedImage im, int x,int  y) 
	    {
	    	// cria marcaObrigatorias tendo como referencia a ponta esquerda superior X,Y
	    	Color MarcaR = new Color(177,59,73);
	    	for(int i =0 ; i< 70; i++)
	    	{
	    		for(int j= 0; j< 70; j++)
	    		im.setRGB(x+i,y+j , MarcaR.getRGB());
	    	}
	    	
	    } public static void CriarMarcaVermelhoClaro(BufferedImage im, int x,int  y) 
	    {
	    	// cria marcaObrigatorias tendo como referencia a ponta esquerda superior X,Y
	    	Color MarcaR = new Color(239,211,210);
	    	for(int i =0 ; i< 70; i++)
	    	{
	    		for(int j= 0; j< 70; j++)
	    		im.setRGB(x+i,y+j , MarcaR.getRGB());
	    	}
	    	
	    } 
	 
	 
	 public static void ExtraObrigatoria(BufferedImage im, int x, int y)
	 {
		 // marcas nas bordas da folha
		 int LimiteHorizontal= im.getWidth();
		 int LimiteVertical = im.getHeight();
		 
		 CriarMarcaObrigatoria(im,50,0 );// esquina superior esquerda
		 CriarMarcaVermelhoClaro(im,50,70 );
		 CriarMarcaVermelhoEscuro(im,50,70*2);
		 CriarMarcaObrigatoria(im,LimiteHorizontal-70,LimiteVertical -70);// esquina inferior direita
		 
		
		 CriarMarcaObrigatoria(im,50,y -70);// primeira linha que contem uma obrigatoria
		
		 CriarMarcaObrigatoria(im, 450*3+ 70*5 +x +200-30,0);
		 
		 
		 
		 
	 }
	 public static void CriarLinhasVermelhas(BufferedImage im, int x,int  y) 
	    {
	    	// cria linhas Vermelhas tendo como referencia a ponta esquerda superior X,Y
	    	Color Marca = new Color(239,211,210);
	    	
	    	for (int linha=0;linha< 50;linha ++ )
	    	{
	    	 if(linha%2==0)
	    	 {
	    	  for(int i =0 ; i< 2400; i++)
	    	  {
	     	 	for(int j= 0; j< 70; j++)
	     	 	im.setRGB(x+i,y+j + linha*70, Marca.getRGB());
	     	  }
	     	 }
	     	}
	    	
	    }
	 public static void GerarNumero(BufferedImage im,int numero, int x, int y,int corBG)
	 {
		 
		 int centena, dezena, unidade;
		 
		 centena = numero/100;
		 numero -= centena*100;
		 dezena= numero/10;
		 numero-=dezena*10;
		 unidade=numero;
		 
		 
		 System.out.println("C: "+ centena+" D: " + dezena+ " U:" +unidade );
			if(centena==0)
			{
				
				if(dezena==0)
				{
				// soh tem unidade	
					ColocarImagemPadrao(image,"NumeroBG"+corBG+"_"+unidade, x+20, y);
				}
			}
			
			if(centena==0)
			{
				
				if(dezena!=0)
				{
				// tem unidade e dezena
					ColocarImagemPadrao(image,"NumeroBG"+corBG+"_"+dezena,x+20 ,y );
					ColocarImagemPadrao(image,"NumeroBG"+corBG+"_"+unidade,x+40, y);
					
				}
			}
			
			if(centena!=0)
			{
			//tem centena,dezena e unidade 
				ColocarImagemPadrao(image,"NumeroBG"+corBG+"_"+centena,x+20 ,y );
				ColocarImagemPadrao(image,"NumeroBG"+corBG+"_"+dezena,x+40 ,y );
				ColocarImagemPadrao(image,"NumeroBG"+corBG+"_"+unidade,x+60, y);
				
			}
		 
		 
	 }
	 
	 public static void ColocarImagemPadrao(BufferedImage im,String padrao, int x, int y)
	 {
		 
		 String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
	 
	 File imagefile = new File(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/ImagensPadrao/"+ padrao+ ".jpg");
	 try {
		 imageTemp = ImageIO.read(imagefile);
		 int widthTemp = imageTemp.getWidth();
		 int heightTemp = imageTemp.getHeight();
		 	System.out.println(widthTemp+ " "+ heightTemp);
		 for(int i=0; i< widthTemp; i ++)
		 {
			 for(int j=0; j< heightTemp; j ++)
			 {
				 int RGB=  imageTemp.getRGB(i,j);
    			 Color cor= new Color(RGB);
    			 im.setRGB(x +i, y+j, cor.getRGB());
				 
			 }
		 }
		 	 	 
	 } catch (IOException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }
	 }

	 public static void ColocarCabecalho(BufferedImage im, int x, int y)
	 {
		 // obtem um cabecalho que deve estar  no diretorio abaixo
		 // este cabecalho deve ter 2280 x 300 pixels 
		 
		 String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
	
		 
	 File imagefile = new File(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/cabecalho.jpg");
	 try {
		 imageTemp = ImageIO.read(imagefile);
		 int widthTemp = imageTemp.getWidth();
		 int heightTemp = imageTemp.getHeight();
		 	System.out.println(widthTemp+ " "+ heightTemp);
		 for(int i=0; i< widthTemp; i ++)
		 {
			 for(int j=0; j< heightTemp; j ++)
			 {
				 int RGB=  imageTemp.getRGB(i,j);
    			 Color cor= new Color(RGB);
    			 im.setRGB(x +i, y+j, cor.getRGB());
				 
			 }
		 }
		 
		 
		 
	 } catch (IOException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }
	 
	 	
	 
	 }
	 
	 
	 public static void MontarCabecalho()
	 {//montar o cabecalho de acordo com o padrao 2280x300 pixel
	  // utilizando as imagens presentes na pasta C:\Cartao\ImagensPadrao\Cabecalho
	  // e as intrucoes no arquivo cabecalho
      // que segue o padrao:
		 //Série -> 1EM , 2EM, 3EM, 9EF, 8EF, 7EF, 6EF
		 //tipo prova -> I (Interdisciplinar), S (Simulado)
		 //bimestre -> 1,2,3,4
		 //ano -> 2013, 2014, 2015, 2016, 2017
		 //dia  -> 0,1,2 (prova unica, 1º dia ,2º dia) 
		 BufferedImage imageCabecalho = null;
		 String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
		
		 File imagefile = new File(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/ImagensPadrao/Cabecalho/Branco.jpg");
		 try {
		 	imageCabecalho = ImageIO.read(imagefile);
		 } catch (IOException e) {
		 	// TODO Auto-generated catch block
		 	e.printStackTrace();
		 }
		 int x=0,y=0;
		 String variaveis[]= new String [6];
		 variaveis =LerInstrucao();
		 tamanhoMatricula= Integer.parseInt(variaveis[5]);
		 //variaveis[0]= "2EM";
		 //variaveis[1]="S";
		 //variaveis[2]="4";
		 //variaveis[3]="2015";
		 //variaveis[4]=0;
		 ColocarImagemPadrao(imageCabecalho,"Cabecalho/logo",x, y);
		 ColocarImagemPadrao(imageCabecalho,"Cabecalho/NomeEscola",x+300, y);
		 ColocarImagemPadrao(imageCabecalho,"Cabecalho/Turma"+variaveis[0],x+300, y+70);
		 ColocarImagemPadrao(imageCabecalho,"Cabecalho/"+variaveis[1],x+300+900, y+70);
		 ColocarImagemPadrao(imageCabecalho,"Cabecalho/LinhaVermelha",x+300, y+70*2);
		 ColocarImagemPadrao(imageCabecalho,"Cabecalho/"+variaveis[2]+"Bimestre",x+300, y+70*2);
		 ColocarImagemPadrao(imageCabecalho,"Cabecalho/"+variaveis[3]+"Ano",x+300+ 250, y+70*2);
		 ColocarImagemPadrao(imageCabecalho,"Cabecalho/"+variaveis[4]+"Dia",x+300+ 250 + 800, y+70*2);
		 ColocarImagemPadrao(imageCabecalho,"Cabecalho/NomeAluno",x+300, y+70*3+10);
		 
		 GerarImagemCartao(imageCabecalho, "cabecalho");
		 
				 
		 
	 }
	 
	 
	 public static String[] LerInstrucao()
	 {
		 String retorno[] = new String[6];
		 String temp;
		 BufferedReader bReader ;
		 
	    FileReader fileConfig;
	    	
	    	
			try {
				 String enderecoDrop = System.getProperty("user.home");
					System.out.println(enderecoDrop);
				fileConfig = new FileReader(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/InstrucaoCabecalho.txt");
			   	bReader = new BufferedReader(fileConfig);
			   	
				for (int i=0; i< 6;i++)
				{
				temp=  bReader.readLine();
				retorno[i]= temp; 
				}
				bReader.close();
							
				}
	    	 catch (IOException e) {
					e.printStackTrace();
				}
			
		 
		 return retorno;
	 }
	 
	 public static void ObterModeloBranco()
	 {// le o moedelo em branco para obter o tamanho da folha que ira ser trabalhada
		 
		 String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
		 
	 File imagefile = new File(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/ImagensPadrao/ModeloBranco.jpg");
	 try {
		 
		 
	 	image = ImageIO.read(imagefile);
	 } catch (IOException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }
	 	
	 }
	 
	 public static void ObterModeloBrancoAluno() // gerar um novo arquivo no tamanho padrao para gerar o cartao de resposta do aluno
	 {// le o moedelo em branco para obter o tamanho da folha que ira ser trabalhada
		 
		 String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
		 
	 File imagefile = new File(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/ImagensPadrao/ModeloBranco.jpg");
	 try {
		
		 
	 	imageAluno = ImageIO.read(imagefile);
	 } catch (IOException e) {
	 	// TODO Auto-generated catch block
	 	e.printStackTrace();
	 }
	 	
	 }
	 
	 

	 
	 
	 public static void GerarImagemCartao(BufferedImage image, String nome)
	    {
	    // salvao o cartao de resposta com o nome desejado
		 
		 
		 
		 if(nome!="cabecalho") // se o arquivo que será gerado nao for do cabecalho e sim de cada turma
		 {
			 
			 String[] sequencia= new String[4]; 
			 sequencia = nome.split("_");
			 System.out.println(nome);
			 System.out.println(sequencia[0]);
			 System.out.println(sequencia[1]);
			 System.out.println(sequencia[2]);
			 System.out.println(sequencia[3]);
			 
			 
			// gerar o arquivo Coringa para provas repetidas e o gabarito
	    	  try { 
	              //you can either use URL or File for reading image using ImageIO
	    		  String enderecoDrop = System.getProperty("user.home");
					System.out.println(enderecoDrop);
				String completo = enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/Cartoes/00 "+sequencia[2]+"o Bimestre/"+ nome+"/"+nome+ ".jpg";
				System.out.println(completo);
	            File imagefile = new File(completo);
	            ImageIO.write(image,"jpg",imagefile);
	               } catch (IOException e) {
	              e.printStackTrace();
	        }
	    	  
	    	// gerar o arquivo de cada aluno
	    	
	              //you can either use URL or File for reading image using ImageIO
	    		  
	    		  // Obtem a lista de alunos da escola todo
	    		  String [] lista;
	    		  mostrarLista = new MostrarLista();
	    		  mostrarLista.removerVazio();
					 lista = mostrarLista.getLista();
					 
					 
					 System.out.println("aluno presentes na série :" + sequencia[0]);
					 for(int i=0;i<lista.length;i++) // loop para obter os alunos da turma presente no "nome"
						{
						 	//System.out.println(lista[i]);
						 	String[] temp = lista[i].split("\t");
						 	
						 	System.out.println(temp[2]); 
						 	System.out.println(sequencia[0]); 
							if(temp[2].contentEquals(sequencia[0]))// caso o aluno for da turma que esta sendo gerado o gabarito
								{
								String enderecoDrop = System.getProperty("user.home");
								String completo = enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/Cartoes/00 "+sequencia[2]+"o Bimestre/"+ nome+"/"+temp[0] +" "+temp[1]+".jpg";
								System.out.println(completo);
								
								// gerar um novo arquivo para o aluno SEM SOBREESCRVER o arquivo que já estava no buffer
								ObterModeloBrancoAluno(); 
								 try {
									 completo = enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/Cartoes/00 "+sequencia[2]+"o Bimestre/"+ nome+"/"+nome+ ".jpg";
								 
									 File imagefile2 = new File(completo);
								 
									 imageTemp = ImageIO.read(imagefile2);
									 int widthTemp = imageTemp.getWidth();
									 int heightTemp = imageTemp.getHeight();
									 	System.out.println(widthTemp+ " "+ heightTemp);
									 for(int k=0; k< widthTemp; k ++)
									 {
										 for(int j=0; j< heightTemp; j ++)
										 {
											 int RGB=  imageTemp.getRGB(k,j);
							    			 Color cor= new Color(RGB);
							    			 imageAluno.setRGB(0+k,0+j, cor.getRGB());
											 
										 }
									 }
								
								EscreverNomeAluno(imageAluno, temp[0], temp[1]);
								EscreverMatriculaAluno(imageAluno, temp[0], temp[1]);
								 completo = enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/Cartoes/00 "+sequencia[2]+"o Bimestre/"+ nome+"/"+temp[0] +" "+temp[1]+".jpg";
									  File imagefile = new File(completo);
								ImageIO.write(imageAluno,"jpg",imagefile);
								  } catch (IOException e) {
						              e.printStackTrace();
						              
								}
						}
					

	    		  
	              
	        }
	    	  
	    	  
	    	  
		 }
	    if(nome=="cabecalho") 
	    {
	    	  try {
	              //you can either use URL or File for reading image using ImageIO
	    		  String enderecoDrop = System.getProperty("user.home");
					System.out.println(enderecoDrop);
	            File imagefile = new File(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/"+ nome+ ".jpg");
	            ImageIO.write(image,"jpg",imagefile);
	               } catch (IOException e) {
	              e.printStackTrace();
	        }
	    }
	    
	    }
	 
	 public static void EscreverNomeAluno(BufferedImage imageAluno, String nomeAluno, String Matricula)
	 {
	int tamanhoNome =nomeAluno.length();
		for(int i =0; i<tamanhoNome; i++)
		{
			System.out.println(nomeAluno.charAt(i));
			String letra=nomeAluno.charAt(i)+"";
			letra.toUpperCase();
			letra = removeAccents(letra);
			if(letra!=" ")
				ColocarImagemPadrao(imageAluno,"alfabeto/"+letra ,660+ 30*i, 220);
			if(letra==" ")
				ColocarImagemPadrao(imageAluno,"alfabeto/ESPACO" ,660+ 30*i, 220);
		}
	 	
	 }
	 
	 
	 public static void EscreverMatriculaAluno(BufferedImage imageAluno, String nomeAluno, String matricula)
	 {
	
	 	int x=1960;
	 	int y=370;
	 	int[] casaDecimal = new int[9];
	 	int dx=tamanhoMatricula-matricula.length();
	 	
	 	
	 	
	 	
	 	for(int i=0; i<matricula.length();i++) // loop pelas colunas da matricula para adicionar as marcacoes preenchidas
	 	{
	 		String digitoRodada= matricula.charAt(i)+"";
	 		casaDecimal[i] = Integer.parseInt(digitoRodada);
	 		int umOuDois= (casaDecimal[i]+1)%2+1 ;


	 		ColocarImagemPadrao(imageAluno,"CirculoCheioBG"+ umOuDois ,x+ 70*(i+dx) , y+70*casaDecimal[i] );
	 	}
	 }
	 
	 
	 
	 
	 public static int[] LerBaseGabarito(String nome) // le a arquivo da base do gabarito e retorna um vetor com a sequencia para gerar a imagem 
	    {
	    	/* --------------------
			 * tipo A - codigo :1-> C E                 2 opcoes  
			 * tipo B - codigo :2-> valor 000- 999       30 opcoes
			 * tipo C - codigo :3-> A B C D	   4 opcoes	
			 * tipo C'- codigo :4-> A B C D E   5 opcoes 
			 * tipo D - codigo :5-> Dissertativa 2 opcoes
			 * 
			 */
	    	

			
			
		 
		 
	    	BufferedReader bReader ;
	    	FileReader fileConfig;
	    	int[] questoes = new int[1];
	    	int nq=0;
			try {
				 String enderecoDrop = System.getProperty("user.home");
					System.out.println(enderecoDrop);
				fileConfig = new FileReader(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/Bases/" + nome+ ".txt");
			   	bReader = new BufferedReader(fileConfig);
			   	//nq=  Integer.parseInt(bReader.readLine());
			  
			   
			   	
				nq= Integer.parseInt(bReader.readLine());
				
				
				questoes = new int[nq];
				for (int i=0; i< nq;i++)
				{
				String[] temp = new String[3];
				temp = bReader.readLine().split("\t");
				questoes[i]= Integer.parseInt(temp[1]); // obtem os tipos das questoes
				
				}
				bReader.close();
							
				}
	    	 catch (IOException e) {
					e.printStackTrace();
				}
			
	for ( int k= 0; k<questoes.length; k++)
		System.out.println(questoes[k]);
	
			return questoes;
			
	    	
	    }
	 
	 public static int[] LerBaseGabaritoMaterias(String nome) // le a arquivo da base do gabarito e retorna um vetor com a sequencia para gerar a imagem 
	    {
	    	/* --------------------
			 * tipo A - codigo :1-> C E                 2 opcoes  
			 * tipo B - codigo :2-> valor 000- 999       30 opcoes
			 * tipo C - codigo :3-> A B C D	   4 opcoes	
			 * tipo C'- codigo :4-> A B C D E   5 opcoes 
			 * tipo D - codigo :5-> Dissertativa 2 opcoes
			 * 
			 */
	    	

			
			
		 
		 
	    	BufferedReader bReader ;
	    	FileReader fileConfig;
	    	int[] questoes = new int[1];
	    	int nq=0;
			try {
				 String enderecoDrop = System.getProperty("user.home");
					System.out.println(enderecoDrop);
				fileConfig = new FileReader(enderecoDrop+"/Dropbox/Corretor" + escola +"/Cartao/Bases/" + nome+ ".txt");
			   	bReader = new BufferedReader(fileConfig);
			   	//nq=  Integer.parseInt(bReader.readLine());
			  
			   	
				nq= Integer.parseInt(bReader.readLine());
				
				questoes = new int[nq];
				for (int i=0; i< nq;i++)
				{
				String[] temp = new String[3];
				temp = bReader.readLine().split("\t");
				questoes[i]= Integer.parseInt(temp[2]); // obtem as materias das questoes
				
				}
				bReader.close();
							
				}
	    	 catch (IOException e) {
					e.printStackTrace();
				}
			
	for ( int k= 0; k<questoes.length; k++)
		System.out.println(questoes[k]);
	
			return questoes;
			
	    	
	    }
	 // codigo obtido em https://stackoverflow.com/questions/8523631/remove-accents-from-string
	 public static String removeAccents(String value) // funcao de remover acento nas letras recebidas... !!thanks stackoverFlow 
	 {
	     if (MAP_NORM == null || MAP_NORM.size() == 0)
	     {
	         MAP_NORM = new HashMap<Character, Character>();
	         MAP_NORM.put('À', 'A');
	         MAP_NORM.put('Á', 'A');
	         MAP_NORM.put('Â', 'A');
	         MAP_NORM.put('Ã', 'A');
	         MAP_NORM.put('Ä', 'A');
	         MAP_NORM.put('È', 'E');
	         MAP_NORM.put('É', 'E');
	         MAP_NORM.put('Ê', 'E');
	         MAP_NORM.put('Ë', 'E');
	         MAP_NORM.put('Í', 'I');
	         MAP_NORM.put('Ì', 'I');
	         MAP_NORM.put('Î', 'I');
	         MAP_NORM.put('Ï', 'I');
	         MAP_NORM.put('Ù', 'U');
	         MAP_NORM.put('Ú', 'U');
	         MAP_NORM.put('Û', 'U');
	         MAP_NORM.put('Ü', 'U');
	         MAP_NORM.put('Ò', 'O');
	         MAP_NORM.put('Ó', 'O');
	         MAP_NORM.put('Ô', 'O');
	         MAP_NORM.put('Õ', 'O');
	         MAP_NORM.put('Ö', 'O');
	         MAP_NORM.put('Ñ', 'N');
	         MAP_NORM.put('Ç', 'C');
	         MAP_NORM.put('ª', 'A');
	         MAP_NORM.put('º', 'O');
	         MAP_NORM.put('§', 'S');
	         MAP_NORM.put('³', '3');
	         MAP_NORM.put('²', '2');
	         MAP_NORM.put('¹', '1');
	         MAP_NORM.put('à', 'a');
	         MAP_NORM.put('á', 'a');
	         MAP_NORM.put('â', 'a');
	         MAP_NORM.put('ã', 'a');
	         MAP_NORM.put('ä', 'a');
	         MAP_NORM.put('è', 'e');
	         MAP_NORM.put('é', 'e');
	         MAP_NORM.put('ê', 'e');
	         MAP_NORM.put('ë', 'e');
	         MAP_NORM.put('í', 'i');
	         MAP_NORM.put('ì', 'i');
	         MAP_NORM.put('î', 'i');
	         MAP_NORM.put('ï', 'i');
	         MAP_NORM.put('ù', 'u');
	         MAP_NORM.put('ú', 'u');
	         MAP_NORM.put('û', 'u');
	         MAP_NORM.put('ü', 'u');
	         MAP_NORM.put('ò', 'o');
	         MAP_NORM.put('ó', 'o');
	         MAP_NORM.put('ô', 'o');
	         MAP_NORM.put('õ', 'o');
	         MAP_NORM.put('ö', 'o');
	         MAP_NORM.put('ñ', 'n');
	         MAP_NORM.put('ç', 'c');
	     }

	     if (value == null) {
	         return "";
	     }

	     StringBuilder sb = new StringBuilder(value);

	     for(int i = 0; i < value.length(); i++) {
	         Character c = MAP_NORM.get(sb.charAt(i));
	         if(c != null) {
	             sb.setCharAt(i, c.charValue());
	         }
	     }

	     return sb.toString();

	 }
	 
	 
	 
	 
}
