package classes;


public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	public void imprimirExtrato() {
		super.imprimirExtrato("Conta Poupança");
	}

}
