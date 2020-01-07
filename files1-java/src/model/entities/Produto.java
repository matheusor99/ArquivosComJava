package model.entities;

import model.exceptions.DomainExceptions;

public class Produto {

	private String nome;
	private Double valor;
	private Integer unidades;
	private Double valorTotal;
	
	public Produto(String nome, Double valor, Integer unidades) {
		if(valor <= 0) {
			throw new DomainExceptions("Preço do Produto abaixo de R$ 0");
		}
		if(unidades < 0) {
			throw new DomainExceptions("O numero de unidades não pode ser abaixo de 0");
		}
		
		this.nome = nome;
		this.valor = valor;
		this.unidades = unidades;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		if(valor <= 0) {
			throw new DomainExceptions("Preço do Produto abaixo de R$ 0");
		}
		this.valor = valor;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		if(unidades < 0) {
			throw new DomainExceptions("O numero de unidades não pode ser abaixo de 0");
		}
		this.unidades = unidades;
	}

	public String getNome() {
		return nome;
	}
	
	public Double calculoTotal() {
		valorTotal = valor * unidades;
		return valorTotal;
	}
}
