package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import banking.Card;
import banking.Money;

public class TransacaoTest {

	private static final String ACCOUNT_DETAILS = "ACCOUNT_DETAILS";
	private static final String ACCOUNT_MODE = "ACCOUNT_MODE";
	private static final String DEPOSITO = "DEPOSITO";
	private static final String USER_DETAILS = "USER_DETAILS";
	private static final String MENU_MODE = "MENU_MODE";

	ATMInterface atm;
	Card cartaoOK = new Card(123);
	int pinOk = 000;

	String detalhesCertos = "Nome: Ok, Conta: OK";
	String detalhesIncorretos = "Nome: 423, Conta:x0x";

	String tipoDeContaExistente = "Savings";
	String tipoDeContaInexistente = "Current";

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
		assertEquals(MENU_MODE, atm.getCustomerConsoleStatus());
		atm.cancelaOperacao();
		assertFalse(atm.isSessaoAtiva());
		assertTrue(atm.podeEjetarCartao());
	}

	@Test
	public void testSelecionarTransacao() {
		assertTrue(atm.isSessaoAtiva());
		assertEquals(MENU_MODE, atm.getCustomerConsoleStatus());
		atm.selecionaTransacao(DEPOSITO);
		assertEquals(USER_DETAILS, atm.getCustomerConsoleStatus());
	}

	@Test
	public void testNaoSelecionaTransacao() {
		// Não sai do modo Menu
		assertTrue(atm.isSessaoAtiva());
		assertEquals(MENU_MODE, atm.getCustomerConsoleStatus());
		assertNotEquals(USER_DETAILS, atm.getCustomerConsoleStatus());
	}

	@Test
	public void testImprimeRecibo() {
		assertTrue(atm.isSessaoAtiva());
		assertEquals(MENU_MODE, atm.getCustomerConsoleStatus());
		atm.selecionaTransacao(DEPOSITO);
		assertEquals(USER_DETAILS, atm.getCustomerConsoleStatus());
		atm.insereDetalhes(detalhesCertos);
		assertTrue(atm.isReciboImpresso());
	}

	@Test
	public void testFalhaNaTransacao() {
		assertTrue(atm.isSessaoAtiva());
		assertEquals(MENU_MODE, atm.getCustomerConsoleStatus());
		atm.selecionaTransacao(DEPOSITO);
		assertEquals(USER_DETAILS, atm.getCustomerConsoleStatus());
		try {
			atm.insereDetalhes(detalhesIncorretos);
		} catch (Exception e) {
			assertEquals("Detalhes inseridos incorretamente.", e.getMessage());
			assertFalse(atm.isReciboImpresso());
			assertEquals(MENU_MODE, atm.getCustomerConsoleStatus());
		}
	}

	@Test
	public void testSelecaoDeConta() {
		assertTrue(atm.isSessaoAtiva());
		atm.selecionaTransacao(DEPOSITO);
		assertEquals(ACCOUNT_MODE, atm.getCustomerConsoleStatus());
	}

	@Test
	public void testDetalhesDeConta() {
		assertTrue(atm.isSessaoAtiva());
		atm.selecionaTransacao(DEPOSITO);
		assertEquals(ACCOUNT_MODE, atm.getCustomerConsoleStatus());
		atm.selecionaTipoDeConta(tipoDeContaExistente);
		assertEquals(ACCOUNT_DETAILS, atm.getCustomerConsoleStatus());
	}

	@Test
	public void testContaInexistente() {
		assertTrue(atm.isSessaoAtiva());
		atm.selecionaTransacao(DEPOSITO);
		assertEquals(ACCOUNT_MODE, atm.getCustomerConsoleStatus());
		atm.selecionaTipoDeConta(tipoDeContaInexistente);
		assertEquals(MENU_MODE, atm.getCustomerConsoleStatus());
	}
}
