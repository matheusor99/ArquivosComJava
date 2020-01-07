package application;

import java.io.File;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		File[] folders = path.listFiles(File::isDirectory);
		
		System.out.println("FOLDERS:");
		
		for(File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile);
		
		System.out.println("FILES:");
		
		for (File file : files) {
			System.out.println(file);
		}
		
		/**
		 * criar uma pasta dentro do caminho passado
		 * pasta com nome novaPasta
		 */
		
		boolean success = new File(strPath +"//novaPasta").mkdir();
		System.out.println("Diretorio criado com sucesso: " + success);
		sc.close();
	}
}
