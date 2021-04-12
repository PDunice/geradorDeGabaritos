import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class MostrarLista {

	/**
	 * 
	 */
		int nLinhas=0;
	String[] lista;
	static String escola = "";
	
	
	

	/**
	 * Create the frame.
	 */
	public MostrarLista() {
		
		nLinhas = this.getnLinhas();
		lista= new String[nLinhas];
		try{
			String Lista="";
			String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
			FileReader entrada= new FileReader(enderecoDrop+"/Dropbox/Corretor"+ escola+"/Main/lista.txt");
			BufferedReader lerArq = new BufferedReader(entrada);
			int i=0;
			
			while(i<nLinhas) // faz a contagem ateh o fim do arquivo
			{
				String temp =lerArq.readLine();
				lista[i] = temp;
				Lista+=temp + "\n";
		     	i++;
			}
			System.out.println("Numero de alunos presentes na lista: "+ nLinhas);
			
			lerArq.close();
			entrada.close();
			
		}	catch(IOException e) { // caso algum erro tosco apareça
			 System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
				      }
		
		
	}
	
		
	

	
	
	public void contarLinhas() // metodo que conta quantas nomes tem na lista
	{
		try{
			String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
			FileReader entrada= new FileReader(enderecoDrop+"/Dropbox/Corretor"+ escola+"/Main/lista.txt");
			BufferedReader lerArq = new BufferedReader(entrada);
			nLinhas=0;
			while(lerArq.readLine()!=null) // faz a contagem ateh o fim do arquivo
			nLinhas++;
			
			System.out.println(nLinhas);
			
			lerArq.close();
			entrada.close();
		}	catch(IOException e) { // caso algum erro tosco apareça
			 System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
				      }
		
	}
	public int getnLinhas() {
		contarLinhas();
		return nLinhas;
	}
	public String[] getLista()
	{
		return lista;
		
	}
	
	
	public void removerVazio()
	{
		nLinhas = this.getnLinhas();
		String listaM="";
		try{
			String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
			FileReader entrada= new FileReader(enderecoDrop+"/Dropbox/Corretor"+ escola+"/Main/lista.txt");
			BufferedReader lerArq = new BufferedReader(entrada);
			int i=0;
			
			while(i<nLinhas) // faz a contagem ateh o fim do arquivo
			{
				
					
				String temp =lerArq.readLine();
				if(temp!=" ")
				listaM += temp+"\n";
				i++;
			}
			System.out.println(nLinhas);
						lerArq.close();
			entrada.close();
			
		}	catch(IOException e) { // caso algum erro tosco apareça
			 System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
				      }
		
		
			try{ // criar a nova lista
				String enderecoDrop = System.getProperty("user.home");
				System.out.println(enderecoDrop);
			FileWriter saida = new FileWriter(enderecoDrop+"/Dropbox/Corretor"+ escola+"/Main/lista.txt"); // incrementa o arquivo lista.txt
			PrintWriter escArq = new PrintWriter(saida);
			
				escArq.print(listaM);
			

			
			escArq.close();
			saida.close();
			
			}catch(IOException e) {
			    System.err.printf("Erro na abertura do arquivo: %s.\n",
			            e.getMessage());
			      }
		
		
		
		
		
	}
	

	
public void MostrarListaTurma() {
		
		nLinhas = this.getnLinhasTurma();
		lista= new String[nLinhas];
		try{
			String Lista="";
			String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
			FileReader entrada= new FileReader(enderecoDrop+"/Dropbox/Corretor"+ escola+"/Main/listaTurma.txt");
			BufferedReader lerArq = new BufferedReader(entrada);
			int i=0;
			
			while(i<nLinhas) // faz a contagem ateh o fim do arquivo
			{
				String temp =lerArq.readLine();
				lista[i] = temp;
				Lista+=temp + "\n";
		     	i++;
			}
			System.out.println("Numero de alunos presentes na lista: "+ nLinhas);
			
			lerArq.close();
			entrada.close();
			
		}	catch(IOException e) { // caso algum erro tosco apareça
			 System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
				      }
		
		
	}



public void removerVazioTurma()
{
	nLinhas = this.getnLinhasTurma();
	String listaM="";
	try{
		String enderecoDrop = System.getProperty("user.home");
		System.out.println(enderecoDrop);
		FileReader entrada= new FileReader(enderecoDrop+"/Dropbox/Corretor"+ escola+"/Main/listaTurma.txt");
		BufferedReader lerArq = new BufferedReader(entrada);
		int i=0;
		
		while(i<nLinhas) // faz a contagem ateh o fim do arquivo
		{
			
				
			String temp =lerArq.readLine();
			if(temp!=" ")
			listaM += temp+"\n";
			i++;
		}
		System.out.println(nLinhas);
					lerArq.close();
		entrada.close();
		
	}	catch(IOException e) { // caso algum erro tosco apareça
		 System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			      }
	
	
		try{ // criar a nova lista
			String enderecoDrop = System.getProperty("user.home");
			System.out.println(enderecoDrop);
		FileWriter saida = new FileWriter(enderecoDrop+"/Dropbox/Corretor"+ escola+"/Main/listaTurma.txt"); // incrementa o arquivo lista.txt
		PrintWriter escArq = new PrintWriter(saida);
		
			escArq.print(listaM);
		

		
		escArq.close();
		saida.close();
		
		}catch(IOException e) {
		    System.err.printf("Erro na abertura do arquivo: %s.\n",
		            e.getMessage());
		      }
	
	
	
	
	
}
	
	
public String[] getListaTurma()
{
	
	MostrarListaTurma();
	return lista;
	
}
	

public void limparTurma()
{
	try{ 
		String enderecoDrop = System.getProperty("user.home");
		System.out.println(enderecoDrop);
		FileWriter saida = new FileWriter(enderecoDrop+"/Dropbox/Corretor"+ escola+"/Main/listaTurma.txt"); //cria um novo  arquivo listaTurma.txt em branco
		PrintWriter escArq = new PrintWriter(saida);

	}catch(IOException e) {
	    System.err.printf("Erro na abertura do arquivo: %s.\n",
	            e.getMessage());
	      }	


}


public int getnLinhasTurma() {
	contarLinhasTurma();
	return nLinhas;
}


public void contarLinhasTurma() // metodo que conta quantas nomes tem na lista
{
	try{
		String enderecoDrop = System.getProperty("user.home");
		System.out.println(enderecoDrop);
		FileReader entrada= new FileReader(enderecoDrop+"/Dropbox/Corretor"+ escola+"/Main/listaTurma.txt");
		BufferedReader lerArq = new BufferedReader(entrada);
		nLinhas=0;
		while(lerArq.readLine()!=null) // faz a contagem ateh o fim do arquivo
		nLinhas++;
		
		System.out.println("linhas no lista turma : "+nLinhas);
		
		lerArq.close();
		entrada.close();
	}	catch(IOException e) { // caso algum erro tosco apareça
		 System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			      }
	
}
	
	
	
	
}
