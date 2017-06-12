package ex2;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class BillTest {
	
	private Bill emptyBill;
	private Bill billWithEmptyFields;
	private Bill bill;
	private Bill setBill;
	
	private int code;
	private double value;
	private Date date;
	private Client client;

	@Before
	public void setUp() {
		code = 12345;
		value = 15.0;
		date = new GregorianCalendar(2017, 06, 01).getTime();
		client = new Client();
		billWithEmptyFields = new Bill();
		bill = new Bill(code, value, date, client);
		setBill = new Bill();
	}
	
	@Test
	public void emptyBillIsEmpty() {
		assertNull(emptyBill);
	}
	
	@Test
	public void emptyBillFieldsAreEmpty() {
		assertEquals(0, billWithEmptyFields.getCode());
		assertEquals(0.0, billWithEmptyFields.getValue(), 0.0);
		assertNull(billWithEmptyFields.getDate());
		assertNull(billWithEmptyFields.getClient());
	}
	
	@Test
	public void billIsNotEmpty() {
		assertNotNull(bill.getCode());
		assertNotNull(bill.getValue());
		assertNotNull(bill.getDate());
		assertNotNull(bill.getClient());
	}
	
	@Test
	public void constructorNotEmpty() {
		assertEquals(code, bill.getCode());
		assertEquals(value, bill.getValue(), 0.0);
		assertEquals(date, bill.getDate());
		assertEquals(client, bill.getClient());
	}
	
	@Test
	public void setCode() {
		assertEquals(0, setBill.getCode());
		setBill.setCode(code);
		assertEquals(code, setBill.getCode());
	}
	
	@Test
	public void setValue() {
		assertEquals(0.0, setBill.getValue(), 0.0);
		setBill.setValue(value);
		assertEquals(value, setBill.getValue(), 0.0);
	}
	
	@Test
	public void setDate() {
		assertNull(setBill.getDate());
		setBill.setDate(date);
		assertEquals(date, setBill.getDate());
	}
	
	@Test
	public void setClient() {
		assertNull(setBill.getClient());
		setBill.setClient(client);
		assertEquals(client, setBill.getClient());
	}
}
