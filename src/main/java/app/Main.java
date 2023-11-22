package app;
import classes.Cliente;
import classes.ContaCorrente;
import classes.ContaPoupanca;
import classes.Genero;

public class Main {

	public static void main(String[] args) {

		Cliente c1 = new Cliente("ANDRÉ ALVES", "1111", Genero.HOMEM, "11/04/1987", 5000);
		Cliente c2 = new Cliente("WILLYAN CAETANO", "2222", Genero.HOMEM, "01/01/1990", 20000);
		
		ContaCorrente cc = new ContaCorrente(c1);
		ContaPoupanca cp = new ContaPoupanca(c2);
		
		cc.depositar(100);
		cc.depositar(500);
		cc.sacar(200);
		cc.transferir(300, cp);

		cc.imprimirExtrato();
		cp.imprimirExtrato();


	}

}
