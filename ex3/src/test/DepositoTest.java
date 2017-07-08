package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import banking.Card;
import banking.Money;

public class DepositoTest {

	private static final String MENU_MODE = "MENU_MODE";

	private static final String DEPOSITO = "Deposito";

	ATMInterface atm;
	Card cartaoOK = new Card(123);
	int pinOk = 000;

	String detalhesCertos = "Nome: Ok, Conta: OK";

	String tipoDeContaExistente = "Savings";

	@Before
	public void setUp() throws Exception {
		atm = new ATMInterface();

		atm.setInitialCash(new Money(200));
		atm.switchOn();
		atm.insereCartao(cartaoOK);
		atm.inserePin(pinOk);
		atm.selecionaTransacao(DEPOSITO);
	}

	@Test
	public void testRealizaDeposito() {
		float saldoAnterior = atm.getSaldoUsuario(tipoDeContaExistente);
		atm.selecionaTipoDeConta(tipoDeContaExistente);
		atm.insereDetalhes(detalhesCertos);
		float valorDeposito = (float) 67.79;
		atm.insereQuantidade(valorDeposito);
		atm.insereEnvelope();
		assertTrue(atm.podeDepositar());
		assertEquals(saldoAnterior + valorDeposito, atm.getSaldoUsuario(tipoDeContaExistente), 0.0);
	}

	@Test
	public void testNaoInseriuEnvelope() {
		float saldoAnterior = atm.getSaldoUsuario(tipoDeContaExistente);
		atm.selecionaTipoDeConta(tipoDeContaExistente);
		atm.insereDetalhes(detalhesCertos);
		float valorDeposito = (float) 49.12;
		atm.insereQuantidade(valorDeposito);
		assertFalse(atm.podeDepositar());
		assertEquals(saldoAnterior, atm.getSaldoUsuario(tipoDeContaExistente), 0.0);
		assertEquals(MENU_MODE, atm.getCustomerConsoleStatus());
	}

	@Test
	public void testTentaRealizarDepositoValor0() {
		atm.selecionaTipoDeConta(tipoDeContaExistente);
		atm.insereDetalhes(detalhesCertos);
		float valorDeposito = (float) 0.0;
		atm.insereQuantidade(valorDeposito);
		atm.insereEnvelope();
		assertFalse(atm.podeDepositar());
	}
}
