package classes;

public class Movimentacao {
	private String dataAtual;
	private Tipo tipo;
	private double valor;

	public Movimentacao(String dataAtual, Tipo tipo, double valor) {
		this.dataAtual = dataAtual;
		this.tipo = tipo;
		this.valor = valor;
	}

	public String getDataAtual() {
		return dataAtual;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

}
