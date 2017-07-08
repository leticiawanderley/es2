package test;

import banking.Card;
import banking.Money;

public class ATMInterface {

	/**
	 * Simulação do pressionamento do botão de ligar
	 */
	public void switchOn() {
	}

	/**
	 * Simulação do pressionamento do botão de desligar
	 */
	public void switchOff() {
	}

	/**
	 * Simulação da inserção de valor inicial de dinheiro disponível
	 */
	public void setInitialCash(Money money) {
	}

	/**
	 * Retorna conexão com o banco
	 */
	public Object getNetworkToBank() {
		return null;
	}

	/**
	 * Simulação da transação de depósito
	 */
	public void deposit(Card card, int pin, int amount) {
	}

	/**
	 * Simulação da inserção de senha do cartão (pin)
	 */
	public void inserePin(int pin) {
	}

	/**
	 * Simulação da inserção do cartão na máquina
	 */
	public void insereCartao(Card cartao) {
	}

	/**
	 * Simulação do cancelamento de operação atual
	 */
	public void cancelaOperacao() {
	}

	/**
	 * Retorna true se houver um usuário logado na ATM e false caso contrário
	 */
	public boolean isUsuarioLogado() {
		return false;
	}

	/**
	 * Retorna true se o cartão pode ser ejetado da ATM e false caso contrário
	 * Simula ejecão de cartão
	 */
	public boolean podeEjetarCartao() {
		return false;
	}

	/**
	 * Retorna true se a sessão do usuário estiver ativa, se houver uma transção
	 * em curso e false caso contrário
	 */
	public boolean isSessaoAtiva() {
		return false;
	}

	public void selecionaTransacao(String transacao) {
	}
	
	public String getCustomerConsoleStatus() {
		return null;
	}

	public void insereDetalhes(String detalhes) {
		// TODO Auto-generated method stub
		
	}

	public boolean isReciboImpresso() {
		// TODO Auto-generated method stub
		return false;
	}
}
