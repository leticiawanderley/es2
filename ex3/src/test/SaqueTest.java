package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import banking.Card;
import banking.Money;

public class SaqueTest {

	private static final String USER_DETAILS = "USER_DETAILS";

	private static final String SAQUE = "Saque";

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
		atm.selecionaTransacao(SAQUE);
	}

	@Test
	public void testRealizaSaque() {
		float saldoAnterior = atm.getSaldoUsuario(tipoDeContaExistente);
		atm.selecionaTipoDeConta(tipoDeContaExistente);
		atm.insereDetalhes(detalhesCertos);
		float saque = (float) 100.50;
		atm.insereQuantidade(saque);
		assertTrue(atm.dinheiroSuficiente());
		assertTrue(atm.podeSacar());
		assertEquals(saldoAnterior - saque, atm.getSaldoUsuario(tipoDeContaExistente), 0.0);
	}

	@Test
	public void testRealizaSaqueSemDinheiroSuficiente() {
		atm.selecionaTipoDeConta(tipoDeContaExistente);
		atm.insereDetalhes(detalhesCertos);
		float saque = (float) 100.50;
		try {
			atm.insereQuantidade(saque);
		} catch (Exception e) {
			assertFalse(atm.dinheiroSuficiente());
			assertFalse(atm.podeSacar());
			assertEquals(USER_DETAILS, atm.getCustomerConsoleStatus());
		}
	}

}
