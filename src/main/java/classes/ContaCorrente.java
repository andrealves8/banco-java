package classes;


public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	public void imprimirExtrato() {
		super.imprimirExtrato("Conta Corrente");
	}

}
