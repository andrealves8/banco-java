package classes;

import java.time.LocalDate;

public class Movimentacao {
	private LocalDate data;
	private Tipo tipo;
	private double valor;

	public Movimentacao(LocalDate data, Tipo tipo, double valor) {
		this.data = data;
		this.tipo = tipo;
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

}
