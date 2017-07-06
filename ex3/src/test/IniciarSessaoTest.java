package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import banking.Card;
import banking.Money;

public class IniciarSessaoTest {

	ATMInterface atm;
	Card cartaoFitaDanificada = new Card(333);
	Card cartaoOK = new Card(123);
	int pinOk = 000;
	int pinErrado = 00;

	@Before
	public void setUp() throws Exception {
		// Essa classe representa a API que captura as capacidades do sistema
		// ATM sem a utilização da GUI
		atm = new ATMInterface();
		atm.setInitialCash(new Money(200));
		atm.switchOn();
	}

	@Test
	public void testLogin() {
		assertFalse(atm.isUsuarioLogado());
		atm.insereCartao(cartaoOK);
		atm.inserePin(pinOk);
		assertTrue(atm.isUsuarioLogado());
	}

	@Test
	public void testLoginCartaoDanificado() {
		assertFalse(atm.isUsuarioLogado());
		try {
			atm.insereCartao(cartaoOK);
		} catch (Exception e) {
			assertEquals("A fita do cartão está danificada.", e.getMessage());
		}
		assertFalse(atm.isUsuarioLogado());
	}

	@Test
	public void testLoginCartaoInseridoErroneamente() {
		assertFalse(atm.isUsuarioLogado());
		try {
			atm.insereCartao(null);
		} catch (Exception e) {
			assertEquals("O Cartão não foi inserido corretamente.", e.getMessage());
		}
		assertFalse(atm.isUsuarioLogado());
	}

	@Test
	public void testLoginCancelado() {
		assertFalse(atm.isUsuarioLogado());
		atm.insereCartao(cartaoOK);
		atm.cancelaOperacao();
		assertFalse(atm.isUsuarioLogado());
		assertTrue(atm.podeEjetarCartao());
	}

	@Test
	public void testPinIncorreto() {
		assertFalse(atm.isUsuarioLogado());
		atm.insereCartao(cartaoOK);
		atm.inserePin(pinErrado);
		assertFalse(atm.isUsuarioLogado());
		assertTrue(atm.podeEjetarCartao());
		atm.inserePin(pinOk);
		assertTrue(atm.isUsuarioLogado());
	}

	@Test
	public void testPinIncorretoMaisVezesQuePermitido() {
		int numeroDeTentativasPermitido = 5;
		assertFalse(atm.isUsuarioLogado());
		atm.insereCartao(cartaoOK);
		for (int i = 0; i <= numeroDeTentativasPermitido; i++) {
			atm.inserePin(pinErrado);
			assertFalse(atm.isUsuarioLogado());
		}
		assertFalse(atm.podeEjetarCartao());
	}
}
