package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import banking.Card;
import banking.Money;

public class DesligarATMTest {

	ATMInterface atm;
	
	@Before
	public void setUp() throws Exception {
		// Essa classe representa a API que captura as capacidades do sistema
		// ATM sem a utilização da GUI
		atm = new ATMInterface();
	}

	@Test
	public void testSwitchOff() {
		atm.setInitialCash(new Money(200));
		atm.switchOn();
		assertNotNull(atm.getNetworkToBank());
		assertFalse(atm.isSessaoAtiva());
		atm.switchOff();
		assertNull(atm.getNetworkToBank());
	}
	
	@Test
	public void testSwitchOffBusy() {
		atm.setInitialCash(new Money(200));
		atm.switchOn();
		assertNotNull(atm.getNetworkToBank());
		atm.deposit(new Card(123), 1, 100);
		assertTrue(atm.isSessaoAtiva());
		atm.switchOff();
		assertNotNull(atm.getNetworkToBank());
	}
}
