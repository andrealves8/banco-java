package classes;


import java.util.Random;

public class GeradorDeContas {

	public String numeroGerado = gerarConta();

	public String getNumeroGerado() {
		return numeroGerado;
	}

	public String gerarConta() {

		Random random = new Random();
		int min = 100000, max = 999999;
		String numeroGerado = String.valueOf(random.nextInt((max - min) + 1) + min);
		String p1 = numeroGerado.substring(0, 5);
		String p2 = numeroGerado.substring(numeroGerado.length() - 1);
		return p1 + "-" + p2;

	}
	
	

}