package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
	public static void main(String[] args) {
		
		String[] lines = new String[] { "Good morning", "Good afternoon", "Good night" };
		
		String path = "//home//matheus//Documentos//out.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			
			for (String line : lines) {
				bw.write(line);
				/**
				 * newLine() para dar 1 quebra de linha
				 */
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
