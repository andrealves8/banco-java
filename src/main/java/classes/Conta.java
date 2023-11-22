package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Conta {
	private static final int AGENCIA = 332;
	private String numero = new GeradorDeContas().numeroGerado;
	private double saldo;
	private Cliente cliente;
	private Tipo tipo;
	private ModalidadeCliente modalidadeCliente;
	private int contadorTransacoes = 0;

	LocalDateTime data = LocalDateTime.now();
	DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM  HH:mm ");
	String dataAtual = data.format(dataFormatada);

	private List<Movimentacao> movimentacoes = new ArrayList<>();

	public Conta(Cliente cliente) {
		this.cliente = cliente;
	}

	public void depositar(double valor) {
		if (valor > -1) {
			saldo += valor;
			movimentacoes.add(new Movimentacao(dataAtual, tipo.CREDITO, valor));
			contadorTransacoes++;
		}

	}

	public void sacar(double valor) {
		if (valor > -1) {
			saldo -= valor;
			movimentacoes.add(new Movimentacao(dataAtual, tipo.DEBITTO, valor));
		}
	}

	public void transferir(double valor, Conta contaDestino) {
		if (valor > -1) {
			sacar(valor);
			contaDestino.depositar(valor);
		}
	}

	public Cliente getCliente() {
		return cliente;
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
	
	public int getContadorTransacoes() {
		return contadorTransacoes;
	}
	
	public void setContadorTransacoes(int contadorTransacoes) {
		this.contadorTransacoes = contadorTransacoes;
	}

	public ModalidadeCliente getModalidadeCliente() {
		if (cliente.getRendaMensal() <= 5000) {
			return modalidadeCliente.BASICO;
		}
		if (cliente.getRendaMensal() > 5000 && cliente.getRendaMensal() <= 12000) {
			return modalidadeCliente.INTERMEDIARIO;
		}
		if (cliente.getRendaMensal() > 12000) {
			return modalidadeCliente.PREMIUM;
		}

		return null;

	}

	public void setModalidadeCliente(ModalidadeCliente modalidadeCliente) {
		this.modalidadeCliente = modalidadeCliente;
	}

	public void imprimirExtrato(String nomeConta) {
		System.out.println(String.format("**** Extrato %s ****", nomeConta));
		System.out.println(String.format("CLIENTE: %s ¬ CPF: %s", cliente.getNome(), cliente.getCpf()));
		System.out.println(String.format("MODALIDADE DO CLIENTE: %s", getModalidadeCliente()));
		System.out.println(String.format("AGENCIA: %d ¬ CONTA: %s%n", AGENCIA, numero));
		System.out.println("|DATA   HORA   |TIPO     |VALOR");

		for (Movimentacao movimentacao : movimentacoes) {

			System.out.println(String.format("|%s |%s  |R$%.2f", movimentacao.getDataAtual(), movimentacao.getTipo(),
					movimentacao.getValor()));

		}

		System.out.println(String.format("%nSALDO DISPONÍVEL: R$%.2f%n", this.saldo));
		System.out.println(String.format("TRANSAÇÕES DIÁRIAS: %s", this.contadorTransacoes));

	}

}
