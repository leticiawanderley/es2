package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import banking.Card;
import banking.Money;

public class TransacaoTest {
	
	ATMInterface atm;
	Card cartaoOK = new Card(123);
	int pinOk = 000;

	@Before
	public void setUp() throws Exception {
		// Essa classe representa a API que captura as capacidades do sistema
		// ATM sem a utilização da GUI
		atm = new ATMInterface();
		atm.setInitialCash(new Money(200));
		atm.switchOn();
		atm.insereCartao(cartaoOK);
		atm.inserePin(pinOk);
	}

	@Test
	public void testCancela() {
		assertTrue(atm.isSessaoAtiva());
		atm.cancelaOperacao();
		assertFalse(atm.isSessaoAtiva());
		assertTrue(atm.podeEjetarCartao());
	}
}
