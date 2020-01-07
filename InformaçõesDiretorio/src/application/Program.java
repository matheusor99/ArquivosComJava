package application;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		//pegar o nome do arquivo
		System.out.println("getName: " + path.getName());
		
		//pegar apenas o caminho até o arquivo
		System.out.println("getParent: " + path.getParent());
		
		//pegar o caminho por completo inclusive o nome do arquivo
		System.out.println("getPath: " + path.getPath());
		sc.close();
	}

}
