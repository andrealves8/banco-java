package teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import classes.Conta;

class ContaTest {
	
	Conta conta = new Conta(null);

	@Test
	void testDepositar() {
		double saldoAtual = 100;
		conta.setSaldo(saldoAtual);

		double valorDeposito = 150;
		conta.depositar(valorDeposito);

		double valorEsperado = saldoAtual + valorDeposito;

		Assertions.assertEquals(valorEsperado, conta.getSaldo());

	}

	/*
	 * @Test void testSacar() { fail("Not yet implemented"); }
	 * 
	 * @Test void testTransferir() { fail("Not yet implemented"); }
	 */

}
