package model.entities;

import model.Exception.saqueInvalidoException;

public class Conta {

	private Integer numero;
	private String nome;
	private Double saldo;
	private Double limiteDeRetirada;
	
	public Conta() {
		super();
	}

	public Conta(Integer numero, String nome, Double saldo, Double limiteDeRetirada) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteDeRetirada = limiteDeRetirada;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteDeRetirada() {
		return limiteDeRetirada;
	}
	
	public void saque(double quantia) throws saqueInvalidoException{
		
		if(quantia > limiteDeRetirada) {
			throw new saqueInvalidoException("Quantia excede o limite de saque da conta");
		}
		if(saldo == 0) {
			throw new saqueInvalidoException("Nao existe saldo nessa conta");
		}
		this.saldo -= quantia;
	}
	
	public void deposito(double quantia) {
		this.saldo += quantia;
	}

	@Override
	public String toString() {
		return "Saldo: " + String.format("%.2f", saldo);
	}
	
	
	
}
