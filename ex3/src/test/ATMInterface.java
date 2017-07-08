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
	 * Seleciona transação a ser executada
	 */
	public void selecionaTransacao(String transacao) {
	}

	/**
	 * Retorna status da interface do usuário
	 */
	public String getCustomerConsoleStatus() {
		return null;
	}

	/**
	 * Recebe detalhes do usuário e sua conta e os insere no sistema
	 */
	public void insereDetalhes(String detalhes) {
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

	/**
	 * Retorna true se o recibo pode ser impresso pela ATM e false caso
	 * contrário 
	 * Simula impressão de recibo
	 */
	public boolean isReciboImpresso() {
		return false;
	}

	/**
	 * Seleciona tipo de conta participante da transação
	 */
	public void selecionaTipoDeConta(String tipoConta) {
	}

	/**
	 * Retorna true se a ATM tem notas suficientes para atender um transaçao de
	 * saque e false caso contrário
	 */
	public boolean dinheiroSuficiente() {
		return false;
	}

	/**
	 * Recebe quantidade de dinheiro envolvida na transação atual
	 */
	public void insereQuantidade(float saque) {
	}
	
	/**
	 * Simula o recebimento de um envelope no depósito
	 */
	public void insereEnvelope() {
	}
	
	/**
	 * Recebe conta para qual a transferência será realizada
	 */
	public void insereContaTransferencia(String tipoConta) {
	}
	
	/**
	 * Retorna saldo da conta, passada como parâmetro, do usuário atual
	 */
	public float getSaldoUsuario(String tipoDeConta) {
		return 0;
	}

	/**
	 * Retorna true se o Banco autorizou a transação de saque e false caso
	 * contrário
	 */
	public boolean podeSacar() {
		return false;
	}

	/**
	 * Retorna true se o Banco autorizou a transação de depósito e false caso
	 * contrário
	 */
	public boolean podeDepositar() {
		return false;
	}

	/**
	 * Retorna true se o Banco autorizou a transação de transferência e false
	 * caso contrário
	 */
	public boolean podeTransferir() {
		return false;
	}
}
