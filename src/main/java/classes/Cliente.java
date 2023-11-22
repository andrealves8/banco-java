package classes;

public class Cliente {
	private String nome;
	private String cpf;
	private Genero genero;
	private String dataNascimento;
	private double rendaMensal;

	public Cliente(String nome, String cpf, Genero genero, String dataNascimento, double rendaMensal) {
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.rendaMensal = rendaMensal;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public double getRendaMensal() {
		return rendaMensal;
	}
	
	public void setRendaMensal(double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

}
