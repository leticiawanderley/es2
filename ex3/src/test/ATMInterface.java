package test;

import banking.Card;
import banking.Money;

public class ATMInterface {

	public void setInitialCash(Money money) {
	}

	public Object getNetworkToBank() {
		return null;
	}

	public void switchOn() {
	}

	public void switchOff() {
	}

	public void deposit(Card card, int pin, int amount) {
	}

	public boolean isBusy() {
		return false;
	}

	public void inserePin(int pin) {
	}

	public void insereCartao(Card cartao) {
	}

	public boolean isUsuarioLogado() {
		return false;
	}

	public void cancelaOperacao() {
	}

	public boolean podeEjetarCartao() {
		return false;
	}

	public boolean isSessaoAtiva() {
		return false;
	}

}
