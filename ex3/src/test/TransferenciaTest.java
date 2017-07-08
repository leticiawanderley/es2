package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import banking.Card;
import banking.Money;

public class TransferenciaTest {

	private static final String TRANSFERENCIA = "Transferencia";

	ATMInterface atm;
	Card cartaoOK = new Card(123);
	int pinOk = 000;

	String detalhesCertos = "Nome: Ok, Conta: OK";

	String tipoDeContaExistente = "Savings";

	String contaTransferenciaValida = "Current";

	@Before
	public void setUp() throws Exception {
		atm = new ATMInterface();

		atm.setInitialCash(new Money(200));
		atm.switchOn();
		atm.insereCartao(cartaoOK);
		atm.inserePin(pinOk);
		atm.selecionaTransacao(TRANSFERENCIA);
	}

	@Test
	public void testRealizaTransferencia() {
		float saldoAnteriorConta1 = atm.getSaldoUsuario(tipoDeContaExistente);
		float saldoAnteriorConta2 = atm.getSaldoUsuario(contaTransferenciaValida);
		atm.selecionaTipoDeConta(tipoDeContaExistente);
		atm.insereDetalhes(detalhesCertos);
		float valorDeTransferencia = (float) 50.0;
		atm.insereQuantidade(valorDeTransferencia);
		atm.insereContaTransferencia(contaTransferenciaValida);
		assertTrue(atm.podeTransferir());
		assertEquals(saldoAnteriorConta1 - valorDeTransferencia, atm.getSaldoUsuario(tipoDeContaExistente), 0.0);
		assertEquals(saldoAnteriorConta2 + valorDeTransferencia, atm.getSaldoUsuario(contaTransferenciaValida), 0.0);
	}

	@Test
	public void testRealizaTransferenciaValor0() {
		atm.selecionaTipoDeConta(tipoDeContaExistente);
		atm.insereDetalhes(detalhesCertos);
		float valorDeTransferencia0 = (float) 0.0;
		atm.insereQuantidade(valorDeTransferencia0);
		assertFalse(atm.podeTransferir());
	}
}
