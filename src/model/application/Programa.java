package model.application;

import java.util.Locale;
import java.util.Scanner;

import model.Exception.saqueInvalidoException;
import model.entities.Conta;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("------ Digite os dados da conta bancaria: ------");
		System.out.print("Numero da conta: ");
		int numeroConta = sc.nextInt();
		sc.nextLine();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Saldo da conta: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteSaque = sc.nextDouble();
		Conta conta = new Conta(numeroConta, nome, saldo, limiteSaque);
		sc.nextLine();
	
		System.out.println("------------------ Digite 1 para realizar um saque -------------------");
		System.out.println("------------------ Digite 2 para realizar um deposito ----------------");

		int auxiliar = sc.nextInt();
		
		while(auxiliar != 1 && auxiliar != 2 ) {
			System.out.print("Numero invalido digite 1 para saque ou 2 para deposito: ");
			auxiliar = sc.nextInt();
		}
		
		
		if(auxiliar == 1) {
			System.out.print("Digite o valor do saque: ");
			double valorSaque = sc.nextDouble();
			conta.saque(valorSaque);
		}
		
		else if(auxiliar == 2) {
			System.out.print("Digite o valor do deposito: ");
			double valorDeposito = sc.nextDouble();
			conta.deposito(valorDeposito);
		}
	
		System.out.println("\nAtualizacao concluida");
		System.out.println(conta);
		}
		
		catch (saqueInvalidoException e) {
			System.out.println("Impossivel realizar o saque: " + e.getMessage());
		}

		catch (IllegalArgumentException e) {
			System.out.println("Algo deu errado, verifique se os dados digitados sao validos");
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		
		
		
		
		sc.close();
	}

}
