package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import banking.Money;

public class LigarATMTest {

	ATMInterface atm;
	
	@Before
	public void setUp() throws Exception {
		// Essa classe representa a API que captura as capacidades do sistema
		// ATM sem a utilização da GUI
		atm = new ATMInterface();
	}

	@Test
	public void testSwitchOn() {
		assertNull(atm.getNetworkToBank());
		assertEquals("AMOUNT_MODE", atm.getCustomerConsoleStatus());
		atm.setInitialCash(new Money(200));
		atm.switchOn();
		assertNotNull(atm.getNetworkToBank());
	}
	
	@Test
	public void testSwitchOnNoCash() {
		assertNull(atm.getNetworkToBank());
		assertEquals("AMOUNT_MODE", atm.getCustomerConsoleStatus());
		atm.switchOn();
		assertNull(atm.getNetworkToBank());
	}

}
