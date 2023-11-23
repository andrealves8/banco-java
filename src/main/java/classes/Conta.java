package classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Conta {
	private static final int AGENCIA = 332;
	private String numero = new GeradorDeContas().numeroGerado;
	private double saldo;
	private Cliente cliente;
	private Tipo tipo;
	private int qtdSaque = 0;
	private int qtdTransferencia = 0;
	private List<String> logs = new ArrayList<>();

	LocalDate localDate = LocalDate.now();
	DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String data = localDate.format(dataFormatada);

	private List<Movimentacao> movimentacoes = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.cliente = cliente;
	}

	public void depositar(double valor) {
		if (valor > -1) {
			saldo += valor;
			movimentacoes.add(new Movimentacao(LocalDate.now(), Tipo.CREDITO, valor));
		}

	}

	public void sacar(double valor) {
		cliente.validarLimiteMaxMovimentacao();

		if (qtdSaque < cliente.getLimiteMaxSaque()) {

			if (valor >= 10) {

				if (saldo > valor) {
					saldo -= valor;
					movimentacoes.add(new Movimentacao(LocalDate.now(), Tipo.DEBITTO, valor));
					qtdSaque++;
					logs.add("Saque " + (qtdSaque) + " realizado com sucesso!");

				} else {
					logs.add("Saldo insuficiente!");
				}

			} else {
				logs.add("Valor menor que o permitidio!");
			}

		} else {
			logs.add("Limite de saque excedido!");
		}

	}

	public void transferir(double valor, Conta contaDestino) {
		cliente.validarLimiteMaxMovimentacao();

		if (qtdTransferencia < cliente.getLimiteMaxTransferencia()) {

			if (valor >= 10) {

				if (saldo > valor) {
					sacarDepositar(valor);
					contaDestino.depositar(valor);
					qtdTransferencia++;
					logs.add("Transferência " + (qtdTransferencia) + " realizada com sucesso!");

				} else {
					logs.add("Saldo insuficiente!");
				}

			} else {
				logs.add("Valor menor que o permitidio!");
			}
		} else {
			logs.add("Limite de transferêcia excedido!");
		}
	}

	public void sacarDepositar(double valor) {
		saldo -= valor;
		movimentacoes.add(new Movimentacao(LocalDate.now(), Tipo.DEBITTO, valor));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public int getQtdSaque() {
		return qtdSaque;
	}

	public void setQtdSaque(int qtdSaque) {
		this.qtdSaque = qtdSaque;
	}

	public int getQtdTransferencia() {
		return qtdTransferencia;
	}

	public void setQtdTransferencia(int qtdTransferencia) {
		this.qtdTransferencia = qtdTransferencia;
	}

	public void imprimirExtrato(String nomeConta) {
		System.out.println(String.format("**** Extrato %s ****", nomeConta));
		System.out.println(String.format("CLIENTE: %s ¬ CPF: %s", cliente.getNome(), cliente.getCpf()));
		System.out.println(String.format("MODALIDADE DO CLIENTE: %s", cliente.getModalidadeCliente()));
		System.out.println(String.format("AGENCIA: %d ¬ CONTA: %s%n", AGENCIA, numero));
		System.out.println("|DATA       |TIPO    |VALOR");

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(String.format("|%s |%s |R$%.2f", movimentacao.getData(), movimentacao.getTipo(),
					movimentacao.getValor()));
		}

		System.out.println(String.format("%nSALDO DISPONÍVEL: R$%.2f%n", this.saldo));

		for (String msg : logs) {
			System.err.println(msg);
		}
		
		System.out.println();

	}

}
