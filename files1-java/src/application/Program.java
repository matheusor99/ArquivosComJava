package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Produto;
import model.exceptions.DomainExceptions;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o numero de produtos que sera inserido: ");
		int numeroProdutos = sc.nextInt();
		
		Produto[] produtos = new Produto[numeroProdutos];
		
		for (int i = 0; i < numeroProdutos; i++) {
			System.out.println("Insira os dados do produto " + (i+1) + ":");
			System.out.print("Digite o nome do produto: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Digite o preço do(a) " + nome + ": ");
			double valor = sc.nextDouble();
			System.out.print("Digite quantas unidades de "+ nome +" possui : ");
			int unidades = sc.nextInt();
			
			try {
				Produto produto = new Produto(nome, valor, unidades);
				produtos[i] = produto;
			} catch(DomainExceptions e) {
				System.out.println("ERROR: " + e.getMessage());
				e.fillInStackTrace();
			}
		}
		
		sc.close();
		
		String pathFile = "//home//matheus//Documentos//file.csv";
		
		try (BufferedWriter br = new BufferedWriter(new FileWriter(pathFile))) {
			for(Produto produto : produtos) {
				String line = produto.getNome() + "," + String.format("%.2f", produto.getValor()) + "," + produto.getUnidades();
				br.write(line);
				br.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pathFile = "//home//matheus//Documentos";
		boolean success = new File(pathFile+"//out").mkdir();
		System.out.println("Pasta /out criada: " + success);
		
		try (BufferedWriter br = new BufferedWriter(new FileWriter(pathFile+"//out//summary.csv"))) {
			for(Produto produto : produtos) {
				String line = produto.getNome() + "," + String.format("%.2f", produto.calculoTotal());
				br.write(line);
				br.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
