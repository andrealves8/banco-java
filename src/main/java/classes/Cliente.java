package classes;

import java.time.LocalDate;

public class Cliente {
	private String nome;
	private String cpf;
	private Genero genero;
	private LocalDate dataNascimento;
	private double rendaMensal;
	private ModalidadeCliente modalidadeCliente;
	private Integer limiteMaxSaque = 0;
	private Integer limiteMaxTransferencia = 0;

	public Cliente(String nome, String cpf, Genero genero, LocalDate dataNascimento, double rendaMensal) {
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.rendaMensal = rendaMensal;
	}

	public Cliente(int limiteMaxSaque, int limiteMaxTransferencia) {
		this.limiteMaxSaque = limiteMaxSaque;
		this.limiteMaxTransferencia = limiteMaxTransferencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public int getLimiteMaxSaque() {
		return limiteMaxSaque;
	}

	public void setLimiteMaxSaque(int limiteMaxSaque) {
		this.limiteMaxSaque = limiteMaxSaque;
	}

	public int getLimiteMaxTransferencia() {
		return limiteMaxTransferencia;
	}

	public void setLimiteMaxTransferencia(int limiteMaxTransferencia) {
		this.limiteMaxTransferencia = limiteMaxTransferencia;
	}

	public ModalidadeCliente getModalidadeCliente() {
		if (rendaMensal <= 5000) {
			limiteMaxSaque = 4;
			return ModalidadeCliente.BASICO;
		}
		if (rendaMensal > 5000 && rendaMensal <= 12000) {
			return ModalidadeCliente.INTERMEDIARIO;
		}
		if (rendaMensal > 12000) {
			return ModalidadeCliente.PREMIUM;
		}
		return modalidadeCliente;
	}

	public void validarLimiteMaxMovimentacao() {
		if (getModalidadeCliente() == ModalidadeCliente.BASICO) {
			setLimiteMaxSaque(4);
			setLimiteMaxTransferencia(4);
		}

		if (getModalidadeCliente() == ModalidadeCliente.INTERMEDIARIO) {
			setLimiteMaxSaque(8);
			setLimiteMaxTransferencia(8);
		}
		
		if (getModalidadeCliente() == ModalidadeCliente.PREMIUM) {
			setLimiteMaxSaque(Integer.MAX_VALUE);
			setLimiteMaxTransferencia(Integer.MAX_VALUE);
		}

	}

	public void setModalidadeCliente(ModalidadeCliente modalidadeCliente) {
		this.modalidadeCliente = modalidadeCliente;
	}

}
