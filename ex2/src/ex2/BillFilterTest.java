package ex2;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class BillFilterTest {

	private BillFilter filter;

	private Client clientInclusionDate2Months;
	private Client clientSouth;
	private Date oneMonthAgo;
	
	private Client clientNortheast; 
	private Date currentDate;
	
	@Before
	public void setUp() {
		currentDate = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(currentDate); 
		c.add(Calendar.MONTH, -1);
		oneMonthAgo = c.getTime();
		
		Calendar c2 = Calendar.getInstance(); 
		c2.setTime(currentDate);
		c2.add(Calendar.MONTH, -2);
		clientNortheast = new Client("Beltrano", currentDate, "AL");
		clientInclusionDate2Months = new Client("Sicrano", c2.getTime(), "PB");
		clientSouth = new Client("Fulano", currentDate, "SC");
		filter = new BillFilter();
	}

	@Test
	public void emptyList() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		assertTrue(bills.isEmpty());
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}

	@Test
	public void firstCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(1, 600.0, currentDate, clientNortheast));
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}

	@Test
	public void secondCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(2, 2250.0, oneMonthAgo, clientNortheast));
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void thirdCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(2, 2990.0, oneMonthAgo, clientInclusionDate2Months));
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
	
	@Test
	public void fourthCriteria() {
		ArrayList<Bill> bills = new ArrayList<Bill>();
		bills.add(new Bill(2, 6000.0, currentDate, clientSouth));
		filter.filterBills(bills);
		assertTrue(bills.isEmpty());
	}
}
