package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
	
	public static void main(String[] args) {
		
		String path = "//home//matheus//Documentos//in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			/**
			 * este line irá ler 1 linha do arquivo, se o arquivo ja tiver no final e n tiver mais linhas
			 * ele vai retornar null, e se ainda tiver ele vai ler as linhas 1 por 1
			 */
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
