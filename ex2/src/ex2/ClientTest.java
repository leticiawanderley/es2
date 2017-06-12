package ex2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {
	
	private Client emptyClient;
	private Client notEmptyClient;
	private Client setClient;
	
	private String name;
	private Date date;
	private String state;
	
	@Before
	public void setUp() {
		name = "Fulano";
		date = new GregorianCalendar(2017, 06, 01).getTime();
		state = "PB";
		emptyClient = new Client();
		setClient = new Client();
		notEmptyClient = new Client(name, date, state);
	}
	
	@Test
	public void emptyClientIsEmpty() {
		assertNull(emptyClient.getName());
		assertNull(emptyClient.getInclusionDate());
		assertNull(emptyClient.getState());
	}

	@Test
	public void clientNotEmpty() {
		assertNotNull(notEmptyClient.getName());
		assertNotNull(notEmptyClient.getInclusionDate());
		assertNotNull(notEmptyClient.getState());
	}
	
	@Test
	public void constructorNotEmpty() {
		assertEquals(name, notEmptyClient.getName());
		assertEquals(date, notEmptyClient.getInclusionDate());
		assertEquals(state, notEmptyClient.getState());
	}
	
	@Test
	public void constructorEmpty() {
		assertNotEquals(name, emptyClient.getName());
		assertNotEquals(date, emptyClient.getInclusionDate());
		assertNotEquals(state, emptyClient.getState());
	}
	
	@Test
	public void setName() {
		assertNull(setClient.getName());
		setClient.setName(name);
		assertNotNull(setClient.getName());
		assertEquals(name, setClient.getName());
	}
	
	@Test
	public void setDate() {
		assertNull(setClient.getInclusionDate());
		setClient.setInclusionDate(date);
		assertNotNull(setClient.getInclusionDate());
		assertEquals(date, setClient.getInclusionDate());
	}
	
	@Test
	public void setState() {
		assertNull(setClient.getState());
		setClient.setState(state);;
		assertNotNull(setClient.getState());
		assertEquals(state, setClient.getState());
	}
}
