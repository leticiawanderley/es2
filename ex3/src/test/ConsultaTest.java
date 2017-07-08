package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import banking.Card;
import banking.Money;

public class ConsultaTest {

	private static final String CONSULTA = "Consulta";

	ATMInterface atm;
	Card cartaoOK = new Card(123);
	int pinOk = 000;
	String tipoDeContaExistente = "Savings";

	@Before
	public void setUp() throws Exception {
		atm = new ATMInterface();

		atm.setInitialCash(new Money(200));
		atm.switchOn();
		atm.insereCartao(cartaoOK);
		atm.inserePin(pinOk);
		atm.selecionaTransacao(CONSULTA);
	}

	@Test
	public void testFazConsulta() {
		atm.selecionaTipoDeConta(tipoDeContaExistente);
		assertTrue(atm.isReciboImpresso());
	}

}
