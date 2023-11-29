package app;

import java.time.LocalDate;

import classes.Cliente;
import classes.ContaCorrente;
import classes.ContaPoupanca;
import classes.Genero;
import classes.ValorNegativoException;

public class Main {

	public static void main(String[] args) throws ValorNegativoException {

		Cliente cliente1 = new Cliente("ANDRÉ", "1111", Genero.HOMEM, LocalDate.of(1987, 4, 11), 5000);
		Cliente cliente2 = new Cliente("JOÃO", "2222", Genero.HOMEM, LocalDate.of(2010, 1, 1), 12000);
		Cliente cliente3 = new Cliente("MARIA", "3333", Genero.MULHER, LocalDate.of(2000, 1, 1), 20000);

		ContaPoupanca andre = new ContaPoupanca(cliente1);
		ContaCorrente joao = new ContaCorrente(cliente2);
		ContaCorrente maria = new ContaCorrente(cliente3);

		andre.depositar(1000);

		try {
			andre.sacar(20);
			andre.sacar(20); 
			andre.sacar(0);
			andre.sacar(100);
			andre.sacar(100);
			andre.sacar(0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} 

		andre.imprimirExtrato();
		// joao.imprimirExtrato();
		// maria.imprimirExtrato();

	}

}
