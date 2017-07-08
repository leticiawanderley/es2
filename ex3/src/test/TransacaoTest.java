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
	
	String detalhesCertos = "Nome: Ok, Conta: OK";
	String detalhesIncorretos = "Nome: 423, Conta:x0x";

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
		assertEquals(atm.getCustomerConsoleStatus(), "MENU_MODE");
		atm.cancelaOperacao();
		assertFalse(atm.isSessaoAtiva());
		assertTrue(atm.podeEjetarCartao());
	}
	
	@Test
	public void testSelecionarTransacao() {
		assertTrue(atm.isSessaoAtiva());
		assertEquals(atm.getCustomerConsoleStatus(), "MENU_MODE");
		atm.selecionaTransacao("DEPOSITO");
		assertEquals(atm.getCustomerConsoleStatus(), "USER_DETAILS");
	}
	
	@Test
	public void testNaoSelecionaTransacao() {
		// Não sai do modo Menu
		assertTrue(atm.isSessaoAtiva());
		assertEquals(atm.getCustomerConsoleStatus(), "MENU_MODE");
		assertNotEquals(atm.getCustomerConsoleStatus(), "USER_DETAILS");
	}
	
	@Test
	public void testImprimeRecibo() {
		assertTrue(atm.isSessaoAtiva());
		assertEquals(atm.getCustomerConsoleStatus(), "MENU_MODE");
		atm.selecionaTransacao("DEPOSITO");
		assertEquals(atm.getCustomerConsoleStatus(), "USER_DETAILS");
		atm.insereDetalhes(detalhesCertos);
		assertTrue(atm.isReciboImpresso());
	}
	
	@Test
	public void testFalhaNaTransacao() {
		assertTrue(atm.isSessaoAtiva());
		assertEquals(atm.getCustomerConsoleStatus(), "MENU_MODE");
		atm.selecionaTransacao("DEPOSITO");
		assertEquals(atm.getCustomerConsoleStatus(), "USER_DETAILS");
		atm.insereDetalhes(detalhesIncorretos);
		assertFalse(atm.isReciboImpresso());
		assertEquals(atm.getCustomerConsoleStatus(), "MENU_MODE");
	}
	
	
}
